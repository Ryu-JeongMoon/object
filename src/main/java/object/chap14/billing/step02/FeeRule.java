package object.chap14.billing.step02;

import object.chap14.money.Money;

public class FeeRule {

	private final FeeCondition feeCondition;
	private final FeePerDuration feePerDuration;

	public FeeRule(FeeCondition feeCondition, FeePerDuration feePerDuration) {
		this.feeCondition = feeCondition;
		this.feePerDuration = feePerDuration;
	}

	public Money calculateFee(Call call) {
		return feeCondition.findTimeIntervals(call)
			.stream()
			.map(feePerDuration::calculate)
			.reduce(Money.ZERO, Money::plus);
	}
}
