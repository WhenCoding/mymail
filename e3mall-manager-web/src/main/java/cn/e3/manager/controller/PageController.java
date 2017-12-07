package cn.e3.manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	/**
	 * 后台页面跳转
	 * 
	 */
	@RequestMapping("{page}")
	public String showPage(@PathVariable("page") String page){
		return page;
	}
	
}
