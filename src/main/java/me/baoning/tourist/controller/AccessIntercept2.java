package me.baoning.tourist.controller;

import me.baoning.tourist.model.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author qyn
 *
 */

//前台页面拦截器
public class AccessIntercept2 extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
		User user=(User)request.getSession().getAttribute("nowuser");
		if(user==null){
			//重定向
			String path=request.getSession().getServletContext().getContextPath();
			String login=path+"/index/login.do";
			response.sendRedirect(login);
			return false;
		}
		return true;
	}
}
