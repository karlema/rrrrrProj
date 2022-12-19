package com.sparta.homework.entity;

import com.sparta.homework.dto.CommentsRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String comment;
    @ManyToOne
    @JoinColumn(name = "MEMO_ID", nullable = false)
    private Memo memo;

    public Comments(CommentsRequestDto requestDto, Memo memo){
        this.comment = requestDto.getComment();
        this.memo = memo;
    }

    public void update(CommentsRequestDto requestDto){
        this.comment = requestDto.getComment();
    }
// 전부 USER_ID로는 원래 안함. -> 의존관계를 잘 설정해야함.
// 부모와 자식 잘 설정해서, 부모의 Key를 자식이 Join하자.
}
