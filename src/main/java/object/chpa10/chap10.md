# Inheritance and Code Reusing

## Inheritance and Duplicated Code
- Don't Repeat Yourself, DRY <br>
단순히 똑같은 코드만 중복이 아니라 변경 상황에서 함께 수정해야 한다면 중복 코드다

<hr>

## Fragile Base Class Problem
super class의 변경에 의해 sub class가 영향을 받는 현상, 취약한 기반 클래스 문제 extends를 구현하게 되면 이런 현상이 발생한다 <br>
코드 재사용을 위해서라면 합성을 이용하고 다형성을 위한 상속 계층이 필요하다면 인터페이스를 이용하자

Stack의 예로 취약한 기반 클래스 문제를 확인할 수 있다 애초 설계 시에는 코드 재사용을 위해 Vector를 extends하여 Stack을 구현했는데 이는 Stack의 개념을 넘어서는 api를 사용할 수 있게 되었고 Collection Framework의 등장 이후 결국 deprecated 되었다 

<hr>

## Problem-Solving by Abstraction
- 추상화에 의존하라
- 차이를 메서드로 추출하라
- 중복되는 코드를 부모 클래스로 올려라 (위에서 내리지 말고 추상화 시켜라)

<hr>

## Programming by Difference
기존 코드와 다른 부분만을 추가함으로써 기능을 확장하는 방식
중복을 없애야 하는 이유는 개발자의 수고를 덜어주는 것 뿐만 아니라 버그를 줄이는데 더 큰 가치가 있다