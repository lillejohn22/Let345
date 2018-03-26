package singleBuffer;

public class SingleBuffer<S>
{
	private S s = null;
	
	public boolean put(S s) {
		if(this.s == null) {
			this.s = s;
			return true;
			}
		return false;
	}

	// kolla om det ska vara this.s eller s i get()
	public S get() {
		if(s == null) {return null;} 
		S temp = s;
		s = null;
		return temp;
	}
}