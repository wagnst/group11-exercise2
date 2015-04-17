package de.wagnst.tpe.exercises.exercise2.master;

/**
 * contains defined objects of currency with its exchange rate to dollar,
 * name, currency symbol and an information if it has a subunit 
 *
 * @author maxGross, wagnst
 */
public final class Currencies {

    /**
     * Definition of exchange rates to basis dollar
     */
    private static final int EXCHANGE_DOLLAR = 10000;
    private static final int EXCHANGE_EURO = 12690;
    private static final int EXCHANGE_YEN = 91;
    private static final int EXCHANGE_RUBEL = 255;
    private static final int EXCHANGE_CHF = 10509;
    

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
     * Japanischer Yen
     */
    public static final Currency YEN = new Currency("Yen", "¥", EXCHANGE_YEN,
            false);

    /**
     * Rubel der russischen Föderation
     */
    public static final Currency RUBEL = new Currency("Rubel", "RUB",
            EXCHANGE_RUBEL, false);

    /**
     * Schweizer Franken
     */
    public static final Currency CHF = new Currency("Schweizer Franken", "CHF",
            EXCHANGE_CHF, true);

}
