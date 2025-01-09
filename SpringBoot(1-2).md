#```의존성 관리```
- 스프링 프레임워크에서는 개발에 필요한 각 모듈의 의존성을 직접 설정해야 했고, 호환되는 버전을 명시해야 정상 동작을 했다.
- 위 문제의 불편함을 해소하기 위해 "spring-boot-starter"라는 의존성을 재공한다.
- "spring-boot-starter"의 의존성은 여러 종류가 있다. 각 라이브러리의 기능과 관련해서 자주 사용되고 서로 호환되는 버전의 모듈 조합을 제공한다.
- 많이 사용되는 "spring-boot-starter"라이브러리
  - spring-boot-starter-web: 스프링 MVC를 사용하는 RESTful 애플리케이션을 만들기 위한 의존성이다. 기본으로 내장 톰캣(Tomcat)이 포함되어 있어 jar 형식으로 실행 가능하다.
  - spring-boot-starter-test: JUnit Jupiter, Mokito등의 테스트용 라이브러리를 포함한다.
  - spring-boot-starter-jdbc: HikariCP 커넥션 풀을 활용한 JDBC 기능을 제공한다.
  - spring-boot-starter-security: 스프링 시큐리티(인증, 권한, 인가 등) 기능을 제공한다.
  - spring-boot-starter-data-jpa: 하이버네이트를 활용한 JPA 기능을 제공한다.
  - spring-boot-starter-cache: 스프링 프레임워크의 캐시 기능을 지원한다.
---
#```자동 설정```
- 스프링 부트는 스프링 프레임워크의 기능을 사용하기 위한 자동 설정(Aoto Configuration)을 지원한다.
- 자동 설정은 애플리케이션에 추가된 라이브러리를 실행하는 데 필요한 환경 설정을 알아서 찾아준다.
- 애플리케이션을 개발하는 데 필요한 의존성을 추가하면 프레임워크가 이를 자동으로 관리해준다.
![image](https://github.com/user-attachments/assets/766e1dc1-c359-4d52-a000-29f484304ab0)
- @SpringBootApplication 어노테이션은 여러 어노테이션을 합쳐 놓은 인터페이스지만 기능 위주로 보면 크게 세 개의 어노테이션을 합쳐놓은 구성이다.
  - @SpringBootConfiguration
  - @EnableAutoConfiguration
  - @ComponentScan
- 스프링 부트 애플리케이션이 실행되면 우선 @ComponentScan 어노테이션이 @Component 시리즈 어노테이션이 붙은 클래스를 발견해 빈(bean)을 등록한다.
- 이후  @EnableAutoConfiguration 어노테이션을 통해 "spring-boot-autoconfigure" 패키지 안에 spring.factories 파일을 추가해 다양한 자동 설정이 이부 조건을 거쳐 적용된다.
![image](https://github.com/user-attachments/assets/348a4088-3454-4af7-aa35-03f41a521cec)
- 위와 같이 하단에 많은 자동 설정이 정의되어 있다. 이 설정은 각 파일에 설정된 @Conditional의 조건을 충족할 경우 빈에 등록되고 애플리케이션에 자동 반영된다.
- @Component 시리즈 어노테이션의 대표적인 예는 다음과 같다.
  - @Controller
  - @RestController
  - @Service
  - @Repository
  - @Configuration 

