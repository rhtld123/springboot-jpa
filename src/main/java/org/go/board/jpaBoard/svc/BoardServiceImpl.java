package org.go.board.jpaBoard.svc;

import lombok.RequiredArgsConstructor;
import org.go.board.jpaBoard.ctr.BoardCtr;
import org.go.board.jpaBoard.vo.Board;
import org.go.board.jpaBoard.vo.BoardDTO;
import org.go.board.jpaBoard.vo.BoardRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{
    Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    @Override
    public Page<BoardDTO> getAllBoardList(Pageable pageable) throws Exception {
        Page<Board> boards = boardRepository.findAll(pageable);
        Page<BoardDTO> result = boards.map(board -> new BoardDTO(board.getId(),board.getTitle(),board.getContent(),board.getWriter(),board.getRegDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm")),board.getViewcnt()));
        return result;
    }

    @Override
    public BoardDTO getBoardDtl(Long bid) throws Exception {
        Board board = boardRepository.findById(bid).orElseThrow(()->new Exception("해당 ID가 존재하지 않습니다."));
        board.updateViewCnt();
        boardRepository.save(board);
        return BoardDTO.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .regDate(board.getRegDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm")))
                .viewcnt(board.getViewcnt())
                .build();
    }

    @Transactional
    @Override
    public Long updateBoard(Long bid, BoardDTO dto)throws Exception {
        Board result = boardRepository.findById(bid).orElseThrow(()->new Exception("해당 ID가 존재하지 않습니다."));
        result.update(dto);
        return bid;
    }

    @Transactional
    @Override
    public Long registBoard(BoardDTO dto) throws Exception {
        return boardRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    @Override
    public void deleteBoard(Long bid) throws Exception {
        Board result = boardRepository.findById(bid).orElseThrow(()->new Exception("해당 ID가 존재하지 않습니다."));
        boardRepository.delete(result);
    }
}
