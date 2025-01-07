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
