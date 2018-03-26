package collection;

public class IsEven implements Predicate<Integer,Boolean> {
	public Boolean test(Integer x) {
		return x % 2 == 0;
	}
}
