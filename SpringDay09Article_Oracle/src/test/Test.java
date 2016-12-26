package test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.ArticleService;
import vo.Article;

public class Test {
	public static void main(String[] args) {
		ApplicationContext context = new 
				ClassPathXmlApplicationContext("applicationContext.xml");
		ArticleService service = context.getBean(ArticleService.class);
		Scanner scan = new Scanner(System.in);
		
		boolean isExit = true;
		while(isExit){
			System.out.println("1.�� ��Ϻ���(�ʼ� �Է�) 2.�� ���� 3.�� �б�(�۹�ȣ �Է�) 4.�� ���� �����ϱ� 5.�� �����ϱ� 6.��� �ޱ�");
			int choice = scan.nextInt();
			if(choice == 1) {
//				System.out.println("��ȸ ������ �ʼ� : "+ service.checkAblePage());
//				System.out.print("��ȸ�� ���ϴ� �ʼ��� �Է��Ͻʽÿ� : ");
//				int page = scan.nextInt();
//				for(Article a : service.selectListPerPage(page)){
//					System.out.println(a.getArticleNum()+")����:"+a.getTitle()+", �۾���:"+a.getWriter()
//								+", ����:"+a.getCt()+", ��ȸ��:"+a.getHits()+", �Խ���:"+a.getCreateDate());
//				}	
				
				// �ʼ� �����ؾ���. oracle�� limit�� �����Ƿ� �ٸ� ����� ã�ƾߵ�
				// ��ũ ����
				http://stylegoths.blogspot.kr/2013/02/oracle-dbms-limit.html
				
				for(Article a : service.selectList()){
					System.out.println(a.getArticleNum()+")����:"+a.getTitle()+", �۾���:"+a.getWriter()
								+", ��ȸ��:"+a.getHits()+", �Խ���:"+a.getCreateDate());
				}	
			} else if(choice == 2) {
				System.out.println("���� �Է�");
				String title = scan.next();
				System.out.println("�۾��� �Է�");
				String writer = scan.next();
				System.out.println("���� �Է�");
				String ct = scan.next();
				System.out.println("��й�ȣ �Է�");
				String pw = scan.next();
				int insertResult = service.insert(title, ct, writer, pw);
				if(insertResult == 1){
					System.out.println("�۾��⸦ �Ϸ��߽��ϴ�.");
				} else if(insertResult == 0){
					System.out.println("�۾��� ����");
					isExit = false;
				}
			} else if(choice == 3) {
				System.out.println("�۹�ȣ �Է�");
				int articleNum = scan.nextInt();
				Article a = service.select(articleNum);
				System.out.println(a.getArticleNum()+")����:"+a.getTitle()+", �۾���:"+a.getWriter()
				+", ����:"+a.getCt()+", �Խ���:"+a.getCreateDate());
			} else if(choice == 4) {
				System.out.println("������ �۹�ȣ �Է�");
				int articleNum = scan.nextInt();
				System.out.println("��й�ȣ �Է�");
				String pw = scan.next();
				Article article = service.select(articleNum);
				
				String result = service.checkPassword(article.getArticleNum(),pw);
				System.out.println(result);
				if(result == "��й�ȣ�� �ٽ� Ȯ�����ּ���.") continue;
				
				System.out.println("���� ������ : " + article.getTitle());
				System.out.print("���� ������ �Է� : ");
				String updateTitle = scan.next();
				System.out.println("���� �۳��� : " + article.getCt());
				System.out.print("���� �۳��� �Է� : ");
				String updatect = scan.next();
				System.out.println("���� �۾��� : " + article.getCt());
				System.out.print("���� �۾��� �Է� : ");
				String updateWriter = scan.next();
				System.out.println("���� ��й�ȣ : " + article.getCt());
				System.out.print("���� ��й�ȣ �Է� : ");
				String updatepw = scan.next();
				String updateResult = service.update(articleNum, updateTitle, updatect, updateWriter, updatepw);
				System.out.println(updateResult);
			} else if(choice == 5) {
				System.out.println("������ �۹�ȣ �Է�");
				int articleNum = scan.nextInt();
				System.out.println("��й�ȣ �Է�");
				String pw = scan.next();
				Article article = service.select(articleNum);
				
				String result = service.checkPassword(article.getArticleNum(),pw);
				System.out.println(result);
				if(result == "��й�ȣ�� �ٽ� Ȯ�����ּ���.") continue;
				
				String deleteResult = service.delete(articleNum);
				System.out.println(deleteResult);
			} else if(choice == 6){
				System.out.println("��� �� ���� �۹�ȣ�� �Է��ϼ���");
				int parentsArticleNum = scan.nextInt();
				System.out.println("���� �Է�");
				String title = scan.next();
				System.out.println("�۾��� �Է�");
				String writer = scan.next();
				System.out.println("���� �Է�");
				String ct = scan.next();
				System.out.println("��й�ȣ �Է�");
				String pw = scan.next();
				
				int insertResult = service.insertReply(parentsArticleNum, title, ct, writer, pw);
				if(insertResult == 1){
					System.out.println("�۾��⸦ �Ϸ��߽��ϴ�.");
				} else if(insertResult == 0){
					System.out.println("�۾��� ����");
					isExit = false;
				}
			}else if(choice == 100) {
				service.insert100();
			}else {
				System.out.println("Ÿ�Կ� �´� ���ڸ� �Է����ֽʽÿ�.");
			}
		}
		System.out.println("���α׷� ����");
	}
}
