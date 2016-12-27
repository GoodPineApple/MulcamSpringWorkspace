package vo;

import java.util.List;

public class ArticlePage {
	private List<Article> articleList;
	private int startPage;
	private int endPage;
	private int totalPage;
	private int currentPage;
	
	public ArticlePage(){}
	
	public ArticlePage(List<Article> articleList, int startPage, int endPage, int totalPage, int currentPage) {
		super();
		this.articleList = articleList;
		this.startPage = startPage;
		this.endPage = endPage;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
	}
	public List<Article> getArticleList() {
		return articleList;
	}
	public void setArticleList(List<Article> articleList) {
		this.articleList = articleList;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "ArticlePage [articleList=" + articleList + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", totalPage=" + totalPage + ", currentPage=" + currentPage + "]";
	}
	
	
}
