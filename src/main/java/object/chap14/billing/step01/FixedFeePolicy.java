package object.chap14.billing.step01;

import java.time.Duration;

import object.chap14.money.Money;

public class FixedFeePolicy extends BasicRatePolicy {

	private final Money amount;
	private final Duration seconds;

	public FixedFeePolicy(Money amount, Duration seconds) {
		this.amount = amount;
		this.seconds = seconds;
	}

	@Override
	protected Money calculateCallFee(Call call) {
		return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
	}
}
