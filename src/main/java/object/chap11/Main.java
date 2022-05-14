package object.chap11;

import java.util.HashSet;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// custom stack
		Stack<String> stack = new Stack<>();
		stack.push("ronaldo");
		stack.push("messi");

		System.out.println(stack.pop());
		System.out.println(stack.pop());

		// custom instrumentedHashSet
		InstrumentedHashSet<String> instrumentedHashSet = new InstrumentedHashSet<>(new HashSet<>());
		instrumentedHashSet.add("panda");
		instrumentedHashSet.add("bear");
		instrumentedHashSet.addAll(List.of("tiger", "lion"));

		System.out.println("instrumentedHashSet.getAddCount() = " + instrumentedHashSet.getAddCount());
	}
}
