package com.chen.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.chen.entity.Book;
import com.chen.services.BookService;
import com.chen.services.BookServiceImpl;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//获取jsp的中的值
		String bookName=request.getParameter("bookName");
		String bookAuthor=request.getParameter("bookAuthor");
		String bookPublish=request.getParameter("bookPublish");
		int bookPage=Integer.parseInt(request.getParameter("bookPage"));
		double bookPrice=Integer.parseInt(request.getParameter("bookPrice"));
		String createDate=request.getParameter("createDate");
		Date create=Date.valueOf(createDate);
		//赋值
		Book bk=new Book();
		bk.setBookName(bookName);
		bk.setBookAuthor(bookAuthor);
		bk.setBookPage(bookPage);
		bk.setBookPublish(bookPublish);
		bk.setBookPrice(bookPrice);
		bk.setCreateDate(create);
		
		BookService bs=new BookServiceImpl();
		int num=bs.InsertBook(bk);
		HttpSession session=request.getSession();
		if (num>0) {
			session.setAttribute("mess", "保存成功！");
		}else {
			session.setAttribute("mess", "保存失败！");
		}
		response.sendRedirect("SelectServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
