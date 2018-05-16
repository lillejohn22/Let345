package maze;

import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

public class Maze extends Board {
    
    int rows,cols;
    private Random random;
    final int lastCellId;
    private DisjointSets djset;
    private ExtendedGraph graph;
    private HashMap<Integer, Point.Direction> directions; 
    
    public Maze( int rows, int cols ) {
        super(rows,cols);
        this.rows = rows;
        this.cols = cols;
        
        random = new Random();
        graph = new ExtendedGraph();
        lastCellId = rows*cols-1;
        djset = new DisjointSets(rows*cols);
        directions = new HashMap<Integer, Point.Direction>();
        
        directions.put(0, Point.Direction.UP);
        directions.put(1, Point.Direction.RIGHT);
        directions.put(2, Point.Direction.DOWN);
        directions.put(3, Point.Direction.LEFT);
        }

    public void create() {
    		
    	// Knocks out the first and last wall
    	setChanged();
    	notifyObservers(new Pair<Integer, Point.Direction>(0, Point.Direction.LEFT));
    	setChanged();
    	notifyObservers(new Pair<Integer, Point.Direction>(lastCellId, Point.Direction.RIGHT));

    	// Knocks out walls in between
    	int count = 0; // Keep track of the number of performed union operations
    	
    	while(count < lastCellId) {			// Makes sure every set is connected aka. every box is reachable
    		
    		int randRow = random.nextInt(rows); 
    		int randCol = random.nextInt(cols);
    		int randDir = random.nextInt(4);
    		
    		Point thisPoint = new Point(randRow,randCol);
    		int eqClass1 = djset.find( getCellId(thisPoint) );
    		int orgCellId = getCellId(thisPoint);
    		
    		// Are we inside boundaries if we move in the random direction?
    		thisPoint.move( directions.get(randDir) );
    		if( !isValid(thisPoint) ) continue;
    		
    		int eqClass2 = djset.find( getCellId(thisPoint) );
    	  
    		if(eqClass1 != eqClass2) {					// Makes sure that we don't get circular paths 
    			djset.union(eqClass1, eqClass2);
    			count++;
    			int prevCellId = getCellId(thisPoint);
    			
    			// For graph
    			graph.addEdge(prevCellId, orgCellId, 0);
    			graph.addEdge(orgCellId, prevCellId, 0);
    			
    			// For labyrinth
    			Point.Direction oppositeDir = directions.get((randDir + 2) % 4);
    			this.setChanged();
    	    	this.notifyObservers(new Pair<Integer, Point.Direction>(prevCellId, oppositeDir));
    			}
    		}
    }
   

    public void search() {
    	graph.dijkstra(0);
//    	graph.unweighted(0);
    	
    	ArrayList<Integer> theNodes = (ArrayList<Integer>) graph.getPath(lastCellId);
    	
    	for( Integer cellId : theNodes ) {
    		this.setChanged();
        	this.notifyObservers(cellId);
    	}
    }
}























