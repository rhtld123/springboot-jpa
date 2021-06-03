package org.go.board.jpaReply.svc;

import lombok.RequiredArgsConstructor;
import org.go.board.jpaBoard.vo.Board;
import org.go.board.jpaBoard.vo.BoardRepository;
import org.go.board.jpaReply.vo.Reply;
import org.go.board.jpaReply.vo.ReplyDTO;
import org.go.board.jpaReply.vo.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Override
    public Page<ReplyDTO> getAllReplyList(Long bid, Pageable pageable) throws Exception {
        Board board = boardRepository.findById(bid).orElseThrow(()->new Exception("해당 게시글이 존재하지 않습니다."));
        Page<Reply> replies = replyRepository.findReplyByBoard(board,pageable);
        Page<ReplyDTO> result = replies.map(reply -> new ReplyDTO(reply.getId()
                                                                 ,reply.getWriter()
                                                                ,reply.getContent()
                                                                ,reply.getRegDate()
                                                                ,reply.getModifyDate()
                                                                )
                                            );
        return result;
    }

    @Transactional
    @Override
    public Long updateReply(Long rid, ReplyDTO dto) throws Exception {
        Reply reply = replyRepository.findById(rid).orElseThrow(()->new Exception("해당 댓글이 존재하지 않습니다."));
        reply.update(dto);
        return rid;
    }

    @Transactional
    @Override
    public Long registReply(Long bid,ReplyDTO dto) throws Exception {
        Reply reply = dto.toEntity();
        Board board = boardRepository.findById(bid).orElseThrow(()->new Exception("게시글이 없습니다."));
        reply.save(board);
        return replyRepository.save(reply).getId();
    }

    @Transactional
    @Override
    public void deleteReply(Long rid) throws Exception {
        Reply reply = replyRepository.findById(rid).orElseThrow(()->new Exception("해당 게시글이 존재하지 않습니다."));
        replyRepository.delete(reply);
    }
}
