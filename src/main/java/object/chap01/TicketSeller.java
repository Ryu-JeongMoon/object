package object.chap01;

public class TicketSeller {

	private final TicketOffice ticketOffice;

	public TicketSeller(TicketOffice ticketOffice) {
		this.ticketOffice = ticketOffice;
	}

	public void sellTo(Audience audience) {
		ticketOffice.sellTicketTo(audience);
	}
}

/*
TicketOffice 를 TicketSeller 안으로 캡슐화
 */