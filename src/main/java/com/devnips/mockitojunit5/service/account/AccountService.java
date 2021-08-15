package com.devnips.mockitojunit5.service.account;

import com.devnips.mockitojunit5.service.notification.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final NotificationService notificationService;

    public void updateBalance(String accountNumber, BigDecimal newBalance) {
        // some calculations
        notificationService.publish(new AccountUpdatedEvent(accountNumber, newBalance));
    }
}
