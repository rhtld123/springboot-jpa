package org.go.board.jpaReply.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ReplyDTO {
    private Long rid;
    private String writer;
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime modifyDate;

    public Reply toEntity() {
        return Reply.builder()
                .writer(writer)
                .content(content)
                .build();
    }
}
