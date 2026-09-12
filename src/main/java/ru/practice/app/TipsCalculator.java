package ru.practice.app;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TipsCalculator {
    public static TipResult calculateTips(Bill bill) {
        if (bill == null || bill.getAmount().compareTo(BigDecimal.ZERO) < 1) {
            return new TipResult(BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO);
        }
        BigDecimal tipRate;
        switch (bill.getServiceQuality()){
            case ServiceQuality.EXCELLENT -> tipRate = BigDecimal.valueOf(0.15);
            case ServiceQuality.BAD -> tipRate = BigDecimal.valueOf(0.05);
            default -> tipRate = BigDecimal.valueOf(0.10);
        }

        if(bill.getGuestsCount() >= 10) {
            tipRate = tipRate.add(BigDecimal.valueOf(0.05));
        }

        BigDecimal tipsAmount = bill.getAmount().multiply(tipRate).setScale(2, RoundingMode.HALF_UP);

        return new TipResult(bill.getAmount(), tipsAmount, bill.getAmount().add(tipsAmount));
    }
}
