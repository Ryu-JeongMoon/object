package object.chap01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicketOffice {

	private final List<Ticket> tickets = new ArrayList<>();
	private Long amount;

	public TicketOffice(Long amount, Ticket... tickets) {
		this.amount = amount;
		this.tickets.addAll(Arrays.asList(tickets));
	}

	private Ticket getTicket() {
		return tickets.remove(0);
	}

	public void minusAmount(Long amount) {
		this.amount -= amount;
	}

	private void plusAmount(Long amount) {
		this.amount += amount;
	}

	public void sellTicketTo(Audience audience) {
		plusAmount(audience.buy(getTicket()));
	}
}

/*
TicketOffice가 Audience에게 티켓을 판다?!
현실에서는 판매원이 티켓을 판매하고, 고객은 자신의 가방에서 초대장을 꺼내 준다
-> 객체지향 세계가 현실 세계를 완전 모방하는 것이 아닌게 무생물 & 개념이 능동적인 존재가 되기 때문

설계란 코드를 배치하는 것
설계는 구현과 뗄 수 없는 사이다
어떻게 배치해야 하는가?
-> 객체 간 의존성을 줄여 변경에 유연하게 대처할 수 있어야 한다
 */