package de.wagnst.tpe.exercises.exercise2;

public class Currencies {

    /** US-Dollar */
    public static final Currency DOLLAR = new Currency("Dollar", "$", 10000,
            false);
    /** EURO */
    public static final Currency EURO = new Currency("Euro", "€", 12690, false);

    /** Japanischer Yen */
    public static final Currency YEN = new Currency("Yen", "¥", 91, false);

    /** Rubel der russischen FÃ¶deration */
    public static final Currency RUBEL = new Currency("Rubel", "RUB", 255,
            false);

    /** Schweizer Franken */
    public static final Currency CHF = new Currency("Schweizer Franken",
            "CHF)", 10509, false);
}
