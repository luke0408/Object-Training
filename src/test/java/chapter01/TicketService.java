package chapter01;

import org.junit.jupiter.api.Assertions;

public class TicketService {
    final GiverForTheater giverForTheater = new GiverForTheater();

    void give_ticket_into_bag(final Theater theater, final Audience audience) {
        final Long beforeAmount = audience.getBag().getAmount();
        theater.enter(audience);

        Assertions.assertTrue(audience.getBag().hasTicket(), "관람객의 가방에는 이미 티켓이 들어있습니다.");
        Assertions.assertEquals(beforeAmount, audience.getBag().getAmount(), "관람객의 가방에는 티켓이 들어있으므로, 현금은 변동이 없어야합니다.");
    }

    boolean pay_to_ticket_fee(final Theater theater, final Audience audience) {
        final Long beforeAmount = audience.getBag().getAmount();
        theater.enter(audience);

        final Long afterAmount = audience.getBag().getAmount();
        Assertions.assertEquals((long) giverForTheater.givenTicketFee, beforeAmount - afterAmount, "관람객의 가방에는 티켓이 없었음으로, 현금은 티켓의 가격만큼 감소해야합니다.");

        return true;
    }

    boolean givenAudience_withInvitation_test(Theater theater, Audience audience) {
        give_ticket_into_bag(theater, audience);
        return true;
    }

    boolean givenAudience_withoutInvitation_test(final Theater theater, final Audience audience) {
        boolean result = pay_to_ticket_fee(theater, audience);

        if (result) {
            give_ticket_into_bag(theater, audience);
        } else {
            return false;
        }

        return true;
    }
}