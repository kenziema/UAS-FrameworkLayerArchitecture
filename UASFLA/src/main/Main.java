package main;

import java.util.ArrayList;
import java.util.Scanner;

import model.Family;
import model.Regular;
import model.Room;
import model.Royal;
import observable.ReservationHandler;
import model.Observer;

public class Main {

		Scanner sc = new Scanner(System.in);
		ReservationHandler rh = new ReservationHandler();
		ArrayList<String> userList = new ArrayList<String>();
		
		void display() {
			System.out.println("1. Insert New Reservation");
			System.out.println("2. Manage Reservation");
			System.out.println("3. Prepare Reservation");
			System.out.println("4. Exit");
		}
		
		int displayAllUser() {
			int count = 0;
			System.out.println("");
			for(String s : userList) {
				System.out.println((count+1) + ". " + s);
				count++;
			}
			System.out.println("");
			return count;
		}
		
		int getOpt(int min, int max) {
			int opt = 0;
			do {
				System.out.print(">>");
				try {
					opt = sc.nextInt();
				} catch (Exception e) {
					
				}
				sc.nextLine();
			}while(opt < min || opt > max);
			
			return opt;
		}
		
		Observer newReservation() {
			//validasi nama gaboleh kosong
			String name = "";
			do {
				System.out.print("Input your name: ");
				name = sc.nextLine();
			}while(name.isEmpty());

			String roomType;
			double price;
			System.out.println("");
			do {
				System.out.println("Pilih tipe kamar: [Royal|Family|Regular]");
				roomType = sc.nextLine();
			}while(!(roomType.equalsIgnoreCase("Royal") || roomType.equalsIgnoreCase("Family") || roomType.equalsIgnoreCase("Regular")));
			
			userList.add(roomType);
			if(roomType.equalsIgnoreCase("Royal")) {
				do {
					System.out.println("Masukkan harga kamar: [Minimum harga kamar 4.000.000]");
					price = sc.nextDouble();
					sc.nextLine();
				}while(price <= 4000000);
				return new Royal(price);
			}else if(roomType.equalsIgnoreCase("Family")){
				do {
					System.out.println("Masukkan harga kamar: [Minimum harga kamar 2.000.000]");
					price = sc.nextDouble();
					sc.nextLine();
				}while(price <= 2000000);
				return new Family(price);
			}else if(roomType.equalsIgnoreCase("Regular")){
				do {
					System.out.println("Masukkan harga kamar: [Minimum harga kamar 1.000.000]");
					price = sc.nextDouble();
					sc.nextLine();
				}while(price <= 1000000);
				return new Regular(price);
			}
			return null;
		}
		
		Observer prepareReservation() {
			if(userList.isEmpty()) {
				System.out.println("\nBelum ada reservasi!\n");
				return null;
			}else {
				int max = displayAllUser();
				int opt = getOpt(1, max);
				
				rh.notifyReservation();
				
			}
			return null;
		}
		
		Observer manageReservation() {
			System.out.println("");
			System.out.println("1. Upgrade Reservation");
			System.out.println("2. Cancel Reservation");
			int choice = getOpt(1, 2);
			
			if(choice == 2) {
				int max = displayAllUser();
				int opt = getOpt(1, max);
				opt--;
				rh.removeReservation(rh.getObserverList().get(opt));
				userList.remove(opt);
				rh.cancel();
			} else {
				int max = displayAllUser();
				int opt = getOpt(1, max);
				opt--;
				userList.remove(opt);
				
				String roomType;
				double price;
				System.out.println("");
				do {
					System.out.println("Pilih tipe kamar: [Royal|Family|Regular]");
					roomType = sc.nextLine();
				}while(!(roomType.equalsIgnoreCase("Royal") || roomType.equalsIgnoreCase("Family") || roomType.equalsIgnoreCase("Regular")));
				
				userList.add(roomType);
				if(roomType.equalsIgnoreCase("Royal")) {
					do {
						System.out.println("Masukkan harga kamar: [Minimum harga kamar 4.000.000]");
						price = sc.nextDouble();
						sc.nextLine();
					}while(price <= 4000000);
					return new Royal(price);
				}else if(roomType.equalsIgnoreCase("Family")){
					do {
						System.out.println("Masukkan harga kamar: [Minimum harga kamar 2.000.000]");
						price = sc.nextDouble();
						sc.nextLine();
					}while(price <= 2000000);
					return new Family(price);
				}else if(roomType.equalsIgnoreCase("Regular")){
					do {
						System.out.println("Masukkan harga kamar: [Minimum harga kamar 1.000.000]");
						price = sc.nextDouble();
						sc.nextLine();
					}while(price <= 1000000);
					return new Regular(price);
				}
			}
			return null;
		}
		
		public Main() {
			int mOpt = 0;
			do {
				displayAllUser();
				display();
				
				mOpt = getOpt(1, 4);
				switch(mOpt) {
					case 1:
						Observer ob = newReservation();
						rh.addReservation(ob);
						break;
					case 2:
						manageReservation();
						break;
					case 3:
						prepareReservation();
						break;
				}
			}while(mOpt != 4);
		}
	

	public static void main(String[] args) {
		new Main();
	}

}
