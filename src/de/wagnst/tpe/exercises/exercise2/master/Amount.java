package de.wagnst.tpe.exercises.exercise2.master;

/**
 * Class to make different arithmetic operation with the Amounts. An amount
 * consists of classical money and a currency which has to be created according
 * to the Currency class.
 *
 * @author Kathainka, maxGross, wagnst
 */
public final class Amount {

    private long amount;
    private Currency currency;

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
     * Creates an Amount of "money" from the given parameters
     *
     * @param amount   amount of money in double (will be converted to long)
     * @param currency currency of the amount
     */
    public Amount(double amount, Currency currency) {
        this(((long) (amount * 100)) * 100, currency);
    }

    /**
     * Adds to amounts and keeps the currency of the first amount
     *
     * @param other the amount which will be added
     * @return sum of "other" amount and this amount
     */
    public Amount add(Amount other) {
        if (this.currency.equals(other.currency)) {
            return new Amount((this.amount + other.amount), this.currency);
        } else {
            return new Amount(this.amount
                    + other.currency.convert(other.amount, this.currency),
                    this.currency);
        }
    }

    /**
     * subtracs to amounts and keeps the currency of the first amount
     *
     * @param other the amount which will be substracted
     * @return difference of "other" amount and this amount
     */
    public Amount subtract(Amount other) {
        if (this.currency.equals(other.currency)) {
            return new Amount((this.amount - other.amount), this.currency);
        } else {
            return new Amount(this.amount
                    - other.currency.convert(other.amount, this.currency),
                    this.currency);
        }
    }

    /**
     * multiplies the amount with a factor
     *
     * @param factor factor to multiply with in double
     * @return a new amount with the multiplied amount
     */
    public Amount multiply(double factor) {

        return new Amount((toDouble(this.amount) * factor), this.currency);
    }

    /**
     * multiplies the amount with a factor
     *
     * @param factor factor to multiply with in integer
     * @return a new amount with the multiplied amount
     */
    public Amount multiply(int factor) {

        return new Amount((this.amount * factor), this.currency);
    }

    /**
     * multiplies the amount with a percentage
     *
     * @param percentage factor to multiply with in integer
     * @return a new amount with the multiplied amount (amount * percentage /
     * 100)
     */
    public Amount percentage(int percentage) {
        return new Amount(this.amount * percentage / 100, this.currency);
    }

    /**
     * Returns the size of the saved amount
     *
     * @return long amount, with two decimal places, always positive
     */
    public long toLong() {
        long result = this.amount;
        if (this.amount < 0) {
            result = this.amount * -1;
        }
        return result / 100;
    }

    /**
     * Checks is an amount is positive or negative
     *
     * @return +1 = Amount >= 0 ; -1 = Amount < 0
     */
    public int getSign() {

        if (amount >= 0) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Returns an amount of money in double
     *
     * @param amount amount of money in long
     * @return amount with two decimal places in double
     */
    public double toDouble(long amount) {
        return ((double) (amount / 100)) / 100;
    }

    /**
     * Returns the value of currency
     *
     * @return currency of this object
     */
    public Currency getCurrency() {
        return this.currency;
    }

    /**
     * Converts current currency to a new currency
     *
     * @param toCurrency new currency
     * @return converted currency with amount
     */
    public Amount convertToCurrency(Currency toCurrency) {
        return new Amount(this.currency.convert(this.amount, toCurrency),
                toCurrency);
    }

    @Override
    public String toString() {
        // amount (with or without comma)
        if (this.currency.getName() != "Yen")
            return toDouble(this.amount) + " " + this.currency.getCode();
        else {
            return (this.amount / 10000) + " " + this.currency.getCode();
        }
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Amount) {
            // return true if amount and currency is equal. ignore chop!
            return ((((Amount) obj).amount == this.amount) && (((Amount) obj).currency == this.currency));

        }
        return false;
    }
}
