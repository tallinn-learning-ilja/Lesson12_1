package org.myexample.service;

import org.myexample.entity.BankAccount;
import org.myexample.entity.Customer;
import org.myexample.exceptions.CustomerNotFoundException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CustomerService {

    private final BankAccountService bankAccountService;

    private final Map<Integer, Customer> customers = Map.of(1, new Customer(),
            2, new Customer());

    public CustomerService(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    public Optional<Customer> getById(int customerId) {
        return Optional.ofNullable(customers.getOrDefault(customerId, null));
    }

    public List<BankAccount> getCustomerBankAccounts(int customerId) {
        if (customers.containsKey(customerId)) {
            return bankAccountService.getCustomerBankAccounts(customerId);
        }
        throw new CustomerNotFoundException(String.format("Customer with id %s not found", customerId));

    }
}
