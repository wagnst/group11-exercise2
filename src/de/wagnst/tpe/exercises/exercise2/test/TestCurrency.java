package de.wagnst.tpe.exercises.exercise2.test;

import de.wagnst.tpe.exercises.exercise2.master.Currencies;
import de.wagnst.tpe.exercises.exercise2.master.Currency;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCurrency {

    @Test
    public void testToString() {
        // regular ExchangeRates
        assertEquals("Dollar [$] 1 $ = 1,0000 $", Currencies.DOLLAR.toString());
        assertEquals("Euro [€] 1 $ = 1,2690 €", Currencies.EURO.toString());
        assertEquals("Yen [¥] 1 $ = 0,0091 ¥", Currencies.YEN.toString());
        assertEquals("Rubel [RUB] 1 $ = 0,0255 RUB",
                Currencies.RUBEL.toString());
        assertEquals("Schweizer Franken [CHF] 1 $ = 1,0509 CHF",
                Currencies.CHF.toString());

        // rate with more than one digit in front of the decimal point
        Currency higherExchangeRate = new Currency("Test", "?!", 111111, false);
        assertEquals("Test [?!] 1 $ = 11,1111 ?!",
                higherExchangeRate.toString());
    }

    @Test
    public void testEquals() {
        assertTrue(Currencies.DOLLAR.equals(Currencies.DOLLAR));
        assertTrue(Currencies.CHF.equals(Currencies.CHF));
        assertFalse(Currencies.DOLLAR.equals(Currencies.EURO));
    }

    @Test
    public void testHashCode() {
        assertEquals(Currencies.DOLLAR.hashCode(), Currencies.DOLLAR.hashCode());
        assertEquals(Currencies.EURO.hashCode(), Currencies.EURO.hashCode());
        assertFalse(Currencies.YEN.hashCode() == Currencies.EURO.hashCode());
    }

    @Test
    public void testConvert() {
        // Dollar

        assertEquals(100000,
                Currencies.DOLLAR.convert(100000, Currencies.DOLLAR));
        assertEquals(78802, Currencies.DOLLAR.convert(100000, Currencies.EURO));
        assertEquals(10989010,
                Currencies.DOLLAR.convert(100000, Currencies.YEN));
        assertEquals(3921568,
                Currencies.DOLLAR.convert(100000, Currencies.RUBEL));
        assertEquals(95156, Currencies.DOLLAR.convert(100000, Currencies.CHF));
        // Euro

        assertEquals(100000, Currencies.EURO.convert(100000, Currencies.EURO));
        assertEquals(126900, Currencies.EURO.convert(100000, Currencies.DOLLAR));
        assertEquals(13945054, Currencies.EURO.convert(100000, Currencies.YEN));
        assertEquals(4976470, Currencies.EURO.convert(100000, Currencies.RUBEL));
        assertEquals(120753, Currencies.EURO.convert(100000, Currencies.CHF));

        // Yen
        assertEquals(100000, Currencies.YEN.convert(100000, Currencies.YEN));
        assertEquals(910, Currencies.YEN.convert(100000, Currencies.DOLLAR));
        assertEquals(717, Currencies.YEN.convert(100000, Currencies.EURO));
        assertEquals(35686, Currencies.YEN.convert(100000, Currencies.RUBEL));
        assertEquals(865, Currencies.YEN.convert(100000, Currencies.CHF));

        // Rubel
        assertEquals(100000, Currencies.RUBEL.convert(100000, Currencies.RUBEL));
        assertEquals(2550, Currencies.RUBEL.convert(100000, Currencies.DOLLAR));
        assertEquals(2009, Currencies.RUBEL.convert(100000, Currencies.EURO));
        assertEquals(280219, Currencies.RUBEL.convert(100000, Currencies.YEN));
        assertEquals(2426, Currencies.RUBEL.convert(100000, Currencies.CHF));

        // Schweizer Franken
        assertEquals(100000, Currencies.CHF.convert(100000, Currencies.CHF));
        assertEquals(105090, Currencies.CHF.convert(100000, Currencies.DOLLAR));
        assertEquals(82813, Currencies.CHF.convert(100000, Currencies.EURO));
        assertEquals(11548351, Currencies.CHF.convert(100000, Currencies.YEN));
        assertEquals(4121176, Currencies.CHF.convert(100000, Currencies.RUBEL));

    }
}
