package singleBuffer;

public class SingleBuffer<S>
{
	private S s = null;
	
	public boolean put(S t) {
		if(s == null) {
			s = t;
			return true;
			}
		return false;
	}
	
	public S get() {
		if(s == null) {return null;} 
		S temp = s; // do not want to return reference but object
		s = null;
		return temp;
	}
}