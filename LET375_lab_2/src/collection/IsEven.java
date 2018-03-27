package collection;

public class IsEven implements Predicate<Integer> {
	public boolean test(Integer x) {
		return isEven(x);
	}
	boolean isEven(Integer x) {
		return x % 2 == 0;
	}
}
