package com.chen.services;

import com.chen.entity.Book;
import com.chen.entity.Page;

public interface BookService {
	Page<Book>SelectBook(String bookname,String bookpublish,int currPageNo,int pageSize);
	int InsertBook(Book book);
}
