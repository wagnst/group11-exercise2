package de.wagnst.tpe.exercises.exercise2.master;

public final class Amount {

    private long amount;
    private Currency currency;
    // chop ist für zwei Nachkommastellen
    private boolean chop;

    public Amount(long amount, Currency currency) {

        this.amount = amount;
        this.currency = currency;
        this.chop = false;
    }

    public Amount(double amount, Currency currency) {
        // chop amount after second decimal digit
        this(((long) (amount * 100)) * 100, currency);
        this.chop = true;
    }

    /**
     * Addiert zwei Beträge, die Währung des ersten Betrages wird beibehalten
     *
     * @param other , zu addierender Betrag
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
        return new Amount((this.amount * (((long) factor)) * 100), this.currency);
    }


    public Amount multiply(int factor) {
        return new Amount((this.amount * factor), this.currency);
    }

    public Amount percentage(int percent) {
        return null;
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
            result = this.amount * -1;
        }
        if (!this.chop) {
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
        if (!this.chop) {
            // chop 3rd and 4th digit
            return (double) this.amount / 1000;
        } else {
            return (double) this.amount;
        }
    }

    /**
     * Liefert für einen Betrag die Währung zurück
     *
     * @return die Währung des Betrages
     */
    public Currency getCurrency() {
        return this.currency;
    }

    @Override
    public String toString() {
        //Todo: needs to check which currency it is and return corresponding amount (with or without comma)
        return this.amount + " " + this.currency.getCode();
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Amount) {
            //return true if amount and currency is equal. ignore chop!
            return ((((Amount) obj).amount == this.amount) && (((Amount) obj).currency == this.currency));
        }
        return false;
    }

}
