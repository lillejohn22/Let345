package maze;
import java.util.*;


public class ExtendedGraph extends Graph {
	
	List<Integer> nodePath;
	
	public List<Integer> getPath( int destName ) {
		nodePath = new ArrayList<Integer>();
		nodePath.add(1,1);
		
		printPath(destName);
		
		return nodePath;
	}
	
//    {
//        Vertex w = vertexMap.get( destName );
//        if( w == null )
//            throw new NoSuchElementException( "Destination vertex not found" );
//        else
//        {
//			  add node to list at place 1
//            getPath( w );
//		  }
    
	
	private List<Integer> getPath( Vertex dest ) {
			
		return null;
	}
	

}
