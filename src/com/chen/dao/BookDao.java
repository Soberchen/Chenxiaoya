package com.chen.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chen.entity.Book;

public interface BookDao {
	List<Book>SelectBook(@Param("bookname")String bookname,@Param("bookpublish")String bookpublish,@Param("startIndex")int startIndex,@Param("maxlength")int maxlength);
	int InsertBook(Book book);
	int SelecCount(@Param("bookname")String bookname,@Param("bookpublish")String bookpublish);

}
