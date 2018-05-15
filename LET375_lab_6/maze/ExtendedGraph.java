package maze;
import java.util.*;

import sun.jvm.hotspot.debugger.posix.elf.ELFSectionHeader;


public class ExtendedGraph extends Graph {
	
	List<Integer> nodePath;
	List<Integer> tempPath;
	
	public List<Integer> getPath( int destName ) {
		nodePath = new ArrayList<Integer>();
		nodePath = getPath(vertexMap.get( destName ));
		
		
		return nodePath;
	}
	
	private List<Integer> getPath( Vertex dest ) {
		if(dest.prev != null)
			getPath(dest.prev);
		else
			tempList = new  ArrayList<Integer>(dest.name);
			return tempList.add(dest.name);
	}
	

}
