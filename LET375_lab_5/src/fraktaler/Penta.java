package fraktaler;

public class Penta extends Flake {

	public void draw( Turtle turtle, int n, double size ) {
		this.turtle = turtle;
		turtle.turnTo(0.0);
		
		turtle.turn(-31.0);
		drawSide(n,size);
		
		for( int i = 1; i <= 4; i++ ) {
			turtle.turn(-72.0);
			drawSide(n,size);	
		}
	}

	private void drawSide( int n, double size ) {
		if( n <= 0 )				// Base case
			turtle.walk(size);
		else {						// Recursive case
			double l = size/4.0;
			drawSide(n-1,l);
			turtle.turn(108.0);
			drawSide(n-1,l);
			turtle.turn(-72);
			drawSide(n-1,l);
			turtle.turn(-72);
			drawSide(n-1,l);
			turtle.turn(-72);
			drawSide(n-1,l);
			turtle.turn(108);
			drawSide(n-1,l);
		}
	}
}
