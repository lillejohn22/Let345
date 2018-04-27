package fraktaler;

public class Sierpinski extends Flake{
	public void draw( Turtle turtle, int n, double size ) {
		this.turtle	 = turtle;
		turtle.turnTo(0.0);
		for(int i = 0; i <= 3; i++) {
			drawSide(n, size);
			turtle.turn(-120);
		}
	}

	private void drawSide( int n, double size ) {
		if( n <= 0 ) {			// Base casee
			turtle.walk(size);	
		}
		else {						// Recursive case			
			drawSide(n-1,size/2.);
			turtle.turn(-120);
			drawSide(n-1,size/2.);
			turtle.turn(-120);
			drawSide(n-1,size/2.);
			turtle.turn(-120);
			turtle.jump(size);
			}
	}
}
