package hello.core.scope;

import static org.assertj.core.api.Assertions.assertThat;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;


class PrototypeTest {

	@Test
	void PrototypeBeanFind() {
		
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

		
		System.out.println("find prototypeBean 1");
		PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
		
		System.out.println("find prototypeBean 2");
		PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
						
		
		System.out.println("prototypeBean 1 : " + prototypeBean1);
		System.out.println("prototypeBean 2 : " + prototypeBean2);
		
		assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
		
		
		//수동 destroy 필요
		prototypeBean1.destroy();
		prototypeBean2.destroy();
		
		ac.close();
	}

	@Scope("prototype")
	static class PrototypeBean {

		@PostConstruct
		public void init() {
			System.out.println("prototype init");
		}

		@PreDestroy
		public void destroy() {
			System.out.println("prototype destroy");
		}
	}

}
