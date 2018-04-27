package mobile;

public class Mobile {
	private enum MobileType { SIMPLE, COMPOSITE }
	private MobileType type;
	private float weight;                   // Simple
	private float leftLength, rightLength;  // Composite
	private Mobile left, right;
	
	public Mobile( float weight ) {
		type = MobileType.SIMPLE;
		this.weight = weight;
		left = null;
		right = null;	
	}
	
	public Mobile( Mobile left, float leftLength, Mobile right, float rightLength ) {
		type = MobileType.COMPOSITE;
		this.left = left;
		this.right = right;
	    this.leftLength = leftLength;
	    this.rightLength = rightLength;	
	}
	
	// Return the total mass of the mobile
	public float getWeight() {
		if ( isSimple() )
			return weight;
		else
			return left.getWeight() + right.getWeight();
	}  
	
	// Return the maximum height of the mobile
	public int getHeight() {
		int height = 0;
		
		if( this.type == MobileType.SIMPLE )		// Base case
			return 1;
		else {										// Recursive case
			int maxLeft = this.left.getHeight();
			int maxRight = this.right.getHeight();
			height = 1 + Math.max(maxLeft, maxRight); // count current mobile and max depth of subtrees
		}
		return height;
	}  
	
	// Print the leaves of the mobile
	public void flatten()  {
		
		if( this.type == MobileType.SIMPLE )		// Base case
			System.out.println(this.weight);
		else {										// Recursive case
			this.left.flatten();
			this.right.flatten();
		}	
	}  
	
//	Print a structured view of the mobile
	public void prettyPrint() {
		
	    if( this.type == MobileType.SIMPLE )		// Base case
	    	System.out.printf( "(%.0f)", this.getWeight());
	    else { 										// Recursive case
	    	System.out.print("[");
	    	this.left.prettyPrint();
	    	System.out.printf(", %.0f, ", this.leftLength);
	    	System.out.printf("%.0f, ", this.rightLength);
	       	this.right.prettyPrint();
	       	System.out.print("]");
	    }
	}
	
// Determine if the mobile is balanced
    public boolean isBalanced() {
        return isSimple() ||
        left.isBalanced() && right.isBalanced() &&
        leftLength * left.getWeight() == rightLength * right.getWeight();
    }   
    
    
    public boolean equals(Object obj ) {
 
    	if( !(obj instanceof Mobile) )
    		return false;
    	Mobile mob = (Mobile) obj; // type cast
    	
    	// If both are simple: compare weights
    	if( isSimple() && mob.isSimple() ) // Base case
    		return ( weight == mob.weight );
    	
    	// if both are composite: compare arm lengths.
    	if( !isSimple() && !mob.isSimple() ) { // Recursive case
    		if( leftLength == mob.leftLength && rightLength == mob.rightLength)
    			return left.equals(mob.left) && right.equals(mob.right);
    	}
    	
    	// If one is simple and the other composite or both are composite but with different
    	// arm lengths, return false.
    	return false;
    }
    
//	Return a clone of this mobile
	public Mobile clone() {
		if( isSimple() )
			return new Mobile(weight);
			
		return new Mobile(left.clone(), leftLength, right.clone(), rightLength);
	}
	
// Change this mobile to its mirror image
	public void mirror() {
		
		if( this.type == MobileType.SIMPLE )
			return;
		else {
			this.left.mirror();
			this.right.mirror();
			Mobile temp = this.left;
			this.left = this.right;
			this.right = temp;
		}
	}
	
	private boolean isSimple() { 
		return type == MobileType.SIMPLE; 
	}
	
	public static void main(String[] args) {
		Mobile  m1 = new Mobile( 1 ),
		        m2 = new Mobile( new Mobile( 2 ), 6,  new Mobile( 3 ), 4 ),
		        m = new Mobile( m1, 10, m2, 2 );
	
		System.out.println("Total mass: " + m.getWeight() );
		System.out.println("Height:     " + m.getHeight() );
		
		m.flatten(); System.out.println();
		m.prettyPrint(); System.out.println();
		if ( m.isBalanced() )
			System.out.println("Balanced!");
		else
			System.out.println("Not balanced!");
		
		Mobile m22 = new Mobile( new Mobile( 2 ), 6,  new Mobile( 3 ), 4 ),
		       m3 = new Mobile( m1, 10, m22, 2 );
		
		if ( m.equals(m3) )
			System.out.println("Equal!");		// They should be!
		else
			System.out.println("Not equal!");
		
		Mobile c = m.clone();
		if ( c.equals(m) )
			System.out.println("Equal!");		// They should be!
		else
			System.out.println("Not equal!");

		if ( c == m ) // Do they reference the same object? Should not
			System.out.println("Identical!");	// They should definately not!
		else
			System.out.println("Not identical!");
		
		m.mirror();
		m.prettyPrint(); System.out.println();
		m.mirror();
		m.prettyPrint(); System.out.println();
		 
	}
}
