package com.zozoldu.book.springboot.config.auth;

import com.zozoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //Spring Security 설정들을 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable() //h2-console화면을 사용하기 위해 해당 옵션들을 비활성화
                .and()
                    .authorizeRequests() //URL별 관리 설정 시작점
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //권한 관리 대상 지정, URL HTTP 메소드별로 관리가 가능, "/"등 지정된 URL들은 permitAll() 옵션을 통해 전체 열람 권한을, 그 아래는 USER 권한을 가진 사람만 가능하도록 함
                .anyRequest().authenticated() //설정된 값들 이외 나머지 URL들은 모두 인증된 사용자들에게만 허용(로그인 사용자)
                .and()
                    .logout()
                        .logoutSuccessUrl("/") //로그아웃성공시 이동주소
                .and()
                    .oauth2Login() //OAuth2 로그인 기능 설정 시작점
                        .userInfoEndpoint() //OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정 담당
                            .userService(customOAuth2UserService); //소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록. 리소스 서버(소셜 서비스)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능 명시
    }
}
