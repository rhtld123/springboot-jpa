package org.go.board.jpaBoard.vo;

import lombok.*;
import org.apache.tomcat.jni.Local;
import org.go.board.jpaReply.vo.Reply;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 150, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    @Column(nullable = false, insertable = false)
    private LocalDateTime regDate;

    @Column(nullable = false, insertable = false)
    private LocalDateTime modifyDate;

    @Column(nullable = false,insertable = false)
    private long viewcnt;

    @OneToMany(mappedBy = "board" ,fetch = FetchType.LAZY)
    private List<Reply> reply;

    @Builder
    public Board(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", regDate=" + regDate +
                ", modifyDate=" + modifyDate +
                ", viewcnt=" + viewcnt +
                '}';
    }
    public void update(BoardDTO dto) {
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.writer = dto.getWriter();
        this.modifyDate = LocalDateTime.now();
    }

    public void updateViewCnt() {
        this.viewcnt = this.viewcnt + 1L;
    }

}
