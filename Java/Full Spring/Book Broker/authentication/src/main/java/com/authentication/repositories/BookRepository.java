package com.authentication.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.authentication.models.Book;
import com.authentication.models.User;
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
	
	List<Book> findByBorrow(User borrow);
	List<Book> findByBorrowNull();
}
