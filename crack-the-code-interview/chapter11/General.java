package chapter11;

import java.util.Scanner;

public class General {
	byte[] bitfield = new byte[0xFFFFFFFF/8];
	
	void findOpenNumber2() throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("input_file_q11_4.txt"));
		while(in.hasNextInt()){
			int n = in.nextInt();
			bitfield[n/8] |= 1 << (n % 8);
		}
		
		for (int i = 0; i < bitfield.length; i++){
			for (int j = 0; j < 8; j++){
				if ((bitfield[i] & (1 << j)) == 0){
					System.out.println(i*8 + j);
					return;
				}
			}
		}
	}
	
	int bitsize = 1048576;
	int blockNum = 4096;
	byte[] bitfield = new byte[bitsize/8];
	int[] blocks = new int[blockNum];
	
	void findOpenNumber() throws FileNotFoundException{
		int starting = -1;
		Scanner in = new Scanner (new FileReader ("input_file_qll_4.txt"));
		while(in.hasNextInt())){
			int n = in.nextInt();
			blocks[n/(bitfield.length*8)]++;
		}
		
		for (int i = 0; i < blocks.length; i++){
			if (blocks[i] < bitfield.length * 8){
				starting = i * bitfield.length * 8;
				break;
			}
		}
		
		in = new Scanner(new FileReader("input_file_q11_4.txt"));
		while (in.hasNext()){
			int n = in.nextInt();
			if (n >= starting && n < starting + bitfield.length*8){
				//set!!!!!!!!!!!!!!!!!!
				bitfield[(n-starting)/8] |= 1 << ((n-starting)%8);
			}
		}
		
		for (int i = 0; i < bitfield.length; i++){
			for (int j = 0; j < 8; j++){
				// get!!!!!!!!!!!!!!!
				if ((bitfield[i] & (1 << j)) == 0){
					System.out.println(i * 8 + j + starting);
					return;
				}
			}
		}
	}
}
