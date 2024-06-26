package zombie;

public class Hero extends Unit implements Playerable {

	private Hero() {
		super(150, 10, 1, 0, "Player"); // 플레이어 초기 셋팅
		setPosition();
		setItems(2);
	}
	
	private static Hero instance = new Hero();
	
	public static Hero getInstance() {
		return instance;
	}
	
	@Override
	public void setLv() {
		if (super.exp >= 100) {
			System.out.println("레벨업!");
			super.lv++;
			super.exp -= 100;
			setMaxHp();
			setOffensivePower();
		}
	}

	@Override
	public void setMaxHp() {
		super.maxHp += 50;
		super.currentHp = this.maxHp;
	}

	@Override
	public void setOffensivePower() {
		super.offensivePower += 5;
		super.minAttack = super.offensivePower - 10;
		super.maxAttack = super.offensivePower + 10;
	}

	@Override
	public void setExp(int exp) {
		super.exp += exp;
	}

	@Override
	public boolean setItems(int items) {
		if (super.items + items < 0) {
			System.err.println("아이템이 모두 소진되었습니다.");
			return false;
		}
		super.items += items;
		return true;
	}

	@Override
	public void setPosition() {
		this.position++;
	}

	@Override
	public int damage() {
		int rDamage = ran.nextInt(super.maxAttack) + super.minAttack + 1;
		int critical = ran.nextInt(4);
		if (critical == 0) {
			System.out.printf("%s 크리티컬!!!\n",super.name);
			rDamage *= 2;
		}
		return rDamage;
	}
}
