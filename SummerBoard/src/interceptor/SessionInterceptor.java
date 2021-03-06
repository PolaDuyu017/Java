package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter{
	
	
	//컨트롤러 진입한 다음 실행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {}
	
	
	//컨트롤러 진입전에 실행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		Object userId = request.getSession().getAttribute("userId");
		
		if(request.getRequestURI().equals("/SummerBoard/login.do") || request.getRequestURI().equals("/SummerBoard/member/join.do")){
			if(userId!=null){
				response.sendRedirect(request.getContextPath()+"/board/list.do");
				return true;
			}else{
				return true;
			}
		}
		
		if(userId==null){
			response.sendRedirect(request.getContextPath()+"/login.do");
			return false;
		}else{
			return true;
		}
	}
}
