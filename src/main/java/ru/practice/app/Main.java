package ru.practice.app;

import java.math.BigDecimal;

/*
    Данная программа рассчитывает итоговый счет для посетителей с учетом чаевых
    Их сумма зависит от количества гостей за столом и от качества обслуживания
    При отличном обслуживании чаевые составляют 15%
    При плохом 5%
    Базовое значение - 10%
    Также если за столиком находится компания более 10 человек, то официанту добавляется прибавка в 5%
*/
public class Main {
    public static void main(String[] args) {
        Bill bill = new Bill(17, BigDecimal.valueOf(3500.00), 12, ServiceQuality.EXCELLENT);
        TipResult result = TipsCalculator.calculateTips(bill);

        System.out.println("Счет: " + result.getBillAmount());
        System.out.println("Чаевые: " + result.getTipsAmount());
        System.out.println("Итого: " + result.getTotal());
    }
}
