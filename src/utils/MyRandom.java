package utils;

import java.security.SecureRandom;
import java.util.Random;

public class MyRandom {
	private Random myrandom;
	
	public MyRandom(){
		try {     
			myrandom = SecureRandom.getInstanceStrong(); 
		} catch (Exception e) {
			e.printStackTrace(); }
	}
	
	public int getRandom(int max){
		return myrandom.nextInt(max);
	}
}
