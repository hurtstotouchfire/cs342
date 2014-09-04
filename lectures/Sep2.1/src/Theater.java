
public class Theater {
	private static int ticketCount = 0;
	
	public String printTicketCount() {
		return Integer.toString(ticketCount);
	}
	
	public void sellTicket() {
		ticketCount++; 
	}
}
