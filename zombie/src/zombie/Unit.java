package zombie;

public class Unit {
	private int currentHp; // 현재 hp
	private int maxHp; // 최대 hp
	private int items; // 가진 포션 수

	private int offensivePower; // 공격력
	private int minAttack; // 최소 공격
	private int maxAttack; // 최대 공격

	private int position; // 위치

	protected Unit(int maxHp, int items, int offensivePower, int position) {
		this.maxHp = maxHp;
		this.currentHp = maxHp;

		this.items = items;
		this.offensivePower = offensivePower;
		this.minAttack = this.offensivePower - 10;
		this.maxAttack = this.offensivePower + 10;
		this.position = position;
	}
}
