package zombie;

import java.util.Random;

interface Playerable {
	public void setLv();

	public void setMaxHp();

	public void setOffensivePower();

	public void setExp(int exp);
}

interface Damageable {
	public int damage();
}

abstract public class Unit {
	protected Random ran = new Random();

	protected int currentHp; // 현재 hp
	protected int maxHp; // 최대 hp
	protected int items; // 가진 포션 수

	protected int offensivePower; // 공격력
	protected int minAttack; // 최소 공격
	protected int maxAttack; // 최대 공격

	protected int position; // 위치

	protected int lv; // lv
	protected int exp; // 경험치

	private String name;

	private boolean isDead;

	protected Unit(int maxHp, int offensivePower, int lv, int exp, String name) {
		this.maxHp = maxHp;
		this.currentHp = maxHp;

		this.offensivePower = offensivePower;
		this.minAttack = this.offensivePower - 10;
		this.maxAttack = this.offensivePower + 10;
		this.name = name;
		this.lv = lv;
		this.exp = exp;
		this.isDead = false;
	}

	public int getCurrentHp() {
		return this.currentHp;
	}

	public void setCurrentHp(int attack) {
		this.currentHp -= attack;
		dead();
	}

	public int getPosition() {
		return this.position;
	}

	abstract public void setPosition();

	public int getExp() {
		return this.exp;
	}

	abstract public void setItems(int items);

	public int getItems() {
		return this.items;
	}

	public boolean isDead() {
		return this.isDead;
	}

	private void dead() {
		if (this.currentHp <= 0)
			this.isDead = true;
	}

	@Override
	public String toString() {
		return String.format("%d. %s [%d/%d]", lv, name, currentHp, maxHp);
	}
}
