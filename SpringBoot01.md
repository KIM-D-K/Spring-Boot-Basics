# Spring-Boot-Basics

#```스프링(Spring)이란?```
- 정확한 표현으로는 스프링 프레임워크(Spring Framework)는 자바에서 가장 많이 사용되는 프레임워크
- 의존성 주입(DI, Dependency Injection)과 제어역전(IOC, Inversion of Control), 관점 지향 프로그래밍(AOP)이 가장 중요한 요소
- 위 요소들을 통해 느슨한 결합(Loose Coupling)을 달성할 수 있음
- 위와 같이 느슨한 결합으로 개발한 어플리케이션은 단위 테스트를 수행하기 용이함
---
#```스프링 프레임워크의 대표적 모듈```
- Spring JDBC
- Spring MVC
- Spring AOP
- Spring ORM
- Spring Test
- Spring Expression Language(SpEL)
---
#```스프링 부트가 나오게 된 이유```
- 스프링 부트는 단지 실행만 하면 되는 스프링 기반의 어플리케이션을 쉽게 만들 수 있다.
---
#```스프링 부트가 제공하는 기능```
- 어플리케이션 개발에 필요한 모든 디펜던시(Dependency)를 프레임워크에서 관리
- jar파일이 클래스 패스에 있는 경우 스프링 부프는 Dispatcher Servlet으로 자동 구성됨
- 스프링 부트는 미리 설정되어 있는 Starter 프로젝트를 제공
- xml설정 없이 자바 코드를 통해 설정할 수 있음
- 어플리케이션을 개발하면서 사용되는 디펜던시들은 호환되는 버전으로 관리해야 함 -> 이런 복잡도를 줄이기 위해 스프링 부트는 SpringBoot-Starter를 제공하여 자동으로 호환되는 버전을 관리
---
#```스프링 부트 프로젝트의 의존성 관리```
- Spring boot starter dependency를 통해 다양한 패키지를 수용하고 있음 이를 통해 개발자는 dependency관리 (호환성 체크 등)에 대해 고려할 필요가 없어짐
---
#```스프링 부트 프로젝트의 startet 디펜던시```
- spring-boot-starter-web-service : SOAP 웹 서비스
- spring-boot-starter-web : RESTful 응용 프로그램
- spring-boot-starter-test : 단위 테스트, 통합 테스트
- spring-boot-starter-jdbc : 기본적인 JDBC
- spring-boot-starter-security : 스프링 시큐리티 (인증, 권한)
- spring-boot-starter-data-jpa : Spring Data JPA (Hibernate)
- spring-boot-starter-cache : 캐시
---
#```MVC패턴```
- 디자인 패턴 중 하나인 MVC 패턴은 Model, View, Controller의 줄임말로 어플리케이션을 구성할 때 그 구성요소를 세가지의 역할로 구분한 패턴을 의미
- 사용자 인터페이스로부터 비즈니스 로직을 분리하여 서로 영향 없이 쉽게 고칠 수 있는 설계가 가능
![image](https://github.com/user-attachments/assets/51b7670e-89f6-4a24-9c6f-55a7016c26ac)
---
#```컨트롤러 (Controller)```
- 모델(Model)과 뷰(View)사이에서 브릿지 역할을 수행
- 앱의 사용자로부터 입력에 대한 응답으로 모델 및 뷰를 업데이트 하는 로직을 포함
- 사용자의 요청은 모두 컨트롤러를 통해 진행되어야 함
- 컨트롤러로 들어온 요청은 어떻게 처리할지 결정하여 모델로 요청을 전달함
---
#```모델(Model)```
- 데이터를 처리하는 영역
- 데이터베이스와 연동을 위한 DAO(Data Access Object)와 데이터의 구조를 표현하는 DO(Data Object)로 구성됨
---
#```뷰(View)```
- 데이터를 보여주는 화면 자체의 영역을 뜻함
- 사용자 인터페이스(UI)요소들이 여기에 포함되어, 데이터를 각 요소에 배치함
- 뷰에서는 별도의 데이터를 보관하지 않음
---
#```API란?```
- Application Programming Interface의 줄임말
- 응용 프로그램에서 사용할 수 있도록 다른 응용 프로그램을 제어할 수 있게 만든 인터페이스를 뜻함
- API를 사용하면 내부 구현 로직을 알지 못해도 정의되어 있는 기능을 쉽게 사용할 수 있음
---
#```REST란?```
- REST는 Representational State Transfer의 줄임말
- 자원의 이름으로 구분하여 해당 자원의 상태를 교환하는 것을 의미
- REST는 서버와 클라이언트의 통신 방식 중 하나임
- HTTP URI(Uniform Resource Identifier)를 통해 자원을 명시하고 HTTP Method를 통해 자원을 교환하는 것 (HTTP Method : Create, Read, Update, Delete)
---
#```REST 특징```
- Server-Client
  - 자원이 있는 쪽이 Server, 요청하는 쪽이 Client 클라이언트와 서버가 독립적으로 분리되어 있어야 함
- Stateless
  - 요청 간에 클라이언트 정보가 서버에 저장되지 않음 서버는 각각의 요청을 완전히 별개의 것으로 인식하고 처리
- Cacheable
  - HTTP 프로토콜을 그대로 사용하기 때문에 HTTP의 특징인 캐싱 기능을 적용 대량의 요청을 효율적으로 처리하기 위해 캐시를 사용
---
#```제어 역전 (IoC: Inversion of Control)```
- IoC를 적용한 환경에서는 사용할 객체를 직접 생성하지 않고 객체의 생명주기 관리를 외부에 위임한다.
- 여기서 '외부'는 스프링 컨테이너(Spring Container) 또는 IoC 컨테이너(IoC Container)를 의미한다.
- 객체의 관리를 컨테이너에 맡겨 제어권이 넘어간 것을 제어 역전이다 부른다.
- 제어 역전을 통해 의존성 주입(DI: Dependency Injection), 관점 지향 프로그래밍(AOP: Aspect-Oriented Programming) 등이 가능하다.
---
#```의존성 주입(DI: Dependency Injection)```
- 의존성 주입(DI: Dependency Injection)이란 제어 역전의 방법 중 하나로, 사용할 객체를 직접 생성하지 않고 외부 컨테이너가 생성한 객체를 주입받아 사용하는 방식을 의미한다.
- 스프링에서 의존성을 주입받는 방법은 세 가지가 있다.
  - 생성자를 통한 의존성 주입
  - 필드 객체 선언을 통한 의존성 주입
  - setter 메서드를 통한 의존성 주입 
---
#```관점 지향 프로그래밍(AOP)
- 관점 지향 프로그래밍(이후 AOP: Aspect-Oriented Programming)은 스프링의 아주 중요한 특징이다.
- AOP의 관점에서는 부가 기능은 핵심 기능이 어떤 기능인지에 무관하게 로직이 수행되기 전 또는 후에 수행되기만 하면 된다.
- 여러 비즈니스 로직에서 반복되는 부가 기능을 하나의 공통 로직으로 처리하도록 모듈화해 삽입하는 방식을 AOP라고 한다.
- AOP를 구현하는 방법
  - 컴파일 과정에 삽입하는 방식
  - 바이트코드를 메모리에 로드하는 과정에 삽입하는 방식
  - 프락시 패턴을 이용한 방식

![image](https://github.com/user-attachments/assets/e66b0b5c-f729-4bf8-8703-793bd6e581c0)
