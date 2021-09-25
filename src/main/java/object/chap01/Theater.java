package object.chap01;

public class Theater {

    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }
}

/*
audience, ticket-seller가 수동적인 존재
객체지향의 세계에서는 서로 의존하며 협력하는 공동체를 만드는 것이 목표
객체가 각자의 책임 & 역할을 가지고.

너무 많은 정보, 많은 객체에 의존하고 있다
결합도가 높아 변경하기 어렵다
-> 객체를 자율적인 존재로 만들자

캡슐화를 통해 Theater는 TicketOffice 존재 자체를 모르게 된다
-> 의존성을 끊어냈다, 티켓 판매 행위를 TicketSeller에게 위임

 */