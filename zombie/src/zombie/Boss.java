package zombie;

public class Boss extends Zombie {
	public Boss() {
		this.lv = 5;
		this.maxHp *= 1.5;
		this.currentHp = this.maxHp;
		this.exp *= 1.5;
		this.offensivePower *= 1.5;
		this.setAttacks();
		this.position = 10; // 10 층보스
		this.name = "Zombie King";
		this.items *= ran.nextInt(3);
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
