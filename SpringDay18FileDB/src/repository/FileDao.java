package repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import repository.mapper.FileMapper;
import vo.MyFile;

@Component
public class FileDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session){
		this.session = session;
	}
	
	public int insert(MyFile myFile){
		FileMapper mapper = session.getMapper(FileMapper.class);
		return mapper.insert(myFile);
	}
	
	public MyFile select(int fileNum){
		FileMapper mapper = session.getMapper(FileMapper.class);
		return mapper.select(fileNum);
	}
	
	public List<MyFile> selectAll(){
		FileMapper mapper = session.getMapper(FileMapper.class);
		return mapper.selectAll();
	}
	
}
