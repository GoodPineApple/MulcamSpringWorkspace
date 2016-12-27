package vo;

import org.springframework.web.multipart.MultipartFile;

public class Book {
	private String title;
	private MultipartFile myFile;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public MultipartFile getMyFile() {
		return myFile;
	}
	public void setMyFile(MultipartFile myFile) {
		this.myFile = myFile;
	}
	
	
}
