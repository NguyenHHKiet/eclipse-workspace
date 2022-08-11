import java.util.Random;

public class Edureka {
	static char[] OTP(int len) {
		System.out.println("Generating OTP using random(): ");
		System.out.println("Your OTP is: ");
		String numbers = "0123456789";
		Random random_method = new Random();
		char[] otp = new char[len];
		for (int i = 0; i < otp.length; i++) {
			otp[i] = numbers.charAt(random_method.nextInt(numbers.length()));
		}
		return otp;
	}

	public static void main(String[] args) {
		int length = 4;
		System.out.println(OTP(length));
	}
}
