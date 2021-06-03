package org.go.board.jpaBoard.vo;

import org.go.board.jpaBoard.vo.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {

}
