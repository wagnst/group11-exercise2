package de.wagnst.tpe.exercises.exercise2.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import de.wagnst.tpe.exercises.exercise2.master.Currencies;

public class TestCurrencies {

    /**
     * Testet die drei unveränderlichen Attribute "name,code,exchangeRate" der
     * Währung
     */
    @Test
    public void TestCreation() {

        assertEquals("Dollar", Currencies.DOLLAR.getName());
        assertEquals("$", Currencies.DOLLAR.getCode());
        assertEquals(10000, Currencies.DOLLAR.getExchangeRate());
        assertEquals(true, Currencies.DOLLAR.hasSubunit());

        assertEquals("Euro", Currencies.EURO.getName());
        assertEquals("€", Currencies.EURO.getCode());
        assertEquals(12690, Currencies.EURO.getExchangeRate());
        assertEquals(true, Currencies.DOLLAR.hasSubunit());

        assertEquals("Yen", Currencies.YEN.getName());
        assertEquals("¥", Currencies.YEN.getCode());
        assertEquals(91, Currencies.YEN.getExchangeRate());
        assertEquals(false, Currencies.YEN.hasSubunit());

        assertEquals("Rubel", Currencies.RUBEL.getName());
        assertEquals("RUB", Currencies.RUBEL.getCode());
        assertEquals(255, Currencies.RUBEL.getExchangeRate());
        assertEquals(false, Currencies.RUBEL.hasSubunit());

        assertEquals("Schweizer Franken", Currencies.CHF.getName());
        assertEquals("CHF", Currencies.CHF.getCode());
        assertEquals(10509, Currencies.CHF.getExchangeRate());
        assertEquals(true, Currencies.CHF.hasSubunit());


    }

}
