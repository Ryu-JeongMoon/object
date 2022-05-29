package object.chap14.billing.step01;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import object.chap14.money.Money;
import object.chap14.time.DateTimeInterval;

public class TimeOfDayDiscountPolicy extends BasicRatePolicy {

	private final List<LocalTime> starts = new ArrayList<>();
	private final List<LocalTime> ends = new ArrayList<>();
	private final List<Duration> durations = new ArrayList<>();
	private final List<Money> amounts = new ArrayList<>();

	@Override
	protected Money calculateCallFee(Call call) {
		Money result = Money.ZERO;
		for (DateTimeInterval interval : call.splitByDay()) {
			for (int loop = 0; loop < starts.size(); loop++) {
				result.plus(amounts.get(loop).times(
						Duration.between(
							from(interval, starts.get(loop)),
							to(interval, ends.get(loop))).getSeconds() / durations.get(loop).getSeconds()
					)
				);
			}
		}
		return result;
	}

	private LocalTime from(DateTimeInterval interval, LocalTime from) {
		return interval.getFrom().toLocalTime().isBefore(from) ? from : interval.getFrom().toLocalTime();
	}

	private LocalTime to(DateTimeInterval interval, LocalTime to) {
		return interval.getTo().toLocalTime().isAfter(to) ? to : interval.getTo().toLocalTime();
	}
}
