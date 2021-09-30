package object.chap05;

import java.time.LocalDateTime;
import lombok.Getter;
import object.chap02.Money;

@Getter
public class Screening {

    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
