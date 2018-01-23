
public class Scoreboard {

	//instance variables
	
	

	private boolean[] alreadyUsedScores;
	private int[] scoreArray;
	private String[] types = new String[] {"Ones", "Twos", "Threes", "Fours", "Fives", "Sixes", "Three of a Kind", "Four of a Kind", "Full House", "Small Straight", "Large Straight", "Chance", "Yahtzee" };

	
	//constructor
	public Scoreboard() {
		scoreArray = new int[13];
		alreadyUsedScores = new boolean[13];

	}
	
	
	//getters and setters
	public int getTotalScore() {
		int totalScore = 0;
		for(int i = 0; i < scoreArray.length; i++) {
			totalScore += scoreArray[i];
		}
		return totalScore;
	}

	
	public int[] getScoreArray() {
		return scoreArray;
	}
	
	public void setScoreArray(int[] newScore) {
		for(int i = 0; i < scoreArray.length; i++) {
			scoreArray[i] = newScore[i];
		}
	}
	public void setScoreArray(int score, int userInput) {
		scoreArray[userInput] = score;
	}
	
	public boolean[] getAlreadyUsedScores() {
		return alreadyUsedScores;
	}
	public boolean getAlreadyUsedScores(int num) {
		return alreadyUsedScores[num];
	}


	public void setAlreadyUsedScores(int userChoice) {
		alreadyUsedScores[userChoice] = true;
	}
	
	

	
	//toString
	public String toString() {
	String scoreboard  = "";
	
		for(int i = 0; i < scoreArray.length; i++) {
			if(alreadyUsedScores[i] == true) {
				scoreboard +="("+ i + ")"+ types[i] + " " + "X \n";
			} else {
				scoreboard += "("+ i + ")"+ types[i] + " " + scoreArray[i] + "\n";
			}
		
		}
		
		return scoreboard;
	}
}
