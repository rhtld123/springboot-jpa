package org.go.board.jpaReply.vo;

import org.go.board.jpaBoard.vo.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReplyRepository extends JpaRepository<Reply,Long> {
    public Page<Reply> findReplyByBoard(Board board, Pageable pageable);
}
