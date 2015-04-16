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
        assertEquals("100 €", steffen.returnElementInHistory(0).toString());

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
    public void testAccountFee() throws Exception {

    }

    @Test
    public void testReturnAccountHistory() throws Exception {
        Account steffen = new Account("Steffen Wagner", Currencies.EURO);
        Amount test1 = new Amount(100, Currencies.EURO);
        Amount test2 = new Amount(100, Currencies.DOLLAR);

        steffen.post(test1);
        steffen.post(test2);

        assertEquals("100 €\n100 $\n",steffen.returnAccountHistory());
    }

    @Test
    public void testToString() throws Exception {
        Account steffen = new Account("Steffen Wagner", Currencies.EURO);
        Amount test1 = new Amount(100, Currencies.EURO);
        Amount test2 = new Amount(100, Currencies.DOLLAR);
        steffen.post(test1);
        steffen.post(test2);

        assertEquals("Owner: " + steffen.getOwner() + "\n" +
                     "Currency: " + steffen.getCurrency().getName() + "\n" +
                     "---------" + "\n" +
                     steffen.returnAccountHistory() +
                     "---------" + "\n" +
                     "Saldo: " + steffen.total().toString()
                ,steffen.toString());
    }
}