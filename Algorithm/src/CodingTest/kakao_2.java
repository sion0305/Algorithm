package CodingTest;

public class kakao_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 110011;
		int k = 10;
		
		System.out.println(solution(n,k));
	}

	public static int solution(int n, int k) {
		int answer = 1;
		
		StringBuilder kNum = new StringBuilder();
		
		while(n != 0) {
			kNum.insert(0, n % k);
			n /= k;
		}
		
		boolean beforeZero = false;
		String s = "";
		int idx = kNum.indexOf("0");
		for(int i = idx; i < kNum.length(); i++ ) {
			 if(kNum.charAt(i) == '0') {
				 if(beforeZero) {
					if(s.length() > 0 && !s.equals("1")) {
						answer++;
						beforeZero = false;
					}
					s = "";
				 }else {
					 beforeZero = true;
					 s = "";
				 }
			 }else {
				 s += kNum.charAt(i);
			 }
		}
		
		return answer + 1;
	}
}
