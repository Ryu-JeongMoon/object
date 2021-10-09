# Flexible Design


## OCP
- 요구사항이 변경될 때 변경에 맞는 새로운 동작을 추가해 기능을 확장할 수 있어야 한다
- 기존의 코드를 수정하지 않고 새로운 기능을 추가할 수 있어야 한다

컴파일 타임 의존성을 고정시키고 런타임 의존성을 변경하라


## Separating Use from Creation
~~~
소프트웨어 시스템은 (객체를 제작하고 의존성을 연결하는) 시작 단계와 이후에 이어지는 실행 단계를 분리해야 한다
~~~
객체의 생성이 문제가 아니라 같은 클래스 내에서 생성과 사용이 공존하는 것이 문제다
가장 보편적인 해결법은 객체 생성의 책임을 클라이언트로 옮기는 것이다 (사용하는 쪽에서 직접 선택하게 만드는 것)

객체 생성의 책임을 클라이언트로 옮긴 배경에는 클라이언트는 문맥에 결합되도 상관 없다는 것이 전제인데
클라이언트 측에서도 생성과 책임이 공존할 수 있다 이 문제를 해결하기 위한 방법은 _FACTORY class_

~~~
public class Factory {
    public Movie createAvatarMovie() {
        return new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000), new AmountDiscountPolicy());
    }
}
~~~


## Pure Fabrication, 순수한 가공물
Domain Driven Development <br>
좋은 개발 방법론이지만 도메인만으로 모든 것을 표현할 수는 없다 <br>
객체지향이 실제 세계를 모방하는 것에 목표가 있긴 하지만 유연한 설계를 하기 위해 SOLID 원칙이 지켜질 필요가 있다<br>
도메인만으로 표현할 수 없는 것 중 대표적으로 Factory class, Database Access Object 가 있다

- representational decomposition <br>
도메인에 존재하는 사물 또는 개념을 표현하는 객체들을 이용해 시스템 분해
- behavioral decomposition <br>
데이터베이스 접근을 위한 객체와 같이 도메인 개념을 초월한 기계적인 개념을 이용해 시스템 분해


## Dependency Injection
생성과 사용을 분리했을 때, 사용하는 측에서는 외부의 객체가 자신에게 사용할 인스턴스를 전달해준 것이다 <br>
외부의 독립적인 객체가 인스턴스를 생성하고 전달해줘 의존성을 해결하는 방법을 의존성 주입이라 한다

- constructor : 제일 무난
- setter : 네이밍이 문제, setter는 닫아두고 다른 메서드를 만들어 런타임에도 의존성을 변경하면 유연한 설계 가능
- method : 의존성이 1회성으로 필요한 경우
- field : 스프링 컨테이너를 사용하는 경우 @Autowired 사용하면 필드 변수에 직접 박아줌 (테스트 외 사용 금지) 


## Service Locator Pattern
의존성은 나쁘지 않지만 감춰진 의존성은 개나쁘다 그런 의미에서 저자는 Service Locator 를 사용하지 말라고 한다 - 인정


## Inversion of Control
상위 수준의 class, module 은 하위 수준의 class, module 에 의존해서는 안 된다 <br>
상위, 하위 모두 추상화에 의존해야 한다


## About Flexibility
유연한 설계가 가지는 장점은 무수히 많다 그러나 항상 옳지는 않다
설계는 trade-off 의 산물, 설계자가 원하는 바가 무엇인지 결정해야 한다
