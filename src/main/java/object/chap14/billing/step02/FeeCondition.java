package object.chap14.billing.step02;

import java.util.List;

import object.chap14.time.DateTimeInterval;

public interface FeeCondition {

	List<DateTimeInterval> findTimeIntervals(Call call);
}
