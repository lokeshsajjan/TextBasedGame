package com.company.cli;

import static com.company.cli.common.StaticMessages.BONUS_STATS_DMG_QUESTION;
import static com.company.cli.common.StaticMessages.BONUS_STATS_HP_QUESTION;
import static com.company.cli.common.StaticMessages.DESC_QUESTION;
import static com.company.cli.common.StaticMessages.INTRODUCTION;
import static com.company.cli.common.StaticMessages.NAME_QUESTION;
import static com.company.cli.common.StaticMessages.PLAYER_READY_MESSAGE;
import static com.company.cli.common.StaticMessages.REALM_QUESTION;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.company.cli.Charactor.EnemyConfiguration;
import com.company.cli.Charactor.PlayerConfiguration;
import com.company.cli.Charactor.RealmConfiguration;
import com.company.cli.adapter.exception.UserInputParseException;
import com.company.cli.common.ResourceManager;
import com.company.cli.common.ResourceManagerImpl;

//TODO: many plasces replace String constants
public class GameManager {
	
	private static final String INVALID_INPUT_MESSAGE = "Oops Invalid Action Please try one more time";
	private static final String PLAYER_LOST_MESSAGE = "You have taken to much damage you are too weak to go on!";
	public static ResourceManager rsManger = new ResourceManagerImpl();
	private final static Scanner scanner = new Scanner(System.in);
	private static final Logger LOG = LogManager.getLogger(GameManager.class);

	public static void newGame(ArrayList<RealmConfiguration> realms) {
		LOG.traceEntry();
		System.out.println(REALM_QUESTION);
		RealmConfiguration realmConfiguration = startGame(realms);
		confirmRealmConfigurationMessage(realmConfiguration);
		PlayerConfiguration playerConfiguration = initPlayer();
		biginGame(playerConfiguration, realmConfiguration);
		LOG.traceExit();

	}

	private static void biginGame(PlayerConfiguration playerConfiguration, RealmConfiguration realmConfiguration) {
		System.out.println(PLAYER_READY_MESSAGE);
		System.out.println("======================");
		EnemyConfiguration randomEnemy = getEnemyForFight(realmConfiguration);
		fightWithEnemy(playerConfiguration, randomEnemy);

	}

	private static void fightWithEnemy(PlayerConfiguration playerConfiguration, EnemyConfiguration randomEnemy) {
		Random RANDOM = new Random();
		int enemyHealth = randomEnemy.getMaxHp();
		int playerHealth = playerConfiguration.getHpBonus();
		while (enemyHealth > 0) {
			showFightMenu();
			System.out.println("\n");
			System.out.println("\t> Your Health :" + playerHealth);
			System.out.println("\t> " + randomEnemy.getName() + " health:" + enemyHealth);
			int fightInput = Integer.parseInt(scanner.next());
			if (fightInput == 1) {
				int playerDamageDealt = RANDOM.nextInt(playerConfiguration.getDamageBonus());
				int enemyDamageTaken = RANDOM.nextInt(randomEnemy.getDamage());
				enemyHealth -= playerDamageDealt;
				playerHealth -= enemyDamageTaken;
				System.out.println("You Strike the " + randomEnemy.getName() + " for " + playerDamageDealt + " damage");
				System.out.println("You Recieved the " + enemyDamageTaken + "in Retaliation");

				if (playerHealth < 1) {
					System.out.println(PLAYER_LOST_MESSAGE);
					break;
				}

			} else if (fightInput == 2) {
				System.out.println("You Ran Away From " + randomEnemy.getName());
				break;
			} else if (fightInput == 3) {
				// save the Game
				PlayerConfiguration playerConfiguration2 = new PlayerConfiguration(playerConfiguration.getName(),
						playerConfiguration.getDesc(), playerHealth, randomEnemy.getDamage());
				EnemyConfiguration enemyConfiguration = new EnemyConfiguration(randomEnemy.getName(),
						randomEnemy.getDescription(), randomEnemy.getGreeting(), enemyHealth, randomEnemy.getDamage(),
						0);
				GameState gameState = new GameState(playerConfiguration2, enemyConfiguration);

				rsManger.saveGame(gameState);
				break;

			} else {
				System.out.println(INVALID_INPUT_MESSAGE);
			}
		}
		if (enemyHealth < 1) {
			System.out.println("You defeated==" + randomEnemy.getName());
		}
	}

	private static void showFightMenu() {
		System.out.println("What you would like to do ");
		System.out.println("\t 1.Attack");
		System.out.println("\t 2.Run Aways");
		System.out.println("\t 3.Save the Game");
	}

	private static EnemyConfiguration getEnemyForFight(RealmConfiguration realmConfiguration) {
		Random random = new Random();
		EnemyConfiguration randomEnemy = realmConfiguration.getEnemyConfiguration()
				.get(random.nextInt(realmConfiguration.getEnemyConfiguration().size()));
		System.out.println("\t>" + randomEnemy.getName() + " has Apprered");
		System.out.println("\t> Health :" + randomEnemy.getMaxHp());
		System.out.println("\t> Damage :" + randomEnemy.getDamage());
		return randomEnemy;
	}

	private static PlayerConfiguration initPlayer() {
		System.out.println(INTRODUCTION);
		PlayerConfiguration playerConfiguration = askQuestion();
		return playerConfiguration;
	}

	private static PlayerConfiguration askQuestion() {

		System.out.println(NAME_QUESTION);
		String nameQuestion = scanner.next();
		System.out.println(DESC_QUESTION);
		String descQuestion = scanner.next();
		System.out.println(BONUS_STATS_HP_QUESTION);
		int hpQuestion = scanner.nextInt();
		System.out.println(BONUS_STATS_DMG_QUESTION);
		int dmgQuestion = scanner.nextInt();
		PlayerConfiguration configuration = new PlayerConfiguration(nameQuestion, descQuestion, hpQuestion, dmgQuestion);
		return configuration;
	}

	private static void confirmRealmConfigurationMessage(RealmConfiguration realmConfiguration) {
		System.out.println("You are selected ##" + realmConfiguration + "## Good Luck");

	}

	public static RealmConfiguration startGame(ArrayList<RealmConfiguration> realms) {
		printAllOption(realms);
		return selectOption(realms);

	}

	public static RealmConfiguration selectOption(ArrayList<RealmConfiguration> realms) {

		int result = Integer.parseInt(scanner.nextLine());
		if (realms.size() < result) {
			throw new UserInputParseException(
					"Sorry, but command number is either below 0 or too high. Please try again");
		}
		return realms.get(result - 1);

	}

	private static void printAllOption(ArrayList<RealmConfiguration> realms) {

		System.out.println("Please choose one of those options:");
		int counter = 1;
		for (RealmConfiguration item : realms) {
			System.out.println(counter + "." + item);
			counter++;
		}

	}

	public static void loadGame() {
		GameState gameState = rsManger.loadGame();
		if (null != gameState) {
			PlayerConfiguration playerConfiguration = gameState.getPlayerConfiguration();
			EnemyConfiguration enemyConfiguration = gameState.getEnemyConfiguration();
			fightWithEnemy(playerConfiguration, enemyConfiguration);
		} else {
			System.out.println("No Saved Game to load!!!!!!!!!!!");
		}

	}

}
