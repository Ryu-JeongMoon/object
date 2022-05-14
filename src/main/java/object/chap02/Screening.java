package object.chap02;

import java.time.LocalDateTime;

import object.chap04.Customer;

public class Screening {

	private final Movie movie;
	private final int sequence;
	private final LocalDateTime startTime;

	public Screening(Movie movie, int sequence, LocalDateTime startTime) {
		this.movie = movie;
		this.sequence = sequence;
		this.startTime = startTime;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public boolean isSatisfiedSequenceCondition(int sequence) {
		return this.sequence == sequence;
	}

	public Money getMovieFee() {
		return movie.getFee();
	}

	public Reservation reserve(Customer customer, int audienceCount) {
		return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
	}

	private Money calculateFee(int audienceCount) {
		return movie.calculateFee(this).times(audienceCount);
	}
}
