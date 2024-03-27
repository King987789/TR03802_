package cn;

import java.util.Scanner;

public class tihuanSJH {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入手机号");
		String sjh = in.next();
		sjh.split("XXXX", 5);
		if (sjh.matches("{\\d}{11}")) {
			
		}else {
			System.out.println("输入错误");
		}
	}
}
