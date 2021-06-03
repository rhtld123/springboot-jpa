package org.go.board.jpaReply.ctr;

import lombok.RequiredArgsConstructor;
import org.go.board.jpaReply.svc.ReplyService;
import org.go.board.jpaReply.vo.ReplyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReplyCtr {

    private final ReplyService replyService;

    @GetMapping("/reply/{bid}")
    public ResponseEntity<Page<ReplyDTO>> getBoardReply(@PathVariable("bid") Long bid, Pageable pageable) throws Exception {
        Page<ReplyDTO> result = replyService.getAllReplyList(bid, pageable);
        return new ResponseEntity<Page<ReplyDTO>>(result, HttpStatus.OK);
    }

    @PostMapping("/reply/{bid}")
    public ResponseEntity<Long> registBoardReply(@PathVariable("bid") Long bid, @RequestBody ReplyDTO dto) throws Exception{
        Long registReplyId = replyService.registReply(bid,dto);
       return new ResponseEntity<Long>(registReplyId, HttpStatus.CREATED);
    }

    @PutMapping("/reply/{rid}")
    public ResponseEntity<Long> updateBoardReply(@PathVariable("rid") Long rid, @RequestBody ReplyDTO dto) throws Exception {
        Long updateReplyId = replyService.updateReply(rid, dto);
        return new ResponseEntity<Long>(updateReplyId,HttpStatus.CREATED);
    }

    @DeleteMapping("/reply/{rid}")
    public ResponseEntity<Long> deleteBoardReply(@PathVariable("rid") Long rid) throws Exception {
        replyService.deleteReply(rid);
        return new ResponseEntity<Long>(rid,HttpStatus.NO_CONTENT);
    }

}
