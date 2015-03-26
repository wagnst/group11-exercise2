# Pflichtübung 2: Devisenkonto [100 Punkte]

Nachdem Ihre letzte Software zwar wunderbar funktioniert hat, Pagan Min aber wegen anderer Ereignisse sehr böse auf sie war, mussten Sie schleunigst aus Kyrat fliehen. Es ist Ihnen gelungen, sich auf ein Frachtschiff zu schmuggeln, das aber leider bei der Überfahrt in Seenot gerät und sinkt. Mitten im Meer erblicken Sie einen Leuchtturm, zu dem Sie sich retten können. Dort treffen Sie auf einen seltsamen Menschen namens Andrew Ryan, der Ihnen eine Anstellung bei der _Rapture Bank Corporation_ verschafft. Diese Bank zeichnet sich durch erstklassige Beziehungen nach Nord-Korea und ihr internationales Engagement aus. Kurz nach Ihrem ersten Arbeitstag kommen Ihnen Gerüchte zu Ohren, dass der Vorstandsvorsitzende der Bank, Louis Cyphre, sehr ruppig mit Mitarbeitern umgeht, die schlechte oder fehlerhafte Software entwickeln. Besonderen Wert legt er auf sauberen Programmierstil und gute Tests. Hierdurch mehr als motiviert, stürzen Sie sich sofort in die Arbeit. Ihre erste Aufgabe ist die Implementierung einer Software zur Kontenverwaltung für die Bank.

Da die Bank international tätig ist, muss zu jedem Betrag bekannt sein, in welcher Währung er vorliegt. Beträge (einschließlich der dazugehörigen Währung) werden von einer speziellen Klasse `Amount` verwaltet. Die Daten zu einer Währung (z.B. Wechselkurs) liegen in der Klasse `Currency`. Ein Konto bei der Bank wird durch die Klasse `Account` repräsentiert.

Im Bereich finanzmathematischer Berechnungen setzt man normalerweise keine Fließkommazahlen ein, da diese durch Rundungsfehler zu ungenauen Ergebnissen führen. Verwenden Sie daher bei allen folgende Klassen für die Darstellung von Geldbeträgen grundsätzlich den Datentyp `long` und speichern Sie die Daten mit einer Genauigkeit von vier Nachkommastellen, d.h. dass zum Beispiel ein Betrag von `19,45` als `194500` gespeichert wird. Bereiten Sie die Klassen aber so vor, dass man die Genauigkeit später erhöhen oder senken kann.

Bitte geben Sie sich ein **Paktbenennungsschema** und wenden Sie dieses für diese und alle folgenden Aufgaben an.


## Verwaltung von Währungen

Schreiben Sie eine Klasse `Currency`, die folgende Informationen zu einer Währung verwalten kann:

  * Name der Währung (`name`), z.B. Euro oder Rubel
  * Kürzel der Währung (`code`), z.B. € oder RUB
  * Wechselkurs zum Dollar (`exchangeRate`) mit einer Genauigkeit von 4 Stellen hinter dem Komma
  * Information, ob die Währung eine Untereinheit hat oder nicht (`subunit`)

Die Daten sollen über den Konstruktor in das Objekt gelangen und danach nicht mehr verändert werden können, d.h. die Klasse soll _immutable_ sein. Über entsprechende Methoden (`getCode()`, `getExchangeRate()`, `getName()`, `hasSubunit()`) können die Informationen wieder ausgelesen werden.

Weiterhin soll es eine Methode `convert(...)` geben, mit der man Beträge von einer Währung in eine andere umrechnen kann. Hierzu wird eine Betrag als `long` und eine Zielwährung übergeben und die Methode gibt den umgerechneten Betrag wieder als `long` zurück. Um nicht den Wechselkurs zwischen allen Währungen speichern zu müssen, werden verschiedene Währungen immer über den Dollar umgerechnet. Sie rechnen also zuerst den Betrag in Dollar um und danach in die Zielwährung.

Weiterhin besitzt die Klasse noch drei weitere Methoden:

  * `toString()` - gibt die Informationen zur Währung als String zurück. Die Ausgabe soll den Namen der Währung, das Kürzel und den Wechselkurs (mit vier Nachkommastellen) enthalten. Eine beispielhafte Ausgabe sähe wie folgt aus: `Rubel [RUB] 1 $ = 0,0254 RUB`
  * `equals(Object o)` - vergleicht den Inhalt des Objekts mit einem anderen. Sie können sich die Methode von Eclipse generieren lassen.
  * `hashCode()` - berechnet einen Hash-Wert über das Objekt. Sie können sich die Methode von Eclipse generieren lassen.

## Liste von Währungen

Schreiben Sie eine Klasse `Currencies`, die vorgefertigte Objekte von Währungen mit den jeweiligen Wechselkursen enthält, damit man diese einfach innerhalb des Programms wiederverwenden kann.

Folgende Währungen sind vorgegeben (jeweils mit Kurs zum Dollar):

  * US-Dollar ($) 1,0000
  * Euro (€) 1,2690
  * Yen  (¥) 0,0091
  * Rubel (RUB) 0,0255
  * Schweizer Franken (CHF) 1,0509

## Verwaltung von Beträgen

Die Beträge werden durch die Klasse `Amount` realisiert. 

