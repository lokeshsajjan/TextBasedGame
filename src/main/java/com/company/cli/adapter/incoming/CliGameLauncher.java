package com.company.cli.adapter.incoming;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.company.cli.MainMenuManager;
import com.company.cli.adapter.exception.ConfigurationException;
import com.company.cli.adapter.exception.UserInputParseException;

public class CliGameLauncher {
	private static final Logger LOG = LogManager.getLogger(CliGameLauncher.class);
		public static void startGame() {

		try {
			LOG.debug("CLI calling MainMenuManager...");
			MainMenuManager mainMenuManager=new MainMenuManager();
			mainMenuManager.showMenu();
		} catch (UserInputParseException e) {
			shutdown(e.getMessage(), e);
		} catch (ConfigurationException e) {
			if (null != e.getMessage()) {
				shutdown(e.getMessage(), e);
			} else {
				String msg = "There was a problem with the configuration. Please ask your local IT for support.\n"
						+ "I'm sure they will come up with a solution to your problem (for example 'have you tried turning it off and on again')";
				shutdown(msg, e);
			}

		} catch (Exception e) {
			/*String msg = "There was a general problem with the game. Pray to God that it will work next time.";
			shutdown(msg, t);*/
			e.printStackTrace();
			
		}

	}

	private static void shutdown(String msg, Throwable e) {
		System.out.println(msg);
		LOG.fatal(msg, e);
		System.exit(1);
	}
}
