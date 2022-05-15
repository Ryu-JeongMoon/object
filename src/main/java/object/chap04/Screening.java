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

/*
단순히 행위를 위임한다고 하여 캡슐화가 지켜지는 것은 아니다
calculateFee()에서는 영화의 타입을 확인하고 switch-case 돌려서 타입에 따라 다른 메시지를 전송한다
영화 요금 계산 수행 자체는 Movie 인스턴스가 하지만
그 전에 어떤 타입인지 확인하고 어떤 메세지를 보낼지는 Screening이 수행한다

확장 가능한, 다시 말해 캡슐화가 잘 지켜진 객체지향 프로그램에서는 일련의 흐름 자체를 Movie에 맡겨야 한다
현재 API는 타입 확인, 타입에 따른 할인 정책까지 노출시키고 있어 타입이나 정책이 추가 & 수정되면 Screening까지 변경되어야 하고
이 구조를 유지할 때 요구 사항이 늘어나면 switch-case 돌릴 요소가 계속해서 증가한다

단순히 메서드 위임, getter & setter 없다고 캡슐화가 지켜지는 것은 아니다
어떤 타입 / 정책 / 조건이 있는지 노출하는 순간 캡슐화가 깨진 것이고 Movie의 변경으로만 끝났어야 할 여파가 다른 객체로 전파된 것이다
응집도가 낮고 결합도가 높은 구조다
이를 막기 위해서는 변할 수 있는 어떤 것이라도 숨겨야 하고 이 것이 진정한 캡슐화의 의미다
 */