package object.chap04;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import object.chap02.Money;

@Data
@AllArgsConstructor
public class Screening {

	private Movie movie;
	private int sequence;
	private LocalDateTime whenScreened;

	public Money calculateFee(int audienceCount) {
		switch (movie.getMovieType()) {
			case AMOUNT_DISCOUNT:
				if (movie.isDiscountable(whenScreened, sequence)) {
					return movie.calculateAmountDiscountedFee().times(audienceCount);
				}
				break;
			case PERCENT_DISCOUNT:
				if (movie.isDiscountable(whenScreened, sequence)) {
					return movie.calculatePercentDiscountedFee().times(audienceCount);
				}
				break;
			case NONE_DISCOUNT:
				return movie.calculateNoneDiscountedFee().times(audienceCount);
		}

		return movie.calculateNoneDiscountedFee().times(audienceCount);
	}
}
