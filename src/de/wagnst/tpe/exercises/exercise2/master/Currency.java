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
     *            Wechselkurs zum Dollar Ganzzahl
     * @return Wechselkurs codiert als String
     */
    private String convertToString(long exchangeRate) {
        int size = this.digit;
        String euro = "";
        String cent = "";

        // counting digits infront of the deciaml point; save this Information
        // at variable size
        while ((exchangeRate / (int) Math.pow(10, size + 1)) > 0) {
            size++;
        }

        // creat array with space for all digits
        long[] digit = new long[size + 1];

        // digits get set into the array
        for (int i = size; i >= 0; i--) {
            digit[i] = exchangeRate % 10;
            exchangeRate /= 10;
        }
        int centPointer = size + 1 - this.digit;
        int euroPointer = 0;

        // creat String of digits infront of the decimal point
        while (euroPointer < centPointer) {
            euro += digit[euroPointer];
            euroPointer++;
        }

        // creat Sting of digits behind the decimal point

        while ((centPointer) < digit.length) {
            cent += digit[centPointer];
            centPointer++;
        }

        return "" + euro + "," + cent;
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
