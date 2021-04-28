package com.chen.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.entity.Book;
import com.chen.entity.Page;
import com.chen.services.BookService;
import com.chen.services.BookServiceImpl;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String bookname = request.getParameter("bookName");
		String bookpublish=request.getParameter("bookPublish");
		String currPageinfo = request.getParameter("currPageNo");
		int currPage = 1;
		if (currPageinfo != null && currPageinfo.length() != 0) {
			currPage = Integer.parseInt(currPageinfo);
		}

	
		String pageSizeInfo = request.getParameter("pageSize");
		int pageSize = 4;

		if (pageSizeInfo != null && pageSizeInfo.length() != 0) {
			pageSize = Integer.parseInt(pageSizeInfo);
		}
		Map<String , String>map=new HashMap<String, String>();
		map.put("bookname",bookname);
		map.put("bookpublish", bookpublish);
		request.setAttribute("map", map);
		// 2. 维护共享数据
		BookService bs=new BookServiceImpl();
		Page<Book> pager = bs.SelectBook(bookname,bookpublish,currPage, pageSize);
		request.setAttribute("pager", pager);
		// 3. 资源跳转
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
