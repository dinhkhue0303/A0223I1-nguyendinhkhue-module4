package com.example.image.aop;

import com.example.image.model.Comment;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Aspect
@Component
public class Logger {
    @AfterThrowing("execution(* com.example.image.controller.CommentController.create(..))")
    public void badWordException(JoinPoint joinPoint){
        System.out.println("---------------------------------------------------------------");
        Object[] args = joinPoint.getArgs();
        Comment comment = (Comment) args[0];
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("information : \nAuthor : " + comment.getAuthor() + ", Feedback : " + comment.getFeedBack()
        + ", Time : " + localDateTime);
        System.out.println("---------------------------------------------------------------");
    }
}
