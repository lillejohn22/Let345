import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.function.*;

import collection.*;
import static collection.CollectionOps.*; // Use static methods without the "Collection." prefix

public class Main {
    public static void main(String[] args) {    
         ArrayList<String> names = new ArrayList<String>();

         // Test print for an empty list
         print(names); System.out.println();

         // Test print for a list containing one element
         names.add("a");
         print(names); System.out.println();

         // Test print for a list containing more than one elment
         names.add("b");
         names.add("c");
         print(names); System.out.println();
         
         // Test the return value from reverse
         print(reverse(names));
         System.out.println();
         // Test that reverse mutates its argument
         print(names);
         System.out.println();

         
         
         // Assignment 4: Write code to test less here 
         IntegerComparator intcomp = new IntegerComparator();
         List<Integer> list1 = new LinkedList<Integer>();
         list1.add(1);
         list1.add(2);
         list1.add(3);
         List<Integer> list2 = new LinkedList<Integer>();
         list2.add(6);
         
         List<String> campusLindholmen = new LinkedList(); 
         campusLindholmen.add("he");
         campusLindholmen.add("123");
         campusLindholmen.add("234");
         campusLindholmen.add("345");
         campusLindholmen.add("456");
         List<String> a = new LinkedList();
         a.add("22as");
         a.add("2jfgh2as");
         a.add("2sss");
         a.add("22aasdas");
         
         System.out.println(less(list1,list2,intcomp));
         
         
         // Assignment 5: Write code to test map here
             
         // Assignment 5: Write code to test filter here

//         ArrayList<Person> pl = new ArrayList<>();
//         pl.add(new Person("Nisse","nisse@hipnet.moc","male",23));
//         pl.add(new Person("Lisa","lisa@shipnet.sea","female",67));
//         pl.add(new Person("Ada","ada@jahuu.vanu","female",49));
//         pl.add(new Person("Kal","karl@gotnet.vg","male",78));
//         pl.add(new Person("Beda","beda@fishnet.cod","female",102));
        
         // Assignment 6: Write code using lambdas here
    }
}
