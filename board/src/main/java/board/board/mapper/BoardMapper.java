package board.board.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import board.board.dto.BoardDto;
@Mapper

public interface BoardMapper {
 List<BoardDto> selectBoardList() throws Exception;	
 void insertBoard(BoardDto board) throws Exception;
 
 BoardDto selectBoardDetail(int boardIdx) throws Exception;
 
 void updateHitCount(int boardIdx) throws Exception;
 
	void updateBoard(BoardDto board) throws Exception;
	void deleteBoard(int boardIdx) throws Exception;
}
