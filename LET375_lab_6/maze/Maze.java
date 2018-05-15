package maze;

import java.util.HashMap;
import java.util.Random;
import maze.Point.Direction;
import java.util.HashMap;
import java.util.ArrayList;

public class Maze extends Board {
    
	ExtendedGraph graph;
    DisjointSets grid;
    int rows,cols;
    
    Random random;
    Pair<Integer, Point.Direction> pair; 
    HashMap<Integer, Point.Direction> directions; 
    ArrayList<Pair<Integer,Point.Direction>> knockList; 
    
    public Maze( int rows, int cols ) {
        super(rows,cols);
        this.rows = rows;
        this.cols = cols;
        
        random = new Random();
        graph = new ExtendedGraph();
        grid = new DisjointSets(rows*cols);
        directions = new HashMap<Integer, Point.Direction>();
        knockList = new ArrayList<Pair<Integer,Point.Direction>>();
        
        directions.put(0, Point.Direction.UP);
        directions.put(1, Point.Direction.RIGHT);
        directions.put(2, Point.Direction.DOWN);
        directions.put(3, Point.Direction.LEFT);
        }

    public void create() {
    		
    	// Knocks out the first wall, at the starting point
    	
    	setChanged();
    	notifyObservers(new Pair<Integer, Point.Direction>(0, Point.Direction.LEFT));

    	// Knocks out the last wall, at the exit 
    	
    	setChanged();
    	notifyObservers(new Pair<Integer, Point.Direction>(rows*cols-1, Point.Direction.RIGHT));

    	// knocks out walls in between
    	int count = 0;
    	
    	while(count < rows*cols-1) {			// Makes sure every set is connected aka. every box is reachable
    		
    		int randRow = random.nextInt(rows); 
    		int randCol = random.nextInt(cols);
    		int randDir = random.nextInt(4);
    		
    		Point thisPoint = new Point(randRow,randCol);
    		int eqClass1 = grid.find(getCellId(thisPoint));
    		int orgCellId = getCellId(thisPoint);
    		
    		// Check that we do not step outside maze if we go in the random direction
    		thisPoint.move(directions.get(randDir));
    		if(!isValid(thisPoint)) continue;
    		
    		int eqClass2 = grid.find(getCellId(thisPoint)); // New point is valid, get eqClass
    	  
    		if(eqClass1 != eqClass2) {					// Makes sure that we don't get circular paths 
    			grid.union(eqClass1,eqClass2);
    			count++;
    			int prevId = getCellId(thisPoint);
    			
    			// For graph
    			graph.addEdge(prevId, orgCellId, 0);
    			graph.addEdge(orgCellId, prevId, 0);
    			
    			// For labyrinth
    			Point.Direction oppositeDir = directions.get((randDir + 2) % 4);
    			this.setChanged();
    	    	this.notifyObservers(new Pair<Integer, Point.Direction>(prevId, oppositeDir));
    			}
    		}
    	
    }
   

    public void search() {
    	graph.dijkstra(0);
    	this.setChanged();
    	this.notifyObservers(graph.getPath(rows*cols-1));
    }
//    ...
}
