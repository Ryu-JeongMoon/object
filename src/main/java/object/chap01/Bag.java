package object.chap01;

public class Bag {

	private Long amount;
	private final Invitation invitation;
	private Ticket ticket;

	public Bag(Long amount) {
		this(amount, null);
	}

	public Bag(Long amount, Invitation invitation) {
		this.amount = amount;
		this.invitation = invitation;
	}

	private boolean hasInvitation() {
		return invitation != null;
	}

	public boolean hasTicket() {
		return ticket != null;
	}

	private void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	private void minusAmount(Long amount) {
		this.amount -= amount;
	}

	public void plusAmount(Long amount) {
		this.amount += amount;
	}

	public Long hold(Ticket ticket) {
		if (hasInvitation()) {
			this.ticket = ticket;
			return 0L;
		} else {
			this.ticket = ticket;
			minusAmount(ticket.getFee());
			return ticket.getFee();
		}
	}
}
