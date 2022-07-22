package board.board.controller;


import java.util.List;


import board.board.dto.BoardDto;
import board.board.service.BoardService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/")
	public String hello() {
		return "redirect:/board/openBoardList.do";
	}
	
	@RequestMapping("/board/openBoardList.do")
	public ModelAndView openBoardList() throws Exception{

		log.debug("openBoardList_kimnew");
		ModelAndView mv = new ModelAndView("/board/boardList");
		List<BoardDto> list = boardService.selectBoardList();
		mv.addObject("list",list);
		
		return mv;
	}
	
	@RequestMapping("/board/openBoardDetail.do")
	public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception{
		ModelAndView mv = new ModelAndView("/board/boardDetail");
		BoardDto board = boardService.selectBoardDetail(boardIdx);
		mv.addObject("board",board);
		return mv;
	}
	
	@RequestMapping("/board/openBoardWrite.do")
	public String openBoardWrite() throws Exception{
		return "/board/boardWrite";
	}
	
	@RequestMapping("/board/insertBoard.do")
	public String insertBoard(BoardDto board) throws Exception{
	
		boardService.insertBoard(board);
		
		return "/board/boardInsert";
	}
	/*public String insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest) throws Exception{
		//boardService.insertBoard(board, multipartHttpServletRequest);
		boardService.insertBoard(board);
		//return "redirect:/board/openBoardList.do";
		return "/board/boardInsert";
	}*/
	
	@RequestMapping("/board/updateBoard.do")
	public String updateBoard(BoardDto board) throws Exception{
		boardService.updateBoard(board);
		return "redirect:/board/openBoardList.do";
	}
	
	@RequestMapping("/board/deleteBoard.do")
	public String deleteBoard(int boardIdx) throws Exception{
		boardService.deleteBoard(boardIdx);
		return "redirect:/board/openBoardList.do";
	}
}
