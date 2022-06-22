package Programmers;

public class 신규_아이디_추천_0 {// 2021 kakao

	//self -> ����(61.5)
	public static void main(String[] args) {
		String new_id = "abcdefghijklmn.p";

		// 1�ܰ�
		new_id = new_id.toLowerCase();

		System.out.println(new_id);

		// 2�ܰ� 
		StringBuffer sb = new StringBuffer(new_id);
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.' ) 
				continue;
			else {
				sb.setCharAt(i, ' ');
			}

		}
		System.out.println(sb.toString());

		// 3�ܰ�
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c == '.' && i != sb.length()-1) {
				while (c == '.') {
					c = sb.charAt(i + 1);
					if (c == '.') {
						i++;
						sb.setCharAt(i, ' ');
					}
				}
			}
		}
		new_id = sb.toString();
		new_id = new_id.replaceAll(" ", "");
		System.out.println("3�ܰ� : " + new_id);
		
		// 4�ܰ�
		sb = new StringBuffer(new_id);
		while(sb.charAt(0) == '.') {
			sb.setCharAt(0, ' ');
		}
		
		int idx = sb.length() - 1;
		while (sb.charAt(idx) == '.') {
			sb.setCharAt(idx, ' ');
			idx--;
		}
		new_id = sb.toString();
		new_id = new_id.replaceAll(" ", "");
		System.out.println("4�ܰ� : " + new_id);

		// 5�ܰ�
		if (new_id.equals("")) {
			new_id = "a";
		}

		// 6�ܰ�
		if (new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			if (new_id.charAt(14) == '.') {
				new_id = new_id.substring(0, 14);
			}
		}
		System.out.println(new_id);

		// 7�ܰ�
		if (new_id.length() <= 2) {
			while (new_id.length() != 3) {
				new_id += new_id.charAt(new_id.length() - 1);
			}
		}
		System.out.println(new_id);
	}

}
