package ru.practice.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TipsCalculationTest {
    private TipsCalculator tipsCalculator;

    @BeforeEach
    void setUp(){
        tipsCalculator = new TipsCalculator();
    }

    @Test
    void testNormalService10Percent() {
        Bill bill = new Bill(3, BigDecimal.valueOf(1000.0), 2, ServiceQuality.NORMAL);
        TipResult result = tipsCalculator.calculateTips(bill);

        assertEquals(BigDecimal.valueOf(100).setScale(2), result.getTipsAmount());
        assertEquals(BigDecimal.valueOf(1100).setScale(2), result.getTotal());
    }

    @Test
    void testExcellentService15Percent() {
        Bill bill = new Bill(12, BigDecimal.valueOf(1000.0), 2, ServiceQuality.EXCELLENT);
        TipResult result = tipsCalculator.calculateTips(bill);

        assertEquals(BigDecimal.valueOf(150).setScale(2), result.getTipsAmount());
        assertEquals(BigDecimal.valueOf(1150).setScale(2), result.getTotal());
    }

    @Test
    void testLargeGroupExtraPercent() {
        Bill bill = new Bill(3, BigDecimal.valueOf(1000.0), 11, ServiceQuality.NORMAL);
        TipResult result = tipsCalculator.calculateTips(bill);

        assertEquals(BigDecimal.valueOf(150).setScale(2), result.getTipsAmount());
    }

    @Test
    void testLargeGroupAndExcellentService20Percent() {
        Bill bill = new Bill(7, BigDecimal.valueOf(1000.0), 11, ServiceQuality.EXCELLENT);
        TipResult result = tipsCalculator.calculateTips(bill);

        assertEquals(BigDecimal.valueOf(200).setScale(2), result.getTipsAmount());
    }


    @Test
    void testZeroBill() {
        Bill bill = new Bill(1, BigDecimal.valueOf(0.0), 2, ServiceQuality.NORMAL);
        TipResult result = tipsCalculator.calculateTips(bill);

        assertEquals(BigDecimal.ZERO, result.getTipsAmount());
        assertEquals(BigDecimal.ZERO, result.getTotal());
    }

    @Test
    void testNegativeBill() {
        Bill bill = new Bill(4,BigDecimal.valueOf(-500.0), 2, ServiceQuality.NORMAL);
        TipResult result = tipsCalculator.calculateTips(bill);

        assertEquals(BigDecimal.ZERO, result.getTipsAmount());
    }

    @Test
    void testNullBill() {
        TipResult result = tipsCalculator.calculateTips(null);

        assertEquals(BigDecimal.ZERO, result.getTipsAmount());
        assertEquals(BigDecimal.ZERO, result.getTotal());
    }
}
