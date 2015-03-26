package de.wagnst.tpe.exercises.exercise2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.wagnst.tpe.exercises.exercise2.master.Currency;

public class TestCurrency {

    @Test
    public void TestToString() {

        Currency currency = new Currency("Rubel", "RUB", 255);
        assertEquals("Rubel [RUB] 1 $ = 0,0255 RUB", currency.toString());
    }
}
