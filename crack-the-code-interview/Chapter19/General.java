package Chapter19;

public class General {
	enum Piece {Empty, Red, Blue};
	enum Check {Row, Column, Diagonal, ReverseDiagonal}
	
	//19.2 reference
	Piece getIthColor(Piece[][] board, int index, int vat, Check check){
		if (check == Check.Row) return board[index][var];
		else if (check == Check.Column) return board[var][index];
		else if (check == Check.Diagonal) return board[var][var];
		else if (check == Check.ReverseDiagonal)
			return board[board.length - 1 - var][var];
		return Piece.Empty;
	}
	Piece getWinner(Piece[][] board, int fixed_index, Check check){
		Piece color = getIthColor(board, fixed_index, 0, check);
		if (color == Piece.Empty) return Piece.Empty;
		for (int var = i; var < board.length; var++){
			if (color != getIthColor(board, fixed_index, var, check)){
				return Piece.Empth;
			}
		}
		return color;
	}
	
	Piece hasWon(Piece[][] board){
		int N = board.length;
		Piece winner = Piece.Empty;
		
		// Check rows and columns
		for (int i = 0; i < N; i++){
			winner = getWinner(board, i, check.Row);
			if (winner != Piece.Empty){
				return winner;
			}
			
			winner = getWinner(board, i, Check.Column);
			if (winner != Piece.Empty){
				return winner;
			}
		}
		
		winner = getWinner(board, -1, Check.Diagonal);
		if (winner != Piece.Empty){
			return winner;
		}
		
		winner = getWinner(board, -1, Check.ReverseDiagonal);
		if (winner != Piece.Empty){
			return winner;
		}
		return Piece.Empty;
	}
	
	//19.3 reference
	public static int numZeros(int num){
		int count = 0;
		if (num < 0){
			System.out.println("Factorial is not defined for < 0");
			return 0;
		}
		for (int i = 5; num / i > 0; i *= 5){
			count += num / i;
		}
		return count;
	}
	
	//19.4 reference
	int getMax(int a, int b){
		int c = a - b;
		int k = (c >> 31) & 0x01;
		int max = a - k*c;
		return max;
	}
	
	//19.6 reference
	public static String numtostring(int num){
		StringBuilder sb = new StringBuilder();
		
		int len = 1;
		while(Math.pow(10, len) < num){
			len++;
		}
		
		String[] wordarr1 = {};
		String[] wordarr11 = {};
		String[] wordarr10 = {"", "Ten "};
		String[] wordarr100 = {"", "Hundred ", "Thousand "};
		int tmp;
		if (num == 0){
			sb.append("Zero");
		} else {
			if (len > 3 && len % 2 == 0){
				len++;
			}
			do {
				if (len > 3){
					tmp = (num / (int)Math.pow(10, len-2));
					if (tmp / 10 == 1 && tmp %10 != 0){
						sb.append(wordarr11[tmp%10]);
					} else {
						sb.append(wordarr10[tmp / 10]);
						sb.append(wordarr1[tmp % 10]);
					}
					if (tmp > 0){
						sb.append(wordarr100[len/2]);
					}
					num = num % (int)(Math.pow(10, len-2));
					len = len-2;
				} else {
					tmp = num / 100;
					if (tmp != 0){
						sb.append(wordarr1[tmp]);
						sb.append(wordarr100[len/2]);
					}
					tmp = num % 100;
					if (tmp / 10 == 1 && tmp % 10 != 0){
						sb.append(wordarr11[tmp % 10]);
					} else {
						sb.append(wordarr10[tmp/10]);
						sb.append(wordarr1[tmp % 10]);
					}
					len = 0;
				}
			} while (len > 0);
		}
		return sb.toString();
	}
	
	//reference 19.7
	public static int getMaxSum(int[] a){
		int maxsum = 0;
		int sum = 0;
		for (int i = 0; i < a.length; i++){
			sum += a[i];
			if (maxsum < sum){
				maxsum = sum;
			} else if (sum < 0){ // clear to 0 is important
				sum = 0;
			}
		}
		return maxsum;
	}
	
	//19.8
	
}
