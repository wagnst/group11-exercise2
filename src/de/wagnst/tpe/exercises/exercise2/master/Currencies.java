package de.wagnst.tpe.exercises.exercise2.master;

/**
 * enthält vorgefertigte Objekte von Währungen mit den jeweiligen Wechselkursen,
 * damit man diese einfach innerhalb des Programms wiederverwenden kann.
 * 
 * @author Max
 *
 */
public final class Currencies {

    /** US-Dollar */
    public static final Currency DOLLAR = new Currency("Dollar", "$", 10000);
    /** EURO */
    public static final Currency EURO = new Currency("Euro", "€", 12690);

    /** Japanischer Yen */
    public static final Currency YEN = new Currency("Yen", "¥", 91);

    /** Rubel der russischen FÃ¶deration */
    public static final Currency RUBEL = new Currency("Rubel", "RUB", 255);

    /** Schweizer Franken */
    public static final Currency CHF = new Currency("Schweizer Franken", "CHF",
            10509);
}
