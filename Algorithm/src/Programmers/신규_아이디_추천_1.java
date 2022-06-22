package Programmers;

public class 신규_아이디_추천_1 {

	//��¦ ���� -> 100
	public static void main(String[] args) {
		String new_id = "abcdefghijklmn.p";
		
		//1�ܰ�
		new_id = new_id.toLowerCase();
		
		System.out.println(new_id);
		
		//2�ܰ�
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < new_id.length(); i++) {
			char c = new_id.charAt(i);
			if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.' ) 
				sb.append(c);
		}
		new_id = sb.toString();
		System.out.println(new_id);
		
		//3�ܰ�
		while(new_id.contains("..")) {
			new_id = new_id.replace("..", ".");//replaceAll�� ����ϸ� �ȵ�
		}
		
		System.out.println(new_id);
		
		//4�ܰ�
		//����
		while(new_id.startsWith(".")) {
			new_id = new_id.substring(1, new_id.length());
		}
		
		System.out.println(new_id);
		
		//��
		while(new_id.endsWith(".")) {
			new_id = new_id.substring(0, new_id.length()-1);
		}
		
		System.out.println(new_id);
		
		//5�ܰ�
		if(new_id.length() == 0) {
			new_id = "a";
		}
		System.out.println(new_id);
		
		//6�ܰ�
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
			if(new_id.endsWith(".")) {
				new_id = new_id.substring(0, new_id.length()-1);
			}
		}
		System.out.println(new_id);
		
		//7�ܰ�
		if(new_id.length() <= 2) {
			char c = new_id.charAt(new_id.length()-1);
			while (new_id.length() != 3) {
				new_id += c;
			}
		}
		
		System.out.println(new_id);
	}

}
