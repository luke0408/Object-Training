package chapter01;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TheaterTest {

    private final TicketService ticketService = new TicketService();

    @Test
    public void enter_test() {
        // given
        Theater theater = ticketService.giverForTheater.givenTheater();

        int key = (int)(Math.random() * 2);


        // when
        final boolean response = get_enter_test_result(theater, key);

        // then
        Assertions.assertTrue(response, "관람객 입장이 실패하였습니다.");
    }

    private boolean get_enter_test_result(Theater theater, int key) {
        boolean result = false;

        switch (key) {
            case 0:
                Audience audience_withInvitation = ticketService.giverForTheater.givenAudience_withInvitation();
                result = ticketService.givenAudience_withInvitation_test(theater, audience_withInvitation);
                break;
            case 1:
                Audience audience_withoutInvitation = ticketService.giverForTheater.givenAudience_withoutInvitation();
                result = ticketService.givenAudience_withoutInvitation_test(theater, audience_withoutInvitation);
                break;
        }

        return result;
    }

}