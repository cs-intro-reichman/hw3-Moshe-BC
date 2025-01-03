// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	private static double endBalance(double loan, double rate, int n, double payment) {	
		double balance = loan;
		for (int i =0; i < n; i++){
			balance = (balance - payment) * (1 + rate / 100);
		}
		return balance;
	}
	
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		iterationCounter = 0; //reset iteration counter
		double payment = loan / n; //first iteration guess
		while(true){
			iterationCounter++;
			double balance = endBalance(loan, rate, n, payment);
			if (balance < 0){//make negative balance positive
				balance -= 2 * balance;
			}
			if (balance <= epsilon) {// good enough proximity
				break;
			}
			payment += epsilon;// increment for next iteration
		}
		return payment;
    }
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		iterationCounter = 0;//reset iteration counter

		double low = loan / n; // lower bound
		double high = loan * Math.pow(1 + rate / 100, n);// upper bound
		double mid = (low + high) / 2;// initial middle

		while (high - low > epsilon) {// distance too large
			iterationCounter++;
			mid = (low + high) / 2;
			double balance = endBalance(loan, rate, n, mid);
			if (balance > 0){
				low =mid;//recalibrate lower bound
			} else {
				high = mid;//recalibrate upper bound
			}	
		}
		return mid;
    }
}