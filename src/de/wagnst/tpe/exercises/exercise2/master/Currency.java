package de.wagnst.tpe.exercises.exercise2.master;

import java.util.Arrays;

public final class Currency {

    private String name;
    private String code;
    private long exchangeRate;
    private boolean subunit;

    // accuracy after the decimal point
    private int digit = 4;

    public Currency(String name, String code, long exchangeRate, boolean subunit) {
        this.name = name;
        this.code = code;
        this.exchangeRate = exchangeRate;
        this.subunit = subunit;
    }

    /**
     * Konvertiert den gewünschten Betrag in die angegebene Währung
     *
     * @param amount     zu konvertierender Betrag
     * @param toCurrency in zu konvertierende Währung
     *
     * @return Konvertierter Betrag
     */
    public long convert(long amount, Currency toCurrency) {

        amount *= this.exchangeRate;

        return amount / toCurrency.exchangeRate;

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

    /**
     * Wandelt Wechselkurs in Funschformat euro,cent um; Ohne Verlust durch
     * Rundungsfehler
     *
     * @param exchangeRate Wechselkurs zum Dollar Ganzzahl
     *
     * @return Wechselkurs codiert als String
     */
    private String convertToString(long exchangeRate) {
        // at least one digit infront of the decimal point (this.digit + 1)
        int arraySize = this.digit + 1;
        String infrontOf = "";
        String behindOf = "";

        // get the array size for all digits; save this at arraySize
        while ((exchangeRate / (int) Math.pow(10, arraySize)) > 0) {
            arraySize++;
        }
        long[] digit = new long[arraySize];

        // digits get set into the array
        for (int i = arraySize - 1; i >= 0; i--) {
            digit[i] = exchangeRate % 10;
            exchangeRate /= 10;
        }
        int euroPointer = 0;
        int centPointer = arraySize - this.digit;

        // create String with all digits in front of the decimal point
        while (euroPointer < centPointer) {
            infrontOf += digit[euroPointer];
            euroPointer++;
        }

        // create String with all digits behind the decimal point
        while ((centPointer) < digit.length) {
            behindOf += digit[centPointer];
            centPointer++;
        }

        return "" + infrontOf + "," + behindOf;
    }

    /**
     * @return String im gewünschten Format
     */
    public String toString() {

        return "" + name + " [" + code + "] 1 $ = "
                + convertToString(this.exchangeRate) + " " + code;

    }

    /**
     * Erzeugt hashCode für das Objekt
     */
    public int hashCode() {
        return Arrays.hashCode(new double[]{this.exchangeRate});
    }

    /**
     * Prüft zwei Objekte auf Gleichheit
     *
     * @param o zu verlgeichendes Objekt
     *
     * @return boolean
     */
    public boolean equals(Object o) {
        if (o instanceof Currency) {
            return this.toString().equals(o.toString());
        } else {
            return false;
        }
    }
}
