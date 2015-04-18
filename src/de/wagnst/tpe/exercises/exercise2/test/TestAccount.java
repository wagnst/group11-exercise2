package de.wagnst.tpe.exercises.exercise2.test;

import de.wagnst.tpe.exercises.exercise2.master.Account;
import de.wagnst.tpe.exercises.exercise2.master.Amount;
import de.wagnst.tpe.exercises.exercise2.master.Currencies;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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
        assertEquals("100 €", steffen.returnElementInHistory(0));

    }

    @Test
    public void testTotal() {
        Account steffen = new Account("Steffen Wagner", Currencies.EURO);
        Amount test1 = new Amount(100.00, Currencies.EURO);
        Amount test2 = new Amount(100.00, Currencies.EURO);

        steffen.post(test1);
        steffen.post(test2);
        assertEquals("200.00 €", steffen.total());

    }

    @Test
    public void testAccountFee() {

    }

    @Test
    public void testReturnAccountHistory() {
        Account steffen = new Account("Steffen Wagner", Currencies.EURO);
        Amount test1 = new Amount(1000.00, Currencies.EURO);
        Amount test2 = new Amount(1000.00, Currencies.DOLLAR);
        Amount test3 = new Amount(1000.00, Currencies.DOLLAR);
        Amount test4 = new Amount(1000.00, Currencies.YEN);

        steffen.post(test1);
        steffen.post(test2);
        assertEquals("1000.00 €\n788.02 €\n", steffen.getStringAccountHistory
                ());
        steffen.post(test3);
        assertEquals("1000.00 €\n788.02 €\n788.02 €\n", steffen
                .getStringAccountHistory
                        ());
        steffen.post(test4);
        assertEquals("1000.00 €\n788.02 €\n788.02 €\n7 €\n", steffen
                .getStringAccountHistory
                        ());

    }

    @Test
    public void testToString() {
        Account steffen = new Account("Steffen Wagner", Currencies.EURO);
        Amount test1 = new Amount(100.00, Currencies.EURO);
        Amount test2 = new Amount(100.00, Currencies.DOLLAR);
        steffen.post(test1);
        steffen.post(test2);

        assertEquals("Owner: " + steffen.getOwner() + "\n" +
                "Currency: " + steffen.getCurrency().getName() + "\n" +
                "---------" + "\n" +
                steffen.getStringAccountHistory() +
                "---------" + "\n" +
                "Saldo: " + steffen.total().toString()
                , steffen.toString());

    }
}