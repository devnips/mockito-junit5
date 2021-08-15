package com.devnips.mockitojunit5.service.account;

import com.devnips.mockitojunit5.service.notification.NotificationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Captor
    private ArgumentCaptor<AccountUpdatedEvent> accountUpdatedEventCaptor;

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private AccountService accountService;

    @Test
    void verify_update_event() {
        final String accountNumber = "636636636";
        final BigDecimal newBalance = BigDecimal.valueOf(1000000L);

        accountService.updateBalance(accountNumber, newBalance);

        Mockito.verify(notificationService).publish(accountUpdatedEventCaptor.capture());

        AccountUpdatedEvent accountUpdatedEvent = accountUpdatedEventCaptor.getValue();
        Assertions.assertEquals(accountNumber, accountUpdatedEvent.getAccountNumber());
        Assertions.assertEquals(newBalance, accountUpdatedEvent.getBalance());
    }

}