# Subclassing and Subtyping

## Type

### 상속의 용도

1. 타입 계층 구현
2. 코드 재사용

Object-based Programming 안에 OOP 가 속한다 <br>
OBP 는 자바스크립트와 같이 클래스가 존재하지 않는 프로토타입 기반 언어를 칭할 때도 사용한다

### 타입

- Symbol : 타입에 이름 붙인 것
- Intension : 타입의 정의, 타입에 속하는 객체들이 가지는 공통적인 속성이나 행동을 가르킴
- Extension : 타입에 속하는 객체들의 집합

> ex <br>
> Symbol - 프로그래밍 언어
> Intension - 프로그래밍 시에 사용하는 언어
> Extension - C, C++, Java ...

### 타입이 왜 필요한가?

Java 를 사용하는 측면에서 살펴보면 <br>
> 1.타입에 수행될 수 있는 유효한 오퍼레이션 집합을 정의함으로써 개발자의 실수 방지 가능 <br>
> 연산자 +의 경우, 문자열과 숫자 타입에는 적용하나 커스텀 클래스에 적용할 수 없다 <br>
>
> 2.타입에 수행되는 오퍼레이션에 대한 문맥 제공 <br>
> a + b -> 문자일 때 concat 으로 작용, 숫자일 때 sum 으로 작용

<hr>

## Subclassing and Subtyping

### 언제 상속을 사용해야 하는가?

1. 클라이언트 입장에서 is-a 관계를 모델링할 때 <br>
   ex) 객체지향 언어(subtype)는 프로그래밍 언어(supertype)다, 어휘적으로 중요한 것이 아니라 행동이 중요
2. 행동 호환성이 이루어질 때 <br>

설계 관점에서 두번째가 더 중요하다? <br>
클라이언트의 관점에서 두 클래스에 기대하는 행동이 같을 때를 의미

<hr>

## Design By Contract, DBC
