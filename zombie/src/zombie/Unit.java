package zombie;

import java.util.Random;

public class Unit {
	protected Random ran = new Random();

	private int currentHp; // 현재 hp
	private int maxHp; // 최대 hp
	private int items; // 가진 포션 수

	private int offensivePower; // 공격력
	private int minAttack; // 최소 공격
	private int maxAttack; // 최대 공격

	private int position; // 위치

	private String name;

	protected Unit(int maxHp, int items, int offensivePower, int position, String name) {
		this.maxHp = maxHp;
		this.currentHp = maxHp;

		this.items = items;
		this.offensivePower = offensivePower;
		this.minAttack = this.offensivePower - 10;
		this.maxAttack = this.offensivePower + 10;
		this.position = position;
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%s [%d/%d]", name, currentHp, maxHp);
	}
}
