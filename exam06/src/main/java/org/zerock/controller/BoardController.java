package org.zerock.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")		// 어느 url에 따라서 동작할지 지정
@Log4j
@AllArgsConstructor				// BoardService와 연동을 위해 주입받기 위해
public class BoardController {
	private BoardService service;	// 주입 받음
	
	// 게시글 목록 보기
//	@GetMapping("/list")
//	public void list(Model model) {
//		log.info("list...");
//		model.addAttribute("list", service.getList());
//	}
	
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		log.info("list..." + cri);
		model.addAttribute("list", service.getList(cri));	// 게시글 목록
		// 페이징 처리를 위해 PageDTO 객체를 전달 -> jsp 페이지에서 페이징 처리를 한다.
		int total = service.getTotal(cri);
		log.info("total: " + total);
		model.addAttribute("pageMaker", new PageDTO(cri, total));

//		model.addAttribute("pageMaker", new PageDTO(cri, 123));	// total을 계산해 주어야 함
	}
	
	// 게시글 쓰기를 위한 폼을 보여주기
	@GetMapping("/register")
	public void register() {
		
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("================================");   //로그인만
		log.info("register:" + board);
		if(board.getAttachList() != null) {
			board.getAttachList().forEach(attach -> log.info(attach));
		}
		log.info("================================");
//		log.info("register: " + board);
		service.register(board);
//		rttr.addAttribute("result", board.getBno());
		rttr.addFlashAttribute("result", board.getBno());	// 게시글 등록을 성공하면 팝업창을 띄워서
			// 추가된 bno를 출력해 준다. (새로고침을 눌렀을 때 다시 팝업창이 뜨는 것을 막기 위해)
			// 1번만 브라우저로 전달이 된다.
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get", "/modify"})	// '{' : 배열
	public void get(@RequestParam("bno") Integer bno, @ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/get or /modify");
		model.addAttribute("board", service.get(bno));
	}	// jsp 페이지 : get-> /board/get.jsp, update-> /board/update.jsp 를 보여준다.
	
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify: " + board);
		if(service.modify(board)) {	// 게시글 수정이 성공하면 팝업창을 띄워 준다.
			rttr.addFlashAttribute("result", "success");
		}
//		rttr.addAttribute("pageNum", cri.getPageNum()); // -> cri.getListLink()로 대체
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/list" + cri.getListLink();
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Integer bno, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("remove..." + bno);
	
		//첨부 파일 목록애 대한 정보를 가져온다.
		List<BoardAttachVO> attachList = service.getAttachList(bno);
		if(service.remove(bno)) {	// 게시글 삭제가 성공하면 팝업창을 띄워준다.
			//첨부 파일을 삭제 (데이터베이스가 삭제를 성공하면 파일을 삭제)
			deleteFile(attachList);
			rttr.addFlashAttribute("result", "success");
		}
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/list" + cri.getListLink();
	}

	private void deleteFile(List<BoardAttachVO> attachList) {
		if (attachList == null || attachList.size() == 0) {
			return;
		}

		log.info("delete attach files...................");
		log.info(attachList);

		attachList.forEach(attach -> {
			try {
				Path file = Paths.get("C:\\jx\\upload\\" + attach.getUploadPath() + "\\" + attach.getUuid() + "_"
						+ attach.getFileName());
				Files.deleteIfExists(file);
				if (Files.probeContentType(file).startsWith("image")) {
					Path thumbNail = Paths.get("C:\\jx\\upload\\" + attach.getUploadPath() + "\\s_" + attach.getUuid()
							+ "_" + attach.getFileName());
					Files.delete(thumbNail);
				}
			} catch (Exception e) {
				log.error("delete file error" + e.getMessage());
			} // end catch
		});// end foreachd
	}
	@GetMapping(value="/getAttachList",
			produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public ResponseEntity<List<BoardAttachVO>>getAttachList(Integer bno){
		log.info("getAttachList" + bno);
		return new ResponseEntity<>(service.getAttachList(bno),HttpStatus.OK);
	}
}
