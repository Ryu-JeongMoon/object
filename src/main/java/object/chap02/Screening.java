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

/*
영화 요금을 계산할 책임은 누구에게 있는가?
영화 요금에 대한 정보를 가장 잘 알고 있는 전문가에게 맡겨야 한다
Screening에서 요금 계산을 하겠다고 getMovie().getFee() 어쩌구 저쩌구 식으로 풀어내면
Movie 객체의 자율성을 훼손하고 Movie는 데이터 저장소로 전락하고 만다
요금에 대한 정보를 알고 있는, 그에 앞서 요금 계산에 대한 책임을 갖고 있는 Movie에게 묻지 말고 시킬 것
그래야만 영화 요금 계산 로직이 변하더라도 그 책임을 갖고 있는 Movie에서만 변경하면 된다

의식의 흐름을 따라 설계해서는 안 된다
영화라는 개념을 듣고 상영을 해야겠다고 생각이 들 수 있지만 현재 문맥 안에서 Movie는 요금 계산의 책임을 가지고 있다
응집도 있는, 자율적인 객체를 만들기 위해서는
1. 협력 안에서 전달할 메세지를 먼저 선택하고
2. 메세지를 수신할 역할을 선택하고
3. 역할을 수행할 수 있는 객체를 선택하고
4. 메세지를 처리할 메서드를 선택하고
5. 메서드를 실행하기 위한 정보를 선택해야 한다

요금 계산해라 -> 영화 요금 계산 (역할) -> Movie 객체 선택 (책임을 가진 객체) -> calculateFee() 메서드 선택 -> 요금 계산 로직 구현
 */