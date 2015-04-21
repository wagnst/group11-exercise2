package de.wagnst.tpe.exercises.exercise2.master;

/**
 * Contains defined objects of currency with its exchange rate to dollar, name,
 * currency symbol and an information if it has a subunit
 * <p>
 * This class could normally better be replaces with a enum, because it does not
 * use the features of a class. It simply creates currencies with the help of
 * the Currency class.
 *
 * @author maxGross, wagnst
 */
public final class Currencies {

    /**
     * Definition of exchange rates to basis dollar
     */
    private static final long EXCHANGE_DOLLAR = 10000;
    private static final long EXCHANGE_EURO = 12690;
    private static final long EXCHANGE_YEN = 91;
    private static final long EXCHANGE_RUBEL = 255;
    private static final long EXCHANGE_CHF = 10509;

    /**
     * US-Dollar
     */
    public static final Currency DOLLAR = new Currency("Dollar", "$",
            EXCHANGE_DOLLAR, true);
    /**
     * EURO
     */
    public static final Currency EURO = new Currency("Euro", "€",
            EXCHANGE_EURO, true);

    /**
     * Japanese Yen
     */
    public static final Currency YEN = new Currency("Yen", "¥", EXCHANGE_YEN,
            false);

    /**
     * Rubel of the Russian Federation
     */
    public static final Currency RUBEL = new Currency("Rubel", "RUB",
            EXCHANGE_RUBEL, false);

    /**
     * Swiss Frank
     */
    public static final Currency CHF = new Currency("Schweizer Franken", "CHF",
            EXCHANGE_CHF, true);

}
