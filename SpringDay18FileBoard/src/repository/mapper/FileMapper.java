package repository.mapper;

import java.util.List;

import vo.MyFile;

public interface FileMapper {
	public int insert(MyFile myFile);
	public MyFile select(int fileNum);
	public List<MyFile> selectAll();
}
