package object.chap04;

import lombok.AllArgsConstructor;
import lombok.Data;
import object.chap02.Money;

@Data
@AllArgsConstructor
public class Reservation {

    private Customer customer;
    private Screening screening;
    private Money fee;
    private int audienceCount;

}
