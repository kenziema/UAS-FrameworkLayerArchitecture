package observable;

import java.util.ArrayList;

import model.Observer;


public class ReservationHandler implements ReservationEvents {
	
	private ArrayList<Observer> observerList;
	protected String roomType, name;

	public ReservationHandler() {
		observerList = new ArrayList<Observer>();
	}

	@Override
	public void addReservation(Observer ob) {
		this.observerList.add(ob);

	}

	@Override
	public void removeReservation(Observer ob) {
		this.observerList.remove(ob);
	}

	@Override
	public void notifyReservation() {
		for(Observer ob : observerList) {
			ob.updateRoom(name, roomType);
		}
	}
	
	@Override
	public void cancel() {
		for(Observer ob : observerList) {
			ob.cancelRoom(roomType);
		}
	}
	
	public ArrayList<Observer> getObserverList() {
		return observerList;
	}

	
	
	

}
