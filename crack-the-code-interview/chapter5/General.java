package chapter5;

import java.util.ArrayList;

public class General {
	
	//5.1 reference
	public static int setBits(int n, int m, int i, int j){
		int max = ~0;	
		int left = max - ((1 << j) - 1);
		int right = (i << i) - 1;
		int mask = left | right;
		return (n & mask) | (m << i);
	}
	
	//5.2 reference
	public static String printBinary(String n){
		int intPart = Integer.parseInt(n.substring(0, n.indexOf('.')));
		double decPart = Double.parseDouble(n.substring(n.indexOf('.'), n.length()));
		String int_string = "";
		while (intPart > 0){
			int r = intPart % 2;
			intPart >>= 1;
		    int_string = r + int_string;
		}
		StringBuffer dec_string = new StringBuffer();
		while (decPart > 0){
			if (dec_string.length() > 32) return "ERROR";
			if (decPart == 1){
				dec_string.append((int)decPart);
				break;
			}
			double r = decPart * 2;
			if (r >= 1){
				dec_string.append(1);
				decPart = r - 1;
			} else {
				dec_string.append(0);
				decPart = r;
			}
		}
		return int_string + "." + dec_string.toString();
	}
	
	//5.3 reference
	public static boolean GetBit(int n, int index){
		return ((n & (1 << index)) > 0);
	}
	public static int SetBit(int n, int index, boolean b){
		if (b){
			return n | (1 << index);
		} else {
			int mask = ~(1 << index);
			return n & mask;
		}
	}
	public static int GetNext_NP(int n){
		if (n <= 0) return -1;
		int index = 0;
		int countOnes = 0;
		// Find first one.
		while (!GetBit(n, index)) index++;
		// Turn on next zero
		while (GetBit(n, index)){
			index++;
			countOnes++;
		}
		n = SetBit(n, index, true);
		//Turn off previous one
		index--;
		n = SetBit(n, index, false);
		countOnes--;
		// Set zeros
		for (int i = index -1; i >= countOnes; i--){
			n = SetBit(n, i, false);
		}
		for (int i = countOnes - 1; i >= 0; i--){
			n = SetBit(n, i, true);
		}
		return n;
	}
		
	public static int GetPrevious_NP(int n){
			return 0;
	}
	
    //5.4, ((n&(n-1)) == 0) checks if n is a power of 2.
	
	//5.5
	public static int numForConvert(int a, int b){
		int c = a ^ b;
		int count = 0;
		while (c > 0){			
			count += c & 1;
			c = c >> 1;
		}
		return count;
	}
	
	//5.6, reference
	public static int swapOddEvenBits(int x){
		return ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1);
	}
	
	//5.7
	public int findMissing(ArrayList<BitInteger> array){
		return findMissing(array, BitInteger.INTEGER_SIZE - 1);
	}
	
	public BitInteger findMissing(ArrayList<BitInteger> array, int column){
		if (column < 0) // base case and error condition
			return 0;
		
		ArrayList<BitInteger> array1 = new ArrayList<BitInteger>();
		ArrayList<BitInteger> array2 = new ArrayList<BitInteger>();
		for (BitInteger t : array){
			if (t.fetch(column)] == 0)
				array1.add(t);
			else 
				array2.add(t);
		}
		/*********************************************************************
		 * *******************************************************************
		 */
		if (array2.size() < array1.size())
			return findMissing(array2, column - 1) << 1 | 1;
		else
			return findMissing(array1, column - 1) << 1 | 0;
	}
	
	
	
	
	
	
	public static void main(String[] args){
	}
}
