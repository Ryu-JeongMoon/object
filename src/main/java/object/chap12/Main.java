package object.chap12;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Lecture lecture = new Lecture("OOP", 70, List.of(81, 95, 75, 50, 45));
		System.out.println("lecture = " + lecture.evaluate());

		GradeLecture gradeLecture = new GradeLecture("OOP", 70, List.of(81, 95, 75, 50, 45),
			List.of(
				new Grade("A", 100, 95),
				new Grade("B", 94, 80),
				new Grade("C", 79, 70),
				new Grade("D", 69, 50),
				new Grade("F", 49, 0)));
		System.out.println("gradeLecture = " + gradeLecture.evaluate());
	}
}
