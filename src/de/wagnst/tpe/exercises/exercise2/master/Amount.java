package de.wagnst.tpe.exercises.exercise2.master;

/**
 * Class to make arithmetic operation with the Amounts
 *
 * @author Katharina
 */
public final class Amount {

    private long amount;
    private Currency currency;

    public Amount(long amount, Currency currency) {

        this.amount = amount;
        this.currency = currency;
    }

    public Amount(double amount, Currency currency) {

        this(((long) (amount * 100)) * 100, currency);
    }

    /**
     * Addiert zwei Beträge, die Währung des ersten Betrages wird beibehalten
     *
     * @param other , zu addierender Betrag
     *
     * @return Summe der beiden Beträge
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
     * Subtrahiere zwei Beträge, die Währung des ersten Betrages wird
     * beibehalten
     *
     * @param other , zu subtrahierender Betrag
     *
     * @return Differenz der beiden Beträge
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

    public Amount multiply(double factor) {
        return new Amount((toDouble(this.amount) * factor),
                this.currency);
    }

    public Amount multiply(int factor) {
        return new Amount((this.amount * factor), this.currency);
    }

    public Amount percentage(int percent) {
        return new Amount(this.amount * percent / 100, this.currency);
    }

    /**
     * Turns back the height of the saved amount
     *
     * @return long amount, with two decimal place, always positive
     */
    public long toLong() {
        long result = this.amount;
        if (this.amount < 0) {
            result = this.amount * -1;
        }
        return result / 100;
    }

    /**
     * prüft ob der Betrag positiv ist
     *
     * @return +1 = Betrag >= 0 ; -1 = Betrag < 0
     */
    public int getSign() {

        if (amount >= 0) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Gibt Information über die Höhe des gespeicherten Betrages
     *
     * @return double amount, mit zwei Nachkommastellen
     * @param amount
     */
    public double toDouble(long amount) {
        return ((double) (amount / 100)) / 100;
    }

    /**
     * Liefert für einen Betrag die Währung zurück
     *
     * @return die Währung des Betrages
     */
    public Currency getCurrency() {
        return this.currency;
    }

    /**
     * Converts current currency to a new currency
     *
     * @param toCurrency new currency
     *
     * @return converted currency with amount
     */
    public Amount convertToCurrency(Currency toCurrency) {
        return new Amount(this.currency.convert(this.amount, toCurrency),
                toCurrency);
    }

    @Override
    public String toString() {
        // amount (with or without comma)
        if(this.currency.getName() != "Yen")
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
        if (obj instanceof Amount) {
            // return true if amount and currency is equal. ignore chop!
            return ((((Amount) obj).amount == this.amount) && (((Amount) obj).currency == this.currency));
        }
        return false;
    }

}
