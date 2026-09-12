package ru.practice.app;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bill {
    private Integer tableNumber;
    private BigDecimal amount;
    private Integer guestsCount;
    private ServiceQuality serviceQuality;
}
