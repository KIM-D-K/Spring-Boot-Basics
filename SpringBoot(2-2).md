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
