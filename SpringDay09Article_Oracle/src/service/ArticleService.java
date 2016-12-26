package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.ArticleDao;
import vo.Article;

@Component(value="articleService")
public class ArticleService {
	@Autowired
	private ArticleDao dao;
	
	public ArticleService(ArticleDao dao){
		this.dao = dao;
	}
	
	public ArticleService(){}
	
	public int insert(String title, String ct, String writer, String pw){
		Article article = new Article(writer, pw, title, ct);
		return dao.insert(article);
	}
	
	public int update(Article article){
		return dao.update(article);
	}
	
	public String update(int articleNum, String updateTitle, String updatect, 
												String updateWriter, String updatepw){
		Article article = new Article(updateWriter, updatepw, updateTitle, updatect);
		article.setArticleNum(articleNum);
		int updateResult = dao.update(article);
		if(updateResult == 1) {
			return "�����Ϸ�";
		} else {
			return "��������";
		}
	}
	
	public String delete(int articleNum){
		int deleteResult = dao.delete(articleNum);
		if(deleteResult == 1) {
			return "�����Ϸ�";
		} else {
			return "��������";
		}
	}
	
	public Article select(int articleNum){
		dao.updateHit(articleNum);
		return dao.select(articleNum);
	}
	
	public List<Article> selectList(){
		return dao.selectList();
	}

	public String checkPassword(int articleNum, String pw) {
		Article article = dao.select(articleNum);
		if(pw.equals(article.getPw())){
			return "��й�ȣ�� ��ġ�մϴ�.";
		} else {
			return "��й�ȣ�� �ٽ� Ȯ�����ּ���.";
		}
	}

	public void insert100() {
		Article article = new Article("Test","1234","Test","Test");
		for(int i=0; i<10; i++){
			dao.insert(article);
		}
		System.out.println("10�� �Է�");
	}

	public String checkAblePage() {
		int totalArticle = dao.selectCount();
		String ablePage = "";
		int pageNum;
		int i = 1;
		for( i=1; i*10<totalArticle; i++){
			if((totalArticle - i*10) > 0){
				ablePage += "["+i + "] / ";
			}
		}
		if(totalArticle < 10 || totalArticle%10 == 0) ablePage += "["+i + "] / ";
		if(totalArticle == 0) ablePage = "��ϵ� �Խñ��� �����ϴ�.";
		return ablePage;
	}

	public List<Article> selectListPerPage(int page) {
		int start = (page-1)*10;
		int end = 10;
		List<Article> articleList = dao.selectListPerPage(start, end);
		return null;
	}

	public int insertReply(int parentsArticleNum, String title, String ct, String writer, String pw) {
		Article parentsArticle = dao.select(parentsArticleNum);
		System.out.println(dao.updateStep(parentsArticle));
		
		int childGp = parentsArticle.getGp();
		int childStep = parentsArticle.getStep() + 1;
		
		String childTitle = "->";			
		for(int i=1; i<parentsArticle.getStep(); i++){
			childTitle += "->";
		}
		childTitle += title;
		Article childArticle = new Article(writer, pw, childTitle, ct);
		childArticle.setGp(childGp);
		childArticle.setStep(childStep);
		int result = dao.insertReply(childArticle);
		return result;
	}

}
