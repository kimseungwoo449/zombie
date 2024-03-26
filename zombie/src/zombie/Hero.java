package zombie;

public class Hero extends Unit implements Playerable{
	public Hero(int maxHp, int items, int offensivePower, int position) {
		super(150,2,10,1,1,0,"Player");	// 플레이어 초기 셋팅
	}
	
	@Override
	public void setLv() {
		if (super.exp >= 100) {
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
}
