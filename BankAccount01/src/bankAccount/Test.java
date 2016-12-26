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
		System.out.println("TM Bank�� ���Ű� ȯ���մϴ�.");
		try {
			while (isExit) {
				System.out.println("���ϴ� ������ ������ �ֽʽÿ�.");
				System.out.println("1.���»��� 2.�Ա� 3.��� 4.�۱�");
				System.out.println("5.�Աݳ�����ȸ 6.��ݳ�����ȸ 7.������ȸ");
				System.out.println("8.����Ż�� 0.����");
				choice = scan.nextInt();
				if (choice == 0) {
					isExit = false;
					System.out.println("�ý����� �����մϴ�.");
				} else if (choice == 1) {
					System.out.println("���»����� �����մϴ�.");
					System.out.println("�̸��� �Է��Ͻʽÿ�.");
					String name = scan.next();
					System.out.println("��й�ȣ�� �Է��Ͻʽÿ�.");
					String password = scan.next();
					System.out.println("���ʷ� �Ա��� �׼��� �Է��Ͻʽÿ�");
					int deposit = scan.nextInt();
					System.out.println("���»����մϴ�.");
					int createAccountResult = service.createAccount(name, deposit, password);
					if (createAccountResult == 0) {
						System.out.println("���� ���� �����Դϴ�. �ٽ� �õ��Ͻʽÿ�.");
						isExit = false;
					} else if (createAccountResult == 1) {
						AccountVO firstProduct = service.firstCreate();
						tservice.writeDepositRecord(firstProduct.getAccountNum(),deposit);
						System.out.println("������ ������ �����Դϴ�.");
						System.out.println("�̸�:" + firstProduct.getName());
						System.out.println("���¹�ȣ:" + firstProduct.getAccountNum());
						System.out.println("���»�����:" + firstProduct.getCreateDate());
						System.out.println("���ݾ�:" + firstProduct.getBalance());
						System.out.println("��й�ȣ:" + firstProduct.getPassword());
					}
				} else if (choice == 2) {
					System.out.println("���¹�ȣ�� �Է��ϼ���.");
					String accountNum = scan.next();
					System.out.println("�Ա��Ͻ� �ݾ��� �Է��ϼ���.");
					int deposit = scan.nextInt();
					int increaseDepositResult = service.increaseBalance(accountNum, deposit);
					if (increaseDepositResult == 0) {
						System.out.println("�Ա� �����Դϴ�. �ٽ� �õ��Ͻʽÿ�.");
						isExit = false;
					} else if (increaseDepositResult == 1) {
						AccountVO account = service.select(accountNum);
						tservice.writeDepositRecord(accountNum,deposit);
						System.out.println("�ܰ�:" + account.getBalance());
					}
				} else if (choice == 3) {
					System.out.println("���¹�ȣ�� �Է��ϼ���.");
					String accountNum = scan.next();
					System.out.println("����Ͻ� �ݾ��� �Է��ϼ���.");
					int withdraw = scan.nextInt();
					System.out.println("��й�ȣ�� �Է��ϼ���.");
					String password = scan.next();

					boolean checkPasswordResult = service.checkPassword(accountNum, password);
					if (!checkPasswordResult) {
						isExit = false;
					}

					AccountVO account = service.select(accountNum);
					if (withdraw > account.getBalance()) {
						System.out.println("�ܰ����");
					} else {
						int withdrawResult = service.withdraw(accountNum, withdraw);
						if (withdrawResult == 0) {
							System.out.println("��� �����Դϴ�. �ٽ� �õ��Ͻʽÿ�.");
							isExit = false;
						} else if (withdrawResult == 1) {
							AccountVO select = service.select(accountNum);
							tservice.writeWithdrawRecord(accountNum,withdraw);
							System.out.println("�ܰ�:" + select.getBalance());
						}
					}

				} else if (choice == 4) {
					System.out.println("������ ���¹�ȣ�� �Է��ϼ���.");
					String accountNum = scan.next();
					System.out.println("�۱��Ͻ� �ݾ��� �Է��ϼ���.");
					int remitt = scan.nextInt();
					System.out.println("��й�ȣ�� �Է��ϼ���.");
					String password = scan.next();
					System.out.println("�۱��Ͻ� ���¹�ȣ�� �Է��ϼ���.");
					String remittAccountNum = scan.next();

					boolean checkPasswordResult = service.checkPassword(accountNum, password);
					if (!checkPasswordResult) {
						isExit = false;
					}

					AccountVO account = service.select(accountNum);
					if (remitt > account.getBalance()) {
						System.out.println("�ܰ����");
					} else {
						int remittResult = service.remitt(accountNum, remittAccountNum, remitt);
						if (remittResult == 0) {
							System.out.println("�۱� �����Դϴ�. �ٽ� �õ��Ͻʽÿ�.");
							isExit = false;
						} else if (remittResult == 1) {
							System.out.println("�۱� �Ϸ��߽��ϴ�.");
							tservice.writeDepositRecord(accountNum,remitt);
							tservice.writeWithdrawRecord(remittAccountNum,remitt);
							AccountVO select = service.select(accountNum);
							System.out.println("�ܰ�:" + select.getBalance());
						}

					}
				} else if (choice == 5) {
					System.out.println("������ ���¹�ȣ�� �Է��ϼ���.");
					String accountNum = scan.next();
					System.out.println("��й�ȣ�� �Է��ϼ���.");
					String password = scan.next();
					
					boolean checkPasswordResult = service.checkPassword(accountNum, password);
					if (!checkPasswordResult) {
						isExit = false;
					}
					
					System.out.println("1.�ֱ�10ȸ �ӱݳ��� / 2.��� �Աݳ���");
					int flag = scan.nextInt();
					if(flag == 1) {
						//�ֱ� 10ȸ��ȸ
						List<TransactVO> askDepositRecentResult = tservice.askDepositRecent(accountNum);
						System.out.println("----"+accountNum+"�� �ֱ� 10ȸ �Աݳ���"+"----");
						for(TransactVO report : askDepositRecentResult){
							System.out.println("�Ա���:"+report.getDate() + "/ �Աݾ�:" + report.getDeposit());
						}
						System.out.println("---------------------------------------");
					} else if(flag == 2) {
						//��� ������ȸ
						List<TransactVO> askDepositAllResult = tservice.askDepositAll(accountNum);
						System.out.println(accountNum+"�� ��� �Աݳ���");
						for(TransactVO report : askDepositAllResult){
							System.out.println("�Ա���:"+report.getDate() + "/ �Աݾ�:" + report.getDeposit());
						}
						System.out.println("---------------------------------------");
					} else {
						System.out.println("1 Ȥ�� 2�� ������ �ֽʽÿ�. �ٽ� �õ��Ͻʽÿ�.");
						isExit = false;
					}
					
				} else if (choice == 6) {
					System.out.println("������ ���¹�ȣ�� �Է��ϼ���.");
					String accountNum = scan.next();
					System.out.println("��й�ȣ�� �Է��ϼ���.");
					String password = scan.next();
					
					boolean checkPasswordResult = service.checkPassword(accountNum, password);
					if (!checkPasswordResult) {
						isExit = false;
					}
					
					System.out.println("1.�ֱ�10ȸ ��ݳ��� / 2.��� ��ݳ���");
					int flag = scan.nextInt();
					if(flag == 1) {
						//�ֱ� 10ȸ��ȸ
						List<TransactVO> askWithdrawRecentResult = tservice.askWithdrawRecent(accountNum);
						System.out.println("----"+accountNum+"�� �ֱ� 10ȸ ��ݳ���"+"----");
						for(TransactVO report : askWithdrawRecentResult){
							System.out.println("�����:"+report.getDate() + "/ ��ݾ�:" + report.getDeposit());
						}
						System.out.println("---------------------------------------");
					} else if(flag == 2) {
						//��� ������ȸ
						List<TransactVO> askWithdrawAllResult = tservice.askWithdrawAll(accountNum);
						System.out.println(accountNum+"�� ��� ��ݳ���");
						for(TransactVO report : askWithdrawAllResult){
							System.out.println("�����:"+report.getDate() + "/ ��ݾ�:" + report.getDeposit());
						}
						System.out.println("---------------------------------------");
					} else {
						System.out.println("1 Ȥ�� 2�� ������ �ֽʽÿ�. �ٽ� �õ��Ͻʽÿ�.");
						isExit = false;
					}
					
				} else if (choice == 7) {
					System.out.println("������ ���¹�ȣ�� �Է��ϼ���.");
					String accountNum = scan.next();
					System.out.println("��й�ȣ�� �Է��ϼ���.");
					String password = scan.next();
					AccountVO account = service.select(accountNum);
					if (account.getPassword().equals(password)) {
						System.out.println(account.getName() + "���� ���������Դϴ�.");
						System.out.println("�̸�:" + account.getName());
						System.out.println("���¹�ȣ:" + account.getAccountNum());
						System.out.println("���»�����:" + account.getCreateDate());
						System.out.println("���ݾ�:" + account.getBalance());
						System.out.println("��й�ȣ:" + account.getPassword());

					}
				} else {
					isExit = false;
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("������ Ÿ���� �Է��Ͻʽÿ�.");
		}
		System.out.println("TM Bank�� �����մϴ�.");
	}
}
