package hello.core.member;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;

class MemberTest {

	MemberService memberService;
	
	@BeforeEach
	void before() {
		AppConfig appConfig = new AppConfig();
		memberService = appConfig.memberService();
	}
	
	
	@Test
	void join() {
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMember(memberId);
		
		Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
		
	}

}
