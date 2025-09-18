package net.java.banking.service.impl;

import net.java.banking.dto.AccountDto;
import net.java.banking.entity.Account;
import net.java.banking.mapper.AccountMapper;
import net.java.banking.repository.AccountRepository;
import net.java.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account accountSaved=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(accountSaved);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account= accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("account not found"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(Long id ,Double amount){
        Account account=accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("account not found"));

        double total=account.getBalance()+amount;
        account.setBalance(total);
        Account saveAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public AccountDto withdraw(Long id ,Double amount){
        Account account=accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("account not found"));
        if (account.getBalance()<amount){
            throw new RuntimeException("Insufficient balance");
        }
        double total= account.getBalance()-amount;
        account.setBalance(total);
        Account saveAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);

    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts= accountRepository.findAll();
        return accounts.stream().map((account)->AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());

    }

    @Override
    public void deleteAccount(Long id) {
        Account account=accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException("account not found"));
        accountRepository.delete(account);

    }


}
