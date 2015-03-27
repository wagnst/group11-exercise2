package de.wagnst.tpe.exercises.exercise2.master;

public class Currency {

    String name;
    String code;
    long exchangeRate;
    boolean subunit;

    // accuracy after the decimal point
    int digit = 4;

    public Currency(String name, String code, long exchangeRate, boolean subunit) {
        this.name = name;
        this.code = code;
        this.exchangeRate = exchangeRate;
        ;
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

    /**
     * Wandelt Eingabe Wechselkurs in Funschformat euro,cent um; Ohne Verlust
     * durch Rundungsfehler
     * 
     * @param exchangeRate
     *            Wechselkurs zum Dollar, ohne Nachkommastelle
     * @return Wechselkurs codiert als String
     */
    private String convertToString(long exchangeRate) {
        String result = "";
        long[] digit = new long[this.digit + 1];
        int i = this.digit;

        while (exchangeRate > 0) {
            digit[i] = exchangeRate % 10;
            exchangeRate /= 10;
            i--;
        }

        for (int j = 1; j <= this.digit; j++) {
            result += digit[j];
        }
        return "" + digit[0] + "," + result;
    }

    /**
     * 
     * @return String im gewünschten Format
     */
    public String toString() {

        return "" + name + " [" + code + "] 1 $ = "
                + convertToString(this.exchangeRate) + " " + code;

    }

    public int hashCode() {
    }

    public boolean equals(Object obj) {
    }
}
