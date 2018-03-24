import java.io.*;

public class TestSingleBuffer {
	
	// Gjorde en klass f�r att ha ett objekt som kan agera buffer. Venne om det �r bra dock.
	private class SingleBuffer<E>
	{
		private E t;
		public boolean put(E t) {
			this.t = (this.t == null) ? t : this.t;
			if(this.t == null) {return true;}
			return false;
		}
		public E get() {
			if(this.t == null) {return null;}
			E temp = this.t;
			this.t = null;
			return temp;
		}
	}
	
    public static void main(String[] args) throws IOException  {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		

        //  Define the object stringBuf of type SingleBuffer here...
        
        // Egen kod inlagd h�r
        TestSingleBuffer testBuff = new TestSingleBuffer();
        SingleBuffer<String> stringBuf = testBuff.new SingleBuffer<String>();
        // Slut p� egen kid
        
        while ( true ) {
            System.out.print("Command (p/g/q): "); 
            String command = in.readLine();
            if (command.equals("p")) {
                System.out.print("Text: "); System.out.flush();
                String s = in.readLine();
                if ( ! stringBuf.put(s))
                    System.out.println("Buffer was full!");
            } else if (command.equals("g")) {
                String s = stringBuf.get();
                if ( s == null )
                    System.out.println("Buffer was empty!");
                else
                    System.out.println("contents: " + s);
            } else if (command.equals("q"))
                return;
            else
                System.out.println("Unknown command");
        }
    }
}
