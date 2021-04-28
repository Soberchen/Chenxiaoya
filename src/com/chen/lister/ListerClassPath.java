package com.chen.lister;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ListerClassPath implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent arg) {
		// 获得客户端的绝对路径
				HttpServletRequest request=(HttpServletRequest) arg.getServletRequest();
				String path = request.getContextPath();
				String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
			   //  把客户端路径存储到session内置对象中
				HttpSession session=request.getSession();
				if(session.getAttribute("basePath")==null){//第一次请求，session中没有存储客户端绝对信息
					session.setAttribute("basePath", basePath);
				}
	}

}
