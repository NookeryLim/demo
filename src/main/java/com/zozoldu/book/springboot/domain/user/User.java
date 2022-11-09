package com.zozoldu.book.springboot.domain.user;

import com.zozoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
//javax.persistence에 Role이 있어서 전부를 가져오진 않음

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private  String name;

    @Column(nullable = false)
    private  String email;

    @Column
    private  String picture;

    @Enumerated(EnumType.STRING) //JPA로 데이터베이스로 저장할 때 Enum값을 어떤 형태로 저장할지 결정
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey() {
//      return this.role.getKey(); //해당 메소드가 없어서 비슷해보이는걸로 바꿔봄 ->name & value로 바뀌었나...
        return  this.role.getKey();
    }
}
