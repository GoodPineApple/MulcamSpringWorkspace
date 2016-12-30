package vo;

public class MyFile {
		private int fileNum;
		private String originalName;
		private String savedPath;
//////////////////////////////////////////////////////
		public MyFile(){}
		public MyFile(int fileNum, String originalName, String savedPath) {
			this.fileNum = fileNum;
			this.originalName = originalName;
			this.savedPath = savedPath;
		}
///////////////////////////////////////////////////////		
		public int getFileNum() {
			return fileNum;
		}
		public void setFileNum(int fileNum) {
			this.fileNum = fileNum;
		}
		public String getOriginalName() {
			return originalName;
		}
		public void setOriginalName(String originalName) {
			this.originalName = originalName;
		}
		public String getSavedPath() {
			return savedPath;
		}
		public void setSavedPath(String savedPath) {
			this.savedPath = savedPath;
		}
		@Override
		public String toString() {
			return "MyFile [fileNum=" + fileNum + ", originalName=" + originalName + ", savedPath=" + savedPath + "]";
		}
		
}
