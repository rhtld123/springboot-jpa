package org.go.board;

import org.go.board.jpaBoard.svc.BoardService;
import org.go.board.jpaBoard.vo.Board;
import org.go.board.jpaBoard.vo.BoardDTO;
import org.go.board.jpaBoard.vo.BoardRepository;
import org.go.board.jpaReply.svc.ReplyService;
import org.go.board.jpaReply.vo.Reply;
import org.go.board.jpaReply.vo.ReplyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;


@SpringBootTest
class BoardApplicationTests {

    @Autowired
    BoardService boardService;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    ReplyRepository replyRepository;

    @Test
    void contextLoads() {
    }

    /**
     * 전체조회 테스트
     */
    @Test
    public void getBoardList(){
        List<Board> result = boardRepository.findAll();
    }

//    /**
//     * 저장 테스트
//     */
//    @Test
//    public void saveBoardTest() {
//        boardRepository.save(Board.builder()
//                .title("zz")
//                .content("콘텐트2")
//                .writer("test")
//                .build());
//
//        List<Board> list = boardRepository.findAll();
//
//
//
//        Board board = list.get(0);
//
//        System.out.printf(board.getTitle());
//        System.out.printf(board.getWriter());
//        System.out.printf(board.getContent());
//
//        assertThat(board.getTitle()).isEqualTo("zz");
//        assertThat(board.getContent()).isEqualTo("콘텐트");
//        assertThat(board.getWriter()).isEqualTo("test");
//    }

//    /**
//     * 상세조회 테스트
//     */
//    @Test
//    public void getBoardDtlTest() throws Exception {
//        Long bid = 10L;
//        BoardDTO result = boardService.getBoardDtl(bid);
//        System.out.printf(result.toString());
//        assertThat(result.getTitle()).isEqualTo("test");
//        assertThat(result.getContent()).isEqualTo("내용1");
//    }

    /**
     * 수정 테스트
     */
//    @Test
//    public void updateBoardTest() throws Exception {
//        Long bid = 1L;
//        BoardDTO dto = BoardDTO.builder().title("수정테스트타이틀")
//                .content("수정컨텐트")
//                .writer("수정작성자")
//                .build();
//        Long test = boardService.updateBoard(bid,dto);
//        assertThat(test).isEqualTo(bid);
//    }
//
//    /**
//     * 등록 테스트
//     */
//    @Test
//    public void insertTest() throws Exception {
//        BoardDTO dto = BoardDTO.builder().title("등록테스트")
//                .content("내용테스트")
//                .writer("작성자 테스트")
//                .build();
//
//        Long bid = boardService.registBoard(dto);
//        System.out.printf("bid" + bid);
//    }
//
//    /**
//     * 삭제 테스트
//     */
//    @Test
//    public void deleteTest() throws Exception {
//        Long bid = 1L;
//        boardService.deleteBoard(bid);
//    }
//
//    /**
//     * 댓글 조회 테스트
//     */
//    @Test
//    public void getReplyTest() throws Exception {
//        Long bid = 1L;
////        Pageable pageable = new PageRequest.of(1,10);
//        Board board = boardRepository.findById(bid).orElseThrow(()-> new Exception("해당 게시글이 존재하지 않습니다"));
//        //Page<Reply> result = replyRepository.findAllByBoard(board,PageRequest.of(0,10));
//        //Page<Reply> result = replyRepository.findByBoard(board,PageRequest.of(0,10));
//        Page<Reply> result = replyRepository.findReplyByBoard(board,PageRequest.of(0,10));
//        System.out.printf("결과 : " + result.toString());
//    }


}
