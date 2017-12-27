package com.hw.callback;

public class LiSi {
	//这是个回调接口
	public interface CallBack {
		//这是个回调函数
		//当李四知道答案时调用这个函数告诉张三
		public void questionResult(String result);
	}
	
	//回调接口对象
	private CallBack mCallBack;
	
	//LiSi的构造函数
	public LiSi() {
		
	}
	
	//设置回调的对象，李四知道答案后该通知谁
	public void setCallBack(CallBack callback) {
		mCallBack = callback;
	}
	
	
	//计算并回答张三问的问题
	public void answerQuestion(String question) {
		System.out.println("张三的问题：" + question);
		
		for (int i=0; i<5; i++) {
			System.out.println("正在计算张三的问题...");
			try {
				Thread.sleep(300);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//计算出答案了
		String result = "答案是2";
		
		//将答案告诉张三
		mCallBack.questionResult(result);
	}
}