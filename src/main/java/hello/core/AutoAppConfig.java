package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
		//basePackages를 사용하지 않으면 default로 @ComponentScan이 붙은 클래스가 속한 패키지부터 그아래 패키지들까지 스캔을 시작한다
		//권장되는 방법은 basePackages를 사용하지 않고 @ComponentScan이 붙은 Config 파일을 프로젝트 최상단에 둔다.
		basePackages = "hello.core",
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
	

}
