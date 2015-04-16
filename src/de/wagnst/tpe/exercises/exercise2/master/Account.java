package de.wagnst.tpe.exercises.exercise2.master;

import java.util.ArrayList;
import java.util.List;

/**
 * Account manages bookings of money to an account. Every account has an owner
 * as well as a currency
 *
 * @author wagnst / d059727
 */

public class Account {

    private Currency currency;
    private String owner;
    private List<Amount> accountHistory = new ArrayList<Amount>();


    /**
     * @param owner    name of the account owner (format [String String]
     * @param currency currency of the account's money
     */
    public Account(String owner, Currency currency) {
        this.owner = owner;
        this.currency = currency;
        this.accountHistory.clear();
    }

    /**
     * book an amount of money to the account (can be positive or negative) and
     * also convert to the correct currency
     *
     * @param amount amount of money
     */
    public void post(Amount amount) {
        //add transaction to bank statement
        //TODO: Test for wrong type of amount!!!
        this.accountHistory.add(amount);
    }

    public Amount returnElementInHistory(int e) {
        return this.accountHistory.get(e);
    }

    public String returnAccountHistory() {
        String history = "";
        for (int i=0; i < this.accountHistory.size(); i++) {
            history += this.accountHistory.get(i) + "\n";
        }
        return history;
    }

    /**
     * Show saldo of account (sum of all transactions). Decide if elements need
     * to be added or substracted. Start with total of zero.
     *
     * @return sum of transactions
     */
    public Amount total() {
        Amount sum = new Amount(0,this.currency);
        for (int i = 0; i < this.accountHistory.size() - 1; i++) {
            switch (this.accountHistory.get(i).getSign()) {
                //positive
                case 1:
                    sum.add(this.accountHistory.get(i));
                    break;
                //negative
                case -1:
                    sum.subtract(this.accountHistory.get(i));
                    break;
            }
        }
        return sum;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public String getOwner() {
        return this.owner;
    }

    /**
     * set of fees which are charged to the account (product of saldo and
     * promills)
     *
     * @param promills
     */
    public void accountFee(int promills) {
        //ToDo: implementation
    }

    @Override
    public String toString() {
        return "Owner: " + this.owner + "\n" +
                "Currency: " + this.currency.getName() + "\n" +
                "---------" + "\n" +
                returnAccountHistory() +
                "---------" + "\n" +
                "Saldo: " + total().toString();
    }

}
