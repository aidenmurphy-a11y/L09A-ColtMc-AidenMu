import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class NegativeBalanceException extends Exception {

	private double negativeBalance;

	public NegativeBalanceException() {
		super("Error: negative balance");
	}

	public NegativeBalanceException(double negativeBalance) {
		super("Amount exceeds balance by " + negativeBalance);
		this.negativeBalance = negativeBalance;
		try {
			PrintWriter out = new PrintWriter("logfile.txt");
			out.println("Amount exceeds balance by " + negativeBalance);
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not write logfile.txt");
		}
	}

	@Override
	public String toString() {
		return "Balance of " + negativeBalance + " not allowed";
	}
}