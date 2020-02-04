package com.rubypaper.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

// 회원과 게시판의 관계에서 게시판은 FK 를 가지고 있는 자식 엔티티
// 부모 엔티티를 삭제할 경우 자식 엔티티도 삭제할 수 있다      <- 영속성 전이
@Getter
@Setter
@ToString(exclude = "member")
@Entity
public class Board {
    @Id
    @GeneratedValue
    private Long seq;
    private String title;
    private String writer;
    private String content;
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createDate;
    private Long cnt;

    // 연관 관계의 주인은 테이블에 '외래 키'가 있는 곳으로 정해야 한다.
    // 게시판 테이블이 외래 키를 가지고 있으므로 Board.member 변수가 '주인'이 된다.
    @ManyToOne
    @JoinColumn(name="MEMBER_ID", nullable = false)
    private Member member;

    // '영속성 전이' 를 위한 추가 코드
    // 게시판 객체에 회원 객체를 설정할 때, 자동으로 자신의 글도 저장되도록 한다.
    // 이렇게 해야, 영속 객체가 아닌 단순한 일반 자바 객체 상태에서도 관련된 데이터를 사용할 수 있다.
    public void setMember(Member member) {
        this.member = member;
        member.getBoardList().add(this);        // '핵심', 여기서 this 는 Board 인스턴스 자기 자신을 의미함
    }
}