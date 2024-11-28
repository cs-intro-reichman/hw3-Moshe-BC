// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		if (x2 > 0){
		for(int i = 0; i < x2; i++){
			sum++;
			}
		}else if (x2 < 0){
				for(int i = 0; i > x2; i--){
				sum--;
			}
		}	
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int diff = x1;
		if (x2 > 0){
		for(int i = 0; i < x2; i++){
			diff--;
			}
		}else if (x2 < 0) {
			for(int i = 0; i > x2; i--){
			diff++;
			}
		}
		return diff;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int multiple = 0;
		for(int i = 0; i < x2; i++){
			multiple = plus(multiple, x1);
		}
		return multiple;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int pow = 1;
		for(int i = 0; i < n; i++){
			pow = times(pow, x);
		}
		return pow;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int dividend = x1, count = 0;
		while (dividend >= x2){
			dividend = minus(dividend, x2);
			count++; 
		}
		return count;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int dividend = x1;
		while (dividend >= x2){
			dividend = minus(dividend, x2);
		}
		return dividend;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int low = 0, high = x, result = 0;
        while (low <= high) {
            int mid = div(plus(low, high), 2);
            if (times(mid, mid) <= x) {
                result = mid;
                low = plus(mid, 1);
            } else {
                high = minus(mid, 1);
            }
        }
        return result;
	}	  	  
}