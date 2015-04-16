package de.wagnst.tpe.exercises.exercise2.master;

import java.util.Arrays;

/**
 * LOREM IPSUM
 *
 * @author maxGross
 */
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
     * converts amount into other currency
     *
     * @param amount     amount to convert
     * @param toCurrency currency to convert to
     * @return converted amount
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
     * converts exchange rate into string
     *
     * @param exchangeRate exchange rate : dollar
     * @return string exchange rate
     */

    private String convertToString(long exchangeRate) {
        return null;
    }
    /*
    private String convertToString(long exchangeRate) {
        // at least one digit in front of the decimal point (this.digit + 1)
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
*/

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
     * @return boolean
     * @override
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o instanceof Currency) {
            return (this.name.equals(((Currency) o).getName())) && this.code.equals(((Currency) o).getCode()) &&
                    this.exchangeRate == ((Currency) o).getExchangeRate() && (this.subunit == ((Currency) o).hasSubunit());
        } else {
            return false;
        }
    }
}
