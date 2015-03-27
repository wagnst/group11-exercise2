package de.wagnst.tpe.exercises.exercise2.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import de.wagnst.tpe.exercises.exercise2.master.Currencies;

public class TestCurrency {

    /**
     * Testet ob Rückgabestring im korrekten Format ist
     */
    @Test
    public void TestToString() {

        assertEquals("Dollar [$] 1 $ = 1,0000 $", Currencies.DOLLAR.toString());
        assertEquals("Euro [€] 1 $ = 1,2690 €", Currencies.EURO.toString());
        assertEquals("Yen [¥] 1 $ = 0,0091 ¥", Currencies.YEN.toString());
        assertEquals("Rubel [RUB] 1 $ = 0,0255 RUB",
                Currencies.RUBEL.toString());
        assertEquals("Schweizer Franken [CHF] 1 $ = 1,0509 CHF",
                Currencies.CHF.toString());

    }
}
