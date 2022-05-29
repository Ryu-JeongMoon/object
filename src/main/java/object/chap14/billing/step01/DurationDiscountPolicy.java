package object.chap14.billing.step01;

import java.util.List;

import object.chap14.money.Money;

public class DurationDiscountPolicy extends BasicRatePolicy {

	private final List<DurationDiscountRule> rules;

	public DurationDiscountPolicy(List<DurationDiscountRule> rules) {
		this.rules = rules;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		return rules.stream()
			.reduce(Money.ZERO, (money, rule) -> rule.calculate(call), Money::plus);
	}
}