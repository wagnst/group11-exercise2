package de.wagnst.tpe.exercises.exercise2.master;

import java.util.Locale;

/**
 * Class to make different arithmetic operation with the Amounts. An amount
 * consists of classical money and a currency which has to be created according
 * to the Currency class.
 * <p>
 * New instances can be created with the help of the constructor
 * <pre>
 * Amount amount = new Amount(100.00, Currencies.EURO);
 * </pre>
 * Objects of this class are immutable. The methods don't change the state of
 * their object, but return a new object.
 *
 * @author wagnst, Rathainka
 */
public final class Amount {

    /* amount of money */
    private final long amount;
    /* currency of the amount */
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
     *
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
     *
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
     * Multiplies the amount with a factor
     *
     * @param factor factor to multiply with in double
     *
     * @return fluent interface
     */
    public Amount multiply(double factor) {
        return new Amount(toDouble(amount) * factor, currency);
    }

    /**
     * Multiplies the amount with a factor
     *
     * @param factor factor to multiply with an integer
     *
     * @return fluent interface
     */
    public Amount multiply(int factor) {
        return this.multiply((double) factor);
    }

    /**
     * Calculates the percentage of the amount
     *
     * @param percentage dividend of the division with 100
     *
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
        return (long) Math.abs(amount
                / Math.pow(10, currency.getAccuracy() - 2));
    }

    /**
     * Returns an amount of money in double
     *
     * @param amount amount of money in long
     *
     * @return amount with two decimal places in double
     */
    public double toDouble(long amount) {
        /* return amount with accuracy of two after the decimal point */
        amount /= Math.pow(10, (currency.getAccuracy() - 2));
        return (((double) amount) / Math.pow(10, currency.getAccuracy() - 2));
    }

    /**
     * Checks is an amount is positive or negative
     *
     * @return if positive 1, if negative -1
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
     *
     * @return converted currency with amount
     */
    public Amount convertToCurrency(Currency toCurrency) {
        return new Amount(this.currency.convert(amount, toCurrency), toCurrency);
    }

    /**
     * Inverts an Amount to the opposite. E.g. Amount(10, Euro) will be
     * Amount(-10, Euro).
     *
     * @return inverted amount
     */
    public Amount invertAmount() {
        return new Amount(amount * -1, currency);
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        // amount (with or without comma)
        if (currency.hasSubunit())
            return String.format(Locale.ENGLISH, "%.2f %s", toDouble(amount),
                    this.currency.getCode());
        else {
            return String.format("%d %s",
                    (long) (amount / Math.pow(10, currency.getAccuracy())),
                    currency.getCode());
        }
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

        Amount amount1 = (Amount) o;

        if (amount != amount1.amount)
            return false;
        if (!currency.equals(amount1.currency))
            return false;

        return true;
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = (int) (amount ^ (amount >>> 32));
        result = 31 * result + currency.hashCode();
        return result;
    }
}
