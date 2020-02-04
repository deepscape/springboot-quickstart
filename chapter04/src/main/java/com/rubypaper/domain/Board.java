package com.rubypaper.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BOARD")
@TableGenerator(name = "BOARD_SEQ_GENERATOR",
                table = "ALL_SQQUENCE",
                pkColumnValue = "BOARD_SEQ",
                initialValue = 0,
                allocationSize = 1)
@Data
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE,
                    generator = "BOARD_SEQ_GENERATOR")
    private Long seq;
    private String title;
    private String writer;
    private String content;
    private Date createDate;
    private Long cnt;
}
