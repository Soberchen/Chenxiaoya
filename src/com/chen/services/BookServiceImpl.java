package com.chen.services;

import java.util.List;

import com.chen.dao.BookDao;
import com.chen.dao.util.MapperUtil;
import com.chen.entity.Book;
import com.chen.entity.Page;

public class BookServiceImpl implements BookService{
private BookDao  bd=MapperUtil.createsSqlSession().getMapper(BookDao.class);
	@Override
	public Page<Book> SelectBook(String bookname,String bookpublish, int currPageNo, int pageSize) {
		// TODO Auto-generated method stub
		int startIndex=(currPageNo-1)*pageSize;
		int maxlength=pageSize;
		int count=bd.SelecCount(bookname,bookpublish);
		List<Book> list=bd.SelectBook(bookname,bookpublish,startIndex, maxlength);
		
		
		
		Page<Book> page=new Page<Book>();
		page.setCurrPageNo(currPageNo);
		page.setPageSize(pageSize);
		page.setTotalCount(count);
		page.setNewlist(list);
		return page;
	}
	@Override
	public int InsertBook(Book book) {
		
		return bd.InsertBook(book);
	}

}
