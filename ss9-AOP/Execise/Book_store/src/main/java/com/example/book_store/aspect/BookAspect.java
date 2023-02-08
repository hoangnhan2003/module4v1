package com.example.book_store.aspect;

import com.example.book_store.model.History;
import com.example.book_store.service.IHistoryService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
public class BookAspect {
    @Autowired
    private IHistoryService historyService;
    @After("execution(* com.example.book_store.controller.StoreBookController.*(..))")
    public void logAfterMethod(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        String time  = LocalDateTime.now().toString();
        historyService.save(new History(time,name));
    }
}
