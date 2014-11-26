package JUnit_Test;
import java.util.function.BiConsumer;

import associativeArrays.AssociativeArray;
import associativeArrays.GenericAssociativeArray;
import static org.junit.Assert.*;

import org.junit.Test;

public class AssociativeArrayTest {

    @Test
    public void test() {
       //Array erzeugen 
       GenericAssociativeArray array1 = new GenericAssociativeArray("IP-Adresse Zuhause", 192168178);
       //Werte in das Array einfügen 
       //Test der Methode put()
       array1.put("IP-Adresse Bookmark", 1731941161);
       array1.put("IP-Adresse Server", 276194616);
       array1.put("IP-Adresse Router", 192168178);
       array1.put("IP-Adresse Chev Chelios PC", 19217801);
       array1.put("IP-Adresse Handy",4567709);
       
       //Test der Methode clear() und isEmpty()
       //Nicht Leer = false
       assertEquals(false, array1.isEmpty());
       array1.clear();
       //Ist Leer = true
       assertEquals(true, array1.isEmpty());
       
       //Test der Methode containsValue()
       
       array1.update("IP-Adresse Router",2);
       //Vorhandener Schlüssel
       assertEquals(true,array1.containsValue(2));
       //Nicht Vorhandener Schlüssel
       assertEquals(false,array1.containsValue(0));
       
       //Test der Methode containsKey
       //Schlüssel vorhanden = true
       assertEquals(true,array1.containsKey("IP-Adresse Bookmark"));
       //Schlüssel nicht vorhanden = false
       assertEquals(false,array1.containsKey("IP-Adresse Falsch"));
       
       //Test der Methode get()
       //Schlüssel: IP-Adresse Chev Chelios PC Wert: 1921780
       assertEquals( 1921780 ,array1.get("IP-Adresse Chev Chelios PC"));
       
       //Test der Methode update()
       //Schlüssel: IP-Adresse Chev Chelios PC  mit dem 
       // Wert: 1 "Updaten" 
       array1.update("IP-Adresse Chev Chelios PC", 1);
       assertEquals(1,array1.get("IP-Adresse Chev Chelios PC"));
       
       //Test der methode size()
       //array1 hat 6 Elemente 
       assertEquals(6,array1.size());
       //Neues leeres Array erzeugen 
       GenericAssociativeArray array2 = null;
       //array2 hat 0 Elemente
       assertEquals(0,array2.size());
       
       //Test der Methode remove()
       //Schlüssel: IP-Adresse Chev Chelios PC entfernen
       array1.remove("IP-Adresse Chev Chelios PC");
       //Überprüfen ob der Schlüssel und der Wert entfernt wurden
       assertEquals(false,array1.containsKey("IP-Adresse Chev Chelios PC"));
       assertEquals(false,array1.containsValue(1));
       
       //array2 "befüllen"
       array2.put("IP Adresse MI6",007);
       array2.put("IP Adresse Hochschule", 167890412);
       
       //Test der Methode putAll()
       //array1 zu array2 hinzufügen 
       array2.putAll(array1);
       //Neue größe ist 8
       assertEquals(8,array2.size());
       //Prüfen ob neue Schlüssel vorhanden sind 
       assertEquals(true,array2.containsKey("IP Adresse Hochschule"));
       assertEquals(true,array2.containsKey("IP Adresse MI6"));
       assertEquals(true,array2.containsKey("IP Adresse Zuhause"));
       assertEquals(true,array2.containsKey("IP-Adresse Bookmark"));
       assertEquals(true,array2.containsKey("IP Adresse Server"));
       assertEquals(true,array2.containsKey("IP Adresse Router"));
       assertEquals(true,array2.containsKey("IP Adresse Chev Chelios PC"));
       assertEquals(true,array2.containsKey("IP Adresse Handy"));
       
       //Prüfen der Methode extractAll()
       GenericAssociativeArray array3 = null;
       //array1 an array3 anfügen 
       array1.extractAll(array3);
       //Neue größe ist 8
       assertEquals(8,array2.size());
       //Prüfen ob neue Schlüssel vorhanden sind 
       assertEquals(true,array2.containsKey("IP Adresse Hochschule"));
       assertEquals(true,array2.containsKey("IP Adresse MI6"));
       assertEquals(true,array2.containsKey("IP Adresse Zuhause"));
       assertEquals(true,array2.containsKey("IP-Adresse Bookmark"));
       assertEquals(true,array2.containsKey("IP Adresse Server"));
       assertEquals(true,array2.containsKey("IP Adresse Router"));
       assertEquals(true,array2.containsKey("IP Adresse Chev Chelios PC"));
       assertEquals(true,array2.containsKey("IP Adresse Handy"));
       
       BiConsumer <String,Integer>print = (x,y)-> {
       System.out.println(x+" "+y+"  ");
       };
       //Ausgabe des gesamten Arrays
       array2.forEach(print);
       
    }

}
