package service;

import domain.Account;

import java.util.List;

public interface ServiceAccountInterface {
    void addAccount(Account account);

    void deleteAccount(Integer id);

    void updateAccount(Account account);

    List<Account> getAllAccounts();
}
