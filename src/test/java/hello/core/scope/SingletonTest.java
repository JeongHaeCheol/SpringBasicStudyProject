package hello.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

class SingletonTest {

	@Test
	void SingletonBeanFind() {
		
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

		SingletonBean singtonBean1 = ac.getBean(SingletonBean.class);
		SingletonBean singtonBean2 = ac.getBean(SingletonBean.class);
				
		System.out.println("sb 1 = " + singtonBean1 );
		System.out.println("sb 2 = " + singtonBean2 );
				
		assertThat(singtonBean1).isSameAs(singtonBean2);
		ac.close();
	}

	@Scope("singleton")
	static class SingletonBean {

		@PostConstruct
		public void init() {
			System.out.println("singleton init");
		}

		@PreDestroy
		public void destroy() {
			System.out.println("singleton destroy");
		}
	}

}
