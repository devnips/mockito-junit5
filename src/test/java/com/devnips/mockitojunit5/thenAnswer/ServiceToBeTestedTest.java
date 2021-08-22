package com.devnips.mockitojunit5.thenAnswer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ServiceToBeTestedTest {

    @Mock
    private ServiceToBeMocked serviceToBeMocked;

    @InjectMocks
    private ServiceToBeTested serviceToBeTested;

    @Test
    void test_callback() {
        Mockito.doAnswer(it -> {
            Callback callback = it.getArgument(0);
            callback.setValue("Mocked Value");
            return null;
        }).when(serviceToBeMocked).submitCallback(Mockito.any(Callback.class));

        String returnValue = serviceToBeTested.methodToBeTested();

        Assertions.assertEquals("Value Received after callback = Mocked Value", returnValue);
    }
}