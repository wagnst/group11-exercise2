package de.wagnst.tpe.exercises.exercise2.master;

/**
 * Account manages bookings of money to an account. Every account has an owner
 * as well as a currency
 *
 * @author wagnst / d059727
 */
public class Account {

    private Currency currency;
    private String owner;

    /**
     * @param owner    name of the account owner (format [String String]
     * @param currency currency of the account's money
     */
    public Account(String owner, Currency currency) {
        this.owner = owner;
        this.currency = currency;
    }

    /**
     * book an amount of money to the account (can be positive or negative) and
     * also convert to the correct currency
     *
     * @param amount amount of money
     */
    public void post(Amount amount) {
    }

    /**
     * Show saldo of account (sum of all transactions)
     *
     * @return sum of transactions
     */
    public Amount total() {
        return null;
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
    }

    public String toString() {
        return null;
    }
}
