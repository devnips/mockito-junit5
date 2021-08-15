package com.devnips.mockitojunit5.service.account;

import com.devnips.mockitojunit5.service.notification.Event;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class AccountUpdatedEvent implements Event {

    String accountNumber;
    BigDecimal balance;
}
