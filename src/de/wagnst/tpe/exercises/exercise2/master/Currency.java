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
     * Wandelt Wechselkurs in Funschformat euro,cent um; Ohne Verlust durch
     * Rundungsfehler
     * 
     * @param exchangeRate
     *            Wechselkurs zum Dollar Ganzzahl
     * @return Wechselkurs codiert als String
     */
    private String convertToString(long exchangeRate) {
        // this.digit gives no information about how many
        // digits are infront of the deciaml point;
        // atleast one (0,001)
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

        // creat String with all digits infront of the decimal point
        while (euroPointer < centPointer) {
            infrontOf += digit[euroPointer];
            euroPointer++;
        }

        // creat String with all digits behind the decimal point
        while ((centPointer) < digit.length) {
            behindOf += digit[centPointer];
            centPointer++;
        }

        return "" + infrontOf + "," + behindOf;
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
