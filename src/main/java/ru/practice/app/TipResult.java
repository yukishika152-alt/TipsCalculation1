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
public class TipResult {
    private BigDecimal billAmount;
    private BigDecimal tipsAmount;
    private BigDecimal total;
}
