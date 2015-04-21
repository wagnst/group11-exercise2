package de.wagnst.tpe.exercises.exercise2.test;

import de.wagnst.tpe.exercises.exercise2.master.Amount;
import de.wagnst.tpe.exercises.exercise2.master.Currencies;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAmount {

    @Test
    public void testCreation() {
        Amount a = new Amount(12.99, Currencies.CHF);
        Amount b = new Amount(-129999, Currencies.DOLLAR);

        Amount result1 = new Amount(12.99, Currencies.CHF);
        Amount result2 = new Amount(-129999, Currencies.DOLLAR);
        Amount result3 = new Amount(12.99, Currencies.DOLLAR);

        assertEquals(result1, a);
        assertEquals(result2, b);
        assertNotEquals(result3, a);
    }

    @Test
    public void testGetSign() {
        Amount a = new Amount(12.99, Currencies.CHF);
        Amount b = new Amount(-129999, Currencies.DOLLAR);
        Amount c = new Amount(0, Currencies.EURO);

        assertTrue(1 == a.getSign());
        assertTrue(-1 == b.getSign());
        assertTrue(1 == c.getSign());
    }

    @Test
    public void testGetCurrency() {
        Amount a = new Amount(123456, Currencies.EURO);
        Amount b = new Amount(-129999, Currencies.DOLLAR);

        assertEquals(Currencies.EURO, a.getCurrency());
        assertEquals(Currencies.DOLLAR, b.getCurrency());
    }

    @Test
    public void testAddSub() {
        Amount a = new Amount(10.00, Currencies.CHF);
        Amount b = new Amount(-500000, Currencies.DOLLAR);
        Amount c = new Amount(0, Currencies.EURO);
        Amount d = new Amount(100000, Currencies.EURO);

        Amount result1 = new Amount(20.00, Currencies.CHF);
        Amount result2 = new Amount(-500000, Currencies.DOLLAR);
        Amount result3 = new Amount(-37.31, Currencies.DOLLAR);

        /* add */
        assertEquals(result1, a.add(a));
        assertEquals(result2, b.add(c));
        assertEquals(result3, b.add(d));

        /* sub */
        assertEquals(a, result1.subtract(a));
        assertEquals(b, result2.subtract(c));
        assertEquals(b, result3.subtract(d));
    }

    @Test
    public void testToLong() {
        Amount a = new Amount(10.00, Currencies.CHF);
        Amount b = new Amount(-99.99, Currencies.DOLLAR);
        Amount c = new Amount(0.00, Currencies.EURO);

        assertTrue(100000 == a.toLong());
        assertTrue(999900 == b.toLong());
        assertTrue(0 == c.toLong());
    }

    @Test
    public void testToDouble() {
        Amount a = new Amount(100000, Currencies.EURO);

        assertTrue(12.99 == a.toDouble(129999));
        assertTrue(-3389.12 == a.toDouble(-33891212));
        assertTrue(0.0 == a.toDouble(0));
    }

    @Test
    public void testToMultiplyDoubleAndInt() {
        Amount a = new Amount(10.00, Currencies.EURO);
        Amount b = new Amount(-500000, Currencies.EURO);
        Amount c = new Amount(0, Currencies.EURO);

        Amount result1 = new Amount(20.00, Currencies.EURO);
        Amount result2 = new Amount(1500000, Currencies.EURO);
        Amount result3 = new Amount(0, Currencies.EURO);

        Amount result4 = new Amount(25.00, Currencies.EURO);
        Amount result5 = new Amount(1261500, Currencies.EURO);
        Amount result6 = new Amount(0.00, Currencies.EURO);

        /* mult(int) */
        assertEquals(result1, a.multiply(2));
        assertEquals(result2, b.multiply(-3));
        assertEquals(result3, c.multiply(15));
        assertEquals(result3, a.multiply(0));
        assertEquals(result3, c.multiply(0));

        /* mult(double) */
        assertEquals(result4, a.multiply(2.5));
        assertEquals(result5, b.multiply(-2.523));
        assertEquals(result6, c.multiply(4.5));
        assertEquals(result6, a.multiply(0.0));
        assertEquals(result6, c.multiply(0.0));
    }

    @Test
    public void testToPercentage() {
        Amount a = new Amount(10.00, Currencies.EURO);
        Amount b = new Amount(-500000, Currencies.EURO);
        Amount c = new Amount(0, Currencies.EURO);

        Amount result1 = new Amount(2.5, Currencies.EURO);
        Amount result2 = new Amount(-440000, Currencies.EURO);
        Amount result3 = new Amount(0, Currencies.EURO);

        assertEquals(result1, a.percentage(25));
        assertEquals(result2, b.percentage(88));
        assertEquals(result3, a.percentage(0));
        assertEquals(result2, result2.percentage(100));
        assertEquals(result3, c.percentage(100));

    }
}
