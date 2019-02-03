package com.company.cli.Charactor;

import com.company.cli.adapter.exception.PlayerValidationException;

public class PlayerConfiguration {

	private final String name;
	private final String desc;
	private final int hpBonus;
	private final int damageBonus;

	public PlayerConfiguration(String name, String desc, int hpBonus, int damageBonus) {
		this.name = name;
		this.desc = desc;
		this.hpBonus = hpBonus;
		this.damageBonus = damageBonus;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public int getHpBonus() {
		return hpBonus;
	}

	public int getDamageBonus() {
		return damageBonus;
	}

	

}
