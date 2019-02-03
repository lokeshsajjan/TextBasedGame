package com.company.cli.Charactor;

import java.io.Serializable;

public class EnemyConfiguration implements Serializable {
	private final String name;
	private final String description;
	private final String greeting;
	private final int maxHp;
	private final int damage;
	private final int damageVariation;

	public EnemyConfiguration(String name, String description, String greeting, int maxHp, int damage,
			int damageVariation) {
		this.name = name;
		this.description = description;
		this.greeting = greeting;
		this.maxHp = maxHp;
		this.damage = damage;
		this.damageVariation = damageVariation;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getGreeting() {
		return greeting;
	}

	public int getDamage() {
		return damage;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public int getDamageVariation() {
		return damageVariation;
	}

	@Override
	public String toString() {
		return "EnemyConfiguration [name=" + name + ", description=" + description + ", greeting=" + greeting
				+ ", maxHp=" + maxHp + ", damage=" + damage + ", damageVariation=" + damageVariation + "]";
	}

	

}
