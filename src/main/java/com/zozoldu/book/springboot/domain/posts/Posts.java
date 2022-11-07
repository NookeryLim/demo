package com.zozoldu.book.springboot.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //클래스 내 모든 필드의 Getter 메소드 자동생성
@NoArgsConstructor //기본생성자 자동추가
@Entity //테이블과 링크될 클래스임을 나타냄, Entity 클래스를 Request/Responce 클래스로 사용하면 절대 안됨. 데이터베이스와 맞닿은 핵심 클래스, dto이용
public class Posts {

    @Id //해당 테이블의 PK필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙을 나타냄, GenerationType.IDENTIFY옵션-auto_increment
    private Long id;

    @Column(length = 500, nullable = false) //테이블의 칼럼, 변경 필요한 옵션 적용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스 빌더 패턴 클래스를 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
