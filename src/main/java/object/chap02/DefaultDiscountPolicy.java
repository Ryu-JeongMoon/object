package object.chap02;

import java.util.ArrayList;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {

    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition... discountConditions) {
        this.conditions = List.of(discountConditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition condition : conditions) {
            if (condition.isSatisfiedBy(screening))
                return getDiscountAmount(screening);
        }
        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
