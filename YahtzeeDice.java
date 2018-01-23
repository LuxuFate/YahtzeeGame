
public class YahtzeeDice {
	public static final int NUM_OF_DICE = 5; 
//instance variables
	private Die[] dice = new Die[5];
	
//constructors
	//constructs a YahtzeeDice object containing 5 default Die objects in the dice array.
	public YahtzeeDice() {
		for (int i = 0; i < 5; i++) {
			dice[i] = new Die();
		}
		
	}
	//constructs a Yahtzee object containing 5 Die objects with the given number of sides 
	public YahtzeeDice(int numSides) {
		for (int i = 0; i < dice.length; i++) {
			dice[i] = new Die(numSides);
		}
	}

	
//instance methods 
	public int roll() {
		//rolls all 5 dice and returns the total of the dice
		int count = 0;
		for(int i=0;i<dice.length;i++) {
			count += dice[i].roll();
		}
		return count;
	}
	
	public int roll(char[] holdArray) { 
		int sum = 0;
		
		for(int i = 0; i < NUM_OF_DICE; i++) {
			if(holdArray[i] == 'f') {
				sum += dice[i].roll();
			} else {
				sum += dice[i].getCurrentValue();
			}
		}
		return sum;
	}

	public Die[] getDice() {
		//returns the dice array
		return dice;
	}

	public int[] getDiceValues() {
		//returns an int[] containing the values of the 5 dice
		int[]array = new int[dice.length];
		for(int i=0;i<dice.length;i++) {
			array[i]=dice[i].getCurrentValue();
		}
		return array;
	}

	
	public String toString() {
		//returns a String representation of the object
		String yahtzee = "The " + NUM_OF_DICE + " dice read: ";
		
		for(int i = 0; i < dice.length; i++) {
			if(i < dice.length - 1)	
				yahtzee += dice[i].getCurrentValue() + ", ";
			else
				yahtzee += dice[i].getCurrentValue() + ".";
		}
		return yahtzee;
	}
	
}
