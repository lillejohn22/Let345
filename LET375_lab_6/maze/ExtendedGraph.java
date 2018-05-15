package maze;
import java.util.*;


public class ExtendedGraph extends Graph {
	int count = 0; 
	List<Integer> nodePath;
	List<Integer> tempPath;
	
	public List<Integer> getPath( int destName ) {
		nodePath = new ArrayList<Integer>();
		nodePath = getPath(vertexMap.get( destName ));
		for(Integer noden : nodePath) {
			System.out.println(noden);
		}
		
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