Die Klasse hat folgende Eigenschaften:

  * Die Objekte der Klasse sind _unveränderlich (immutable)_, d.h. die Daten eines Objekts können nach der Erzeugung nicht mehr verändert werden.
  * Beim Anlegen eines Objektes muss man sowohl den Betrag als auch die Währung angeben. Man kann den Betrag entweder als `double` mit Kommastellen angeben oder als `long`, wobei dann die Angabe gemäß der vorgegebenen Genauigkeit von 4 Nachkommastellen erfolgt. Ein Betrag von 19,80 € würde also als 198000 angegeben. Der Betrag wird (wie bereits erwähnt) intern immer als `long` gespeichert. Wird er als `double` angegeben, werden nur maximal zwei Nachkommastellen berücksichtigt, weitere Stellen werden einfach abgeschnitten (nicht gerundet).
  * Die Klasse kann sowohl positive als auch negative Beträge verwalten. Um festzustellen, ob der Betrag negativ ist, kann man die Methode `getSign()` aufrufen, die entweder `1` für positiv oder `-1` für negative Werte zurückgibt.
  * Die Klasse bietet elementare arithmetische Operationen an, die weiter unten beschrieben werden.

Implementieren Sie bitte die folgenden Methoden in der Klasse `Amount` (Methodennamen in Klammern):

  * Addieren zweier Beträge (`add(...)`)
  * Subtrahieren zweier Beträge (`subtract(...)`)
  * Multiplizieren eines Beträge mit einem `double`-Wert (`multiply(...)`)
  * Multiplizieren eines Beträge mit einem `int`-Wert (`multiply(...)`)
  * Berechnen eines Prozentwertes von einem Betrag (`prozent(...)`)
  * Auslesen des Wertes als `long` (`toLong()`). Das Vorzeichen wird hier _nicht_ berücksichtigt. Beachten Sie, dass Sie nur zwei Nachkommastellen ausgeben sollen, egal wie viele Stellen die Klasse intern verwendet. 10,00 € werden also als 1000 zurückgegeben.
  * Auslesen des gesamten Wertes als String mit Währungsangabe und führender Null bei Werten kleiner als 1. Das Vorzeichen wird bei negativen Beträgen ebenfalls mit ausgegeben. Bei Währungen ohne Untereinheit (z.B. Yen), werden keine Nachkommastellen ausgegeben. Zum Beispiel `0,99 €`, `12,90 €`, `11,00 €`, `-0,09 RUB`, `9818 ¥` oder `0,00 CHF`. (`toString()`)
  * Konvertieren der Zahl in ein `double`-Wert, wobei aber nur zwei Nachkommastellen im zurück gegebenen Wert vorhanden sein dürfen (`toDouble()`)
  * Vergleich zweier Beträge auf Gleichheit, wobei zwei Zahlen nur gleich sind, wenn sie in Betrag und Währung übereinstimmen (`equals(...)`). Sie können sich diese Methode von Eclipse generieren lassen.

## Konto

Implementieren Sie eine Klasse `Account`, die Buchungen verwalten kann. Jedes Konto hat einen Inhaber (`owner`, `getOwner()`) und eine Währung, auf die das Konto lautet (`currency`, `getCurrency()`).

Über die Methode `post(...)` können Beträge auf das Konto gebucht werden (positive wie negative). Wenn der gebuchte Betrag in einer Fremdwährung erfolgt, d.h. in einer Währung, die von der Kontowährung abweicht, wird der Betrag automatisch zum jeweiligen Wechselkurs in die Kontowährung umgerechnet.

Mit der Methode `total()` kann man das Saldo auf dem Konto abfragen, d.h. die Summe aller Buchungen.

Über die Methode `accountFee(...)` kann die Bank automatisch einen gewissen Promillesatz an Gebühren vom Konto abziehen. Damit ergibt sich die Gebühr als das Produkt aus Saldo und Promillesatz.

Die Methode `toString()` erlaubt es, einen Auszug des Kontos zu bekommen. Dieser soll sich an folgendem Beispiel orientieren:


    Kontoinhaber: Peter Lustig
    Währung: US-Dollar
    ---------
    10,00 $
    20,00 $
    33,33 $
    -10,00 $
    -0,79 $
    ---------
    Saldo: 52,54 $


## Tests

Überprüfen Sie die Funktionalität Ihrer Implementierung mit entsprechenden JUnit-Tests und weise Sie mit diesen Tests nach, dass die implementierten Operationen richtig funktionieren.

## Tipps

Bitte beachten Sie folgendes, damit es nicht zu unnötigen Punktabzügen in der Bewertung kommt:

  * Benennen Sie Klassen und Methoden konsistent und verständlich. Klassen sollten Nomen als Namen, Methoden Verben haben.
  * Dokumentieren Sie alle Klassen, Interfaces, Konstruktoren und Methoden mit JavaDoc. Dokumentieren Sie auch alle Parameter, Rückgabewerte und Ausnahmen.
  * Formatieren Sie Ihren Code konsistent. Ein guter Standard sind 4 Spaces Einrückung pro Ebene ohne Verwendung von Tabulatoren.
  * Halten Sie sich an die Sun [Java-Code-Convention](http://www.oracle.com/technetwork/java/codeconventions-150003.pdf)
  * Programmieren Sie defensiv und testen Sie Eingabewerte auf deren Gültigkeit. Ihr Programm darf auch mit Daten nicht abstürzen, die außerhalb der Aufgabenstellung liegen.
  * Machen Sie keine Konsoleneingaben oder -Ausgaben, es sei denn die Aufgabe fordert dies explizit.
  * Halten Sie Daten und Methoden zusammen. Trennen Sie diese nicht unnötig auf.
  * Kopieren Sie keinen Code sondern versuchen Sie mit den bekannten Mitteln der Objektorientierung Code-Duplikate zu vermeiden.
