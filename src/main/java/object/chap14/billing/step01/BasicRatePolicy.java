package object.chap14.billing.step01;

import object.chap14.money.Money;

public abstract class BasicRatePolicy implements RatePolicy {
	@Override
	public Money calculateFee(Phone phone) {
		return phone.getCalls().stream()
			.reduce(Money.ZERO, (money, call) -> calculateCallFee(call), Money::plus);
	}

	protected abstract Money calculateCallFee(Call call);
}
