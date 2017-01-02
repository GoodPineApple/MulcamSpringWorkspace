package com.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
 
import com.board.domain.BoardVo;
import com.board.mapper.BoardMapper;
 
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BoardApplication.class)
@WebAppConfiguration
public class BoardApplicationTests {
    
    @Autowired
    private BoardMapper mapper;
    
    @Test
    public void contextLoads() {
    }
    
    @Test
    public void testMapper() throws Exception{//작성
        
        BoardVo vo = new BoardVo();
        
        vo.setSubject("제목입니다.");
        vo.setContent("내용입니다.");
        vo.setWriter("작성자입니다.");
        
        mapper.boardInsert(vo);
        
    }
 
}