package object.chap12;

public class Grade {

	private final String name;
	private final int upper;
	private final int lower;

	public Grade(String name, int upper, int lower) {
		this.name = name;
		this.upper = upper;
		this.lower = lower;
	}

	public String getName() {
		return name;
	}

	public boolean isName(String name) {
		return this.name.equals(name);
	}

	public boolean include(int score) {
		return score >= lower && score <= upper;
	}
}
