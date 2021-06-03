package org.go.board.jpaBoard.ctr;
import lombok.RequiredArgsConstructor;
import org.go.board.jpaBoard.svc.BoardService;
import org.go.board.jpaBoard.vo.Board;
import org.go.board.jpaBoard.vo.BoardDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BoardCtr {

    Logger logger = LoggerFactory.getLogger(BoardCtr.class);
    private final BoardService boardService;

    @GetMapping("/board")
    public ResponseEntity<Page<BoardDTO>> getAllBoardList(Pageable pageable) throws Exception {
        Page<BoardDTO> boardList = boardService.getAllBoardList(pageable);
        return new ResponseEntity<Page<BoardDTO>>(boardList, HttpStatus.OK);
    }

    @GetMapping("/board/{bid}")
    public ResponseEntity<BoardDTO> getBoardDtl(@PathVariable("bid") Long bid) throws Exception {
        BoardDTO result = boardService.getBoardDtl(bid);
        return new ResponseEntity<BoardDTO>(result, HttpStatus.OK);
    }

    @PostMapping("/board")
    public ResponseEntity<Long> registBoard(@RequestBody BoardDTO dto) throws Exception {
        Long bno = boardService.registBoard(dto);
        return new ResponseEntity<Long>(bno,HttpStatus.CREATED);
    }

    @PutMapping("/board/{bid}")
    public ResponseEntity<Long> modifyBoard(@PathVariable("bid") Long bid, @RequestBody BoardDTO dto) throws Exception {
        Long result = boardService.updateBoard(bid,dto);
        return new ResponseEntity<Long>(result,HttpStatus.CREATED);
    }

    @DeleteMapping("/board/{bid}")
    public ResponseEntity<Long> deleteBoard(@PathVariable("bid") Long bid) throws Exception {
        boardService.deleteBoard(bid);
        return new ResponseEntity<Long>(bid,HttpStatus.NO_CONTENT);
    }

}
