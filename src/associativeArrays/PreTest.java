package associativeArrays;

import java.util.function.BiConsumer;

public class PreTest {

    public static void main(String[] args) {
        //Array erzeugen 
        GenericAssociativeArray<String,Integer> array1 = new GenericAssociativeArray("IP-Adresse Zuhause", 192168178);
       //Werte in das Array einfügen
       array1.put("IP-Adresse Bookmark", 1731941161);
       array1.put("IP-Adresse Server", 276194616);
       array1.put("IP-Adresse Router", 192168178);
       array1.put("IP-Adresse Chev Chelios PC", 19217801);
       array1.put("IP-Adresse Handy",4567709);
       //Funktion des zu übergebenen BiConsumer festlegen 
       BiConsumer <String,Integer>print = (x,y)-> {
           System.out.println(x+" "+y+"  ");
       };
       //Ausgabe des gesamten Arrays
       array1.forEach(print);
       System.out.println("Test1 vorbei");
       
       //Knoten entfernen 
       array1.remove("IP-Adresse Bookmark");
       array1.forEach(print);
       System.out.println("Test2 vorbei");
       
       //Neues Array erzeugen und Anhängen
       GenericAssociativeArray<String,Integer> array2 = null;
       System.out.println(array2.isEmpty()); //Überprüfen !!!!!!!!!
       
       System.out.println("Test3 vorbei");
       array2.put("IP Adresse MI6",007);
       array2.forEach(print);
       //Array1 an Array2 anfügen 
       array2.putAll(array1);//Methode scheinbar Fehlerhaft!!!!!!!!
       //Array 2 Ausgeben 
       array2.forEach(print);
       System.out.println("Test4 vorbei");
       
       
       
       
    }

}
