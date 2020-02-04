package com.rubypaper.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// 회원과 게시판의 관계에서 회원은 PK 를 가지고 있는 부모 엔티티
// 부모 엔티티를 삭제할 경우 자식 엔티티도 삭제할 수 있다      <- 영속성 전이
@Getter
@Setter
@ToString(exclude = "boardList")
@Entity
public class Member {
    @Id
    @Column(name="MEMBER_ID")
    private String id;
    private String password;
    private String name;
    private String role;

    // 주인이 아닌 Member.boardList 에는 mappedBy="member" 속성을 사용해 주인이 아님을 표시해야 한다.
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Board> boardList = new ArrayList<Board>();
}
