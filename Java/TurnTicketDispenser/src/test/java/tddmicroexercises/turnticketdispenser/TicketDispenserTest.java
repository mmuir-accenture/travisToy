package tddmicroexercises.turnticketdispenser;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TicketDispenserTest {

    @Before
    public void setUp() throws Exception {
        TurnNumberSequence.resetCounter();
    }

    @Test
    public void FirstCustomerShouldGetTicketNumber0() {
        TicketDispenser ticketdispenser = new TicketDispenser();

        TurnTicket testTicket = ticketdispenser.getTurnTicket();

        assertEquals(0, testTicket.getTurnNumber());

    }

    @Test
    public void ThirdCustomerShouldGetTicketNumber2() {
        TicketDispenser newTicketDispenser = new TicketDispenser();

        newTicketDispenser.getTurnTicket();
        newTicketDispenser.getTurnTicket();
        TurnTicket testTicket = newTicketDispenser.getTurnTicket();

        assertEquals(2, testTicket.getTurnNumber());
    }

    @Test
    public void SecondDispenserShouldGiveTicketNumberHigherThanPriorTicket() {
        TicketDispenser firstTicketDispenser = new TicketDispenser();
        TicketDispenser secondTicketDispenser = new TicketDispenser();

        TurnTicket firstTicket = firstTicketDispenser.getTurnTicket();
        TurnTicket secondTicket = secondTicketDispenser.getTurnTicket();

        assertEquals(firstTicket.getTurnNumber() + 1, secondTicket.getTurnNumber());


    }
}