package com.zozoldu.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email); //소셜 로그인으로 반환되는 값 중 email을 통해 판단하기 위한 메소드
}
