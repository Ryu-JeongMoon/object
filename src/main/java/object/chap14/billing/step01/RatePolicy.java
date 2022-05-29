package object.chap14.billing.step01;

import object.chap14.money.Money;

public interface RatePolicy {
	Money calculateFee(Phone phone);
}
