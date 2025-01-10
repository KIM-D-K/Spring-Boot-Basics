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
---
#```내장 WAS```
- 스프링 부트의 각 웹 애플리케이션에는 내장 WAS(Web Application Server)가 존재한다.
- 웹 어플리케이션을 개발할 때 가장 기본이 되는 의존성인 "spring-boot-starter-web"의 경우 톰캣을 내장한다.
- 스프링 부트의 자동 설정 기능은 톰캣에도 적용되므로 특별한 설정 없이도 톰캣을 실행할 수 있다.
---
#```모니터링```
- 개발이 끝나고 서비스를 운영하는 시기에는 해당 시스템이 사용하는 스레드, 메모리, 세션 등의 주요 요소들을 모니터링 해야한다.
- 스프링 부트에는 스프링 부트 액추에이터(Spring Boot Actuator)라는 자체 모니터링 도구가 있다.
---
#```서버 간 통신```
- 단일 서비스로 구성된 포털 사이트는 내부 메서드 호출 등을 통해 원하는 자원을 가져와 사용할 수 있지만 서비스 기능별로 구분해서 독립적인 포털 사이트 애플리케이션을 개발하게 되면 각 서비스 간에 통신해야하는 경우가 발생한다.
  - ex) 사용자가 블로그 기능을 사용하기 위해 로그인 서비스를 거쳐야만 하는 상황 이런 상황에서의 통신을 서버 간 통신 이라고 한다.
- 서버 간 통신은 한 서버가 다른 서버에 통신을 요청하는 것을 의미하며, 한 대는 서버, 다른 한 대는 클라이언트가 되는 구조이다.
- 몇 가지 프로토콜에 의해 다양한 통신 방식을 적용할 수 있지만 가장 많이 사용되는 방식은 HTTP/HTTPS 방식이다.
---
#```스프링 부트의 동작 방식```
- 스프링 부트에서 spring-boot-starter-web 모듈을 사용하면 기본적으로 톰캣(Tomcat)을 사용하는 스프링 MVC 구조를 기반으로 동작한다.
- 일반적으로 웹 요청이 들어왔을 때의 스프링 부트의 동작 구조이다.
![image](https://github.com/user-attachments/assets/df5ea38f-30fa-4aab-bce1-bcfc779bee0a)
- 위 그림의 DispatcherServlet의 동작과정
  - DispatcherServlet으로 요청(HttpServletRequest)이 들어오면 DispatcherServlet은 핸들러 매핑(Handler Mapping)을 통해 요청 URI에 매핑된 핸들러를 탐색한다. 여기서 핸들러는 컨트롤러(Controller)를 의미한다.
  - 핸들러 어댑터(HandlerAdapter)로 컨트롤러를 호출한다.
  - 핸들러 어댑터에 컨트롤러의 응답이 돌아오면 ModelAndView로 응답을 가공해 반환한다.
  - 뷰 형식으로 리턴하는 컨트롤러를 사용할 때는 뷰 리졸버(View Resolver)를 통해 뷰(View)를 받아 리턴한다.
- 서블릿(Servlet)은 클라이언트의 요청을 처리하고 결과를 반환하는 자바 웹 프로그래밍 기술이다.
- 일반적으로 서블릿은 서블릿 컨테이너(Servlet Container)에서 관리한다.
- 서블릿 컨테이너는 서블릿 인스턴스(Servlet Instance)를 생성하고 관리하는 역할을 수행하는 주체로서 톰캣은 WAS의 역할과 서블릿 컨테이너의 역할을 수행하는 대표적은 컨테이너다.
- 서블릿 컨테이너의 특징은 다음과 같다.
  - 서블릿 객체를 생성, 초기화, 호출, 종료하는 생명주기를 관리한다.
  - 서블릿 객체는 싱글톤 패턴으로 관리된다.
  - 멀티 스레딩을 지원한다.
- 스프링에서는 DispatcherServlet이 서블릿의 역할을 수행한다. 일반적으로 스프링은 톰캣을 임베드(embad)해 사용한다. 그렇기 때문에 서블릿 컨테이너와 DispatcherServlet은 자동 설정된 web.xml의 설정값을 공유한다.
- 핸들러 매핑은 요청 정보를 기준으로 어떤 컨트롤러를 사용할지 선정하는 인터페이스다. 핸들러 매핑 인터페이스는 여러 구현체를 가지며, 대표적인 구현체 클래스는 다음과 같다.
  - BeanNameUrlHandlerMapping
    - 빈 이름을 URL로 사용하는 매핑 전략이다.
    - 빈을 정의할 때 슬러시("/")가 들어가면 매핑 대상이 된다.
    - ex) @Bean("/hello")
  - ControllerClassNameHandlerMapping
    - URL과 일치하는 클래스 이름을 갖는 빈을 컨트롤러로 사용하는 전략이다.
    - 이름 중 Controller를 제외하고 앞부분에 작성된 suffix를 소문자로 매핑한다.
  - SimplerUrlHandlerMapping
    - URL 패턴에 매핑된 컨트롤러를 사용하는 전략이다.
  - DefaultAnnotationHandlerMapping
    - 어노테이션으로 URL과 컨트롤러를 매핑하는 방법이다.
- 뷰가 없는 REST 형식의 @ResponseBody를 사용시에 MessageConverter를 거쳐 JSON 형식으로 변환해서 응답한다.
![image](https://github.com/user-attachments/assets/489d1fe5-4ba9-4f3b-a13d-3ec441a19066)
- 위 그림에서 MessageConverter는 요청과 응답에 대해 Body 값을 변환하는 역할을 수행한다. 스프링의 자동 설정 내역을 보면 HttpMessageConverter 인터페이스를 사용한다.
![image](https://github.com/user-attachments/assets/7927c2dd-4070-4944-a67f-92fb1e0ae09a)
- 위 그림과 같이 HttpMessage Converter 인터페이스를 빈으로 등록하는 것을 볼 수 있다.
- 해당 인터페이스를 기반으로 하는 구현체 클래스는 다양하며, Content-Type을 참고해서 Converter를 선정한다. 스프링 부트에서는 자동 설정되기 때문에 별도 설정이 필요하지 않다.


