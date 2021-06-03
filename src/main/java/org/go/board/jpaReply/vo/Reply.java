package org.go.board.jpaReply.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.go.board.jpaBoard.vo.Board;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "reply")
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String writer;

    @Column(length = 150, nullable = false)
    private String content;

    @Column(nullable = false, insertable = false)
    private LocalDateTime regDate;

    @Column(nullable = false, insertable = false)
    private LocalDateTime modifyDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bid")
    private Board board;

    @Builder
    public Reply(String writer, String content) {
        this.writer = writer;
        this.content = content;
    }

    public void update(ReplyDTO dto){
        this.content = dto.getContent();
        this.modifyDate = LocalDateTime.now();
    }

    public void save(Board board){
        this.board = board;
    }


}
