package exercise;

import java.util.Scanner;

public class BankApplication {
	private static BankAccount[] accountArray = new BankAccount[100];
	private static Scanner sc = new Scanner(System.in);
	static int count = 0;

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("-----------------------------------------------------");
			System.out.print("선택> ");

			int selectNo = Integer.parseInt(sc.nextLine());
			if (selectNo == 1) {
				createAccount();
				count++;
			} else if (selectNo == 2) {
				accountList();
			} else if (selectNo == 3) {
				deposit();
			} else if (selectNo == 4) {
				withdraw();
			} else if (selectNo == 5) {
				run = false;
			} else {
				System.out.println("잘못된 값입니다. 다시 입력해 주세요.");
			}
		}
		System.out.println("프로그램 종료");
	}

	/* 계좌 생성하기 */
	private static void createAccount() {
		System.out.print("계좌번호:");
		String accNo = sc.nextLine();
		System.out.print("계좌주:");
		String accOwner = sc.nextLine();
		System.out.print("초기입금액:");
		int accBalance = Integer.parseInt(sc.nextLine());

		accountArray[count] = new BankAccount(accNo, accOwner, accBalance);

		System.out.println("결과: 계좌가 생성되었습니다.");
	}

	/* 계좌 목록 보기 */
	private static void accountList() {
		System.out.println("-------------");
		System.out.println("계좌목록");
		System.out.println("-------------");
		for (int i = 0; i < count; i++)
			System.out.println(
					accountArray[i].getAno() + "\t" + accountArray[i].getOwner() + "\t" + accountArray[i].getBalance());
	}

	/* 예금하기 */
	private static void deposit() {
		System.out.println("-------------");
		System.out.println("예금");
		System.out.println("-------------");
		System.out.print("계좌번호:");
		String accNo = sc.nextLine();
		System.out.print("예금액:");
		int accDeposit = Integer.parseInt(sc.nextLine());
		if (accDeposit < 0) {
			System.out.println("예금액은 음수가 될 수 없습니다. 다시 입력해 주세요.");
			return;
		}
		BankAccount bankAccount = findAccount(accNo);
		accDeposit += bankAccount.getBalance();
		bankAccount.setBalance(accDeposit);

		System.out.println("예금이 성공되었습니다.");
	}

	/* 출금하기 */
	private static void withdraw() {
		System.out.println("-------------");
		System.out.println("출금");
		System.out.println("-------------");
		System.out.print("계좌번호:");
		String accNo = sc.nextLine();
		System.out.print("출금액:");
		int accWithdraw = Integer.parseInt(sc.nextLine());
		
		if (accWithdraw > findAccount(accNo).getBalance()) {
			System.out.println("보유 잔고보다 높은 금액은 출금될 수 없습니다. 다시 입력해 주세요.");
			return;
		}
		BankAccount bankAccount = findAccount(accNo);
		bankAccount.setBalance(bankAccount.getBalance() - accWithdraw);
		
		System.out.println("출금이 성공되었습니다.");
	}

	// BankAccount 배열에서 ano와 동일한 BankAccount 객체 찾기
	private static BankAccount findAccount(String ano) {
		for (int i = 0; i < count; i++) {
			// if (accountArray[i].getAno() == ano) 안됨!!
			if (accountArray[i].getAno().equals(ano))
				return accountArray[i];
		}
		return null;
	}
}
