import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GFG {
	// Function to print N Fibonacci Number
	static void Fibonacci(int N) {
		int num1 = 0, num2 = 1, count = 0;
		while (count < N) {
			System.out.print(num1 + " ");
			int num3 = num1 + num2;
			num1 = num2;
			num2 = num3;
			count++;
		}
	}

	// using Stream
	static List<Integer> getFibonacci(int N) {
		return Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(N).map(n -> n[0])// find,
				.collect(Collectors.toList());
	}

	static Integer recursive(int N) {
		if (N <= 1)
			return N;
		else
			return recursive(N - 1) + recursive(N - 2);
	}

	// Driver Code
	public static void main(String args[]) {
		// Given Number N
		int N = 10;
		List<Integer> fibonacci = getFibonacci(N);
		// Function Call
		Fibonacci(N); // 1
		System.out.println();
		fibonacci.forEach(System.out::println);// 2
		for (int i = 0; i < N; i++) {
			System.out.print(recursive(i) + " "); // 3
		}

	}
}
