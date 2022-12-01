package s0start;

public class ArrayFunctions {
	static double MINIMUM = 0.5;
	
	public static boolean isWholeNumber(double zahl) {
		if (zahl % (int) zahl == 0)
			return true;
		else if (zahl == 0.0)
			return true;
		else 
			return false;
	}
	
	public static int countWholeNumbers(double[] array) {
		int i, n;
		
		i = 0;
		n = 0;
		while (i < array.length) {
			if (isWholeNumber(array[i]) == true) {
				n++;
			}
			i++;
		}
		return n;
		
	}
	
	public static int[] wholeNumbersInMatrix(double[][] array) {
		int i;
		int[] zahlen = new int[array.length];
		
		i = 0;
		while (i < array.length) {
			zahlen[i] = countWholeNumbers(array[i]);
			i++;
		}
		return zahlen;
	}
	
	public static double[] filter(double[] array) {
		double[] filter = new double[array.length];
		int i, n;
		
		i = 0;
		n = 0;
		while (i < array.length) {
			if (array[i] >= MINIMUM) {
				filter[n] = array[i];
				n++;
			}
			i++;
		}
		return filter;
	}
	
	public static void main(String[] args) {
		double[] array1 = {0.0, 0.5, -1.0, 100.0};
		double[][] array2 = new double[4][3];
		array2[0][0] = -0.0;
		array2[0][1] = 7.0;
		array2[0][2] = 8.2;
		array2[1][0] = 100.01;
		array2[1][1] = 0.0;
		array2[1][2] = -1442.0;
		array2[2][0] = -13.5;
		array2[2][1] = 13.1;
		array2[2][2] = 14239.53;
		array2[3][0] = 500.0;
		array2[3][1] = -3.0;
		array2[3][2] = 750.0;
		int[] matrix = wholeNumbersInMatrix(array2);
		double[] filter = filter(array1);
		System.out.println(isWholeNumber(100.01));
		System.out.println(countWholeNumbers(array1));
		System.out.println(matrix[2]);
		System.out.println(filter[1]);
	}
}
