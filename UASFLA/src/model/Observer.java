package model;

public interface Observer {
	//buat ngasih pesan atau msg ke roomType
	//display harga yg di input dari roomType 
	public void updateRoom(String name, String roomType);
	public void cancelRoom(String roomType);
}
