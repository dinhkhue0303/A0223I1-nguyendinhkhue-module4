package com.example.bookborrowingapplication.aop;

import com.example.bookborrowingapplication.model.Book;
import com.example.bookborrowingapplication.service.IBookService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.example.bookborrowingapplication.service.BookService.strnumber;

@Aspect
@Component
public class Logger {
    @Autowired
    IBookService iBookService;
    static int count = 0;
    @AfterReturning("execution(* com.example.bookborrowingapplication.controller.BookController.Borrow(..))")
    public void BorrowAction(JoinPoint joinPoint){
        System.out.println("----------------------------------------------------------------------");
        Object[] args = joinPoint.getArgs();
        int id = (Integer) args[0];
        Book book = iBookService.findById(id);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("ingormation :\n Id : "+book.getId() + ", Name book : " + book.getName() + ", Amount : "
        + book.getAmount() + ", Code book : " + strnumber + ", Time : " + localDateTime + "\nBorrow Book");
        System.out.println("----------------------------------------------------------------------");
    }
    @Around("execution(* com.example.bookborrowingapplication.controller.BookController.ReturnBook(..))")
    public Object ReturnBookAction(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("----------------------------------------------------------------------");
        Object[] args = proceedingJoinPoint.getArgs();
        String codeBook = (String) args[0];
        Book infBook = new Book();
        outerLoop:
        for (Book book:iBookService.findAll()) {
            for(String s:book.getCodeBook()){
                if(s.equals(codeBook)){
                    BeanUtils.copyProperties(book,infBook);
                    break outerLoop;
                }
            }
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        // main
        Object object = proceedingJoinPoint.proceed();
        //
        System.out.println("ingormation :\n Id : "+infBook.getId() + ", Name book : " + infBook.getName() + ", Amount : "
                + (infBook.getAmount() + 1) + ", Code book : " + codeBook + ", Time : " + localDateTime + "\nReturn Book");
        System.out.println("----------------------------------------------------------------------");
        return object;
    }
    @AfterReturning("execution(* com.example.bookborrowingapplication.controller.BookController.*(..))")
    public void Action(){
        count++;
        System.out.println("----------------------------------------------------");
        System.out.println("the number of Action: " + count);
        System.out.println("----------------------------------------------------");
    }
}
