package maze;

import java.util.HashMap;
import java.util.Random;

import maze.Point.Direction;

import java.util.HashMap;
public class Maze extends Board {
    
    DisjointSets rutor;
    int rows,cols;
    Pair<Integer, Point.Direction> pair; 
    HashMap<Integer, Point.Direction> directions; 
    Random random;
    public Maze( int rows, int cols ) {
        super(rows,cols);
        this.rows = rows;
        this.cols = cols;
        rutor = new DisjointSets(rows*cols);
        directions.put(0, Point.Direction.UP);
        directions.put(1, Point.Direction.RIGHT);
        directions.put(2, Point.Direction.DOWN);
        directions.put(3, Point.Direction.LEFT);
        random = new Random();
        }
    

    /*  
    1. Det skall finns exakt en ingång längst upp till vänster och en utgång längst ner till höger som bilden ovan visar. 
    2. Varje cell skall kunna nås från vilken annan cell som helst. 
    3. Det får inte finnas några cykliska vägar. 
    4. Labyrinten skall presenteras grafiskt som exemplet visar. 
    */ 

    /*
    1. Slå ut start och slut väg.
    2. Välj random vägg/granne.
    3.  
    */

    public void create() {        
        HashMap<Integer, Direction> directions2 = directions;
		directions.get( random.nextInt( 4 ) );

        pair =  Pair<Integer, Point.Direction>(1, Point.Direction.LEFT);
        this.setChanged();
        this.notifyObservers(pair);




        
        pair =  Pair<Integer, Point.Direction>(rows*cols, Point.Direction.RIGHT);
        this.setChanged();
        this.notifyObservers(pair);
        

        
        


        





        Pair<Integer, Point.Direction> pair1 = new Pair<Integer, Point.Direction>(6, Point.Direction.UP);

	    this.setChanged(); 
    	this.notifyObservers(pair1);
    }
    
    public void search() {
//    	 Implement this method!
    }
    
//    ...
}
