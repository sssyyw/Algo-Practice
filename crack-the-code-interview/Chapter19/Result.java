package Chapter19;

public class Result {
	public int hits;
	public int pseudoHits;
    
	public static Result estimate(String guess, String solution){
		Result res = new Result();
		int solution_mask = 0;
		for (int i = 0; i < 4; ++i){
			solution_mask |= 1 << (1 + solution.charAt(i) - 'A');
		}
		
		for (int i = 0; i < 4; ++i){
			if (guess.charAt(i) == solution.charAt(i)){
				++res.hits;
			} else if ((solution_mask & (1 << (1 + guess.charAt(i) - 'A'))) >= 1){
				++res.pseudoHits;
			}
		}
		return res;
	}
}
