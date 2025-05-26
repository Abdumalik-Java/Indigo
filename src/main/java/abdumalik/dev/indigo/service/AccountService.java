package abdumalik.dev.indigo.service;

import abdumalik.dev.indigo.dto.AccountDto;
import abdumalik.dev.indigo.model.Account;
import abdumalik.dev.indigo.model.Result;
import abdumalik.dev.indigo.repository.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountService {

    @Autowired
    AccountRepo repo;

    public List<Account> getAllAccounts() {
        return repo.findAll();
    }

    public Account getAccountById(UUID id) {
        return repo.findById(id).get();
    }

    public Result create(AccountDto dto) {
        boolean b = repo.existsByEmailOrPhoneNumber(dto.getEmail(), dto.getPhoneNumber());
        if (b) {
            return new Result("Account with this email or phone number is already exist", false);
        }
        Account account = new Account();
        account.setPhoneNumber(dto.getPhoneNumber());
        account.setEmail(dto.getEmail());
        account.setPassword(dto.getPassword());
        account.setRole(dto.getRole());
        repo.save(account);
        return new Result("Account created successfully", true);
    }

    public Result update(UUID id, AccountDto dto) {
        Optional<Account> byId = repo.findById(id);
        if (byId.isPresent()) {
            Account account = byId.get();
            account.setPhoneNumber(dto.getPhoneNumber());
            account.setEmail(dto.getEmail());
            account.setPassword(dto.getPassword());
            account.setRole(dto.getRole());
            repo.save(account);
            return new Result("Account updated successfully", true);
        }
        return new Result("Account not found", false);
    }

    public Result delete(UUID id) {
        Optional<Account> byId = repo.findById(id);
        if (byId.isPresent()) {
            repo.delete(byId.get());
            return new Result("Account deleted successfully", true);
        }
        return new Result("Account not found", false);
    }

}