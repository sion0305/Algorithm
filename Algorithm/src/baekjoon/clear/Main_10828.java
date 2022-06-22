package baekjoon.clear;

import java.util.*;

public class Main_10828 {
	public static int[] stack;
    public static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();//��¿� ���ɰ�

        int n = sc.nextInt();
        stack = new int[n];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            switch (str){
                case "push":
                    push(sc.nextInt());//push�� ��� �ѹ� �� �Է¹޴´�
                    break;
                case "pop":
                    sb.append(pop()).append('\n');//pop���� ���
                    break;
                case "size":
                    sb.append(size()).append('\n');//size ���
                    break;
                case "empty":
                    sb.append(empty()).append('\n');//empty ���
                    break;
                case "top":
                    sb.append(top()).append('\n');//top ���
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void push(int item){
        stack[size] = item; //stack �� ���� �� �߰�
        size++;
    }

    public static int pop(){
        if(size==0) return -1; //������ ������
        //������ ���� �� �� �ϳ� ���� �� stack���� ����
        int res = stack[size-1];
        stack[size-1] = 0;
        size--;
        return res;
    }

    public static int size(){
        return size;
    }

    public static int empty(){
        if (size==0) return 1;
        return 0;
    }

    public static int top(){
        if(size==0) return -1; //������ ������
        return stack[size-1]; //�� ������ ����
    }
}