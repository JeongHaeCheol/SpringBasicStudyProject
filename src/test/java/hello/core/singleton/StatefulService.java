package hello.core.singleton;

public class StatefulService {
	
	private int price; // 상태를 유지하는 필드
	
	public void order(String name, int price) {
		System.out.println("name = " + name + " , price = " + price);
		this.price = price;
	}
	
	
	/*
	 * 무상태 방식으로 설계한다면
	 * price 필드를 없애고 getPrice메소드도 없앤다.
	 * 
	public int order(String name, int price) {
		System.out.println("name = " + name + " , price = " + price);
		return price;
	}
	*/
	
	public int getPrice() {
		return price;
	}
	

}
