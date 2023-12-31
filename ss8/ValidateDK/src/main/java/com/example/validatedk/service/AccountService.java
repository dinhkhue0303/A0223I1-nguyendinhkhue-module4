package com.example.validatedk.service;

import com.example.validatedk.model.Account;
import com.example.validatedk.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService{
    @Autowired
    IAccountRepository iAccountRepository;
    @Override
    public void save(Account account) {
        iAccountRepository.save(account);
    }
}
