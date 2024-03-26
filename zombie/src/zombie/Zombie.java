package zombie;

public class Zombie extends Unit{
	public Zombie() {
		super(200, 5, 2, 10, "Zombie"); // 좀비 초기 셋팅
		setItems(ran.nextInt(3));
		setPosition();
	}

	@Override
	public void setPosition() {
		this.position = ran.nextInt(8) + 2;
	}

	@Override
	public boolean setItems(int items) {
		this.items = items;
		return true;
	}

	@Override
	public int damage() {
		int rDamage = ran.nextInt(super.maxAttack) + super.minAttack + 1;
		int critical = ran.nextInt(6);	// 몹은 크리가 덜 터지게
		if (critical == 0) {
			System.out.printf("%s 크리티컬!!!\n",super.name);
			rDamage *= 2;
		}
		return rDamage;
	}
}
