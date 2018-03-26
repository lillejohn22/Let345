package collection;


// Skriv en generisk (statisk) klassmetod print som skriver ut elementen i en objektsamling:     
// public static <T> void print(Collection<T> l) Om samlingen inneh�ller elementen a, b och c s� 
// skall utskriften ha formen [a,b,c] och [] om samlingen �r tom. Placera metoden i klassen CollectionOps 
// och skriv testfall f�r den i main. Du f�r anta att samlingens elementtyp har en toString-metod, men 
// inte att hela samlingen har en s�dan. Studera f�rst typen java.util.Collection i Java API. Tips: 
// Samlingar �r itererbara.


import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.*;
import singleBuffer.*;

public class CollectionOps {
	
	public static <T> void print(Collection<T> l) {
		System.out.print("[");
		for (T temp : l)
			System.out.print(temp.toString() + ",");
		System.out.print("]");
	}
    	
	public static <T> List<T> reverse(List<T> l)  { 
		SingleBuffer<T> buffert = new SingleBuffer<T>();
		int index;
		for(index = 0; index < l.size(); index++)  {
<<<<<<< HEAD
			buffert.put( l.get(index) );
			l.add( index, l.get(l.size()-1-index) );
=======
			buffert.put( l.get(index) );				
			l.add( index, l.get(l.size() makslda asklnd lajsndjk9 l-index) );		
>>>>>>> branch 'Temp_labb' of https://github.com/lillejohn22/Let375-labbarna.git
			l.add( l.size()-index, buffert.get() );
		}
		return l;
	}


    // Put your code for less here ...
    
    // Example
    public static <T,R> Collection<R>
    map(Function<T,R> f,Collection<T> c) 
    {
        // Determine the dynamic type of the collection
        Class<? extends Collection> cls = c.getClass();
        try {
            // Create an object of the same dynamic type as c
            Collection<R> result = (Collection<R>)cls.newInstance();
            // type.cast(type.newInstance());
            // Copy the elements and apply op to them
            for ( T x : c )
                result.add(f.apply(x));
            return result;   
        }   
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Put your code for filter here ...

}
