package collection;

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
			System.out.print(temp + ",");
		System.out.print("]");
	}
    	
	public static <T> List<T> reverse(List<T> l)  { 
		SingleBuffer<T> buffert = new SingleBuffer<T>();
		int index;
		for(index = 0; index < l.size()/2; index++)  {
			buffert.put( l.get(index) );
			l.set( index, l.get(l.size()-1-index) );
			l.set(l.size()-1-index, buffert.get());	
		}
		return l;
	}

	public static <T extends Comparable<T>> boolean
	less( Collection<T> c1, Collection<T> c2, Comparator<T> comp ) {
		return comp.compare(Collections.max(c1,comp), Collections.min(c2,comp)) == -1;
	}
    
    // Example
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
	
//	public static <T,R> Collection<R> filter( Predicate<T,R> p, Collection<T> c ) {
//		Class<? extends Collection> cls = c.getClass();
//		try {
//            Collection<R> result = (Collection<R>) cls.newInstance();
//            
//            for ( T x : c )
//                result.add(p.test(x));
//            return result;   
//	        }   
//		catch (Exception e) {
//	            e.printStackTrace();
//	            return null;
//	        }
//		}

}





