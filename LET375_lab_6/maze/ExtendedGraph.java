package maze;
import java.util.*;


public class ExtendedGraph extends Graph {
	
	List<Integer> nodePath;
	
	public List<Integer> getPath( int destName ) {
		nodePath = new ArrayList<Integer>();
		
		
		printPath(destName);
		
		return null;
	}
	
//    {
//        Vertex w = vertexMap.get( destName );
//        if( w == null )
//            throw new NoSuchElementException( "Destination vertex not found" );
//        else if( w.dist == INFINITY )
//            System.out.println( destName + " is unreachable" );
//        else
//        {
//            System.out.print( "(Cost is: " + w.dist + ") " );
//            getPath( w );
//            System.out.println( );
//        }
//    }
    
	
	private List<Integer> getPath( Vertex dest ) {
		return null;
	}
	

}
