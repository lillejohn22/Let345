package maze;
public class Maze extends Board {
  		
    public Maze( int rows, int cols ) {
    	super(rows,cols);
    	// implement this
    }
    
    public void create() {
    	Pair<Integer, Point.Direction> pair1 = new Pair<Integer, Point.Direction>(6, Point.Direction.UP);
	    this.setChanged(); 
    	this.notifyObservers(pair1);
    }
    
    public void search() {
//    	 Implement this method!
    }
    
//    ...
}
