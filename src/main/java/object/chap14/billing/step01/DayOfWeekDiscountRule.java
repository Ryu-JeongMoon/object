package object.chap14.billing.step01;

import java.time.DayOfWeek;
import java.time.Duration;
import java.util.List;

import object.chap14.money.Money;
import object.chap14.time.DateTimeInterval;

public class DayOfWeekDiscountRule {
	private final List<DayOfWeek> dayOfWeeks;
	private final Duration duration;
	private final Money amount;

	public DayOfWeekDiscountRule(List<DayOfWeek> dayOfWeeks, Duration duration, Money amount) {
		this.dayOfWeeks = dayOfWeeks;
		this.duration = duration;
		this.amount = amount;
	}

	public Money calculate(DateTimeInterval interval) {
		if (dayOfWeeks.contains(interval.getFrom().getDayOfWeek()))
			return amount.times(interval.duration().getSeconds() / duration.getSeconds());

		return Money.ZERO;
	}
}
