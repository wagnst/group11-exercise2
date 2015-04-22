package de.wagnst.tpe.exercises.exercise2.test;

import de.wagnst.tpe.exercises.exercise2.master.Amount;
import de.wagnst.tpe.exercises.exercise2.master.Currencies;
import de.wagnst.tpe.exercises.exercise2.master.Currency;
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
        Amount d = new Amount(129999, Currencies.EURO);

        assertTrue(1000 == a.toLong());
        assertTrue(9999 == b.toLong());
        assertTrue(0 == c.toLong());
        assertTrue(1299 == d.toLong());
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

    @Test
    public void testEquals() {
        Amount a = new Amount(10.00, Currencies.EURO);
        Amount b = new Amount(10.00, Currencies.EURO);
        Amount c = new Amount(10.00, Currencies.YEN);

        assertTrue(a.equals(b));
        assertFalse(a.equals(c));
    }

    @Test
    public void testHashCode() {
        Amount a = new Amount(10.00, Currencies.EURO);
        Amount b = new Amount(10.00, Currencies.EURO);
        Amount c = new Amount(10.00, Currencies.YEN);

        assertTrue(a.hashCode() == b.hashCode());
        assertTrue(a.hashCode() != c.hashCode());

    }

    @Test
    public void testToString() {
        Amount a = new Amount(15.67945, Currencies.EURO);
        Amount b = new Amount(10.00, Currencies.DOLLAR);
        Amount c = new Amount(980239848, Currencies.YEN);
        Amount d = new Amount(-20.30, Currencies.RUBEL);

        assertEquals("15.67 €", a.toString());
        assertEquals("10.00 $", b.toString());
        assertEquals("98023 ¥", c.toString());
        assertEquals("-20.30 RUB", d.toString());
    }

    @Test
    public void testInvertAmount() {
        Amount a = new Amount(348.23, Currencies.DOLLAR);
        Amount b = new Amount(-20.30, Currencies.RUBEL);


        Amount result1 = new Amount(-348.23, Currencies.DOLLAR);
        Amount result2 = new Amount(20.30, Currencies.RUBEL);

        assertEquals(result1, a.invertAmount());
        assertEquals(result2, b.invertAmount());

    }

    @Test
    public void testConvertToCurrency() {

        final Currency DOLLAR = new Currency("Dollar", "$",
                10000, true);
        final Currency EURO = new Currency("Euro", "€",
                12690, true);
        final Currency YEN = new Currency("Yen", "¥", 91,
                false);
        final Currency RUBEL = new Currency("Rubel", "RUB",
                255, true);
        final Currency CHF = new Currency("Schweizer Franken", "CHF",
                10509, true);

        Amount a = new Amount(348.23, Currencies.DOLLAR);
        Amount b = new Amount(-20.30, Currencies.RUBEL);
        Amount c = new Amount(980239848, Currencies.YEN);
        Amount d = new Amount(-20.30, Currencies.EURO);
        Amount e = new Amount(4320.3023, Currencies.CHF);

        Amount result1 = new Amount(136560784, Currencies.RUBEL);
        Amount result2 = new Amount(-5176, Currencies.DOLLAR);
        Amount result3 = new Amount(7029300, Currencies.EURO);
        Amount result4 = new Amount(-28308461, Currencies.YEN);
        Amount result5 = new Amount(43203023, Currencies.CHF);

        assertEquals(result1, a.convertToCurrency(RUBEL));
        assertEquals(result2, b.convertToCurrency(DOLLAR));
        assertEquals(result3, c.convertToCurrency(EURO));
        assertEquals(result4, d.convertToCurrency(YEN));
        assertEquals(result5, e.convertToCurrency(CHF));



    }
}
