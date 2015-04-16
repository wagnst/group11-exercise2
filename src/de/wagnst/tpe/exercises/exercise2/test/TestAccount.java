package de.wagnst.tpe.exercises.exercise2.test;

import de.wagnst.tpe.exercises.exercise2.master.Account;
import de.wagnst.tpe.exercises.exercise2.master.Amount;
import de.wagnst.tpe.exercises.exercise2.master.Currencies;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAccount {

    @Test
    public void testAccountCreation() throws Exception {

        Account steffen = new Account("Steffen Wagner", Currencies.EURO);

        assertEquals("Steffen Wagner", steffen.getOwner());
        assertEquals(Currencies.EURO, steffen.getCurrency());

    }

    @Test
    public void testPost() throws Exception {
        Account steffen = new Account("Steffen Wagner", Currencies.EURO);
        Amount test1 = new Amount(100, Currencies.EURO);

        steffen.post(test1);
        assertEquals("100,00 €", steffen.returnElementInHistory(0).toString());

    }

    @Test
    public void testTotal() throws Exception {
        Account steffen = new Account("Steffen Wagner", Currencies.EURO);
        Amount test1 = new Amount(100, Currencies.EURO);
        Amount test2 = new Amount(100, Currencies.EURO);

        steffen.post(test1);
        steffen.post(test2);
        assertEquals("200 €", steffen.total());

    }

    @Test
    public void testGetCurrency() throws Exception {

    }

    @Test
    public void testGetOwner() throws Exception {

    }

    @Test
    public void testAccountFee() throws Exception {

    }

    @Test
    public void testReturnAccountHistory() throws Exception {
        Account steffen = new Account("Steffen Wagner", Currencies.EURO);
        Amount test1 = new Amount(100, Currencies.EURO);
        Amount test2 = new Amount(100, Currencies.EURO);

        steffen.post(test1);
        steffen.post(test2);

        assertEquals("100.00 €\n100.00€",steffen.returnAccountHistory());
    }

    @Test
    public void testToString() throws Exception {
        Account steffen = new Account("Steffen Wagner", Currencies.EURO);
        Amount test1 = new Amount(100, Currencies.EURO);
        Amount test2 = new Amount(100, Currencies.DOLLAR);
        steffen.post(test1);
        steffen.post(test2);

        assertEquals("Owner: Steffen Wagner\nCurrency: Euro\n---------\n" + steffen.returnAccountHistory() +"\n---------\nSaldo: " + steffen.total(), steffen.toString());
    }
}