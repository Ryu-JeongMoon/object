package object.chap14.billing.step02;

import object.chap14.money.Money;

public interface RatePolicy {

	Money calculateFee(Phone phone);
}
