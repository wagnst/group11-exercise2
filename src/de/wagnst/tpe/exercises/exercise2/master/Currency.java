package de.wagnst.tpe.exercises.exercise2.master;

public class Currency {

    String name;
    String code;
    long exchangeRate;
    boolean subunit;

    public Currency(String name, String code, long exchangeRate, boolean subunit) {
        this.name = name;
        this.code = code;
        this.exchangeRate = exchangeRate;
        this.subunit = subunit;
    }

    public Currency(String name, String code, long exchangeRate) {
        this(name, code, exchangeRate, false);
    }

    public long convert(long betrag, Currency toWaehrung) {
    }

    public long getExchangeRate() {
        return exchangeRate;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean hasSubunit() {
        return subunit;
    }

    public String toString() {
        long cent = getExchangeRate() % 10000;
        long euro = getExchangeRate() / 10000;
        return "" + name + " [" + code + "] 1 $ = " + euro + "," + cent + " "
                + code;

    }

    public int hashCode() {
    }

    public boolean equals(Object obj) {
    }
}
