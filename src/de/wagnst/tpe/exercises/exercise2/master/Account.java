package de.wagnst.tpe.exercises.exercise2.master;

import java.util.ArrayList;
import java.util.List;

/**
 * Account manages bookings of money to a bank account. Every account has an
 * owner as well as a currency. All done transactions to an account (through
 * post()) will get logged in accountHistory. A single item can be gained with
 * the method <i>returnElementInHistory()</i>. A complete bank statement can be
 * printed with the toString() method.
 * <p>
 * New instances can be created with the help of the constructor
 * <pre>
 * Account account = new Account("Steffen Wagner", Currencies.EURO);
 * </pre>
 * Objects of this class are immutable. The methods don't change the state of
 * their object, but return a new object.
 *
 * @author Steffen Wagner, Maximilian Groß, Katharina Spinner
 */

public final class Account {

    /* Currency of the bank account */
    private final Currency currency;
    /* Owner of the bank account */
    private final String owner;
    /* Account transaction list. Transactions stored in bank accounts currency */
    private final List<Amount> accountHistory = new ArrayList<Amount>();

    /**
     * Creates a new account with the given parameters
     *
     * @param owner    name of the account owner (format [String String]
     * @param currency currency of the account's money
     */
    public Account(String owner, Currency currency) {
        this.owner = owner;
        this.currency = currency;
        this.accountHistory.clear();
    }

    /**
     * Book an amount of money to the account (can be positive or negative) and
     * also convert to the correct currency
     *
     * @param amount multiple amounts of money (vargargs)
     */
    public void post(Amount... amount) {
        for (Amount currentAmount : amount) {
            // convert transaction to currency of bank account
            if (!currency.equals(currentAmount.getCurrency())) {
                currentAmount = currentAmount.convertToCurrency(currency);
            }
            // add transaction to bank statement
            accountHistory.add(currentAmount);
        }
    }

    /**
     * Return an specific element from the bank account history
     *
     * @param e element number as integer
     * @return element in bank history. if out of bounds return null
     */
    public Amount returnElementInHistory(int e) {
        if (e <= accountHistory.size() - 1 || e >= 0) {
            return accountHistory.get(e);
        } else {
            return null;
        }
    }

    /**
     * Gives all historical bank transfers as a simple string Used for the
     * toString method for printing the transaction history
     *
     * @return bank history as string
     */
    public String getStringAccountHistory() {
        String history = "";
        for (Amount anEntry : accountHistory) {
            history += anEntry + "\n";
        }
        return history;
    }

    /**
     * Gives all historical bank transfers in original format
     *
     * @return bank history as Array List
     */
    public List<Amount> getArrayAccountHistory() {
        return accountHistory;
    }

    /**
     * Show saldo of account (sum of all transactions). Decide if elements need
     * to be added or substracted. Start with total of zero.
     *
     * @return sum of transactions
     */
    public Amount total() {
        Amount sum = new Amount(0.00, currency);
        for (Amount amount : accountHistory) {
            sum = sum.add(amount);
        }
        return sum;
    }

    /**
     * Returns the currency of this bank account
     *
     * @return currency of this bank account
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Returns the owner of this bank account
     *
     * @return owner of this bank account
     */
    public String getOwner() {
        return owner;
    }

    /**
     * Set of fees which are charged to the account (product of saldo and
     * promille)
     *
     * @param promille amount of dues which will be charged (in currency of account)
     * @throws IllegalArgumentException if promille is not greater than zero
     */
    public void accountFee(int promille) throws IllegalArgumentException {
        if (promille > 0) {
            Amount fee = total().percentage(promille);
            accountHistory.add(fee.invertAmount());
        } else {
            throw new IllegalArgumentException(
                    "promille must be greater than zero.");
        }
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Owner: " + owner + "\n" + "Currency: " + currency.getName()
                + "\n" + "---------" + "\n" + getStringAccountHistory()
                + "---------" + "\n" + "Saldo: " + total().toString();
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Account account = (Account) o;

        if (accountHistory != null ? !accountHistory
                .equals(account.accountHistory)
                : account.accountHistory != null)
            return false;
        if (!currency.equals(account.currency))
            return false;
        if (!owner.equals(account.owner))
            return false;

        return true;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = currency.hashCode();
        result = 31 * result + owner.hashCode();
        result = 31 * result
                + (accountHistory != null ? accountHistory.hashCode() : 0);
        return result;
    }
}
