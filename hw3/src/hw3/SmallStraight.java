package hw3;

import hw3.api.Category;

/**
 * Scoring category for a "small straight".  A hand
 * with N dice satisfies this category only if it includes
 * N - 1 distinct consecutive values.  For a hand that satisfies
 * this category, the score is a fixed value specified in the constructor;
 * otherwise, the score is zero.
 */
public class SmallStraight implements Category
{
	private String displayName;
	private int score;
	private Hand hand;
	private boolean isFull;
  /**
   * Constructs a SmallStraight category with the given display name
   * and score.
   * @param displayName
   *   name of this category
   * @param points
   *   points awarded for a dice group that satisfies this category
   */  
  public SmallStraight(String displayName, int points)
  {
	  isFull=false;
	  score=points;
	  this.displayName=displayName;
    // TODO
  }
  
  /**
  * Determines whether this category is filled.
  * @return
  *   true if this category has a fixed hand and score, 
  *   false otherwise
  */

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
	//  TODO
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
	  int i=1;
	  int err=0;
	  while(i<rolls.length&& err<2){
		  if(rolls[i-1]!= rolls[i]+1)
			  err++;
		  
	  }
	  if(err!=2)
		  return true;
	  return false;
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
