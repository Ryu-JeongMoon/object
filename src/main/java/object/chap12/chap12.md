# Polymorphism
`상속은 타입 계층을 구조화하기 위해 사용해야 한다` <br>
코드 재사용을 목적으로 상속을 사용하면 지나친 결합도로 인해 수정에 유연하지 못 하다 
<hr>

## Polymorphism
`하나의 추상 인터페이스에 대해 작성하고, 이에 대한 여러 구현을 연결할 수 있는 능력`<br>
코드 재사용을 목적으로 하는 상속 ? 노노, 상속 계층을 만들어 다형성을 사용하기 위함

- Universal : 
  - Parametric : `List<T>` 와 같이 정의 후 사용 시점에 T에 대응하는 타입을 지정해 사용 범위를 확장할 수 있다
  - Inclusion : Subtype 다형성이라고도 부르며 동일한 메시지라도 수신하는 객체에 따라 행동이 달라질 수 있음
- Ad Hoc : 
  - Overloading : 유사한 기능의 메서드를 같은 이름으로 칭할 수 있어 중복되는 네이밍을 줄일 수 있다  
  - Coercion : 타입이 다른 대상에 연산자의 기능도 달라진다 (+ 연산자 : 대상 타입이 숫자면 합, 문자면 연결)

> <h4>universal</h4>
> Symbols that are universally polymorphic may assume an infinite number of different types. There are two kinds of universal polymorphism: parametric and subtyping. In the rest of this chapter we will see these variations in more detail.

> <h4>ad hoc </h4>
> We say that a form of polymorphism is ad-hoc if it allows the same name to denote a finite number of programming entities. There are two main kinds of ad-hoc polymorphism: overloading and coercion.


## Double Sidedness of Inheritance
서브 클래스의 메서드가 슈퍼 클래스의 메서드보다 우선순위가 높다 <br>
동일한 시그니처의 메서드를 재정의해서 슈퍼 클래스의 메서드를 가리고 서브 클래스의 메서드를 이용하는 것이 메서드 오버라이딩
<hr>


## Upcasting and Dynamic Binding
`Upcasting : supertype으로 선언된 변수에 subtype instance 할당` <br>
`Dynamic Binding : 선언된 변수 타입이 아니라 메시지를 수신하는 객체의 타입에 따라 실행되는 메서드가 달라진다`

12장의 핵심!!
>INSTANCE -> class pointer -> CLASS -> parent pointer -> PARENT ... OBJECT
- 왜 이런 방식으로 진행되는가? <br>
  - 인스턴스 생성 시 클래스를 가르키는 class pointer 가 생기고 클래스 안의 메서드를 사용할 수 있게 된다 <br>
  - 인스턴스는 계속 생성될 수 있지만 클래스는 계속 생성할 필요 없이 메모리에 한 번 올리고 이를 가르키는 포인터만 가지는게 더 효율적인 방식이기 때문이다
  - 슈퍼 클래스도 마찬가지로 이를 가르키는 포인터만 가지면 된다
  
### Function & Method
함수 호출 : 실행될 함수가 컴파일 타임에 결정되고 바뀌지 않는다, static / early / compile-time binding <br>
메시지 전송 : 실행될 메서드는 메시지를 수신한 객체의 타입에 따라 바뀐다 dynamic / late binding

### 그렇다면 어떻게 해서 메서드 탐색이 이루어지는 걸까?
1. 메시지 수신 시 수신 객체를 가리키는 임시 참조 변수 self (this) 가 생성된다 
2. self 를 이용해 현재 객체의 상태와 class pointer 를 파악하고 포인터를 이용해 클래스를 우선 탐색 
3. 수신 객체에 해당하는 클래스에 메시지를 처리할 메서드가 없다면 parent pointer 를 이용해 super class 탐색 
4. 이는 최상위 객체 Object 까지 이어지고 만약 없다면 에러 터짐
5. this, super 를 이용하여 메시지 자동 위임, 상속 계층을 전부 따라가며 탐색한다


> self or this? <br>
> 정적 언어에서는 this, 동적 언어에서는 self 를 주로 사용