package object.chap14.billing.step01;

import object.chap14.money.Money;

public class TaxablePolicy extends AdditionalRatePolicy {

	private final double taxRatio;

	public TaxablePolicy(double taxRatio, RatePolicy next) {
		super(next);
		this.taxRatio = taxRatio;
	}

	@Override
	protected Money afterCalculated(Money fee) {
		return fee.plus(fee.times(taxRatio));
	}
}
