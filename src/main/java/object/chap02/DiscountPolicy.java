package object.chap02;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
