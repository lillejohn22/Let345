package maze;
import java.util.*;


public class ExtendedGraph extends Graph {
	
	List<Integer> nodePath;
	List<Integer> tempPath;
	
	public List<Integer> getPath( int destName ) {
		nodePath = new ArrayList<Integer>();
		nodePath = getPath(vertexMap.get( destName ));
		
		
		return nodePath;
	}
	
	private List<Integer> getPath( Vertex dest ) {
		ArrayList<Integer> node = new ArrayList<Integer>();
		if(dest.prev != null) {
			node.addAll(getPath(dest.prev));
			return node;
		}
		else {
			node.add(dest.name);
			return node;
		}
	}
	

}
