package maze;

import java.util.HashMap;
import java.util.Random;
import maze.Point.Direction;
import java.util.HashMap;
import java.util.ArrayList;

public class Maze extends Board {
    
    DisjointSets grid;
    int rows,cols;
    
    Pair<Integer, Point.Direction> pair; 
    
    HashMap<Integer, Point.Direction> directions = new HashMap<Integer, Point.Direction>(); 
    
    Random random = new Random();
    
    ArrayList<Pair<Integer,Point.Direction>> tempList= new ArrayList<Pair<Integer,Point.Direction>>(); 
    
    public Maze( int rows, int cols ) {
        super(rows,cols);
        this.rows = rows;
        this.cols = cols;
        grid = new DisjointSets(rows*cols);
        directions.put(0, Point.Direction.UP);
        directions.put(1, Point.Direction.RIGHT);
        directions.put(2, Point.Direction.DOWN);
        directions.put(3, Point.Direction.LEFT);
        
        }

    public void create() {
    	
    	// Knocks out the first wall, at the starting point
    	Pair pair = new Pair<Integer, Point.Direction>(0, Point.Direction.LEFT);
    	
    	tempList.add(new Pair<Integer, Point.Direction>(0, Point.Direction.LEFT));
    	// Knocks out the last wall, at the exit 
    	tempList.add(new Pair<Integer, Point.Direction>(rows*cols-1, Point.Direction.RIGHT));
	  	
    	 
    	// knocks out walls in between
    	int count = 0;
    	
    	while(count < rows*cols-1) {			// Makes sure every set is connected aka. every box is reachable
    		
    		int randRad = random.nextInt(rows); 
    		int randColl = random.nextInt(cols);
    		Point punkt = new Point(randRad,randColl);
    	  
    		int randDir = random.nextInt(4);
    	  
    		int eqKlass = grid.find(getCellId(punkt));
    		
    		Point nextPunkt = new Point(punkt.row, punkt.col);
    		nextPunkt.move(directions.get(randDir));
    		if(!isValid(nextPunkt))
    			continue;
    			
    		punkt.move(directions.get(randDir));
    		int eqKlass2 = grid.find(getCellId(punkt));
    	  
    		if(eqKlass != eqKlass2) {						// Makes sure that we don't get circular paths 
    			grid.union(eqKlass,eqKlass2);
    			count++;
    			int tempID = getCellId(punkt);
    			Point.Direction tempDir = directions.get((randDir + 2) % 4);
    			tempList.add(new Pair<Integer, Point.Direction>(tempID, tempDir));
    			}
    		}
    	this.setChanged();
    	this.notifyObservers(tempList);
    }
   

    public void search() {
//    	 Implement this method!
    }
    
//    ...
}
