package de.wagnst.tpe.exercises.exercise2.master;

/**
 * enthält vorgefertigte Objekte von Währungen mit den jeweiligen Wechselkursen,
 * damit man diese einfach innerhalb des Programms wiederverwenden kann.
 *
 * @author Max
 */
public final class Currencies {

    /**
     * US-Dollar
     */
    public static final Currency DOLLAR = new Currency("Dollar", "$", 10000,
            true);
    /**
     * EURO
     */
    public static final Currency EURO = new Currency("Euro", "€", 12690, true);

    /**
     * Japanischer Yen
     */
    public static final Currency YEN = new Currency("Yen", "¥", 91, false);

    /**
     * Rubel der russischen Föderation
     */
    public static final Currency RUBEL = new Currency("Rubel", "RUB", 255,
            false);

    /**
     * Schweizer Franken
     */
    public static final Currency CHF = new Currency("Schweizer Franken", "CHF",
            10509, true);
}
