package com.company.cli.Charactor;

import java.io.Serializable;
import java.util.List;

/**
 * @author lsajjan Enemy details
 */
public class RealmConfiguration implements Serializable {
	private final String name;
	private final int realmSize;
	private final List<EnemyConfiguration> enemies;

	public RealmConfiguration(String name, int realmSize, List<EnemyConfiguration> enemies) {
		this.name = name;
		this.realmSize = realmSize;
		this.enemies = enemies;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	public int getRealmSize() {
		return realmSize;
	}

	public List<EnemyConfiguration> getEnemyConfiguration() {
		return enemies;
	}

	@Override
	public String toString() {
		return name;
	}
}
