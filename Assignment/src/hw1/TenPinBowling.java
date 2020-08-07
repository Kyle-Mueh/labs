package hw1;

public class TenPinBowling {

private int frames, frameCount, rollNumber, pinsDown, pinsPrevious, score, bonus; 
private boolean isOver;	
public static final int PINS = 10;
	/*Constructs a game with the given number of total frames. Initially all 10 pins are up, it is
	* frame number 1, roll number 1, and the score is zero.
	*/
	public TenPinBowling(int howManyFrames){
		frames=howManyFrames;
		reset();
		
	}
	
	/*Returns the current frame number, or -1 if the game is over. Frames are numbered
	*starting with 1.
	*/
	public int getFrameNumber(){
		return frameCount;
	}
	
	/*Returns the current roll number within the frame, or -1 if the game is over. Rolls within
	* each frame are numbered starting with 1.
	*/
	public int getRollNumber(){
		return rollNumber;
	}
	
	/*Returns the number of standing pins in this game, or -1 if the game is over.
	*/
	public int getPinsUp(){
		return PINS-pinsDown;
	}
	
	/*Returns true if this game is over, false otherwise.
	*/
	public boolean isOver(){
		return isOver;
	}
	
	/*Returns the current score for this game. This method should return 0 on initialization or
	*after a reset. When the game is over, this method should return the correct final score. At
	*any other point in the game, the score includes all points up through the most recent roll.
	*If the roll is counted multiple times due to a previous strike or spare, the bonus points are
	*included.
	*/
	public int getScore(){
		return score;
	}
	
	/*Simulates rolling a bowling ball that knocks down the given number of pins. If the
	*number given is greater than the number of pins still standing in this game, or if the game
	*is already over, this method does nothing. Otherwise, this method should correctly
	*update the frame number, roll number, score, and status (over or not).
	*/
	public void roll(int pins){
		if(frameCount==frames){
			if(PINS-pinsDown>pins && !isOver){
				score+=pins;
				if(bonus>0){     	//If you got a strike or spare last frame
					score+=pins;
					bonus--;
					if(bonus==2){	// If two strikes in a row
						score+=pins;
						bonus--;
					}
				}
				pinsDown+=pins;
				pinsPrevious=pins;
				rollNumber++;
				if(rollNumber==2 && frameCount<frames && bonus==0){
					rollNumber=1;
					frameCount++;
					pinsDown=0;
				}
				else if (bonus>0){
					rollNumber++;
				}
					
				if(pins==10 && rollNumber==1){
					bonus+=2;
					rollNumber++;
				}
				if(pinsPrevious+pins==10 && rollNumber==2){
					bonus++;
					rollNumber++;
				}
				if(rollNumber==3 || rollNumber==2 && bonus==0){
					isOver=true;
					frameCount++;}
			}
		}
		if(PINS-pinsDown>pins && !isOver){
			score+=pins;
			if(bonus>0){     	//If you got a strike or spare last frame
				score+=pins;
				bonus--;
				if(bonus==2){	// If two strikes in a row
					score+=pins;
					bonus--;
				}
			}
			pinsDown+=pins;
			pinsPrevious=pins;
			rollNumber++;
			if(rollNumber==2 && frameCount<frames){
				rollNumber=1;
				frameCount++;
				pinsDown=0;
			}
			if(pins==10 && rollNumber==1){
				bonus+=2;
				rollNumber=1;
				frameCount++;
				pinsPrevious=0;
			}
			if(pinsPrevious+pins==10 && rollNumber==2){
				bonus++;
				pinsPrevious=0;
				frameCount++;
				rollNumber=1;
				
			}
		}
		
	}
	
	/*Resets this game to the starting state described in the constructor.
	*/
	public void reset(){
		frameCount=1;
		rollNumber=1;
		pinsDown=0;
		score=0;
		bonus=0;
		isOver=false;
	}
	
}
