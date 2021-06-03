package org.go.board.jpaBoard.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardDTO {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate;
    private Long viewcnt;
    @Builder
    public BoardDTO(Long id,String title, String content, String writer, LocalDateTime regDate, Long viewcnt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.regDate = regDate;
        this.viewcnt = viewcnt;
    }

    public Board toEntity() {
        return Board.builder().title(title)
                .content(content)
                .writer(writer)
                .build();

    }
}
