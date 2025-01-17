package hw3;

import hw3.api.Category;

/**
 * Scoring category that is based on counting occurrences
 * of a particular target value (specified in the constructor).
 * This category is satisfied by any hand.  The score
 * is the sum of just the die values that match the target value.
 */
public class CountOccurrences implements Category
{
	private String displayName;
	private int score;
	private Hand hand;
	private boolean isFull;
	private int whichValue;
  /**
   * Constructs a CountOccurrences category with the given display name and 
   * target value.
   * @param displayName
   *   name for this category
   * @param whichValue
   *   target value that must be matched for a die to count toward the
   *   score
   */
  public CountOccurrences(String displayName, int whichValue)
  {
	  isFull=false;
	  this.whichValue=whichValue;
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
	  return isFull;
  }
  
  /**
   * Returns the score for this category, or zero if the 
   * category is not <em>filled</em>.
   * @return
   *   score for the category or zero if not filled
   */
  public int getScore(){
	  if(isFull)
		  return getPotentialScore(hand);
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
  }
  
  /**
   * Returns the name for this category.
   * @return
   *   name for this category
   */
  public String getDisplayName(){
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
	  if(isFull)
		  return true;
	  return false;
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
	  int rolls[]=dice.getAll();
	  int i=0;
	  score=0;
	  while(i<rolls.length){
		  if(rolls[i]==whichValue)
			  score++;
	  }
	  return score;
  }

  
}
