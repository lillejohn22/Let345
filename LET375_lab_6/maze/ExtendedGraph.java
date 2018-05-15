package maze;
import java.util.*;


public class ExtendedGraph extends Graph {
	int count = 0; 
	List<Integer> nodePath;
	List<Integer> tempPath;
	
	public List<Integer> getPath( int destName ) {
		nodePath = getPath(vertexMap.get( destName ));
		return nodePath;
	}
	
	private List<Integer> getPath( Vertex dest ) {
		
		ArrayList<Integer> node = new ArrayList<Integer>();
		node.add(dest.name);
		System.out.println("CURRENT NODE NAME IS: " + dest.name);
		
		if(dest.prev != null) {			// Recursive case
			node.addAll(getPath(dest.prev)); // Append to existing list
			return new ArrayList<Integer>(node); // return a copy of node
		}
		
		// Base case
		return new ArrayList<Integer>(node); // return a copy of node 
	}
	

}
