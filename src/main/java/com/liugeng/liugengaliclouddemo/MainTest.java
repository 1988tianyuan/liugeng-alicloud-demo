package com.liugeng.liugengaliclouddemo;

import com.liugeng.liugengaliclouddemo.model.User;

public class MainTest {
	public static void main(String[] args) {
//		TypeCheck<Integer> typeCheck = new TypeCheck<>();
//		typeCheck.setData(1);
//		System.out.println(typeCheck.doCheckType(2));
//		System.out.println(typeCheck.doCheckType("2"));
//		System.out.println(typeCheck.returnBige(new User(1L, "bige", "逼哥")));


		String[] stringArray = new String[500000];
		for (int i = 0; i < 500000; i++) {
			stringArray[i] = String.valueOf(i);
		}
		String[] newStringArray = new String[500000];

		long time = System.nanoTime();
		System.arraycopy(stringArray, 0, newStringArray, 0, 500000);
		System.out.println(System.nanoTime() - time);

		time = System.nanoTime();
		for (int i = 0; i < 500000; i++) {
			newStringArray[i] = stringArray[i];
		}
		System.out.println(System.nanoTime() - time);
	}
}

