package de.wagnst.tpe.exercises.exercise2.master;

/**
 * Currency manages special operations on existing Currencies. Every Currency
 * has a name, code, exchange rate and an information if it got a subunit
 * <p>
 * New instances can be created with the help of the constructor
 * <pre>
 * Currency currency = new Currency("Dollar", "$", 10000, true);
 * </pre>
 * Objects of this class are immutable. The methods don't change the state of
 * their object, but return a new object.
 *
 * @author Maximilian Groß, Steffen Wagner, Katharina Spinner
 */
public final class Currency {

    /* long name of currency (e.g. EURO) */
    private final String name;
    /* short code of currency (e.g. €) */
    private final String code;
    /* exchange rate compared to US dollar */
    private final long exchangeRate;
    /* state of unit concerning decimal places */
    private final boolean subunit;
    /* accuracy after the decimal point */
    private final int accuracy = 4;

    /**
     * Creates a new currency from the given parameters
     *
     * @param name         name of the currency as String
     * @param code         short code of the currency
     * @param exchangeRate exchange rate of the currency compared to dollar
     * @param subunit      if currency has no commas
     */
    public Currency(String name, String code, long exchangeRate, boolean subunit) {
        this.name = name;
        this.code = code;
        this.exchangeRate = exchangeRate;
        this.subunit = subunit;
    }

    /**
     * Converts amount into other currency
     *
     * @param amount     amount to convert
     * @param toCurrency currency to convert into
     * @return converted amount
     */
    public long convert(long amount, Currency toCurrency) {
        return amount * exchangeRate / toCurrency.exchangeRate;
    }

    /**
     * Returns the exchange rate compared to dollar
     *
     * @return the exchange rate of this instance
     */
    public long getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Returns the name of the currency
     *
     * @return name of currency
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the short code of the currency
     *
     * @return short code
     */
    public String getCode() {
        return code;
    }

    /**
     * Returns true if currency is a subunit or false if not This means, that
     * the currency doesn't have decimal places
     *
     * @return true for subunit, false no subunit
     */
    public boolean hasSubunit() {
        return subunit;
    }

    /**
     * Returns the accuracy of decimal places, which will be used to recalculate
     * the saved long values
     *
     * @return accuracy of decimal places
     */
    public int getAccuracy() {
        return accuracy;
    }

    /**
     * Adds missing zeroes for exchange rate Format "#,####"
     *
     * @return filled exchange rate
     */
    private String fill() {
        String result = ",";
        /* count how many zeroes to add */
        long behind = exchangeRate % (long) Math.pow(10, accuracy);
        long count = accuracy - String.valueOf(behind).length();

        for (int i = 0; i < count; i++) {
            result += "0";
        }

        return result;
    }

    /**
     * Converts exchange rate into string
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
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "" + name + " [" + code + "] 1 $ = "
                + convertToString(this.exchangeRate) + " " + code;
    }

    /**
     * Generates hashcode based prime numbers and different operations
     *
     * @return returns hashcode
     * @see java.lang.Object#hashCode()
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
     * Compares if two objects are equal
     *
     * @param o object to compare
     * @return boolean
     * @see java.lang.Object#equals(java.lang.Object)
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
