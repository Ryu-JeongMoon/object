package object.chap14.billing.step01;

import java.util.List;

import object.chap14.money.Money;
import object.chap14.time.DateTimeInterval;

public class DayOfWeekDiscountPolicy extends BasicRatePolicy {

	private final List<DayOfWeekDiscountRule> rules;

	public DayOfWeekDiscountPolicy(List<DayOfWeekDiscountRule> rules) {
		this.rules = rules;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		List<DateTimeInterval> intervals = call.getInterval().splitByDay();
		return intervals.stream()
			.reduce(
				Money.ZERO,
				(money, interval) -> rules.stream().reduce(
					money, (eachMoney, rule) -> eachMoney.plus(rule.calculate(interval)), Money::plus),
				Money::plus
			);
	}
}

/*
옴매 가독성 무슨 일
 */