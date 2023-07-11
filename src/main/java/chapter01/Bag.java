package chapter01;

public class Bag {
    private Long amount;    // 현금
    private Invitation invitation;  // 초대장
    private Ticket ticket;  // 티켓

    public Bag(Long amount) {
        this.amount = amount;
    }

    public Bag(Long amount, Invitation invitation) {
        this.amount = amount;
        this.invitation = invitation;
    }

    // 초대장 여부 확인
    public boolean hasInvitation() {
        return invitation != null;
    }

    // 티켓 여부 확인
    public boolean hasTicket() {
        return ticket != null;
    }

    // 초대장을 티켓으로 교환
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    // 현금을 감소
    public void minusAmount(Long amount) {
        this.amount -= amount;
    }

    // 현금을 증가
    public void plusAmount(Long amount) {
        this.amount += amount;
    }
}
