package de.wagnst.tpe.exercises.exercise2.test;

import de.wagnst.tpe.exercises.exercise2.master.Amount;
import de.wagnst.tpe.exercises.exercise2.master.Currencies;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
        Amount amount3 = new Amount(12.99, Currencies.EURO);
        Amount amount4 = new Amount(-100000, Currencies.EURO);
        Amount amount5 = new Amount(100, Currencies.EURO);
        Amount amount6 = new Amount(129900, Currencies.EURO);

        assertEquals(amount4, amount1);
        assertEquals(amount5, amount2);
        assertEquals(amount6, amount3);
    }

    @Test
    public void testGetSign() {
        Amount amount1 = new Amount(-10000, Currencies.EURO);
        Amount amount2 = new Amount(10000, Currencies.EURO);
        Amount amount3 = new Amount(-10.00, Currencies.EURO);
        Amount amount4 = new Amount(10.00, Currencies.EURO);

        assertEquals(-1, amount1.getSign());
        assertEquals(1, amount2.getSign());
        assertEquals(-1, amount3.getSign());
        assertEquals(1, amount4.getSign());
    }

    @Test
    public void testGetCurrency() {
        Amount amount1 = new Amount(-10000, Currencies.EURO);

        assertEquals(Currencies.EURO, amount1.getCurrency());
    }

    @Test
    public void testAddSubLong() {
        Amount amount1 = new Amount(100000, Currencies.EURO);
        Amount amount2 = new Amount(-150000, Currencies.EURO);
        Amount amount3 = new Amount(-50000, Currencies.EURO);
        Amount amount4 = new Amount(100000, Currencies.DOLLAR);
        Amount amount5 = new Amount(178802, Currencies.EURO);
        Amount amount6 = new Amount(100000, Currencies.RUBEL);
        Amount amount7 = new Amount(100000, Currencies.YEN);
        Amount amount8 = new Amount(135686, Currencies.RUBEL);

        assertEquals(amount3, (amount1.add(amount2)));
        assertEquals(amount5, (amount1.add(amount4)));
        assertEquals(amount8, (amount6.add(amount7)));

        assertEquals(amount1, (amount3.subtract(amount2)));
        assertEquals(amount1, (amount5.subtract(amount4)));
        assertEquals(amount6, (amount8.subtract(amount7)));
    }

    @Test
    public void testAddSubDouble() {
        Amount amount1 = new Amount(10.00, Currencies.EURO);
        Amount amount2 = new Amount(-15.00, Currencies.EURO);
        Amount amount3 = new Amount(-5.00, Currencies.EURO);
        Amount amount4 = new Amount(10.00, Currencies.DOLLAR);
        Amount amount5 = new Amount(178802, Currencies.EURO);
        Amount amount6 = new Amount(10.00, Currencies.RUBEL);
        Amount amount7 = new Amount(10.00, Currencies.YEN);
        Amount amount8 = new Amount(135686, Currencies.RUBEL);

        assertEquals(amount3, (amount1.add(amount2)));
        assertEquals(amount5, (amount1.add(amount4)));
        assertEquals(amount8, (amount6.add(amount7)));

        assertEquals(amount1, (amount3.subtract(amount2)));
        assertEquals(amount1, (amount5.subtract(amount4)));
        assertEquals(amount6, (amount8.subtract(amount7)));

    }

    @Test
    public void testToLong() {
        Amount amount1 = new Amount(10.00, Currencies.EURO);

        assertNotEquals(100000, amount1.toLong());
        assertEquals(1000, amount1.toLong());

    }

    @Test
    public void testToDouble() {
        Amount amount1 = new Amount(100000, Currencies.EURO);
        Amount amount2 = new Amount(105000, Currencies.EURO);
        Amount amount3 = new Amount(134598, Currencies.EURO);

        // Todo: neue Tests

    }

    @Test
    public void testToMultiplyDoubleAndInt() {
        Amount amountDollar = new Amount(10.00, Currencies.DOLLAR);
        Amount amountEuro = new Amount(-100, Currencies.EURO);
        Amount amountYen = new Amount(1000, Currencies.YEN);
        Amount amountRubel = new Amount(0.00, Currencies.RUBEL);
        Amount amountChf = new Amount(99.99, Currencies.CHF);
        Amount spez = new Amount(-1569008, Currencies.DOLLAR);
        Amount amountNull = new Amount (15, Currencies.YEN);

        Amount a = new Amount(30000, Currencies.DOLLAR);
        Amount b = new Amount(-3300, Currencies.EURO);
        Amount c = new Amount(-1500, Currencies.YEN);
        Amount d = new Amount(0.0, Currencies.RUBEL);
        Amount e = new Amount(0, Currencies.CHF);
        Amount f = new Amount(-3711457L, Currencies.DOLLAR);
        Amount g = new Amount (30, Currencies.YEN);

        assertEquals(a, amountDollar.multiply(0.3));
        assertEquals(b, amountEuro.multiply(33));
        assertEquals(c, amountYen.multiply(-1.5));
        assertEquals(d, amountRubel.multiply(99.99));
        assertEquals(e, amountChf.multiply(0));
        assertEquals(f, spez.multiply(2.36548));
        assertEquals(g, amountNull.multiply(2));
    }

    @Test
    public void testToPercentage() {
        Amount amount1 = new Amount(10.00, Currencies.EURO);
        Amount amount2 = new Amount(-205700, Currencies.RUBEL);
        Amount amount3 = new Amount(2.50, Currencies.EURO);
        Amount amount4 = new Amount(-102850, Currencies.RUBEL);

        assertEquals(amount3, (amount1.percentage(25)));
        assertEquals(amount4, (amount2.percentage(50)));
    }
}
