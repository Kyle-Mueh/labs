package hw1;

public class TenPinBowling {
/**
 * frames was used to be given a maximum frames to be bowled
 * frameCount was used to count the frames as the player went through them
 * rollNumber was used to keep track of each time the user rolled the ball in a frame
 * pinsDown was used to count the number of pins knocked over in a frame.
 * score was used to keep the total score of the player
 * bonus was used to calculate the strike and spare bonuses
 * finalBowl was used in the final frame to keep the score from being off
 */
private int frames, frameCount, rollNumber, pinsDown, score, bonus, finalBowl; 
private boolean isOver;	
public static final int PINS = 10;
	/**
	* Constructs a game with the given number of total frames. Initially all 10 pins are up, it is
	* frame number 1, roll number 1, and the score is zero.
	* 
	* uses reset to make all values the correct values.
	*/
	public TenPinBowling(int howManyFrames){
		frames=howManyFrames;
		reset();
		
	}
	
	/**
	* Returns the current frame number, or -1 if the game is over. Frames are numbered
	*starting with 1.
	*/
	public int getFrameNumber(){
		return frameCount;
	}
	
	/**
	* Returns the current roll number within the frame, or -1 if the game is over. Rolls within
	* each frame are numbered starting with 1.
	*/
	public int getRollNumber(){
		return rollNumber;
	}
	
	/**
	* Returns the number of standing pins in this game, or -1 if the game is over.
	*/
	public int getPinsUp(){
		return PINS-pinsDown;
	}
	
	/**
	* Returns true if this game is over, false otherwise.
	*/
	public boolean isOver(){
		return isOver;
	}
	
	/**
	* Returns the current score for this game. This method should return 0 on initialization or
	*after a reset. When the game is over, this method should return the correct final score. At
	*any other point in the game, the score includes all points up through the most recent roll.
	*If the roll is counted multiple times due to a previous strike or spare, the bonus points are
	*included.
	*/
	public int getScore(){
		return score;
	}
	
	/**
	* Simulates rolling a bowling ball that knocks down the given number of pins. If the
	*number given is greater than the number of pins still standing in this game, or if the game
	*is already over, this method does nothing. Otherwise, this method should correctly
	*update the frame number, roll number, score, and status (over or not).
	*/
	public void roll(int pins){
		if(frameCount<frames && pins <= getPinsUp() && frameCount!=-1){	//checks for before final frame
			
			if(bonus==3){							//if two strikes in a row
				score+=pins*3;
				bonus-=2;
			}
			else if(bonus==2 || bonus==1){			//if one strike or spare bonus
				score+=pins*2;
				bonus--;
			}
			else 
				score+=pins;
			pinsDown+=pins;
			
			if(pinsDown==PINS && rollNumber==2){
				bonus++;
			}
			rollNumber++;
			if(pins==PINS && rollNumber==2){
				frameCount++;
				rollNumber=1;
				pinsDown=0;
				bonus+=2;
			}
			if(rollNumber==3){
				frameCount++;
				rollNumber=1;
				pinsDown=0;
			}	
			
		}
		else if(frameCount==frames){		//checks for final frame
			if(bonus==3 && finalBowl>0){					//if two strikes in a row
				score+=pins*2;
				bonus-=2;
			}
			else if(bonus==3){					//if two strikes in a row
				score+=pins*3;
				bonus-=2;
			}
			else if((bonus==2 || bonus==1) && finalBowl>0){		//if one strike or spare bonus
				score+=pins;
				bonus--;
			}
			else if(bonus==2 || bonus==1){		//if one strike or spare bonus
				score+=pins*2;
				bonus--;
			}
			else if(rollNumber==1 || rollNumber==2 && finalBowl==0)
				score+=pins;			
			
			pinsDown+=pins;
			if(pins==PINS && rollNumber==1){
				bonus+=2;
				pinsDown=0;
				finalBowl+=2;
			}
			if(pinsDown==PINS && rollNumber==2){
				bonus++;
				finalBowl++;
				pinsDown=0;
			}
			
			
			if(rollNumber==2 && bonus==0){
				frameCount++;
			}
			else if(rollNumber==3){
				frameCount++;
			}
			rollNumber++;
		}
		if(frameCount>frames){	//if last frame passed it ends the game
			isOver=true;
			frameCount=-1;
			rollNumber=-1;
			pinsDown=11;
		}
		
	}
	
	/**
	* Resets this game to the starting state described in the constructor.
	*/
	public void reset(){
		frameCount=1;
		rollNumber=1;
		pinsDown=0;
		finalBowl=0;
		score=0;
		bonus=0;
		isOver=false;
	}
	
}