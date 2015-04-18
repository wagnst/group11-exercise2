package de.wagnst.tpe.exercises.exercise2.master;

import java.util.Arrays;

/**
 * Currency manages special operations on existing Currencies. Every Currency
 * has a name, code, exchange rate and an information if it got a subunit
 *
 * @author maxGross
 */
public final class Currency {

    private String name;
    private String code;
    private long exchangeRate;
    private boolean subunit;
    // accuracy after the decimal point
    private int accurancy = 4;

    /**
     * Creates a new currency from the given parameters
     * @param name name of the currency as String
     * @param code short code of the currency
     * @param exchangeRate exchange rate of the currency compared to dollar
     * @param subunit is a subunit?
     */
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
     * @param toCurrency currency to convert into
     * @return converted amount
     */
    public long convert(long amount, Currency toCurrency) {

        return amount * this.exchangeRate / toCurrency.exchangeRate;
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
     * adds missing zeroes for exchange rate Format "#,####"
     *
     * @return filled exchange rate
     */
    private String fill() {
        String result = ",";
        // count how many zeroes to add
        long behind = this.exchangeRate % (long) Math.pow(10, this.accurancy);
        long count = this.accurancy - String.valueOf(behind).length();

        for (int i = 0; i < count; i++) {
            result += "0";
        }
        return result;
    }

    /**
     * converts exchange rate into string
     *
     * @param exchangeRate exchange rate : dollar
     * @return string exchange rate
     */
    private String convertToString(long exchangeRate) {
        long behind = this.exchangeRate % (long) Math.pow(10, this.accurancy);
        long infront = this.exchangeRate / (long) Math.pow(10, this.accurancy);

        return "" + infront + fill() + behind;
    }

    /**
     * @return String of the currency
     */
    public String toString() {
        return "" + name + " [" + code + "] 1 $ = "
                + convertToString(this.exchangeRate) + " " + code;
    }

    /**
     * generates hashcode based on class Arrays
     *
     * @return returns hashcode
     */
    public int hashCode() {
        return Arrays.hashCode(new double[]{this.exchangeRate,
                String.valueOf(this.name).length()});
    }

    /**
     * compares if two objects are equal
     *
     * @param o object to compare
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        } else if (o instanceof Currency) {
            return (this.name.equals(((Currency) o).getName()))
                    && this.code.equals(((Currency) o).getCode())
                    && this.exchangeRate == ((Currency) o).getExchangeRate()
                    && (this.subunit == ((Currency) o).hasSubunit());
        } else {
            return false;
        }
    }
}
