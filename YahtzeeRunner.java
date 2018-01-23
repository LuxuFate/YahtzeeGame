//make sure checkrolls works
public class YahtzeeRunner {

	public static void main(String[] args) {
	YahtzeeDice gameDice = new YahtzeeDice();
	int totalRounds = 0;
	
	System.out.println("You have 3 turns per round");
	
	Scoreboard currentScoreboard = new Scoreboard();
	Scoreboard rollOptionScoreboard = new Scoreboard();
	boolean rollAgain = true; 
	char[] holdArray = new char[5];
	int[] scoreOptions = new int[13];
	int numberOfTurnsLeft = 2; 
	char userInput = 'q';
	int userScoreChoice = -1;
	
	while(totalRounds < 13) {
		rollingDice(gameDice, rollAgain, holdArray, numberOfTurnsLeft, userInput);
		System.out.println();
		rollOptionScoreboard = findRollOptionScoreboard(rollOptionScoreboard, gameDice, scoreOptions);
		System.out.println("Here are your options");
		System.out.println(rollOptionScoreboard);
		System.out.println();
		userScoreChoice = grabUserScoreChoice(userScoreChoice, rollOptionScoreboard);
		
		
		rollOptionScoreboard.setAlreadyUsedScores(userScoreChoice);
		rollOptionScoreboard.setScoreArray(findScoreValueOfUserChoice(gameDice, userScoreChoice), userScoreChoice);
		currentScoreboard.setAlreadyUsedScores(userScoreChoice);
		currentScoreboard.setScoreArray(findScoreValueOfUserChoice(gameDice, userScoreChoice), userScoreChoice);
		System.out.println();
		System.out.println("Your current Scoreboard \n" + currentScoreboard);
		System.out.println("Your current score is " + currentScoreboard.getTotalScore());
		System.out.println();
		totalRounds++;

	}		
	
	
	System.out.println("Game Over!" +  currentScoreboard.getTotalScore() + " is a good score!");
	
	
	}
	
	public static int findScoreValueOfUserChoice(YahtzeeDice gameDice, int userInput) {  //to do
		if(userInput == 0)
			return Checkrolls.getOnes(gameDice.getDiceValues());
		if(userInput == 1)
			return Checkrolls.getTwos(gameDice.getDiceValues());
		if(userInput == 2)
			return Checkrolls.getThrees(gameDice.getDiceValues());
		if(userInput == 3)
			return Checkrolls.getFours(gameDice.getDiceValues());
		if(userInput == 4)
			return Checkrolls.getFives(gameDice.getDiceValues());
		if(userInput == 5)
			return Checkrolls.getSixes(gameDice.getDiceValues());
		if(userInput == 6)
			return Checkrolls.getThreeOfAKind(gameDice.getDiceValues());
		if(userInput == 7)
			return Checkrolls.getFourOfAKind(gameDice.getDiceValues());
		if(userInput == 8)
			return Checkrolls.getFullHouse(gameDice.getDiceValues());
		if(userInput == 9)
			return Checkrolls.getSmallStraight(gameDice.getDiceValues());
		if(userInput == 10)
			return Checkrolls.getLargeStraight(gameDice.getDiceValues());
		if(userInput == 11)
			return Checkrolls.getChance(gameDice.getDiceValues());
		return Checkrolls.getYahtzee(gameDice.getDiceValues());

	}
	
	
	public static Scoreboard findRollOptionScoreboard(Scoreboard rollOptionScoreboard, YahtzeeDice gameDice, int[] scoreOptions) {  //to do
		scoreOptions[0] =  Checkrolls.getOnes(gameDice.getDiceValues());
		scoreOptions[1] =  Checkrolls.getTwos(gameDice.getDiceValues());
		scoreOptions[2] =  Checkrolls.getThrees(gameDice.getDiceValues());
		scoreOptions[3] =  Checkrolls.getFours(gameDice.getDiceValues());
		scoreOptions[4] =  Checkrolls.getFives(gameDice.getDiceValues());
		scoreOptions[5] =  Checkrolls.getSixes(gameDice.getDiceValues());
		scoreOptions[6] =  Checkrolls.getThreeOfAKind(gameDice.getDiceValues());
		scoreOptions[7] =  Checkrolls.getFourOfAKind(gameDice.getDiceValues());
		scoreOptions[8] =  Checkrolls.getFullHouse(gameDice.getDiceValues());
		scoreOptions[9] =  Checkrolls.getSmallStraight(gameDice.getDiceValues());
		scoreOptions[10] =  Checkrolls.getLargeStraight(gameDice.getDiceValues());
		scoreOptions[11] =  Checkrolls.getChance(gameDice.getDiceValues());
		scoreOptions[12] =  Checkrolls.getYahtzee(gameDice.getDiceValues());

		
		rollOptionScoreboard.setScoreArray(scoreOptions);
		
		
		
		return rollOptionScoreboard;
	}
	
	public static int grabUserScoreChoice(int userChoice, Scoreboard rollOptionScoreboard) {
		userChoice = -1;
		do {
			System.out.println("Pick either 0 - 12 for the score you want  ");
			userChoice = TextIO.getlnInt();
			
			
		} while((userChoice < 0 || userChoice > 12)  || rollOptionScoreboard.getAlreadyUsedScores(userChoice) == true);
		return userChoice;
	}

	
	public static void rollingDice(YahtzeeDice gameDice, boolean rollAgain, char[] holdArray, int numberOfTurnsLeft, char userInput) {
		//declaration in the subroutine might need to be changed
		
		System.out.println("Rolling...");
		rollAgain = true; 
		numberOfTurnsLeft = 2; 
		userInput = 'q';
		for(int i = 0; i < holdArray.length; i++) {
			holdArray[i] = 'f';
		}
		gameDice.roll();
		System.out.println(gameDice);
		System.out.println(numberOfTurnsLeft + " Number of turns left in round");
		
		
		while(rollAgain == true && numberOfTurnsLeft > 0) {
			do {
				System.out.print("Would you like to roll again? (y) for yes, (n) for no:  ");
				userInput = TextIO.getlnChar();
			} while(userInput != 'y' && userInput != 'n');
		
			if(userInput == 'n') {
				rollAgain = false;
				System.out.println(gameDice);
				break;
			} else {
				for(int i = 0; i < 5; i++) {
					do {
						System.out.print("Hold Die " + (i + 1) + "? (t) for yes, (f) for no:  ");
						holdArray[i] = TextIO.getlnChar();
						if(holdArray[i] == 't' || holdArray[i] == 'f') {
							break;
						}
					} while(holdArray[i] != 't' && holdArray[i] != 'f');
				}
				
				gameDice.roll(holdArray);
				System.out.println(gameDice);
				numberOfTurnsLeft--;
				System.out.println(numberOfTurnsLeft + " Number of turns left in round");
			}
		
		}
	
		
	}
}
