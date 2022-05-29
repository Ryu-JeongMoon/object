package object.chap14.billing.step02;

import java.util.List;

import object.chap14.time.DateTimeInterval;

public class FixedFeeCondition implements FeeCondition {

	@Override
	public List<DateTimeInterval> findTimeIntervals(Call call) {
		return List.of(call.getInterval());
	}
}
