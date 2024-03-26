package zombie;

public class Zombie extends Unit {
	public Zombie() {
		super(200, 5, 2, 10, "Zombie"); // 플레이어 초기 셋팅
		setItems(ran.nextInt(3));
		setPosition();
	}

	@Override
	public void setPosition() {
		this.position = ran.nextInt(8) + 2;
	}

	@Override
	public void setItems(int items) {
		this.items = items;
	}
//	private int setItem() {
//		return ran.nextInt(3);
//	}
//	
//	private int rPosition() {
//		return ran.nextInt(8)+2;
//	}
}
