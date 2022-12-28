import java.util.Scanner;

public class StringPalindrome {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string: ");
		String str = sc.nextLine();

		String reverseStr = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			reverseStr = reverseStr + str.charAt(i);
		}
		if (str.equals(reverseStr)) {
			System.out.println("String is palindrone\n");
		}else {
			System.out.println("String is not palindrone\n");
		}
	}
}
