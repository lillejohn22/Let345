package collection;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.*;
import singleBuffer.*;

public class CollectionOps {
	
	public static <T> void print(Collection<T> l) {
		Iterator<T> iterator = l.iterator();
		
		System.out.print("[");
		while ( iterator.hasNext() ) {
			System.out.print(iterator.next()); // using next() increments one step
			if( iterator.hasNext() ) System.out.print(","); // if not last element, print comma
		}
		System.out.println("]");
	}
    	
	public static <T> List<T> reverse(List<T> l)  { 
		SingleBuffer<T> buffert = new SingleBuffer<T>();
		
		ListIterator<T> iterator1 = l.listIterator(); // forwards
		ListIterator<T> iterator2 = l.listIterator(l.size()); // backwards
		
		while ( iterator1.nextIndex() < l.size()/2 ) {
		 	buffert.put(iterator1.next()); // increments counter
		 	l.set(iterator1.previousIndex(), iterator2.previous()); // previousIndex due to iterator1 incremented
		 	l.set(iterator2.nextIndex(), buffert.get()); // nextIndex due to iterator2 decremented
		}
		return l;
		
//		int index;
//		for(index = 0; index < l.size()/2; index++)  {
//			buffert.put( l.get(index) );
//			l.set( index, l.get(l.size()-1-index) );
//			l.set(l.size()-1-index, buffert.get());	
//		}
//		return l;

	}

	public static <T extends Comparable<T>> boolean
	less( Collection<T> c1, Collection<T> c2, Comparator<T> comp ) {
		return comp.compare(Collections.max(c1,comp), Collections.min(c2,comp)) == -1;
	}
    
    public static <T,R> Collection<R>
    map(Function<T,R> f, Collection<T> c) 
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
    
	public static <T> Collection<T> filter( Predicate<T> p, Collection<T> c ) {
		Class<? extends Collection> cls = c.getClass();
		try {
            Collection<T> result = (Collection<T>) cls.newInstance();
            
            for ( T x : c ) {
            		if ( p.test(x) ) result.add(x);
            		}
            return result;
			}   
		catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
		}
}





