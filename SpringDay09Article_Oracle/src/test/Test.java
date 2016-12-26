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
			System.out.println("1.글 목록보기(쪽수 입력) 2.글 쓰기 3.글 읽기(글번호 입력) 4.글 내용 수정하기 5.글 삭제하기 6.답글 달기");
			int choice = scan.nextInt();
			if(choice == 1) {
//				System.out.println("조회 가능한 쪽수 : "+ service.checkAblePage());
//				System.out.print("조회를 원하는 쪽수를 입력하십시오 : ");
//				int page = scan.nextInt();
//				for(Article a : service.selectListPerPage(page)){
//					System.out.println(a.getArticleNum()+")제목:"+a.getTitle()+", 글쓴이:"+a.getWriter()
//								+", 내용:"+a.getCt()+", 조회수:"+a.getHits()+", 게시일:"+a.getCreateDate());
//				}	
				
				// 쪽수 구현해야함. oracle은 limit가 없으므로 다른 방법을 찾아야됨
				// 링크 참조
				http://stylegoths.blogspot.kr/2013/02/oracle-dbms-limit.html
				
				for(Article a : service.selectList()){
					System.out.println(a.getArticleNum()+")제목:"+a.getTitle()+", 글쓴이:"+a.getWriter()
								+", 조회수:"+a.getHits()+", 게시일:"+a.getCreateDate());
				}	
			} else if(choice == 2) {
				System.out.println("제목 입력");
				String title = scan.next();
				System.out.println("글쓴이 입력");
				String writer = scan.next();
				System.out.println("내용 입력");
				String ct = scan.next();
				System.out.println("비밀번호 입력");
				String pw = scan.next();
				int insertResult = service.insert(title, ct, writer, pw);
				if(insertResult == 1){
					System.out.println("글쓰기를 완료했습니다.");
				} else if(insertResult == 0){
					System.out.println("글쓰기 에러");
					isExit = false;
				}
			} else if(choice == 3) {
				System.out.println("글번호 입력");
				int articleNum = scan.nextInt();
				Article a = service.select(articleNum);
				System.out.println(a.getArticleNum()+")제목:"+a.getTitle()+", 글쓴이:"+a.getWriter()
				+", 내용:"+a.getCt()+", 게시일:"+a.getCreateDate());
			} else if(choice == 4) {
				System.out.println("수정할 글번호 입력");
				int articleNum = scan.nextInt();
				System.out.println("비밀번호 입력");
				String pw = scan.next();
				Article article = service.select(articleNum);
				
				String result = service.checkPassword(article.getArticleNum(),pw);
				System.out.println(result);
				if(result == "비밀번호를 다시 확인해주세요.") continue;
				
				System.out.println("원본 글제목 : " + article.getTitle());
				System.out.print("수정 글제목 입력 : ");
				String updateTitle = scan.next();
				System.out.println("원본 글내용 : " + article.getCt());
				System.out.print("수정 글내용 입력 : ");
				String updatect = scan.next();
				System.out.println("원본 글쓴이 : " + article.getCt());
				System.out.print("수정 글쓴이 입력 : ");
				String updateWriter = scan.next();
				System.out.println("원본 비밀번호 : " + article.getCt());
				System.out.print("수정 비밀번호 입력 : ");
				String updatepw = scan.next();
				String updateResult = service.update(articleNum, updateTitle, updatect, updateWriter, updatepw);
				System.out.println(updateResult);
			} else if(choice == 5) {
				System.out.println("삭제할 글번호 입력");
				int articleNum = scan.nextInt();
				System.out.println("비밀번호 입력");
				String pw = scan.next();
				Article article = service.select(articleNum);
				
				String result = service.checkPassword(article.getArticleNum(),pw);
				System.out.println(result);
				if(result == "비밀번호를 다시 확인해주세요.") continue;
				
				String deleteResult = service.delete(articleNum);
				System.out.println(deleteResult);
			} else if(choice == 6){
				System.out.println("답글 달 글의 글번호를 입력하세요");
				int parentsArticleNum = scan.nextInt();
				System.out.println("제목 입력");
				String title = scan.next();
				System.out.println("글쓴이 입력");
				String writer = scan.next();
				System.out.println("내용 입력");
				String ct = scan.next();
				System.out.println("비밀번호 입력");
				String pw = scan.next();
				
				int insertResult = service.insertReply(parentsArticleNum, title, ct, writer, pw);
				if(insertResult == 1){
					System.out.println("글쓰기를 완료했습니다.");
				} else if(insertResult == 0){
					System.out.println("글쓰기 에러");
					isExit = false;
				}
			}else if(choice == 100) {
				service.insert100();
			}else {
				System.out.println("타입에 맞는 숫자를 입력해주십시오.");
			}
		}
		System.out.println("프로그램 종료");
	}
}
