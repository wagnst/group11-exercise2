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
        Amount amount3 = new Amount(12.993, Currencies.EURO);

        assertEquals(100000, amount1.toLong());
        assertEquals(100, amount2.toLong());
        assertEquals(129900, amount3.toLong());
    }

    @Test
    public void testGetSign() {
        Amount amount1 = new Amount(-10000, Currencies.EURO);
        Amount amount2 = new Amount(10000, Currencies.EURO);
        Amount amount3 = new Amount(-10.000, Currencies.EURO);
        Amount amount4 = new Amount(10.000, Currencies.EURO);

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
        Amount amount5 = new Amount(17.88, Currencies.EURO);
        Amount amount6 = new Amount(10.00, Currencies.RUBEL);
        Amount amount7 = new Amount(10.00, Currencies.YEN);
        Amount amount8 = new Amount(13.56, Currencies.RUBEL);

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

        assertNotEquals(1000, amount1.toLong());
        assertEquals(100000, amount1.toLong());

    }

    @Test
    public void testToDouble() {
        Amount amount1 = new Amount(10000, Currencies.EURO);
        Amount amount2 = new Amount(10500, Currencies.EURO);

        assertEquals(10.00, amount1.toDouble(), 0.001); //0.001 fuzz factor for not exactly equal
        assertEquals(10.50, amount2.toDouble(), 0.001); //0.001 fuzz factor for not exactly equal
        assertEquals(10.5, amount2.toDouble(), 0.001); //0.001 fuzz factor for not exactly equal

    }

    @Test
    public void testToMultiplyDouble(){
        Amount amount1 = new Amount(10.00, Currencies.EURO);
        Amount amount2 = new Amount(100000, Currencies.EURO);
        Amount amount3 = new Amount(-20.579896, Currencies.RUBEL);
        Amount amount4 = new Amount(-205700, Currencies.RUBEL);
        Amount amount5 = new Amount(3000, Currencies.EURO);
        Amount amount6 = new Amount(-281397600,Currencies.RUBEL);

        assertEquals(amount5, (amount1.multiply(0.3)));
        assertEquals(amount5, (amount2.multiply(0.3)));
        assertEquals(amount6, (amount3.multiply(1.368)));
        assertEquals(amount6, (amount4.multiply(1.368)));

    }
}
