package hello.core.order;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

class OrderTest {
	
	OrderService orderService;
	
	MemberService memberService;
	
	@BeforeEach
	void before() {
		AppConfig appConfig = new AppConfig();
		orderService = appConfig.orderService();
		memberService = appConfig.memberService();
	}

	@Test
	void test() {
		
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Order order = orderService.createOrder(memberId, "itemA", 20000);
		Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);
		
	}

}
