package com.hw.callback;

import com.hw.callback.LiSi;

public class ZhangSan implements com.hw.callback.LiSi.CallBack {
	private LiSi mLiSi;
	
	public ZhangSan(LiSi lisi) {
		//LiSi的对象，向谁询问问题
		mLiSi = lisi;
		
		//李四知道答案后该告诉谁
		mLiSi.setCallBack(this);
	}
	
	public void askQuestion(String question) {
		//把问题告诉李四，让他帮忙解决
		new Thread(new Runnable(){
			@Override
			public void run() {
				//向李四询问问题
				mLiSi.answerQuestion(question);
			}
		}).start();
		
		//问题交给李四之后自己就玩去了
		play();
	}
	
	
	public void play() {
		System.out.println("玩玩玩玩玩玩玩玩玩玩玩玩玩玩玩玩");
	}
	
	
	//收到李四发来的答案
	@Override
	public void questionResult(String result) {
		System.out.println("李四给的答案："+result);
	}
	
}