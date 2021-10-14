# Composition and Flexible Architecture
상속에서 super - sub 의존성은 compile time 에 해결되고, 합성에서 의존성은 runtime 에 해결됨 <br>
상속 관계는 is - a 관계라 불리고 합성 관계는 has - a 관계라 부른다 <br>
상속에서는 sub class 에서 extends super class 만 해주면 super 클래스의 변수, 메서드를 사용할 수 있어 재사용 측면에서 간단해 보이고 정답 같지만 내부 구현이 강하게 결합된다는 측면에서 지양해야 한다

합성은 구현에 의존하지 않는다 포함된 객체의 구현이 아닌 public interface 에 의존한다 <br>
합성을 이용하면 구현에 대한 의존성을 인터페이스에 대한 의존성으로 바꿀 수 있다

상속 & 합성 가시성의 차이!
- sub-classing : white-box reuse
- composition : black-box reuse

<hr>

## Inheritance to Composition
상속을 남용했을 때 만나는 문제
1. Redundant Interface Inheritance (Properties & HashTable, Stack & Vector)
2. Method Overriding Malfunction (InstrumentedHashSet)
3. Super - Sub need to be modified Concurrently

합성을 사용하면 위 세 가지 문제를 스무뜨하게 해결

### Overriding vs Forwarding
> 상속 or 구현한 객체에서 메서드 호출 시 <br>
> super type 으로 위임 -> forwarding <br>
> super type 과 다른 자신만의 기능 -> overriding

### Monkey Patch
> 원숭이가 패치했다?! 좋은 의미에서는 문제가 있는 라이브러리 등을 직접 수정해 사용할 수 있다는 것이고,
> 나쁜 의미에서는 전체 환경과 다르게 지역적으로 수정을 가하기 때문에 변경 영향 파악이 쉽지 않고 디버깅이 어렵다

<hr>

## Composition Increased Exponentially because of Inheritance
적지 않은 수의 객체가 상속을 하게 되면 수정의 영향이 끝도 없이 전파된다 -> 상속의 개노답적인 측면 <br>
A -> B -> C 인 상황 B class 에 일부 기능을 추가하고 싶으면? A class 는 갖기 싫어도 B class 의 기능을 가져야 함,
이거 완전 강매구만

`상속의 극단적인 단점 사례 -> 기본 정책과 부가 정책 (class explosion)`
제일 큰 단점은 변경하기 어려워진다는 점

<hr>

## Mixin
>추가 정리 필요