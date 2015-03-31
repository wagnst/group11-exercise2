package de.wagnst.tpe.exercises.exercise2.master;

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

    public Amount add(Amount other) {
    }

    public Amount subtract(Amount other) {
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
     * @return long amount, jedoch mit nur zwei Nachkommastellen
     */
    public long toLong() {

        if (!chop) {
            // chop 3rd and 4th digit
            return this.amount / 100;
        } else {
            return this.amount;
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

    public double toDouble() {
    }

    public Currency getCurrency() {
    }

    public String toString() {
    }

    public int hashCode() {
    }

    public boolean equals(Object obj) {
    }
}
