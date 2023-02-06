package observable;

import model.Observer;

public interface ReservationEvents {
	public void addReservation(Observer ob);
	public void removeReservation(Observer ob);
	//ngasih tau prepare fasilitas ke room type apa
	public void notifyReservation();
	public void cancel();
}
