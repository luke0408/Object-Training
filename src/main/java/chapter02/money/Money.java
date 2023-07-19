package chapter02.money;

public class Money {
    public static final Money ZERO = Money.wons(0);

    private final int amount;

    public Money(int amount) {
        this.amount = amount;
    }

    public static Money wons(int amount) {
        return new Money(amount);
    }

    public Money plus(Money amount) {
        return new Money(this.amount + amount.amount);
    }

    public Money minus(Money amount) {
        return new Money(this.amount - amount.amount);
    }

    public Money times(double percent) {
        return new Money((int) (this.amount * percent));
    }

    public boolean isLessThan(Money other) {
        return this.amount < other.amount;
    }

    public boolean isGreaterThanOrEqual(Money other) {
        return this.amount >= other.amount;
    }
}
