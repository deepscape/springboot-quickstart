package com.rubypaper.controller;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// @SessionAttributes 는 해당 어노테이션에 설정한 값과 동일한 이름의 모델 객체를 발견하면 이를 캐치하여 세션값으로 자동 변경시켜준다.
// 컨트롤러 메소드가 생성하는 모델 정보 중에서 @SessionAttributes 에 지정한 이름과 동일한 이름이 있다면 이를 세션에 저장해준다.
// @ModelAttribute 가 지정된 파라미터가 있을 때, 이 파라미터에 전달해줄 오브젝트를 세션에서 가져온다.
@SessionAttributes("member")
@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    // 해당 컨트롤러로 접근하려는 모든 요청에 @ModelAttribute 가 붙은 메서드의 리턴 값을, 설정된 모델명으로 자동 포함해주는 역할을 담당해준다.
    // 해당 컨트롤러로 클라이언트가 접근할 때, 반드시 @ModelAttribute 가 붙은 메서드의 리턴 값을 보장받는다.
    // 때문에, 아래의 Expected session attribute 'member' 에러 발생을 막는다.
    // 세션 초기화 코드 !!!
    @ModelAttribute("member")
    public Member setMember() {
        return new Member();
    }

    // @ModelAttribute("member") 로 지정하면,"member" 키로 세션에서 객체를 찾게 된다.
    // 못 찾으면 Expected session attribute 'member' 에러 발생
    @RequestMapping("/getBoardList")
    public String getBoardList(@ModelAttribute("member") Member member, Model model, Board board) {

        if(member.getId() == null) {
            return "redirect:login";
        }

        // List<Board> boardList = new ArrayList<>();
        List<Board> boardList = boardService.getBoardList(board);

/*        for (int i = 1; i <= 10; i++) {
            Board board = new Board();
            board.setSeq(new Long(i));
            board.setTitle("게시판 프로그램 테스트");
            board.setWriter("도우너");
            board.setContent("게시판 프로그램 테스트입니다...");
            board.setCreateDate(new Date());
            board.setCnt(0L);
            boardList.add(board);
        }*/

        model.addAttribute("boardList", boardList);

        return "getBoardList";
    }

    @GetMapping("/insertBoard")
    public String insertBoardView(@ModelAttribute("member") Member member) {

        if(member.getId() == null) {
            return "redirect:login";
        }

        return "insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(@ModelAttribute("member") Member member, Board board) {

        if(member.getId() == null) {
            return "redirect:login";
        }

        boardService.insertBoard(board);
        return "redirect:getBoardList";
    }

    @GetMapping("/getBoard")
    public String getBoard(@ModelAttribute("member") Member member, Model model, Board board) {

        if(member.getId() == null) {
            return "redirect:login";
        }

        model.addAttribute("board", boardService.getBoard(board));

        return "getBoard";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(@ModelAttribute("member") Member member, Board board) {

        if(member.getId() == null) {
            return "redirect:login";
        }

        boardService.updateBoard(board);
        return "redirect:getBoardList";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(@ModelAttribute("member") Member member, Board board) {

        if(member.getId() == null) {
            return "redirect:login";
        }

        boardService.deleteBoard(board);
        return "redirect:getBoardList";
    }

    @GetMapping("hello")
    public void hello(Model model) {
        model.addAttribute("greeting", "Hello Thymeleaf ~");
    }

}
