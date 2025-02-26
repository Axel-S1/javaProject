package utils;

import java.security.SecureRandom;
import java.util.Random;

public class MyRandom {
	private Random myRand;
	
	public MyRandom(){
		try {     
			myRand = SecureRandom.getInstanceStrong(); 
		} catch (Exception e) {
			e.printStackTrace(); }
	}
	
	public int getRandom(int max){
		return myRand.nextInt(max);
	}
}
