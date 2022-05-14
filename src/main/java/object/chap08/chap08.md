## Dependency

객체 간 협력 시 의존성 발생<br>

- 실행 시점 : 의존 대상 객체가 존재해야 의존하는 객체가 정상 동작한다
- 구현 시점 : 의존 대상 객체가 변경되는 경우, 의존하는 객체 역시 변경된다

~~~
public class PeriodCondition implements DiscountCondition {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    
    public boolean isSatisfied(Screening screening) {
        return screening.getStartTime().getDayOfWeek().equals(dayOfWeek) &&
            startTime.compareTo(screening.getStartTime().toLocalTime()) <= 0 &&
            endTime.compareTo(screening.getStartTime().toLocalTime()) >= 0;
    }
~~~

의존성은 방향성을 가지며 항상 단방향이다 스프링 컨테이너를 사용할 때 순환 참조 발생 시 오류 터진다

### Transitive Dependency

위 코드 참조, PeriodCondition -> Screening 의존성을 가지며 isSatisfiedBy method 에서는 Screening 이 가지고 있는 속성에 대해서도 의존성을 가진다<br>

이 때 직접 의존성과 간접 의존성으로 나눌 수 있다

- Screening 에 대한 의존성이 직접
- Screening 의 속성에 대한 의존성이 간접

### Compile-time & Runtime Dependency

- 컴파일타임은 모호하다 컴파일 하는 시점을 가르키거나 코드 그 자체를 의미하기 때문이다
  __코드 관점에서 주인공은 class__
- 런타임 의존성이란 실행 시점을 의미하므로 __주인공은 object__

컴파일타임과 런타임 의존성이 달라야 유연한 설계가 가능하다<br>
if-else 로 뒤덮인 코드를 작성하지 않으려면 이를 유의해야 한다<br>
컴파일타임에는 interface or abstract class 에 의존해야 하고 런타임에 object instance 에 의존하도록!<br>
이러한 경우에는 객체 특화 메서드는 사용할 수 없다, 사용하기 위해서는 down casting 으로 타입을 명시해줘야 하는데, 객체 간 의존성을 줄이기 위해 실제 객체에 의존하지 않게 코드를 작성한 이유가
사라진다<br>
꼭 필요한 경우라면 interface or abstract class 에 정의하고 public interface 로 만들어야 한다

### Dependency Resolution

컴파일타임, 런타임 의존성이 달라야 한다는 것을 이해했는데 이를 어떻게 수행할 수 있는가?

1. constructor<br>
   객체 생성하는 시점에 클라이언트 코드에서 넘겨주기
2. setter method<br>
   의존성 세팅 전에 의존성이 있는 메서드 사용하면 NPE, 따라서 생성자 방식과 혼합해서 사용<br>
   set method 사용은 변경 전파 위험이 있으니 특별한 네이밍을 통해 changeXX() 등의 방식으로 이용
3. method argument<br>
   의존성이 계속 필요하지 않고 메서드 수행에만 필요한 경우 인자로 넘겨줌

