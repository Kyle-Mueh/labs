  package hw3;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents values of a group of dice for a dice game such as Yahtzee in which 
 * multiple rolls per turn are allowed. The number of faces on the dice, 
 * the number of dice in the Hand, and the maximum number of rolls are configurable 
 * via the constructor. At any time some of the dice may be <em>available</em>
 * to be rolled, and the other dice are <em>fixed</em>.  Calls to the 
 * <code>roll()</code> method will select new, random values for the available
 * dice only.  After the maximum number of rolls, all dice are automatically
 * fixed; before that, the client can select which dice to "keep" (change from
 * available to fixed) and which dice to "free" (change from fixed to
 * available).
 * <p>
 * Note that valid die values range from 1 through the given
 * <code>maxValue</code>. 
 */
public class Hand
{
	private int die[];
	private ArrayList<Integer> fixed, avail;
	private int maxValue, maxRolls, numRolls, numDice;
  /**
   * Constructs a new Hand in which each die initially has 
   * the (invalid) value zero. 
   * @param numDice
   *   number of dice in this group
   * @param maxValue
   *   largest possible die value, where values range from 1
   *   through <code>maxValue</code>
   * @param maxRolls
   *   maximum number of total rolls
   */
  public Hand(int numDice, int maxValue, int maxRolls)
  {
	  fixed=new ArrayList<Integer>();
	  avail=new ArrayList<Integer>();
	  this.maxValue=maxValue;
	  this.maxRolls=maxRolls;
	  this.numDice=numDice;
	  die= new int[numDice];
	  for(int i=0; i<numDice; i++){
		  die[i]=0;
		  avail.add(die[i]);
	  }
	  numRolls=0;
    // TODO
  }   
  
  /**
   * Constructs a new Hand in which each die initially has 
   * the value given by the <code>initialValues</code> array.
   * If the length of the array is greater than the number of dice, the
   * extra values are ignored.  If the length of the array is smaller
   * than the number of dice, remaining dice
   * will be initialized to the (invalid) value 0.
   * <p>
   * This version of the constructor is primarily intended for testing.
   * @param numDice
   *   number of dice in this group
   * @param maxValue
   *   largest possible die value, where values range from 1
   *   through <code>maxValue</code>
   * @param maxRolls
   *   maximum number of total rolls
   * @param initialValues
   *   initial values for the dice
   */
  public Hand(int numDice, int maxValue, int maxRolls, int[] initialValues)
  {
	  fixed=new ArrayList<Integer>();
	  avail=new ArrayList<Integer>();
	  this.maxValue=maxValue;
	  this.maxRolls=maxRolls;
	  this.numDice=numDice;
	  int i=0;
	  while(i<die.length && i<initialValues.length){
		  die[i]=initialValues[i];
		  avail.add(die[i]);
		  i++;
	  }
	  if(die.length>initialValues.length){
		  while(i<die.length){
			  die[i]=0;
			  avail.add(die[i]);
			  i++;
		  }
	  }
	  numRolls=0;
    // TODO
  }  
  
  /**
   * Returns the number of dice in this group.
   * @return
   *   number of dice in this group
   */
  public int getNumDice()
  {
    return numDice;
  }
  
  /**
   * Returns the maximum die value in this group.
   * Valid values start at 1.
   * @return
   *   maximum die value
   */
  public int getMaxValue()
  {
    // TODO
    return maxValue;
  }
  
  /**
   * Rolls all available dice; that is, each available
   * die value in this group is replaced by a randomly generated
   * value produced by the given random number generator.
   * @param rand
   *   random number generator to be used for rolling dice
   */
  public void roll(Random rand)
  {
	  numRolls++;
	  int i=0;
	  while(i<avail.size()){
		  avail.set(i ,rand.nextInt(maxValue-1) +1);
	  }
    // TODO
  }

  /**
   * Selects a die value to be moved from the available dice to the
   * fixed dice. Has no effect if the given value is 
   * not among the values in the available dice. Has no effect if
   * the number of rolls has reached the maximum.
   * @param value
   *   die value to be moved from available to fixed
   */
  public void keep(int value)
  {
	  if(numRolls<maxRolls && avail.contains(value)){
		  fixed.add(value);
		  avail.remove(avail.indexOf(value));
	  }
    // TODO
  }

