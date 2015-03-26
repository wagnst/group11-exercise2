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
    }

    public int hashCode() {
    }

    public boolean equals(Object obj) {
    }
}
