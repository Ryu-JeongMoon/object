package object.chap14.billing.step02;

import object.chap14.money.Money;

public abstract class AdditionalRatePolicy implements RatePolicy {

	private final RatePolicy next;

	public AdditionalRatePolicy(RatePolicy next) {
		this.next = next;
	}

	@Override
	public Money calculateFee(Phone phone) {
		return afterCalculated(next.calculateFee(phone));
	}

	abstract protected Money afterCalculated(Money fee);
}
