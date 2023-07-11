package chapter01;

import java.util.ArrayList;
import java.util.List;

public class GiverForTheater {
    final Long givenTicketFee = 100L;

    public GiverForTheater() {
    }

    List<Ticket> givenTikets() {
        List<Ticket> tickets = new ArrayList<Ticket>();
        tickets.add(new Ticket(givenTicketFee));
        return tickets;
    }

    TicketOffice givenTicketOffice() {
        return new TicketOffice(10000000L, givenTikets());
    }

    TicketSeller givenTicketSeller() {
        return new TicketSeller(givenTicketOffice());
    }

    Theater givenTheater() {
        return new Theater(givenTicketSeller());
    }

    Invitation givenInvitation() {
        return new Invitation();
    }

    Audience givenAudience_withoutInvitation() {
        return new Audience(new Bag(10000L));
    }

    Audience givenAudience_withInvitation() {
        return new Audience(new Bag(10000L, givenInvitation()));
    }
}