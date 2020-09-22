package org.example;

import org.example.impl.CustomerIdGeneratorImpl;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerIdGeneratorImplUnitTest {

    @Test
    public void givenIdGeneratedPreviously_whenGenerated_thenIdIsIncremented(){
        CustomerIdGenerator customerIdGenerator = new CustomerIdGeneratorImpl();
        int firstId = customerIdGenerator.generateNextId();
        assertThat(customerIdGenerator.generateNextId()).isEqualTo(++firstId);
    }
}
