package object.chap14.billing.step02;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import object.chap14.time.DateTimeInterval;

public class DayOfWeekFeeCondition implements FeeCondition {

	private final List<DayOfWeek> dayOfWeeks;

	public DayOfWeekFeeCondition(DayOfWeek... dayOfWeeks) {
		this.dayOfWeeks = Arrays.asList(dayOfWeeks);
	}

	@Override
	public List<DateTimeInterval> findTimeIntervals(Call call) {
		return call.getInterval()
			.splitByDay()
			.stream()
			.filter(each ->
				dayOfWeeks.contains(each.getFrom().getDayOfWeek()))
			.collect(Collectors.toList());
	}
}
