import java.util.Arrays;
public class Checkrolls {
	public static int getOnes(int[]dv) {
		int count = 0;
		for(int i= 0;i<dv.length;i++) {
			if(dv[i]==1){
				count+= dv[i];
			}
		}
		return count;
	}
	public static int getTwos(int[]dv) {
		int count = 0;
		for(int i= 0;i<dv.length;i++) {
			if(dv[i]==2){
				count+= dv[i];
			}
		}
		return count;
		
	}
	public static int getThrees(int[]dv) {
		int count = 0;
		for(int i= 0;i<dv.length;i++) {
			if(dv[i]==3){
				count+= dv[i];
			}
		}
		return count;
		
	}
	public static int getFours(int[]dv) {
		int count = 0;
		for(int i= 0;i<dv.length;i++) {
			if(dv[i]==4){
				count+= dv[i];
			}
		}
		return count;
	}
	public static int getFives(int[]dv) {
		int count = 0;
		for(int i= 0;i<dv.length;i++) {
			if(dv[i]==5){
				count+= dv[i];
			}
		}
		return count;
		
	}
	public static int getSixes(int[]dv) {
		int count = 0;
		for(int i= 0;i<dv.length;i++) {
			if(dv[i]==6){
				count+= dv[i];
			}
		}
		return count;
		
	}
	public static int getThreeOfAKind(int[]dv) {  
		Arrays.sort(dv);
		if (((dv[0] == dv[1]) && (dv[1] == dv[2])) || ((dv[1] == dv[2]) && (dv[2] == dv[3])) || ((dv[2] == dv[3]) && (dv[3] == dv[4]))) {
			return dv[1] + dv[2] + dv[3] + dv[4] + dv[0];
		} 
		else {
			return 0;
		}
	}
	
	public static int getFourOfAKind(int[]dv) {
		int count = 0;
		for(int i=0;i<dv.length;i++) {
			count = 0;
	        for (int j=0; j < dv.length; j++) {
	            if (dv[i] == dv[j]) {
	                count++;
	            }
	        }
	        if (count >= 4) {
	            return dv[0] + dv[1] + dv[2] + dv[3] + dv[4];
	        }
	    }
	    return 0;
	}
		
	public static int getFullHouse(int[]dv) {
		Arrays.sort(dv);
		int count = 0;
		if(dv[0] == dv[1] && dv[1] == dv[2] || dv[0] == dv[1] && dv[2] != dv[1]){
		    count++;
		}
		    if(dv[3] == dv[4]){
		        count++;
		    }
		    if(count > 1){
		        return 25;
		    }
		    return 0;
	}
	public static int getSmallStraight(int[]dv) {
		Arrays.sort(dv);
		boolean smallStraight1 = true;
		for(int i = 0; i < dv.length - 2; i++) {
			if(dv[i] != dv[i + 1] - 1) {
				smallStraight1 = false;
			}
		}
		boolean smallStraight2 = true;
		for(int i = 1; i < dv.length - 1; i++) {
			if(dv[i] != dv[i + 1] - 1) {
				smallStraight2 = false;
			}
		}
		boolean smallStraight3 = false;
		if(dv[0]+1 == dv[1] && dv[1]==dv[2] && dv[2]+1 == dv[3] && dv[3]+1 == dv[4]) {
			smallStraight3 = true;
		}
		boolean smallStraight4 = false;
		if(dv[0]+1 == dv[1] && dv[1]+1==dv[2] && dv[2] == dv[3] && dv[3]+1 == dv[4]) {
			smallStraight4 = true;
		}	
		
		if(smallStraight1 || smallStraight2 || smallStraight3 || smallStraight4) {
			return 30;
		}
		
		return 0;
	}
	public static int getLargeStraight(int[]dv) {
		boolean largeStraight = true;
		Arrays.sort(dv);
		for(int i = 0; i < dv.length - 1; i++) {
			if(dv[i] != dv[i + 1] - 1) {
				largeStraight = false;
			}
		}
		if(largeStraight) {
			return 40;
		}
		
		return 0;
	}
	public static int getChance(int[]dv) {
		int sum = 0;
		
		for(int i = 0; i < dv.length; i++) {
			sum += dv[i];
					
		}
		
		return sum;
	}
	public static int getYahtzee(int[]dv) {
		if(dv[0]==dv[1]&&dv[1]==dv[2]&&dv[2]==dv[3]&&dv[3]==dv[4]) {
			return 50;
		}
		return 0;
	}
	

	
	
	
}
