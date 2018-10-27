package me.baoning.tourist.controller;

import me.baoning.tourist.model.Operator;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author qyn
 *
 */

//后台页面拦截器，拦截未登录直接能访问
public class AccessIntercept extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
		Operator operator=(Operator)request.getSession().getAttribute("operator");
		if(operator==null){
			//重定向
			String path=request.getSession().getServletContext().getContextPath();
			String login=path+"/hlogin/hlogin.do";
			response.sendRedirect(login);
			return false;
		}
		return true;
	}
}