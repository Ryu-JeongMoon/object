package object.chap14.billing.step02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eternity.money.Money;

public class Phone {
	private final RatePolicy ratePolicy;
	private final List<Call> calls = new ArrayList<>();

	public Phone(RatePolicy ratePolicy) {
		this.ratePolicy = ratePolicy;
	}

	public void call(Call call) {
		calls.add(call);
	}

	public List<Call> getCalls() {
		return Collections.unmodifiableList(calls);
	}

	public Money calculateFee() {
		return ratePolicy.calculateFee(this);
	}
}
