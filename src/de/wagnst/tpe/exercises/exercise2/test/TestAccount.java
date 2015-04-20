package de.wagnst.tpe.exercises.exercise2.test;

import de.wagnst.tpe.exercises.exercise2.master.Account;
import de.wagnst.tpe.exercises.exercise2.master.Amount;
import de.wagnst.tpe.exercises.exercise2.master.Currencies;
import de.wagnst.tpe.exercises.exercise2.master.Currency;
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
    public void testAccountFee() {
        /* Really nice pictures on the bank note! */
        final Currency ZAR = new Currency("South-African Rand", "ZAR",
                827, true );
        Account totoraaaeee = new Account("African Elephant", ZAR);
        Amount test1 = new Amount(100.00, ZAR);
        Amount test2 = new Amount(100.00, Currencies.EURO);
        Amount test3 = new Amount(-100.00, Currencies.DOLLAR);
        Amount test4 = new Amount(-100.00, Currencies.YEN);
        Amount test5 = new Amount(-100.00, Currencies.RUBEL);

        //totoraaaeee.post();
        //totoraaaeee.accountFee(10);



    }

    @Test
    public void testReturnAccountHistory() {
        Account steffen = new Account("Steffen Wagner", Currencies.EURO);
        Amount test1 = new Amount(1000.00, Currencies.EURO);
        Amount test2 = new Amount(1000.00, Currencies.DOLLAR);
        Amount test3 = new Amount(1000.00, Currencies.DOLLAR);
        Amount test4 = new Amount(1000.00, Currencies.YEN);

        steffen.post(test1, test2);
        assertEquals("1000.00 €\n788.02 €\n", steffen.getStringAccountHistory
                ());
        steffen.post(test3);
        assertEquals("1000.00 €\n788.02 €\n788.02 €\n", steffen
                .getStringAccountHistory
                        ());
        steffen.post(test4);
        assertEquals("1000.00 €\n788.02 €\n788.02 €\n7.17 €\n", steffen
                .getStringAccountHistory
                        ());

    }

    @Test
    public void testToString() {
        Account steffen = new Account("Steffen Wagner", Currencies.EURO);
        Amount test1 = new Amount(100.00, Currencies.EURO);
        Amount test2 = new Amount(100.00, Currencies.DOLLAR);
        Amount test3 = new Amount(-100.00, Currencies.DOLLAR);

        steffen.post(test1, test2);
        assertEquals("Owner: " + steffen.getOwner() + "\n" +
                "Currency: " + steffen.getCurrency().getName() + "\n" +
                "---------" + "\n" +
                steffen.getStringAccountHistory() +
                "---------" + "\n" +
                "Saldo: " + steffen.total().toString()
                , steffen.toString());
        steffen.post(test3);
        assertEquals("Owner: " + steffen.getOwner() + "\n" +
                "Currency: " + steffen.getCurrency().getName() + "\n" +
                "---------" + "\n" +
                steffen.getStringAccountHistory() +
                "---------" + "\n" +
                "Saldo: " + steffen.total().toString()
                , steffen.toString());
    }
}