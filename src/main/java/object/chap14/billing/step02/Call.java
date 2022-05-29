package object.chap14.billing.step02;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import object.chap14.time.DateTimeInterval;

public class Call {

	private final DateTimeInterval interval;

	public Call(LocalDateTime from, LocalDateTime to) {
		this.interval = DateTimeInterval.of(from, to);
	}

	public Duration getDuration() {
		return interval.duration();
	}

	public LocalDateTime getFrom() {
		return interval.getFrom();
	}

	public LocalDateTime getTo() {
		return interval.getTo();
	}

	public DateTimeInterval getInterval() {
		return interval;
	}

	public List<DateTimeInterval> splitByDay() {
		return interval.splitByDay();
	}
}
