package de.wagnst.tpe.exercises.exercise2.master;

import de.wagnst.tpe.exercises.exercise2.master.Currency;

public final class Amount {

    private long amount;
    private Currency currency;
    private boolean chop;

    public Amount(long amount, Currency currency) {

        this.amount = amount;
        this.currency = currency;
        this.chop = false;
    }

    public Amount(double amount, Currency currency) {
        // chop amount after second decimal digit
        this((long) (amount * 100), currency);
        this.chop = true;
    }

    /**
     * Addiert zwei Beträge, die Währung des ersten Betrages wird beibehalten
     * 
     * @param other
     *            , zu addierender Betrag
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
     * Subtrahier zwei Beträge, die Währung des ersten Betrages wird beibehalten
     * 
     * @param other
     *            , zu subtrahierender Betrag
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
    }

    public Amount multiply(int factor) {
    }

    public Amount percentage(int percent) {
    }

    /**
     * Gibt Information über die Höhe des gespeicherten Betrages
     * 
     * @return long amount, mit zwei Nachkommastellen, immer positiv
     */
    public long toLong() {
        long result = this.amount;
        // turn a negative into a positiv long value
        if (this.amount < 0) {
            result = this.amount + (-2 * this.amount);
        }
        if (!chop) {
            // chop 3rd and 4th digit
            return result / 100;
        } else {
            return result;
        }
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
     * @return double amount, mit zwei Nachkommastellen, immer positiv
     */
    public double toDouble() {
        System.out.println((double) this.amount);
        return (double) this.amount;
    }

    /**
     * Liefert für einen Betrag die Währung zurück
     * 
     * @return die Währung des Betrages
     */
    public Currency getCurrency() {
        return this.currency;
    }

    public String toString() {
    }

    public int hashCode() {
    }

    public boolean equals(Object obj) {
    }
}
