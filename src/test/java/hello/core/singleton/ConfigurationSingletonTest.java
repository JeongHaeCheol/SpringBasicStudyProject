package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;

class ConfigurationSingletonTest {

	@Test
	void configurationTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
		
	
		MemberRepository memberRepository1 = memberService.getMemberRepository();
		MemberRepository memberRepository2 = orderService.getMemberRepository();
		MemberRepository memberRepository3 = ac.getBean("memberRepository", MemberRepository.class);
		
		Assertions.assertThat(memberRepository1).isSameAs(memberRepository2);
		Assertions.assertThat(memberRepository1).isSameAs(memberRepository3);
	}
	
	@Test
	@DisplayName("@configuration은 개발자가 만든 클래스를 토대로 바이트 조작을 통해 새로운 Bean을 만들고 등록한다. bean의 클래스타입으로 확인")
	void configurationDeep() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		AppConfig bean = ac.getBean(AppConfig.class);
		
		System.out.println("AppConfig = " + bean.getClass());
		Assertions.assertThat(bean.getClass()).isNotSameAs(AppConfig.class);
	}

}
