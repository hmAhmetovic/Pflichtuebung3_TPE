package JUnit_Test;

import static org.junit.Assert.*;

import org.junit.Test;

import associativeArrays.Dictionary;

public class DictonaryTest {

    @Test
    public void test() {
       Dictionary dictionary = new Dictionary("Todeseuter", "Hallo");
       dictionary.put("Mustafa", "Yildiz");
       dictionary.put("Lala", "Lulu");
       dictionary.put("Christopher", "Hansen");
       
       
       String[] keys = new String[4];
       keys[0] = "Todeseuter";
       keys[1] = "Mustafa";
       keys[2] = "Lala";
       keys[3] = "Christopher";
       
       // Testet das angefertigte Key Array
       assertArrayEquals(keys, dictionary.keys() );
       
       
       String[] values = new String[4];
       values[0] = "Hallo";
       values[1] = "Yildiz";
       values[2] = "Lulu";
       values[3] = "Hansen";
      
       // Testet das angefertige Values Array
       assertArrayEquals(values, dictionary.values());
       
       
    }

}
