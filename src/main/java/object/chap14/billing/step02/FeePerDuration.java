package object.chap14.billing.step02;

import java.time.Duration;

import object.chap14.money.Money;
import object.chap14.time.DateTimeInterval;

public class FeePerDuration {

	private final Money fee;
	private final Duration duration;

	public FeePerDuration(Money fee, Duration duration) {
		this.fee = fee;
		this.duration = duration;
	}

	public Money calculate(DateTimeInterval interval) {
		return fee.times(Math.ceil((double)interval.duration().toNanos() / duration.toNanos()));
	}
}

