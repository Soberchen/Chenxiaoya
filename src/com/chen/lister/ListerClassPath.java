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
		// ��ÿͻ��˵ľ���·��
				HttpServletRequest request=(HttpServletRequest) arg.getServletRequest();
				String path = request.getContextPath();
				String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
			   //  �ѿͻ���·���洢��session���ö�����
				HttpSession session=request.getSession();
				if(session.getAttribute("basePath")==null){//��һ������session��û�д洢�ͻ��˾�����Ϣ
					session.setAttribute("basePath", basePath);
				}
	}

}
