package hello.core.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

	private final LogDemoService logDemoService;
	//private final ObjectProvider<MyLogger> myLoggerProvider;
	
	//MyLogger에 @Scope 옵션으로 proxyMode = ScopedProxyMode.TARGET_CLASS을 추가
	// 일단 가짜 MyLogger 프록시 객체를 생성하고 실제 요청이 왔을때 진짜 빈을 요청한다. (객체를 진짜로 필요로할때 처리하는 지연처리) 
	private final MyLogger myLogger;
	
	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) {
		
		//MyLogger myLogger = myLoggerProvider.getObject();
		String requestURL = request.getRequestURL().toString();
	
		myLogger.setRequestURL(requestURL);
		
		myLogger.log("controller test");
		logDemoService.logic("test id");
		
		return "OK";
	}
}
