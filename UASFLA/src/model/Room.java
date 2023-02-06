package model;

public class Room implements Observer{
	
	protected String roomType;
	protected double price;
	
	public Room(String roomType, double price) {
		super();
		this.roomType = roomType;
		this.price = price;
	}

	public String getRoomType() {
		return roomType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public void updateRoom(String name, String roomType) {
		if(this.roomType.equalsIgnoreCase("Royal")) {
			System.out.println("Your room is " + this.roomType + " need few things to prepare");
			System.out.println("Private Jacuzzi");
			System.out.println("Private Pool");
			System.out.println("Free breakfast for 4");
			System.out.println("Eligible to request menu (all day serve)\n\n");
		}else if(this.roomType.equalsIgnoreCase("Family")) {
			System.out.println("Your room is " + this.roomType + " need few things to prepare");
			System.out.println("Private Jacuzzi");
			System.out.println("Free breakfast for 3");
			System.out.println("Eligible to request menu (dinner only)\n\n");
		}else if(this.roomType.equalsIgnoreCase("Regular")) {
			System.out.println("Your room is " + (this.roomType) + " need few things to prepare");
			System.out.println("Mini fridge inside bedroom");
			System.out.println("Free breakfast for 2\n\n");
		}
	}
	
	@Override
	public void cancelRoom(String roomType) {
		System.out.println("\nYour reservation on " +(this.roomType)+" has been cancelled, updated invoice has been sent to your email...");
		System.out.println("Thank you for understanding :)");
		System.out.println("Hope you stay with us next time!\n");
	}
	

}
