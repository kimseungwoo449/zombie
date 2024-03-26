package zombie;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	private final int MOVE = 1;
	private final int EXIT = 0;

	private final int ATTACK = 1;
	private final int POTION = 2;

	private Scanner sc = new Scanner(System.in);
	private Hero player = Hero.getInstance();

	private boolean isRun;
	private ArrayList<Unit> enemys;
	private Game() {
		enemys = new ArrayList<Unit>();
		checkAndAddList();
		isRun = true;
	}
	
	private void checkAndAddList() {
		for(int i =0;i<3;i++) {
			Zombie zombie = new Zombie();
			boolean isExist = false;
			for(Unit unit :enemys) {
				if(unit.getPosition()==zombie.getPosition()) {
					isExist = true;
				}
			}
			if(!isExist) {
				enemys.add(zombie);
			}else
				i--;
		}
		enemys.add(new Boss());
	}
	
	private static Game instance = new Game();

	public static Game getInstance() {
		return instance;
	}

	private int inputNumber(String message) {
		int number = -1;
		try {
			System.out.print(message + " : ");
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자로 입력해 주세요.");
		}
		return number;
	}

	private void printGame() {
		System.out.printf("Player 현재 위치 : %d\n", player.getPosition());
		System.out.println("[1] 이동하기");
		System.out.println("[0] 종료하기");
	}

	private void runGame(int choice) {
		if (choice == MOVE)
			move();
		else if (choice == EXIT)
			isRun = false;
	}

	private void move() {
		player.setPosition();
		Unit enemy = checkMonster();
		if (enemy != null)
			fight(enemy);
	}

	private Unit checkMonster() {
		for(Unit enemy : enemys) {
			if(player.getPosition()==enemy.getPosition()) {
				return enemy;
			}
		}
		return null;
	}

	private void fight(Unit enemy) {
		System.err.println("[!!! ENEMY !!!]");
		while (true) {
			System.out.println(player);
			System.out.println(enemy);
			printFightMenu(enemy);

			if (whoseDead(enemy))
				break;
		}
	}

	private boolean whoseDead(Unit enemy) {
		if (enemy.isDead()) {
			calculateResult(enemy);
			return true;
		} else if (player.isDead()) {
			endGame();
			return true;
		}
		return false;
	}

	private void endGame() {
		this.isRun = false;
		System.out.println("[패배]");
	}

	private void calculateResult(Unit enemy) {
		int exp = enemy.getExp();
		int potions = enemy.getItems();
		
		System.out.println("==== 결과 ====");
		System.out.println(player);
		System.out.println(enemy);
		
		if (potions > 0) {
			System.out.printf("포션 %d개 발견!\n", potions);
		}
		
		player.setExp(exp);
		player.setItems(potions);
		player.setLv();
	}

	private void printFightMenu(Unit enemy) {
		System.out.println("[1] 공격하기");
		System.out.println("[2] 포션마시기");
		runFightMenu(inputNumber("menu"), enemy);
	}

	private void runFightMenu(int choice, Unit enemy) {
		if (choice == ATTACK)
			attack(enemy);
		else if (choice == POTION)
			drinkPotion();
	}

	private void attack(Unit enemy) {
		int myAttack = player.damage();
		int enemyAttack = enemy.damage();

		System.out.printf("내 공격 : %d\n", myAttack);
		System.out.printf("적 공격 : %d\n", enemyAttack);
		player.setCurrentHp(enemyAttack);
		enemy.setCurrentHp(myAttack);
	}

	private void drinkPotion() {
		if (player.setItems(-1)) {
			System.out.println("체력 20회복");
			player.setCurrentHp(-20);
		}
	}

	public void run() {
		while (isRun) {
			printGame();
			runGame(inputNumber("menu"));
		}
	}
}
