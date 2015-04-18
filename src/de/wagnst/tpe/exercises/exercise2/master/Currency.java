package de.wagnst.tpe.exercises.exercise2.master;

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
    private int accuracy = 4;

    /**
     * Creates a new currency from the given parameters
     *
     * @param name         name of the currency as String
     * @param code         short code of the currency
     * @param exchangeRate exchange rate of the currency compared to dollar
     * @param subunit      is a subunit?
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
        return amount * exchangeRate / toCurrency.exchangeRate;
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
        long behind = exchangeRate % (long) Math.pow(10, accuracy);
        long count = accuracy - String.valueOf(behind).length();

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
        long behind = exchangeRate % (long) Math.pow(10, accuracy);
        long inFront = exchangeRate / (long) Math.pow(10, accuracy);

        return "" + inFront + fill() + behind;
    }

    /**
     * @return String of the currency
     */
    public String toString() {
        return "" + name + " [" + code + "] 1 $ = "
                + convertToString(this.exchangeRate) + " " + code;
    }

    /**
     * generates hashcode based prime numbers and different operations
     *
     * @return returns hashcode
     */
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + (int) (exchangeRate ^ (exchangeRate >>> 32));
        result = 31 * result + (subunit ? 1 : 0);
        result = 31 * result + accuracy;
        return result;
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
