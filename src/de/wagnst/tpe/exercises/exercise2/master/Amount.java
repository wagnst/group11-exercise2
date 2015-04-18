package de.wagnst.tpe.exercises.exercise2.master;

import java.util.Locale;

/**
 * Class to make different arithmetic operation with the Amounts. An amount
 * consists of classical money and a currency which has to be created according
 * to the Currency class.
 *
 * @author Rathainka, wagnst
 */
public final class Amount {

    private final long amount;
    private final Currency currency;

    /**
     * Creates an Amount of "money" from the given parameters
     *
     * @param amount   amount of money in long
     * @param currency currency of the amount
     */
    public Amount(long amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    /**
     * Creates an Amount of "money" from the given parameters and uses the
     * accuracy of Currency class
     *
     * @param amount   amount of money in double (will be converted to long)
     * @param currency currency of the amount
     */
    public Amount(double amount, Currency currency) {
        this((long) (Math.pow(10, currency.getAccuracy()) * amount), currency);
    }

    /**
     * Adds to amounts and converts the currency from other
     *
     * @param other the amount which will be added
     * @return fluent interface
     */
    public Amount add(Amount other) {
        long newAmount = amount;
        if (this.currency.equals(other.currency)) {
            newAmount += other.amount;
        } else {
            newAmount += other.currency.convert(other.amount, this.currency);
        }
        return new Amount(newAmount, currency);
    }

    /**
     * Subtracts two amounts and converts the currency from other
     *
     * @param other the amount which will be subtracted
     * @return fluent interface
     */
    public Amount subtract(Amount other) {
        long newAmount = amount;
        if (this.currency.equals(other.currency)) {
            newAmount -= other.amount;
        } else {
            newAmount -= other.currency.convert(other.amount, this.currency);
        }
        return new Amount(newAmount, currency);
    }

    /**
     * multiplies the amount with a factor
     *
     * @param factor factor to multiply with in double
     * @return fluent interface
     */
    public Amount multiply(double factor) {
        return new Amount(amount * factor, currency);
    }

    /**
     * multiplies the amount with a factor
     *
     * @param factor factor to multiply with in integer
     * @return fluent interface
     */
    public Amount multiply(int factor) {
        return this.multiply((double) factor);
    }

    /**
     * multiplies the amount with a percentage
     *
     * @param percentage dividend of the division with 100
     * @return fluent interface
     */
    public Amount percentage(int percentage) {
        return this.multiply(((double) percentage) / 100);
    }

    /**
     * Returns the size of the saved amount
     *
     * @return long amount, always positive
     */
    public long toLong() {
        return (long) Math.abs(this.toDouble(amount) * 100);
    }

    /**
     * Returns an amount of money in double
     *
     * @param amount amount of money in long
     * @return amount with two decimal places in double
     */
    public double toDouble(long amount) {
        return ((double) amount / Math.pow(10, currency.getAccuracy()));
    }

    /**
     * Checks is an amount is positive or negative
     *
     * @return +1 = Amount >= 0 ; -1 = Amount < 0
     */
    public int getSign() {
        return amount >= 0 ? 1 : -1;
    }

    /**
     * Returns the value of currency
     *
     * @return currency of this object
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * Converts current currency to a new currency
     *
     * @param toCurrency new currency
     * @return converted currency with amount
     */
    public Amount convertToCurrency(Currency toCurrency) {
        return new Amount(this.currency.convert(amount, toCurrency), toCurrency);
    }

    @Override
    public String toString() {
        // amount (with or without comma)
        if (currency.hasSubunit())
            return String.format(Locale.ENGLISH, "%.2f %s", toDouble(amount),
                    this.currency.getCode());
        else {
            return String.format("%d %s", (long) Math.pow(10,
                    currency.getAccuracy()), currency.getCode());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount1 = (Amount) o;

        if (amount != amount1.amount) return false;
        if (!currency.equals(amount1.currency)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (amount ^ (amount >>> 32));
        result = 31 * result + currency.hashCode();
        return result;
    }
}
