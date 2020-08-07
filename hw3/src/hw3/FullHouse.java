package hw3;
import hw3.api.Category;
/**
 * Scoring category for a generalized full house.  A hand
 * with N dice satisfies this category only in the following cases:
 * If N is even, there are two different values, each occurring exactly N/2 times.
 * If N is odd, there are two different values, one of them occurring N/2 times and
 * the other occurring N/2 + 1 times.  For a hand that satisfies
 * this category, the score is a fixed value specified in the constructor;
 * otherwise, the score is zero.
 */
public class FullHouse implements Category
{
	
	private String displayName;
	private int score;
	private Hand hand;
	private boolean isFull;
  /**
   * Constructs a FullHouse category with the given display name
   * and score.
   * @param displayName
   *   name of this category
   * @param points
   *   points awarded for a hand that satisfies this category
   */  
	public FullHouse(String displayName, int points)
  {
	  isFull=false;
	  score=points;
	  this.displayName=displayName;

    // TODO
  }
  	public boolean isFilled(){
		//TODO
		return isFull;
	}
	  
	  /**
	   * Returns the score for this category, or zero if the 
	   * category is not <em>filled</em>.
	   * @return
	   *   score for the category or zero if not filled
	   */
	  public int getScore(){
		//TODO
		  if(isFilled())
			  return score;
		  return 0;
	  }

	  /**
	   * Returns the hand that was used to fill this category, or null if
	   * not <em>filled</em>.  
	   * @return
	   *   hand filling this category, or null if not filled
	   */
	  public Hand getHand(){
		  if(isFull)
			  return hand;
		  return null;
		//TODO
	  }
	  
	  /**
	   * Returns the name for this category.
	   * @return
	   *   name for this category
	   */
	  public String getDisplayName(){
		//TODO
		  return displayName;
	  }
	  
	  /**
	   * Permanently sets the hand being used to fill
	   * this category.  The score is set to the value of
	   * <code>getPotentialScore</code> for the given hand.
	   * Throws <code>IllegalStateException</code> if 
	   * the category has already been filled or if the
	   * given hand is not <em>complete</em> (as defined
	   * by the <code>Hand.isComplete</code> method).
	   * @param dice
	   *   hand to be used to satisfy this category
	   * @throws IllegalStateException
	   *   if the given hand is not <em>complete</em> (according
	   *   to the <code>isComplete()</code> method of Hand) or
	   *   if this category is already filled
	   */
	  public void fill(Hand dice){
		  if(isFull || !dice.isComplete()){
			  throw new IllegalStateException();
		  }
		  hand=dice;
		  isFull=true;
		//TODO
	  }
	    
	  /**
	   * Determines whether the given hand satisfies the defined
	   * criteria for this scoring category. The criteria are determined
	   * by the concrete type implementing the interface.
	   * This method does not modify the state of this category.
	   * @param dice
	   *   hand to check
	   * @return
	   *   true if the given hand satisfies the defined criteria for the
	   *   category, false otherwise
	   */
	  public boolean isSatisfiedBy(Hand dice){
		  int rolls[]= dice.getAll();
		  int n=rolls.length/2;
		  int num=rolls[0];
		  for(int i=0; i<=n; i++){
			  if(num!=rolls[i])
				  return false;
		  }
		  if(num==rolls[n+1]){
			  n++;
			  num=rolls[n+1];
			  for(int j=n; j<rolls.length; j++){
				  if(num!=rolls[j])
					  return false;
			  }
		  }
		  else{
			  num=rolls[n+1];
			  for(int j=n; j<rolls.length; j++){
			  if(num!=rolls[j])
				  return false;
			  }
		  }
		  return true;
		//TODO
	  }
	  
	  /**
	   * Returns the potential score that would result from 
	   * using the given hand to fill this category.
	   * Always returns zero if the <code>isSatisfiedBy()</code> 
	   * method returns false for the given hand.
	   * This method does not modify the state of this category.
	   * @param dice
	   *   hand to check
	   * @return
	   *   potential score for the given hand
	   */
	  public int getPotentialScore(Hand dice){
		  if(isSatisfiedBy(dice))
			  return score;
		  return 0;
		//TODO
	  }

}
