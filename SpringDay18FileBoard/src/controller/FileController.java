package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import repository.FileDao;
import vo.MyFile;
import vo.UploadFile;

@Controller
public class FileController {
	@Autowired
	private FileDao dao;
	public void setDao(FileDao dao) {
		this.dao = dao;
	}
////////////////////////////////////////////////////////
	@RequestMapping("/fileList.do")
	public ModelAndView fileList(){
		ModelAndView mv = new ModelAndView("file_list");
		mv.addObject("fileList", dao.selectAllFile());
		return mv;
	}
	
	@RequestMapping("/uploadForm.do")
	public String uploadForm(){
		return "upload_form";
	}
	
	@RequestMapping
		(value="/uploadFile.do", method=RequestMethod.POST)
	public ModelAndView upload
	(HttpServletRequest request,UploadFile uploadFile){
		String savePath = 
				request.getServletContext()
					.getRealPath("img");
		
		File dir = new File(savePath);
		if (dir.exists() == false) {
			dir.mkdir();
		}
		
// 사용자가 업로드한 여러개의 파일 각각을 
// ~~/img/ 폴더에 저장한 후 데이터베이스 기록하는 반복문
		for(MultipartFile f: uploadFile.getFileList()){
			String savedName = 
					savePath + "/" + 
							f.getOriginalFilename() + 
							new Random().nextInt(1000000);
			File savedFile = new File(savedName);

			try {
				f.transferTo(savedFile);//실제 업로드 작업

				MyFile myFile = new MyFile();
				myFile.setOriginalName(f.getOriginalFilename());
				myFile.setSavedPath(savedFile.getAbsolutePath());
				
				// 반복문 내의 현재 파일 업로드 정보를 DB에 기록
				dao.insertFile(myFile);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
			
		}
		ModelAndView mv = new ModelAndView("upload_result");
		
		// 업로드 된 파일의 갯수
		mv.addObject("fileCount",
				uploadFile.getFileList().size());
		return mv;
	}

	@RequestMapping("/downloadFile.do")
	public void downloadFile
			(HttpServletResponse response,int fileNum){
		MyFile myFile = dao.selectFile(fileNum);
		
		response.setContentType
		("application/octet-stream; charset=EUC-KR");
		response.setHeader
		("Content-Disposition", 
				"attachment; filename=\""+myFile.getOriginalName()+"\"");

		try {
			// 다운로드 해줄 파일 읽어들이는 Stream
			FileInputStream is = new FileInputStream(myFile.getSavedPath());
			// 읽어들인 파일을 보낼 response의 Stream
			ServletOutputStream os = response.getOutputStream();

//			byte[] buf = new byte[1024];
			int size = 0;

			while ((size = is.read()) != -1) {
				os.write(size);
			}

			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//////////////////////////////////////////////////////
//  한글 이름으로 된 파일도 다운로드 시키려면
//	브라우저마다 다르게 인코딩 해서 이름 붙여줘야함.	
//	@RequestMapping("/download.do")
//	public void download(int item_id,HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
//		FileInfo info = dao.select(item_id);
//		
//		String header = getBrowser(request);
//		if (header.contains("MSIE")) {
//		       String docName = URLEncoder.encode(info.getOriginal_name(),"EUC-KR").replaceAll("\\+", "%20");
//		       response.setHeader("Content-Disposition", "attachment;filename=" + docName + ";");
//		} else if (header.contains("Firefox")) {
//		       String docName = new String(info.getOriginal_name().getBytes("EUC-KR"), "ISO-8859-1");
//		       response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
//		} else if (header.contains("Opera")) {
//		       String docName = new String(info.getOriginal_name().getBytes("EUC-KR"), "ISO-8859-1");
//		       response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
//		} else if (header.contains("Chrome")) {
//		       String docName = new String(info.getOriginal_name().getBytes("EUC-KR"), "ISO-8859-1");
//		       response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
//		}
//		response.setHeader("Content-Type", "application/octet-stream");
//		response.setHeader("Content-Transfer-Encoding", "binary;");
//		response.setHeader("Pragma", "no-cache;");
//		response.setHeader("Expires", "-1;");
//
////		response.setContentType("application/octet-stream; charset=EUC-KR");
////		response.setHeader("Content-Disposition", "attachment; filename=\"" + info.getOriginal_name() + "\"");
//
//		try {
//			// 다운로드 해줄 파일 읽어들이는 Stream
//			FileInputStream is = new FileInputStream(info.getSaved_name());
//			// 읽어들인 파일을 보낼 response의 Stream
//			ServletOutputStream os = response.getOutputStream();
//
//			byte[] buf = new byte[1024];
//			int size = 0;
//
//			while ((size = is.read(buf)) != -1) {
//				os.write(buf, 0, size);
//			}
//
//			is.close();
//			os.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//
//	private String getBrowser(HttpServletRequest request) {
//		String header = request.getHeader("User-Agent");
//		if (header.contains("MSIE")) {
//			return "MSIE";
//		} else if (header.contains("Chrome")) {
//			return "Chrome";
//		} else if (header.contains("Opera")) {
//			return "Opera";
//		}
//		return "Firefox";
//	}
}







