package org.go.board.jpaReply.svc;

import org.go.board.jpaReply.vo.Reply;
import org.go.board.jpaReply.vo.ReplyDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReplyService {
    public Page<ReplyDTO> getAllReplyList(Long bid, Pageable pageable) throws Exception;
    public Long updateReply(Long rid, ReplyDTO dto) throws Exception;
    public Long registReply(Long bid,ReplyDTO dto) throws Exception;
    public void deleteReply(Long rid) throws Exception;

}
