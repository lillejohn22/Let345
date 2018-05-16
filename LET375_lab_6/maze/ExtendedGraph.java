package maze;
import java.util.List;
import java.util.ArrayList;


public class ExtendedGraph extends Graph { 
	private List<Integer> nodePath;
	
	public List<Integer> getPath( int destName ) {
		nodePath = getPath(vertexMap.get( destName ));
		return nodePath;
	}
	
	private List<Integer> getPath( Vertex dest ) {
		
		ArrayList<Integer> node = new ArrayList<Integer>();
		node.add(dest.name);
		
		if(dest.prev != null) {						// Recursive case
			node.addAll(0, getPath(dest.prev)); 	// Append list to start of existing list
			return new ArrayList<Integer>(node);	// return a copy of node
		}
		return new ArrayList<Integer>(node); 		// Base case 
	}
	

}
