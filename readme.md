# Lab Report

Abgabe 04

Daniel Lamprecht

Mathias Gsell

Repository: https://github.com/lamprechtdaniel/19-Abgabe04-Lamprecht-Gsell

---
## Vorgehen
---
1. Zu Beginn wurde das Repository erstellt sowie das Queue-Beispiel eingebunden
2. Das File readme.md wurde erstellt und mit den Tasks mit Github-Flavor erweitert
3. Anschließend wurde der Labreport im Readme.md hinzugefügt (die Tasklist befindet sich nun am Ende des Readme.md File)
4. Das Queue-Beispiel wurde gedebuggt, es wurden die Fehler gefunden sowie ausgebessert. Ebenso wurde der Code optimiert. Die ausgebesserten Stellen wurden kommentiert. Folgende Fehler wurden gefunden:
    - ![Bild Bug1.1](./media/bug1.1_constructor.jpg)
    Hier wurde die Variabel maxsize im Konstruktor zu "maxSize" geändert. Ebenso wurde auf die Membervariable mit this. zugegriffen, um Missverständnisse zu vermeiden.
    - ![Bild Bug1.2](./media/bug1.2_defaultConstructor.jpg)
    Ebenso wurde hier ein Default-Konstruktor hinzugefügt, um die maxSize von 5 zu behalten.
    - ![Bild Bug2](./media/bug2_pollElementSize.jpg)
    In de if-Anweisung wurde "element.size()==0" zu "element.size()>0" ausgebessert. Dies hat den Grund, dass nur ein Element entfernt werden kann, wenn mindestens eines in der Queue vorhanden ist.
    - ![Bild Bug3](./media/bug3_uselessDeclaration.jpg)
    Die Zeile "element = "" wurde entfernt, da ansonsten das Entfernte Element (welches in element sein sollte) überschrieben wird.
5. Die ausgebesserte Version des Queue-Beispiels wurde auf das Repository gepushed.
6. Anschließend werden JavaDoc-Kommentare über Klassen/Methoden erstellt um mithilfe von JavaDoc eine API-Dokumentation zu erstellen.
Die zuvor erwähnte Dokumentation wird in den folgenden Bildern dargestellt.
   - Allgemein
![Bild JavaDoc Übersicht](./media/javadoc_general.png)
   - Interface Queue
![Bild JavaDoc Interface Queue](./media/javadoc_interfaceQueue_general.png)
   - Klasse StringQueue
![Bild JavaDoc Class StringQueue](./media/javadoc_stringqueue_class_general.png)
![Bild JavaDoc Class StringQueue Spezifisch](./media/javadoc_stringqueue_class_specific.png)
   
7. Dann wurden JUnit-Testfälle erstellt, um das den Code automatisiert zu testen.
   - Tests wurden für vor Allem folgende Fälle Tests erstellt
     - Hinzufügen zu Queue wenn Queue bereits voll ist
     - Entfernen von Queue wenn Queue bereits leer ist
     - Entfernen des richtigen Elements
     - Hinzufügen an richtiger Stelle
    - Es wurde ein Line-Coverage von 100% erreicht. Dies stellt den Idealfall dar, und muss/kann aber nicht zwingend immer erreicht werden. Die anschließenden Bilder stellen den Report zum Test dar.
![Bild Surefire Report Teil 1](./media/surefirereport1.png)
![Bild Surefire Report Teil 2](./media/surefirereport2.png)

8. Im nächsten Schritt wird das pom.xml auf das Projekt angepasst, damit dieses sowohl erstellt werden kann als auch die Dokumentation erstellt werden kann. Es wurden Entwicklerinformationen hinzugefügt und Informationen für die Logging-Bibliothek hinzugefügt.

9. Anschließend wurde Log4j integriert und in jeder Methode verwendet, so dass mitgeloggt wird was gerade passiert. Grundsätzlich wird eine Instanz des Loggers erstellt und in jeder Methode diese verwendet um den aktuellen Zustand festzuhalten/zu dokumentieren.

    Das erstellen des Loggers wird in folgendem Screenshot dargestellt:
![Bild Log4j Initialisierung](./media/log4j_init.jpg)

    In einer Funktion wird es folgendermaßen aufgerufen:
![Bild Log4j Aufruf](./media/log4j_call.jpg)

    Die Ausgabe sieht folgendermaßen aus:
![Bild Log4j Ausgabe](./media/log4j_output.jpg)

10. Maven Site
Maven Site dient dazu die generierten Files darzustellen. Ein Bestandteil davon sind sowohl die JUnit-Test als auch das JavaDoc. Ebenso kann auch eine Seite (wie ebenso gefordert) manuell erstellt werden.

Die erstellte Site ist in den folgenden Screenshots ersichtlich

![Bild MavenSite Index.html](./media/mvnsite_index.png)
![Bild MavenSite Queue](./media/mvnsite_queuedescription.png)
![Bild MavenSite Reports](./media/mvnsite_reports.png)


