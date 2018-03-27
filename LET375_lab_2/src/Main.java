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

         // ASSIGMENT 2
         // Test print for an empty list
         print(names);

         // Test print for a list containing one element
         names.add("a");
         print(names);

         // Test print for a list containing more than one elment
         names.add("b");
         names.add("c");
         names.add("d");
         print(names);
         
         // ASSIGNMENT 3
         // Test the return value from reverse
         print(reverse(names));

         // Test that reverse mutates its argument
         print(names);

         
         // ASSIGNMENT 4: Write code to test less here 
         IntegerComparator intcomp = new IntegerComparator();
         StringComparator stringcomp = new StringComparator();

         // Initiate arrays
         Integer[] temp1 = {4,2,5,1,3};
         Integer[] temp2 = {8,6,7,9};
         Integer[] temp3 = {97,5,123,18};
         String[] temp4 = {"HC2", "ED", "HC3"};
         String[] temp5 = {"Saga", "Svea", "Jupiter"};

         // Convert to Lists. Quicker than adding separate elements.
         List<Integer> list1 = Arrays.asList(temp1);
         List<Integer> list2 = Arrays.asList(temp2);
         List<Integer> list3 = Arrays.asList(temp3);
         List<String> johanneberg = Arrays.asList(temp4);
         List<String> campusLindholmen = Arrays.asList(temp5);
         
         List<Boolean> resultsIntComp = new ArrayList<Boolean>();
         resultsIntComp.add(less(list1,list2,intcomp)); // should return true
         resultsIntComp.add(less(list1,list3,intcomp)); // should return false
         resultsIntComp.add(less(list2,list3,intcomp)); // should return false
         resultsIntComp.add(less(johanneberg,campusLindholmen,stringcomp)); // should return true
         
         print(resultsIntComp);
         
         
         // ASSIGNMENT 5: Write code to test map here
         List<Double> mTestList = new ArrayList<Double>();
         mTestList.add(1.1); // is greater than 0 --> return 1
         mTestList.add(56.7); // is greater than 0 --> return 1
         mTestList.add(-0.1); // is less than 0 --> return -1
         mTestList.add(0.0); // is equal to 0 --> return 0
         mTestList.add(0.001); // is greater than 0 --> return 1
         
         Collection<Integer> resultsMapTestList = map(new Sign(), mTestList);
         print(resultsMapTestList);
         
         // ASSIGNMENT 5: Write code to test filter here
         List<Integer> fTestList = new ArrayList<Integer>();
         fTestList.add(9001); // is odd --> won't be returned
         fTestList.add(2); // is even --> will be returned
         fTestList.add(7); // is odd --> won't be returned
         fTestList.add(8); // is even --> will be returned
         fTestList.add(104); // is even --> will be returned
         
         Collection<Integer> resultsFilterTestList = filter(new IsEven(), fTestList);
         print(resultsFilterTestList);
         
         
         // ASSIGNMENT 6: Write code using lambdas here.
         ArrayList<Person> pl = new ArrayList<>();
         pl.add(new Person("Nisse","nisse@hipnet.moc","male",23));
         pl.add(new Person("Lisa","lisa@shipnet.sea","female",67)); // Email should be returned
         pl.add(new Person("Ada","ada@jahuu.vanu","female",49));
         pl.add(new Person("Kal","karl@gotnet.vg","male",78));
         pl.add(new Person("Beda","beda@fishnet.cod","female",102)); // Kind old lady Beda, ofc email should be returned!
         
         // 1) Create function object by lambda expression
         Predicate<Person> p = person -> ( person.getGender() == "female" && person.getAge() > 65);
         
         // 2) Filter out every woman older than 65
         Collection<Person> c = filter(p, pl);
         
         // 3) Retrieve email addresses from filtered list 
         Function<Person, String> f = person -> person.getEmail();
         Collection<String> emails = map(f,c);
         
         // 4) Print out email addresses
         print(emails);
    }
}






