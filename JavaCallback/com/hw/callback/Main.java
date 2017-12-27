
package com.hw.callback;


import com.hw.callback.ZhangSan;
import com.hw.callback.LiSi;


class Main {
	
	private static Test test;
	
	public static void main(String[] args) {
		System.out.println("===============");
		
		ZhangSan zhangSan = new ZhangSan(new LiSi());
		zhangSan.askQuestion("1+1=?");
	}
}