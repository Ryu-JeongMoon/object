package object.chap02;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {

	private final Money discountAmount;

	public AmountDiscountPolicy(Money discountAmount, DiscountCondition... discountConditions) {
		super(discountConditions);
		this.discountAmount = discountAmount;
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		return discountAmount;
	}
}
