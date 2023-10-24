package org.myexample.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.myexample.entity.BankAccount;
import org.myexample.entity.Customer;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private BankAccountService bankAccountService;

    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerService(bankAccountService);
    }

    @Test
    void testGetCustomerById() {
        Optional<Customer> maybeCustomer = customerService.getById(1);
        Optional<Customer> maybeCustomer2 = customerService.getById(10);

        if (maybeCustomer.isPresent()) {
            Customer customer = maybeCustomer.get();
            customer.getName();
        }
    }

    @Test
    void testSuccess() {
        // given
        int customerId = 2;
        List<BankAccount> expectedResult = List.of(new BankAccount());

        // when
        when(bankAccountService.getCustomerBankAccounts(customerId)).thenReturn(expectedResult);

        // then
        List<BankAccount> actualResult = customerService.getCustomerBankAccounts(customerId);

        assertEquals(expectedResult.size(), actualResult.size());

    }
}
