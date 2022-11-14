package com.authentication.services;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.authentication.models.Book;
import com.authentication.models.LoginUser;
import com.authentication.models.User;
import com.authentication.repositories.BookRepository;
import com.authentication.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    private BookRepository bookRepository;
    
    
    
    public UserService(UserRepository userRepo, BookRepository bookRepository) {
		this.userRepo = userRepo;
		this.bookRepository = bookRepository;
	}

	public User register(User newUser, BindingResult result) {
        if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
            result.rejectValue("email", "Unique", "This email is already in use!");
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
            newUser.setPassword(hashed);
            return userRepo.save(newUser);
        }
    }
    
    public User login(LoginUser newLogin, BindingResult result) {
        if(result.hasErrors()) {
            return null;
        }
        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
            result.rejectValue("email", "Unique", "Unknown email!");
            return null;
        }
        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
            result.rejectValue("password", "Matches", "Invalid Password!");
        }
        if(result.hasErrors()) {
            return null;
        } else {
            return user;
        }
    }
    
    public User findUserById(Long id) {
        Optional<User> u = userRepo.findById(id);

        if(u.isPresent()) {
            return u.get();
            } else {
            return null;
        }
    }
    
    public User updateUser(User user1) {
    	return userRepo.save(user1);
    }
    
    public List<Book> allBooks(){
		return bookRepository.findAll();
	}
    
    
    
    public List<Book> AllBorrower(User borrow){
    	return bookRepository.findByBorrow(borrow);
    }
    
    public List<Book> notBorrowed(){
    	return bookRepository.findByBorrowNull();
    }
    
    
	
	public Book findBook(Long id) {
		return bookRepository.findById(id).orElse(null);
	}
    
	public Book creatBook(Book book1) {
		return bookRepository.save(book1);
	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if(optionalBook.isPresent()) {
			bookRepository.deleteById(id);
		}
	}
} 
