package chapter11_4;

public class BitSet {
	
	public static void checkDuplicates(int[] array){
		BitSet bs = new BitSet(32000);
		for (int i = 0; i < array.length; i++){
			int num = array[i];
			int num0 = num - 1;
			if (bs.get(num0))
				System.out.println(num);
			else
				bs.set(num0);
		}
	}

	int[] bitset;
	public BitSet(int size){
		bitset = new int[size >> 5];
	}
	
	boolean get(int pos){
		int wordNumber = (pos >> 5); // which 4bytes
		int bitNumber = (pos & 0x1F); // which bit
		// get!!!!!!!
		return (bitset[wordNumber] & (1<<bitNumber)) != 0;
	}
	
	void set(int pos){
		int wordNumbe = (pos >> 5);
		int bitNumber = (pos & 0xIF);
		//set !!!!!!!!!!!!!
		bitset[wordNumber] |= 1 << bitNumber;
	}
}
