package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

	private String name;
	private int age;
	
	public static void main(String[] args) {
		HelloLombok h = new HelloLombok();
		h.setAge(20);
		h.setName("test");
		System.out.println(h.toString());
	}
	
	
}
