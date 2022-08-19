package com.isu.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class SayHelloController {
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "hello! what are you learning today?";
	}
//------------------------	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb= new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My first HTML-changed</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("My first HTML page with body");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();
	}
//--------------------------
	@RequestMapping("say-hello-jsp")
	
	public String sayHellolJsp() {
		return "sayHello";//mapping it to the view file
	}
}
