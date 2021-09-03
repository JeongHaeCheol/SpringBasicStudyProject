package hello.core.autowired;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import hello.core.member.Member;

class AutowiredTest {

	@Test
	void autowiredOption() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
		//ac.getBean(null)
	}
	
	static class TestBean {
		
		//required=false일떄 자동 주입할 대상이 없으면 아예 메소드가 호출 안된다
		@Autowired(required=false)
		public void setNoBean1(Member noBean1) {
			System.out.println("noBean1 = " + noBean1);
		}
		
		@Autowired
		public void setNoBean2(@Nullable Member noBean2) {
			System.out.println("noBean2 = " + noBean2);
		}
		
		@Autowired
		public void setNoBean3(Optional<Member> noBean3) {
			System.out.println("noBean3 = " + noBean3);
		}
	}

}
