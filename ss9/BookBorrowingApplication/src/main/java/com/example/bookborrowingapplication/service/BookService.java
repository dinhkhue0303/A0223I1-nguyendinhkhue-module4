package com.example.bookborrowingapplication.service;

import com.example.bookborrowingapplication.exception.DuplicateNotExistCodeBookException;
import com.example.bookborrowingapplication.exception.DuplicateNumberEqualZeroException;
import com.example.bookborrowingapplication.model.Book;
import com.example.bookborrowingapplication.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class BookService implements IBookService{
    @Autowired
    IBookRepository iBookRepository;
    public static String strnumber;


    @Override
    public List<Book> findAll() {
        return iBookRepository.findAll();
    }

    @Override
    public Page<Book> findAll(Pageable pageable, String searchName) {
        return iBookRepository.findBookByNameContaining(pageable,searchName);
    }

    @Override
    public void save(Book book) {
        iBookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        return iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void borrowBook(Book book) throws DuplicateNumberEqualZeroException{
        if(book.getAmount() - 1 == -1){
            throw new DuplicateNumberEqualZeroException("số lượng bằng 0");
        }
        book.setAmount(book.getAmount() - 1);
        Random random = new Random();
        int number = random.nextInt(90000) + 10000;
        strnumber = String.valueOf(number);
        String[] nString;
        if(book.getCodeBook() == null){
            nString = new String[]{};
        }else{
            nString = book.getCodeBook();
        }
        String[] newString = new String[nString.length + 1];
        System.arraycopy(nString, 0, newString, 0, nString.length);
        newString[newString.length - 1] = strnumber;
        book.setCodeBook(newString);
        iBookRepository.save(book);
    }
    @Override
    public void returnBook(String codeBook) throws DuplicateNotExistCodeBookException {
        int ktr = 0;
        for (Book book:iBookRepository.findAll()) {
            for (String s:book.getCodeBook()) {
                if (s.equals(codeBook)){
                    book.setAmount(book.getAmount() + 1);
//                    xoaPhanTuCodeBook(book.getCodeBook(),codeBook);
                    ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(book.getCodeBook()));
                    arrayList.removeIf(element -> element.equals(codeBook));
                    book.setCodeBook(arrayList.toArray(new String[0]));
                    iBookRepository.save(book);
                    ktr++;
                    return;
                }
            }
        }
        if(ktr == 0){
            throw new DuplicateNotExistCodeBookException("không tồn tại mã này");
        }
    }
    public void xoaPhanTuCodeBook(String[] array,String target){

    }
}
