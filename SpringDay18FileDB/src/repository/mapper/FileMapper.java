package repository.mapper;

import java.util.List;

import vo.MyFile;

public interface FileMapper {
	public int insert(MyFile file);
	public MyFile select(int fileNum);
	public List<MyFile> selectAll();
}
