package CodingTest;

public class kakao_6 {

	public static void main(String[] args) {
//		int[][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
		int[][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
//
//		System.out.println(solution(board,skill));
		
		// 이차원 배열 선언 및 초기화
        int[][] data = {{10, 20, 30}
                , {40, 50, 60}
                , {40, 50, 60}};
 
        for (int i = 2; i < 4; i++) {
            int row = i / skill[0].length; // 행
            int column = i % skill[0].length; // 열
            System.out.print(skill[row][column] + "\t");
 
 
            if (column == skill[0].length - 1) {
                System.out.println();
            }
        }
	}

	public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int size = board[0].length;
        
        int[] newBoard = new int[board.length * size];
        
        
        for(int i = 0; i < board.length; i++) {
        	for(int j = 0; j < size; j++) {
        		newBoard[i * size + j] = board[i][j];
        	}
        }
        
        for(int i = 0; i < skill.length; i++) {
        	int x = skill[i][1] * size + skill[i][2];
    		int y = skill[i][3] * size + skill[i][4];
    		
    		int degree = skill[i][5];
    		
    		
//    		System.out.println(x + " , " + y + " : " + degree);
        	if(skill[i][0] == 1) {
        		for(int j = x; j <= y; j++) {
        			newBoard[j] -= degree;
        		}
        	}else {
        		for(int j = x; j <= y; j++) {
        			newBoard[j] += degree;
        		}
        	}
//        	
//        	for(int k = 0; k < newBoard.length; k++) {
//        		System.out.print(newBoard[k]);
//        	}
//        	System.out.println();
        }
        
 
        
        for(int i = 0; i < newBoard.length; i++) {
        	if(newBoard[i] > 0) {
        		answer++;
        	}
        }
        
        return answer;
    }
}
