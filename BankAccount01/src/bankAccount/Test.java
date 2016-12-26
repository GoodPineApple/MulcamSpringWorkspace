package bankAccount;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.sql.rowset.spi.TransactionalWriter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bankAccount.vo.AccountVO;
import bankAccount.vo.TransactVO;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bankAccount/applicationContext.xml");

		AccountService service = context.getBean("service", AccountService.class);
		TransactService tservice = context.getBean("transactService", TransactService.class);

		Scanner scan = new Scanner(System.in);

		boolean isExit = true;
		int choice = 100;
		System.out.println("TM Bank에 오신걸 환영합니다.");
		try {
			while (isExit) {
				System.out.println("원하는 동작을 선택해 주십시오.");
				System.out.println("1.계좌생성 2.입금 3.출금 4.송금");
				System.out.println("5.입금내역조회 6.출금내역조회 7.계좌조회");
				System.out.println("8.계좌탈퇴 0.종료");
				choice = scan.nextInt();
				if (choice == 0) {
					isExit = false;
					System.out.println("시스템을 종료합니다.");
				} else if (choice == 1) {
					System.out.println("계좌생성을 진행합니다.");
					System.out.println("이름을 입력하십시오.");
					String name = scan.next();
					System.out.println("비밀번호를 입력하십시오.");
					String password = scan.next();
					System.out.println("최초로 입금할 액수를 입력하십시오");
					int deposit = scan.nextInt();
					System.out.println("계좌생성합니다.");
					int createAccountResult = service.createAccount(name, deposit, password);
					if (createAccountResult == 0) {
						System.out.println("계좌 생성 오류입니다. 다시 시도하십시오.");
						isExit = false;
					} else if (createAccountResult == 1) {
						AccountVO firstProduct = service.firstCreate();
						tservice.writeDepositRecord(firstProduct.getAccountNum(),deposit);
						System.out.println("생성된 계좌의 정보입니다.");
						System.out.println("이름:" + firstProduct.getName());
						System.out.println("계좌번호:" + firstProduct.getAccountNum());
						System.out.println("계좌생성일:" + firstProduct.getCreateDate());
						System.out.println("예금액:" + firstProduct.getBalance());
						System.out.println("비밀번호:" + firstProduct.getPassword());
					}
				} else if (choice == 2) {
					System.out.println("계좌번호를 입력하세요.");
					String accountNum = scan.next();
					System.out.println("입금하실 금액을 입력하세요.");
					int deposit = scan.nextInt();
					int increaseDepositResult = service.increaseBalance(accountNum, deposit);
					if (increaseDepositResult == 0) {
						System.out.println("입금 오류입니다. 다시 시도하십시오.");
						isExit = false;
					} else if (increaseDepositResult == 1) {
						AccountVO account = service.select(accountNum);
						tservice.writeDepositRecord(accountNum,deposit);
						System.out.println("잔고:" + account.getBalance());
					}
				} else if (choice == 3) {
					System.out.println("계좌번호를 입력하세요.");
					String accountNum = scan.next();
					System.out.println("출금하실 금액을 입력하세요.");
					int withdraw = scan.nextInt();
					System.out.println("비밀번호를 입력하세요.");
					String password = scan.next();

					boolean checkPasswordResult = service.checkPassword(accountNum, password);
					if (!checkPasswordResult) {
						isExit = false;
					}

					AccountVO account = service.select(accountNum);
					if (withdraw > account.getBalance()) {
						System.out.println("잔고부족");
					} else {
						int withdrawResult = service.withdraw(accountNum, withdraw);
						if (withdrawResult == 0) {
							System.out.println("출금 오류입니다. 다시 시도하십시오.");
							isExit = false;
						} else if (withdrawResult == 1) {
							AccountVO select = service.select(accountNum);
							tservice.writeWithdrawRecord(accountNum,withdraw);
							System.out.println("잔고:" + select.getBalance());
						}
					}

				} else if (choice == 4) {
					System.out.println("본인의 계좌번호를 입력하세요.");
					String accountNum = scan.next();
					System.out.println("송금하실 금액을 입력하세요.");
					int remitt = scan.nextInt();
					System.out.println("비밀번호를 입력하세요.");
					String password = scan.next();
					System.out.println("송금하실 계좌번호를 입력하세요.");
					String remittAccountNum = scan.next();

					boolean checkPasswordResult = service.checkPassword(accountNum, password);
					if (!checkPasswordResult) {
						isExit = false;
					}

					AccountVO account = service.select(accountNum);
					if (remitt > account.getBalance()) {
						System.out.println("잔고부족");
					} else {
						int remittResult = service.remitt(accountNum, remittAccountNum, remitt);
						if (remittResult == 0) {
							System.out.println("송금 오류입니다. 다시 시도하십시오.");
							isExit = false;
						} else if (remittResult == 1) {
							System.out.println("송금 완료했습니다.");
							tservice.writeDepositRecord(accountNum,remitt);
							tservice.writeWithdrawRecord(remittAccountNum,remitt);
							AccountVO select = service.select(accountNum);
							System.out.println("잔고:" + select.getBalance());
						}

					}
				} else if (choice == 5) {
					System.out.println("본인의 계좌번호를 입력하세요.");
					String accountNum = scan.next();
					System.out.println("비밀번호를 입력하세요.");
					String password = scan.next();
					
					boolean checkPasswordResult = service.checkPassword(accountNum, password);
					if (!checkPasswordResult) {
						isExit = false;
					}
					
					System.out.println("1.최근10회 임금내역 / 2.모든 입금내역");
					int flag = scan.nextInt();
					if(flag == 1) {
						//최근 10회조회
						List<TransactVO> askDepositRecentResult = tservice.askDepositRecent(accountNum);
						System.out.println("----"+accountNum+"의 최근 10회 입금내역"+"----");
						for(TransactVO report : askDepositRecentResult){
							System.out.println("입금일:"+report.getDate() + "/ 입금액:" + report.getDeposit());
						}
						System.out.println("---------------------------------------");
					} else if(flag == 2) {
						//모든 내역조회
						List<TransactVO> askDepositAllResult = tservice.askDepositAll(accountNum);
						System.out.println(accountNum+"의 모든 입금내역");
						for(TransactVO report : askDepositAllResult){
							System.out.println("입금일:"+report.getDate() + "/ 입금액:" + report.getDeposit());
						}
						System.out.println("---------------------------------------");
					} else {
						System.out.println("1 혹은 2를 선택해 주십시오. 다시 시도하십시오.");
						isExit = false;
					}
					
				} else if (choice == 6) {
					System.out.println("본인의 계좌번호를 입력하세요.");
					String accountNum = scan.next();
					System.out.println("비밀번호를 입력하세요.");
					String password = scan.next();
					
					boolean checkPasswordResult = service.checkPassword(accountNum, password);
					if (!checkPasswordResult) {
						isExit = false;
					}
					
					System.out.println("1.최근10회 출금내역 / 2.모든 출금내역");
					int flag = scan.nextInt();
					if(flag == 1) {
						//최근 10회조회
						List<TransactVO> askWithdrawRecentResult = tservice.askWithdrawRecent(accountNum);
						System.out.println("----"+accountNum+"의 최근 10회 출금내역"+"----");
						for(TransactVO report : askWithdrawRecentResult){
							System.out.println("출금일:"+report.getDate() + "/ 출금액:" + report.getDeposit());
						}
						System.out.println("---------------------------------------");
					} else if(flag == 2) {
						//모든 내역조회
						List<TransactVO> askWithdrawAllResult = tservice.askWithdrawAll(accountNum);
						System.out.println(accountNum+"의 모든 출금내역");
						for(TransactVO report : askWithdrawAllResult){
							System.out.println("출금일:"+report.getDate() + "/ 출금액:" + report.getDeposit());
						}
						System.out.println("---------------------------------------");
					} else {
						System.out.println("1 혹은 2를 선택해 주십시오. 다시 시도하십시오.");
						isExit = false;
					}
					
				} else if (choice == 7) {
					System.out.println("본인의 계좌번호를 입력하세요.");
					String accountNum = scan.next();
					System.out.println("비밀번호를 입력하세요.");
					String password = scan.next();
					AccountVO account = service.select(accountNum);
					if (account.getPassword().equals(password)) {
						System.out.println(account.getName() + "님의 계좌정보입니다.");
						System.out.println("이름:" + account.getName());
						System.out.println("계좌번호:" + account.getAccountNum());
						System.out.println("계좌생성일:" + account.getCreateDate());
						System.out.println("예금액:" + account.getBalance());
						System.out.println("비밀번호:" + account.getPassword());

					}
				} else {
					isExit = false;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("적절한 타입을 입력하십시오.");
		}
		System.out.println("TM Bank를 종료합니다.");
	}
}
