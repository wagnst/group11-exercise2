package de.wagnst.tpe.exercises.exercise2.master;

import java.util.ArrayList;
import java.util.List;

/**
 * Account manages bookings of money to an bank account. Every account has an
 * owner as well as a currency. All done transactions to an account (through
 * post) will get logged in accountHistory
 *
 * @author wagnst
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
        if (!this.currency.equals(amount.getCurrency())) {
            amount = amount.convertToCurrency(this.currency);
        }
        this.accountHistory.add(amount);
    }

    /**
     * Return an specific element from the bank account history
     *
     * @param e element number as integer
     * @return element in bank history. if out of bounds return null
     */
    public Amount returnElementInHistory(int e) {
        if (e <= this.accountHistory.size() - 1 || e >= 0) {
            return this.accountHistory.get(e);
        } else {
            return null;
        }
    }

    /**
     * Gives all historical bank transfers as a simple string
     * Used for the toString method for printing the transaction history
     *
     * @return bank history as string
     */
    public String getStringAccountHistory() {
        String history = "";
        for (int i = 0; i < this.accountHistory.size(); i++) {
            history += this.accountHistory.get(i) + "\n";
        }
        return history;
    }

    /**
     * Gives all historical bank transfers in original format
     *
     * @return bank history as Array List
     */
    public List<Amount> getArrayAccountHistory() {
        return this.accountHistory;
    }

    /**
     * Show saldo of account (sum of all transactions). Decide if elements need
     * to be added or substracted. Start with total of zero.
     *
     * @return sum of transactions
     */
    public Amount total() {
        Amount sum = new Amount(0, this.currency);
        for (int i = 0; i < this.accountHistory.size() - 1; i++) {
            switch (this.accountHistory.get(i).getSign()) {
                // transaction is positive
                case 1:
                    sum.add(this.accountHistory.get(i));
                    break;
                // transaction is negative
                case -1:
                    sum.subtract(this.accountHistory.get(i));
                    break;
            }
        }
        return sum;
    }

    /**
     * @return currency of this bank account
     */
    public Currency getCurrency() {
        return this.currency;
    }

    /**
     * @return owner of this bank account
     */
    public String getOwner() {
        return this.owner;
    }

    /**
     * set of fees which are charged to the account (product of saldo and
     * promills)
     *
     * @param percentage percentage of due for the bank
     */
    public void accountFee(int percentage) {
        //ToDo: implementation
    }

    @Override
    public String toString() {
        return "Owner: " + this.owner + "\n" +
                "Currency: " + this.currency.getName() + "\n" +
                "---------" + "\n" +
                getStringAccountHistory() +
                "---------" + "\n" +
                "Saldo: " + total().toString();
    }

}
