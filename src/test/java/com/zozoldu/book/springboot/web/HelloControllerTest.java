package com.zozoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) //테스트 진행 시 JUnit에 내장된 실행자 외에 다른 실행자를 실행, 여기서는 SpringRunner라는 스프링 실행자 사용, 스프링부트 테스트와 JUnit 사이 연결자 역할
@WebMvcTest(controllers = HelloController.class) //Web(Spring MVC)에 집중할 수 있는 어노테이션
public class HelloControllerTest {

    @Autowired //스프링이 관리하는 bean을 주입받음
    private MockMvc mvc; //웹API 테스트시 사용, 스프링 MVC의 시작점, 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있음

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")) // MockMvc를 통해 /hello 주소로 HTTP GET 요청, 체이닝 지원되어 아래같이 검증 가능
                .andExpect(status().isOk()) // mvc.perform의 결과 검증, 200 404 등의 상태를 검증
                .andExpect(content().string(hello)); // mvc.perform의 결과 검증, 컨트롤러에서 "hello"값 리턴
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name) //param : API 테스트할 때 사용될 요청 파라미터를 설정, String만 허용
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) //jsonPath: JSON 응답값을 필드별로 검증할 수 있는 메소드
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