  /**
   * Selects a die value to be moved from the fixed dice to
   * the available dice, so it will be re-rolled in the
   * next call to <code>roll()</code>. Has no effect if the given value is 
   * not among the values in the fixed dice. Has no effect if
   * the number of rolls has reached the maximum.
   * @param value
   *   die value to be moved
   */
  public void free(int value)
  {
	  if(numRolls<maxRolls && fixed.contains(value)){
		  avail.add(value);
		  fixed.remove(fixed.indexOf(value));
	  }
    // TODO
  }
  
  /**
   * Causes all die values be moved from the available dice to the
   * fixed dice. Has no effect if
   * the number of rolls has reached the maximum.
   */
  public void keepAll()
  {
	  if(numRolls<maxRolls){
		  fixed.addAll(avail);
		  avail.clear();
	  }
    // TODO
  }
  
  /**
   * Causes all die values be moved from the fixed dice to the
   * available dice. Has no effect if
   * the number of rolls has reached the maximum.
   */
  public void freeAll()
  {
	  if(numRolls<maxRolls){
		  avail.addAll(fixed);
		  fixed.clear();
	  }
    // TODO
  }
  
  /**
   * Determines whether there are any dice available to be 
   * rolled in this group.
   * @return
   *   true if there are no available dice, false otherwise
   */
  public boolean isComplete()
  {
	  if(avail.size()==0)
		  return true;
    // TODO
    return false;
  }

  /**
   * Returns the values of the dice that are currently fixed (not
   * available to be rerolled) in ascending order.
   * @return
   *   values of the dice that are currently fixed
   */
  public int[] getFixedDice()
  {
	  int[] list= new int[fixed.size()];
	  for(int i=0; i<fixed.size(); i++){
		  list[i]=fixed.get(i);
	  }
	  Arrays.sort(list);
    // TODO
    return list;
  }
  
  /**
   * Returns the values of the dice that are currently available to
   * be rerolled by a subsequent call to <code>roll()</code>,
   * in ascending order.
   * @return
   *   dice that are available to be rerolled
   */
  public int[] getAvailableDice()
  {
	  int[] list= new int[avail.size()];
	  for(int i=0; i<avail.size(); i++){
		  list[i]=avail.get(i);
	  }
	  Arrays.sort(list);
    // TODO
    return list;
  }
 
  /**
   * Returns all die values in this group, in ascending order.
   * @return
   *   all die values in this group
   */
  public int[] getAll()
  {
	  int i;
	  int[] list= new int[fixed.size()+avail.size()];
	  for(i=0; i<fixed.size(); i++){
		  list[i]=fixed.get(i);
	  }
	  
	  for(int j=0; j<avail.size(); j++){
		  list[i+j]=avail.get(j);
	  }
	  Arrays.sort(list);
    // TODO
    return list;
  }
  
  /**
   * Returns a string representation of the die values in
   * this hand, in the form <em>available</em>(<em>fixed</em>).
   * (For example, if there are two fixed dice with values 2
   * and 4, and there are 3 available dice with values 1, 1, and 6,
   * then the method returns the string
   * <pre>
   * 1 1 6 (2 4)
   * </pre>
   * If all dice are available, the parentheses should be empty.
   * @return 
   *   string representation of the available and completed dice,
   *   with the completed values in parentheses
   */
  @Override
  public String toString()
  {
    StringBuilder sb = new StringBuilder();
    int[] availableDice = getAvailableDice();
    for (int value : availableDice)
    {
      sb.append(value + " ");
    }

    sb.append("(");
    int[] fixedDice = getFixedDice();
    if (fixedDice.length > 0)
    {
      // use an index so we can add the first one without a leading space
      sb.append(fixedDice[0]);
      for (int i = 1; i < fixedDice.length; ++i)
      {
        sb.append(" " + fixedDice[i]);
      }
    }
    sb.append(")");
    return sb.toString();
  } 
}
