package chapter02.money;

import chapter02.movie.Screening;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
