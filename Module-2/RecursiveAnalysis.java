//CSD420 Tyler O'Riley 08/20/2023 Assignments 2
//Java program using recursive methods to return sums

public class RecursiveAnalysis {
	public static double recursiveSum(double i) {   // Recursive method
        if (i==1) {         
            return 0.5;     // When i equals 1, return first term of stack
        } 
		else {              
            return i / (i + 1) + recursiveSum(i - 1);   // Returns sum of current term and previous term ex. (1/2 + 2/3)
        }
    }
    public static void main(String[] args) {

        System.out.println("\n--Test 1--");

		for(int i=1; i<=14; i++) {                               
			System.out.println(i + ": " + recursiveSum(i));     // Primary for loop to stack 14 sequences ex. (1/2 + 2/3), (1/2 + 2/3 + 3/4), etc.
		}

        System.out.println("\n--Test 2--");     // Specific index numbers to test integrity of recursion

        System.out.println(recursiveSum(4));    // In this example, 4 should be the same result as index 4 in the above for loop
        System.out.println(recursiveSum(9)); 
        System.out.println(recursiveSum(14)); 

		
    }
}