package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

import com.google.gson.Gson;

import repository.FileDao;
import vo.MyFile;
import vo.UploadFile;

@Controller
public class FileController {
	
	@Autowired
	private FileDao dao;
	public void setDao(FileDao dao){
		this.dao = dao;
	}
	
	@RequestMapping("/fileList.do")
	public ModelAndView fileList(){
		ModelAndView mv = new ModelAndView("file_list");
		mv.addObject("fileList", dao.selectAll());
		return mv;
	}
	
	@RequestMapping("/uploadForm.do")
	public String uploadForm(){
		return "upload_form";
	}
	
	@RequestMapping(value="/upload.do", method=RequestMethod.POST)
	public ModelAndView upload(HttpServletRequest req, UploadFile uploadFile){
		String savePath = req.getServletContext().getRealPath("img");
		
		File dir = new File(savePath);
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		// 사용자가 업로드한 여러개의 파일 각각을 ~~/img/폴더에 저장한 후 데이터베이스 기록하는 반복문
		for(MultipartFile f : uploadFile.getFileList()){
			String savedName = savePath + "/" + 
							f.getOriginalFilename() + new Random().nextInt(100000000);
			File savedFile = new File(savedName);
			
			try {
				f.transferTo(savedFile); // 실제 업로드 작업
				
				MyFile myFile = new MyFile();
				myFile.setOriginalName(f.getOriginalFilename());
				myFile.setSavedPath(savedFile.getAbsolutePath());
				
				// 반복문 내의 현재 파일 업로드 정보를 DB에 기록
				dao.insert(myFile);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		ModelAndView mv = new ModelAndView("upload_result");
		mv.addObject("fileCount", uploadFile.getFileList().size());
		return mv;
	}
	
	@RequestMapping("/downloadFile.do")
    public void downloadFile
            (HttpServletResponse response,HttpServletRequest request, int fileNum) throws UnsupportedEncodingException{
        MyFile myFile = dao.select(fileNum);
        String fileName = myFile.getOriginalName();
        
        String header = getBrowser(request);
        if (header.contains("MSIE")) {
               String docName = URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+", "%20");
               response.setHeader("Content-Disposition", "attachment;filename=" + docName + ";");
        } else if (header.contains("Firefox")) {
               String docName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
               response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
        } else if (header.contains("Opera")) {
               String docName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
               response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
        } else if (header.contains("Chrome")) {
               String docName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
               response.setHeader("Content-Disposition", "attachment; filename=\"" + docName + "\"");
        }
        response.setHeader("Content-Type", "application/octet-stream");
        response.setHeader("Content-Transfer-Encoding", "binary;");
        response.setHeader("Pragma", "no-cache;");
        response.setHeader("Expires", "-1;");
        
        // 한글, 영문 제목 다운의 경우 위의 setHeader를 사용해줘야함.
//        response.setContentType("application/octet-stream; charset=UTF-8");
//        response.setHeader("Content-Disposition", "attachment; filename=\""+myFile.getOriginalName()+"\"");
 
        try {
            // 다운로드 해줄 파일 읽어들이는 Stream
            FileInputStream is = new FileInputStream(myFile.getSavedPath());
            // 읽어들인 파일을 보낼 response의 Stream
            ServletOutputStream os = response.getOutputStream();
 
//          byte[] buf = new byte[1024];
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
	
	private String getBrowser(HttpServletRequest request) {
        String header =request.getHeader("User-Agent");
        if (header.contains("MSIE")) {
               return "MSIE";
        } else if(header.contains("Chrome")) {
               return "Chrome";
        } else if(header.contains("Opera")) {
               return "Opera";
        }
        return "Firefox";
  }
	
	
//	

@RequestMapping("test.do")
    public void test(String command,HttpServletResponse res){
        System.out.println(command);
        Gson gson = new Gson();
        
        String result = gson.toJson(command);
        try {
            res.getWriter().write(result);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	
}