1.  Python/Java Code mit GitHub Flavor
> **Java Code**
> ```java
>   int count = 0;
>   if (count!=0)
>       System.out.println("Count is not equal to 0!")
>   else
>       System.out.println("Count is equal to 0!")
>```

> **Python Code**
>```python
>   #!/usr/bin/python
>   count=0
>   if count!=0:
>       print("Count is not equal to 0!")
>   else:
>       print("Count is equal to 0!")
>```


## Links/Literatur
---
- [Dokumentation Maven Site Plugin](https://maven.apache.org/plugins/maven-site-plugin/)
- [How To Write JavaDoc](http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html)
- [Collections JavaDoc Example](http://www.docjar.net/html/api/java/util/Collections.java.html)
- [Online Markdown Editor](https://dillinger.io/)
- [GitHub Flavored Markdown](https://github.github.com/gfm/)
- [Github Flavored Markdown Code](http://www.rubycoloredglasses.com/2013/04/languages-supported-by-github-flavored-markdown/)
- [Apache log4j](https://logging.apache.org/log4j/2.x/maven-artifacts.html)
- [Log4j2 Beispiel](https://kodehelp.com/log4j2-configuration-file-examples/)
- Vorlesungsfolien


# Taskliste Lamprecht/Gsell

- [x] Übertragen Angabe Taskliste in Markdown Readme

- [x] Einspielen Queue Vorlage aus Repository: https://github.com/michaelulm/software-
configuration-management/tree/master/test-automation/Queue

- [x] Taskergebnisse Schritt für Schritt auf Git stellen
  - [x] Führung Taskliste
  - [x] Veröffentlichung in Git mit aktuell durchgeführten Tätigkeiten, z.B. Testfälle geschrieben so wird auch in der Taskliste diese Aufgabe als erledigt markiert und Testfälle inkl. geänderter Taskliste ins Repository übertragen.

- [x] Korrigieren Sie den Code bzw. Debuggen Sie ihn um die Fehler zu finden
  - [x] Es befinden sich gesamt 3 Fehler im Source Code.
  - [x] Bei Bedarf Optimieren Sie das Queue Beispiel.
  - [x] Ergänzen Sie das Beispiel nach eigenen Ermessen um es testen zu können.

- [x] Erstellen Sie für Klasse und alle Methoden Kommentare um mittels Javadoc eine API Dokumentation zu erzeugen
  - [x] Integrieren Sie ein Bild (der generierten Dokumentation) in Ihren Report

- [x] Erstellung JUnit Tests (vollständig testen, mehrere Varianten)
  - [x] Sie werden die „selben“ Testfälle mehrfach erstellen müssen um „mehrere Variationen“ für einen möglichst vollständigen Test zu erreichen. Achten Sie dabei mit unterschiedlichen Daten zu testen.
  - [x] JavaDoc Kommentare erstellen.
  - [x] Integrieren Sie ein Bild (der generierten Dokumentation) in Ihren Report.

- [x] Passen Sie Ihr pom.xml auf das Projekt an, damit Sie das Projekt erstellen aber auch Dokumentation generieren können.
  - [x] EntwicklerInnen Informationen hinzufügen.
  - [x] Integration Logging Bibliothek log4j mittels Maven Dependencies.


- [x] Log4j (Version 2) integrieren und in jeder Methode ins Log schreiben
  - [x] Siehe aktualisiertes Stack Beispiel.
  - [x] Erstellen Sie einen Statischen Logger der auf die Konsole schreibt.
  - [x] Konfigurieren Sie Logger über ein properties File.
  - [x] Geben Sie eine Info Lognachricht bei Aufruf einer jeden Methode aus.
  - [x] Geben Sie eine Error Lognachricht aus bevor Sie einen Fehler werfen.
  - [x] Ergebnisse (Konsolenausgabe) als Bild in Dokumentation einfließen lassen.

- [x] Maven Site Dokumentation erstellen
  - [x] Inklusive Javadoc Code und Javadoc Test Klassen
  - [x] Inklusive Menü mit Verweis auf manuell erstellte Seite
      - [x] Seite erläutert Funktionsweise Queue
  - [x] Geben Sie ein Bild der Maven Site Dokumentation in den Lab Report
      - [x] Der Inhalt der manuell erstellten Seite sollte ersichtlich sein

- [x] Erstellung detaillierter und nachvollziehbarer Markdown Lab Report
  - [x] Übertragung Information aus Labreport Template.
  - [x] Alle Schritte dieser Übung nachvollziehbar erläutern.
  - [x] Übung Github Flavor: Erstellen Sie einen Codeblock im Dokument welcher 3 Zeilen Python und 3 Zeilen Java Source Code korrekt darstellt.
  - [x] Korrekturlesen Dokumentation
  - [x] PDF erstellen (zB Dillinger)

- [x] Überprüfung Vollständigkeit der Abgabe

- [x] Abgabe PDF Version der Abgabe
