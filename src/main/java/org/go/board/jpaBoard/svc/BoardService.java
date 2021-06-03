package org.go.board.jpaBoard.svc;

import org.go.board.jpaBoard.vo.Board;
import org.go.board.jpaBoard.vo.BoardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BoardService {
    public Page<BoardDTO> getAllBoardList(Pageable pageable) throws Exception;
    public BoardDTO getBoardDtl(Long bid) throws Exception;
    public Long updateBoard(Long bid, BoardDTO dto) throws Exception;
    public Long registBoard(BoardDTO dto) throws Exception;
    public void deleteBoard(Long bid) throws Exception;
}
