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
        Currency higherExchangeRate = new Currency("Test", "?!", 1200000, false);
        assertEquals("Test [?!] 1 $ = 120,0000 ?!",
                higherExchangeRate.toString());
    }

    @Test
    public void testEquals() {
        assertTrue(Currencies.DOLLAR.equals(Currencies.DOLLAR));
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
        assertEquals(78802, Currencies.DOLLAR.convert(100000, Currencies.EURO),
                0001);
        assertEquals(10989011,
                Currencies.DOLLAR.convert(100000, Currencies.YEN), 0001);
        assertEquals(3921569,
                Currencies.DOLLAR.convert(100000, Currencies.RUBEL), 0001);
        assertEquals(95157, Currencies.DOLLAR.convert(100000, Currencies.CHF),
                0001);
        // Euro
        assertEquals(100000, Currencies.EURO.convert(100000, Currencies.EURO));
        assertEquals(100000, Currencies.EURO.convert(78802, Currencies.DOLLAR),
                0001);
        assertEquals(13945055, Currencies.EURO.convert(100000, Currencies.YEN),
                0001);
        assertEquals(4976471,
                Currencies.EURO.convert(100000, Currencies.RUBEL), 0001);
        assertEquals(120754, Currencies.EURO.convert(100000, Currencies.CHF),
                0001);
        // Yen
        assertEquals(100000, Currencies.YEN.convert(100000, Currencies.YEN));
        assertEquals(100000,
                Currencies.YEN.convert(10989011, Currencies.DOLLAR), 0001);
        assertEquals(100000, Currencies.YEN.convert(13945055, Currencies.EURO),
                0001);
        assertEquals(35686, Currencies.YEN.convert(100000, Currencies.RUBEL),
                0001);
        assertEquals(866, Currencies.YEN.convert(100000, Currencies.CHF), 0001);
        // Rubel
        assertEquals(100000, Currencies.RUBEL.convert(100000, Currencies.RUBEL));
        assertEquals(100000,
                Currencies.RUBEL.convert(3921569, Currencies.DOLLAR), 0001);
        assertEquals(100000,
                Currencies.RUBEL.convert(4976471, Currencies.EURO), 0001);
        assertEquals(100000, Currencies.RUBEL.convert(35686, Currencies.YEN),
                0001);
        assertEquals(2426, Currencies.RUBEL.convert(100000, Currencies.CHF),
                0001);
        // Schweizer Franken
        assertEquals(100000, Currencies.CHF.convert(100000, Currencies.CHF));
        assertEquals(100000, Currencies.CHF.convert(95157, Currencies.DOLLAR),
                0001);
        assertEquals(100000, Currencies.CHF.convert(120754, Currencies.EURO),
                0001);
        assertEquals(11548351, Currencies.CHF.convert(100000, Currencies.YEN),
                0001);
        assertEquals(4121176, Currencies.CHF.convert(100000, Currencies.RUBEL),
                0001);
    }
}
