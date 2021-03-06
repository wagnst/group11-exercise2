package de.wagnst.tpe.exercises.exercise2.test;

import de.wagnst.tpe.exercises.exercise2.master.Account;
import de.wagnst.tpe.exercises.exercise2.master.Amount;
import de.wagnst.tpe.exercises.exercise2.master.Currencies;
import de.wagnst.tpe.exercises.exercise2.master.Currency;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAccount {

    @Test
    public void testAccountCreation() {

        Account steffen = new Account("Steffen Wagner", Currencies.EURO);

        assertEquals("Steffen Wagner", steffen.getOwner());
        assertEquals(Currencies.EURO, steffen.getCurrency());

    }

    @Test
    public void testPost() {
        Account steffen = new Account("Steffen Wagner", Currencies.EURO);
        Amount test1 = new Amount(100.00, Currencies.EURO);

        steffen.post(test1);
        assertEquals("100.00 €", steffen.returnElementInHistory(0).toString());

    }

    @Test
    public void testTotal() {
        Account steffen = new Account("Steffen Wagner", Currencies.EURO);
        Amount test1 = new Amount(100.00, Currencies.EURO);
        Amount test2 = new Amount(100.00, Currencies.EURO);
        Amount test3 = new Amount(-100.00, Currencies.EURO);

        steffen.post(test1, test2, test3);
        assertEquals("100.00 €", steffen.total().toString());

    }

    @Test
    public void testGetCurrencyAndOwner() {
        Account test1 = new Account("Max Gross", Currencies.EURO);
        Account test2 = new Account("Katharina Spinner", Currencies.RUBEL);
        Account test3 = new Account("Steffen Wagner", Currencies.YEN);

        /* getCurrency */
        assertEquals(Currencies.EURO, test1.getCurrency());
        assertEquals(Currencies.YEN, test3.getCurrency());

        /* getOwner */
        assertEquals("Max Gross", test1.getOwner());
        assertEquals("Katharina Spinner", test2.getOwner());
        assertEquals("Steffen Wagner", test3.getOwner());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAccountFee() throws Exception {
        /* Really nice pictures on the bank note! */
        final Currency ZAR = new Currency("South-African Rand", "ZAR", 827,
                true);
        Account totoraaaeee = new Account("Susi, the African elephant", ZAR);
        Amount test1 = new Amount(100.00, ZAR);
        Amount test2 = new Amount(100.00, Currencies.EURO);
        Amount test3 = new Amount(-100.00, Currencies.DOLLAR);
        Amount test4 = new Amount(-100.00, Currencies.YEN);
        Amount test5 = new Amount(-100.00, Currencies.RUBEL);

        totoraaaeee.post(test1, test2, test3, test4, test5);
        assertEquals("100.00 ZAR\n1534.46 ZAR\n-1209.18 ZAR\n-11.00 "
                + "ZAR\n-30.83 ZAR\n", totoraaaeee.getStringAccountHistory());
        totoraaaeee.accountFee(10);
        assertEquals("100.00 ZAR\n1534.46 ZAR\n-1209.18 ZAR\n-11.00 "
                        + "ZAR\n-30.83 ZAR\n-38.34 ZAR\n",
                totoraaaeee.getStringAccountHistory());
        totoraaaeee.accountFee(-10);

    }

    @Test
    public void testReturnAccountHistory() {
        Account steffen = new Account("Steffen Wagner", Currencies.EURO);
        Amount test1 = new Amount(1000.00, Currencies.EURO);
        Amount test2 = new Amount(1000.00, Currencies.DOLLAR);
        Amount test3 = new Amount(1000.00, Currencies.DOLLAR);
        Amount test4 = new Amount(1000.00, Currencies.YEN);

        steffen.post(test1, test2);
        assertEquals("1000.00 €\n788.02 €\n", steffen.getStringAccountHistory());
        steffen.post(test3);
        assertEquals("1000.00 €\n788.02 €\n788.02 €\n",
                steffen.getStringAccountHistory());
        steffen.post(test4);
        assertEquals("1000.00 €\n788.02 €\n788.02 €\n7.17 €\n",
                steffen.getStringAccountHistory());

    }

    @Test
    public void testToString() {
        Account steffen = new Account("Steffen Wagner", Currencies.EURO);
        Amount test1 = new Amount(100.00, Currencies.EURO);
        Amount test2 = new Amount(100.00, Currencies.DOLLAR);
        Amount test3 = new Amount(-100.00, Currencies.DOLLAR);

        steffen.post(test1, test2);
        assertEquals("Owner: " + steffen.getOwner() + "\n" + "Currency: "
                + steffen.getCurrency().getName() + "\n" + "---------" + "\n"
                + steffen.getStringAccountHistory() + "---------" + "\n"
                + "Saldo: " + steffen.total().toString(), steffen.toString());
        steffen.post(test3);
        assertEquals("Owner: " + steffen.getOwner() + "\n" + "Currency: "
                + steffen.getCurrency().getName() + "\n" + "---------" + "\n"
                + steffen.getStringAccountHistory() + "---------" + "\n"
                + "Saldo: " + steffen.total().toString(), steffen.toString());
    }

    @Test
    public void testHashCode() {

        Account test1 = new Account("Max Gross", Currencies.EURO);
        Account test2 = new Account("Max Gross", Currencies.EURO);
        Account test3 = new Account("Steffen Wagner", Currencies.YEN);

        assertTrue(test1.hashCode() == test2.hashCode());
        assertFalse(test2.hashCode() == test3.hashCode());
    }

    @Test
    public void testEquals() {
        Account test1 = new Account("Max Gross", Currencies.EURO);
        Account test2 = new Account("Max Gross", Currencies.EURO);
        Account test3 = new Account("Steffen Wagner", Currencies.YEN);

        assertTrue(test1.equals(test2));
        assertFalse(test2.equals(test3));
    }
}