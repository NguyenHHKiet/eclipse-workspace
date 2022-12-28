import java.util.Scanner;

public class ArmStrong {
	public static void main(String[] args) {

//		abcd... = a^n + b^n + c^n + d^n + ...
//		153 = 1*1*1 + 5*5*5 + 3*3*3  // 153 is an Armstrong number.
		int number, originalNumber, remainder, result = 0, count = 0, a;

		Scanner s = new Scanner(System.in);

		System.out.print("Enter any integer you want to check:");

		number = s.nextInt();
		originalNumber = number;
		a = number;
		for (; a != 0; a /= 10, count++)
			;
		while (originalNumber != 0) {
			remainder = originalNumber % 10;
			result += Math.pow(remainder, count);
			originalNumber /= 10;
		}
		if (result == number)
			System.out.println(number + " is an Armstrong number.");
		else
			System.out.println(number + " is not an Armstrong number.");
	}
}
