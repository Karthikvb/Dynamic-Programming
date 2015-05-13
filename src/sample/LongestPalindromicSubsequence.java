package sample;

public class LongestPalindromicSubsequence {

	char str[];
	public LongestPalindromicSubsequence(String str) {
		this.str = str.toCharArray();
	}
	
	public int calculateLPS() {
		int LPSArray[][] = new int[str.length+1][str.length+1];
		for (int i = 0; i < str.length; i++) {
			LPSArray[1][i] = 1;
		}
		for(int c = 2; c <= str.length; c++){
            for(int i = 1; i <= str.length-c+1; i++){
                if(str[i-1] == str[i-1 + c-1] && c == 2){
                    LPSArray[c][i] = 2;
                }else if(str[i-1] == str[i+c-2]){
                    LPSArray[c][i] = LPSArray[c-2][i+1] + 2;
                }else{
                    LPSArray[c][i] = Math.max(LPSArray[c-1][i+1], LPSArray[c-1][i]);
                }
            }
        }

		return LPSArray[str.length][1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence("AAAMOABTTTCFGOMEDF");
		System.out.println(lps.calculateLPS());
	}
}
