package org.myexample.service;

import org.myexample.entity.BankAccount;

import java.util.List;
import java.util.Map;

public class BankAccountService {
    private final Map<Integer, List<BankAccount>> customerBankAccount = Map.of(1, List.of(new BankAccount(), new BankAccount()),
            3, List.of(new BankAccount(), new BankAccount(), new BankAccount()));

    public List<BankAccount> getCustomerBankAccounts(int customerId) {
        return customerBankAccount.getOrDefault(customerId, List.of());
    }
}
