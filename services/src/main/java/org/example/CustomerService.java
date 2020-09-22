package org.example;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer createCustomer(Customer customer);

    Optional<Customer> findCustomer(String id);

    List<Customer> getCustomers();

    void updateCustomer(Customer customer);
}
