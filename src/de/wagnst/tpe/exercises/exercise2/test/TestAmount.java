package de.wagnst.tpe.exercises.exercise2.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import de.wagnst.tpe.exercises.exercise2.master.*;

public class TestAmount {

    @Test
    public void testCreationWithLong() {
        Amount amount1 = new Amount(-100000, Currencies.EURO);
        Amount amount2 = new Amount(100, Currencies.EURO);

        assertEquals(1000, amount1.toLong());
        assertEquals(1, amount2.toLong());

    }

    @Test
    public void testCreationWithDouble() {
        Amount amount1 = new Amount(-10.00, Currencies.EURO);
        Amount amount2 = new Amount(0.01, Currencies.EURO);
        Amount amount3 = new Amount(12.993, Currencies.EURO);

        assertEquals(1000, amount1.toLong());
        assertEquals(1, amount2.toLong());
        assertEquals(1299, amount3.toLong());
    }

    @Test
    public void testGetSign() {
        Amount amount1 = new Amount(-10000, Currencies.EURO);
        Amount amount2 = new Amount(10000, Currencies.EURO);
        Amount amount3 = new Amount(-10.000, Currencies.EURO);
        Amount amount4 = new Amount(10.000, Currencies.EURO);
        
        assertEquals(-1, amount1.getSign());
        assertEquals(1,amount2.getSign());
        assertEquals(-1,amount3.getSign());
        assertEquals(1,amount4.getSign());
    }
}
