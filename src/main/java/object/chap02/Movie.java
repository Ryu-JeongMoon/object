package object.chap02;

import java.time.Duration;

public class Movie {

	private final String title;
	private final Duration runningTime;
	private final Money fee;
	private final DefaultDiscountPolicy discountPolicy;

	public Movie(String title, Duration runningTime, Money fee, DefaultDiscountPolicy discountPolicy) {
		this.title = title;
		this.runningTime = runningTime;
		this.fee = fee;
		this.discountPolicy = discountPolicy;
	}

	public Money getFee() {
		return fee;
	}

	public Money calculateFee(Screening screening) {
		return fee.minus(discountPolicy.calculateDiscountAmount(screening));
	}
}
