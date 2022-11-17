교재와 다른 점

Group: 디폴트값으로 실행중
Version: 17

 변경
implementation 'org.springframework.boot:spring-boot-starter-web'

추가
testImplementation 'junit:junit'

설정 변경
RUN TEST USING 을 INTELLIJ 로 수정

흔히 겪는 일 -> 포트 8080이 종료가 안됨 -> 강종
lsof -n -i -P | grep 8080
Kill -9 <<pid숫자>>

변경
그래들 버젼에 따라 롬복 사용법이 다르기에 변경 / 책에서도 언급
https://deeplify.dev/back-end/spring/lombok-required-args-constructor-initialize-error

쿼리 로그 MySQL 버전으로 출력 -> 패스
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.mysql5innodbdialect
Deprecated 되었다는 썰이 있음

H2데이터베이스 웹 콘솔 ->최신 버젼일 경우 별도설정 필요
https://galid1.tistory.com/611

mustache 에서 한글 깨짐 ->최신버전 스프링부트가 문제
https://velog.io/@jihye/mustache에서-한글이-깨진다-뚫뚏
2.6.13으로 스프링부트 다운 그레이드(이건 좀 너무하다 생각됨)
다운그레이드하며 org.springframework.boot.test.web.server.LocalServerPort 비활성화됨

js코드 var -> 모두 let 교체

네이버로그인이 안되는 문제 발생
https://dawitblog.tistory.com/42
registration 주소 변경, 이메일이 안넘어갔는데 오타일 것으로 추정

p.211의 테스트에 떠야할 오류들이 전혀 안뜸-> 최신버젼이라 자동적용?
jUnit 또는 spring.security 영향일꺼라 추정


——

터미널에서 인스턴스 접근 : ssh <<서비스명>>

인스턴스에도 자바 17 다운로드함
 java-17-amazon-corretto-devel.x86_64

타임존 한국시간으로 변경

자주보게될듯 : vim 명령어
https://iamfreeman.tistory.com/entry/vi-vim-편집기-명령어-정리-단축키-모음-목록

261p 호스트네임 변경 적용이 안됨
해결 : https://docs.aws.amazon.com/ko_kr/AWSEC2/latest/UserGuide/set-hostname.html

RDS는 MariaDB 선택
MariaDB 10.6.10

인텔리제이 플러그인으로 Database Navigator 대신 내장기능(보기->데이터베이스) 사용해보기
Database browser는 성공, 내장기능은 실패한 상황임

**원격커밋  테스트**
