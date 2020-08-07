  package edu.iastate.cs228.hw4;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.ArrayList; 

public class JarvisMarch extends ConvexHull
{
	// last element in pointsNoDuplicate(), i.e., highest of all points (and the rightmost one in case of a tie)
	private Point highestPoint; 
	
	// left chain of the convex hull counterclockwise from lowestPoint to highestPoint
	private PureStack<Point> leftChain; 
	
	// right chain of the convex hull counterclockwise from highestPoint to lowestPoint
	private PureStack<Point> rightChain; 
		

	/**
	 * Call corresponding constructor of the super class.  Initialize the variable algorithm 
	 * (from the class ConvexHull). Set highestPoint. Initialize the two stacks leftChain 
	 * and rightChain. 
	 * 
	 * @throws IllegalArgumentException  when pts.length == 0
	 */
	public JarvisMarch(Point[] pts) throws IllegalArgumentException 
	{
		super(pts); 
		
		algorithm="Jarvis' March";
		
		highestPoint=pointsNoDuplicate[pointsNoDuplicate.length-1];
		
		rightChain= new ArrayBasedStack<Point>();
		leftChain= new ArrayBasedStack<Point>();
		
	}

	
	/**
	 * Call corresponding constructor of the superclass.  Initialize the variable algorithm.
	 * Set highestPoint.  Initialize leftChain and rightChain.  
	 * 
	 * @param  inputFileName
	 * @throws FileNotFoundException
	 * @throws InputMismatchException   when the input file contains an odd number of integers
	 */
	public JarvisMarch(String inputFileName) throws FileNotFoundException, InputMismatchException
	{
		super(inputFileName); 
		
		algorithm="Jarvis' March";
		
		highestPoint=pointsNoDuplicate[pointsNoDuplicate.length-1];
		
		rightChain= new ArrayBasedStack<Point>();
		leftChain= new ArrayBasedStack<Point>();
		
	}


	// ------------
	// Javis' march
	// ------------

	/**
	 * Calls createRightChain() and createLeftChain().  Merge the two chains stored on the stacks  
	 * rightChain and leftChain into the array hullVertices[].
	 * 
     * Two degenerate cases below must be handled: 
     * 
     *     1) The array pointsNoDuplicates[] contains just one point, in which case the convex
     *        hull is the point itself. 
     *     
     *     2) The array contains only two points, in which case the hull is the line segment 
     *        connecting them.   
	 */
	public void constructHull()
	{
		time=System.nanoTime();
		if(pointsNoDuplicate.length<=2){
			hullVertices=pointsNoDuplicate;
		}
		ArrayList<Point> list = new ArrayList<Point>();
		
		createRightChain();
		createLeftChain();
		
		while(leftChain.size()>0){
			list.add(0, leftChain.pop());
		}
		
		while(rightChain.size()>0){
			list.add(0, rightChain.pop());
		}
		
		hullVertices= new Point[list.size()]; 
		for(int i=0; i<list.size(); i++){
			hullVertices[i]=list.get(i);
		}
		
		time=System.nanoTime()-time;
	}
	
	
	/**
	 * Construct the right chain of the convex hull.  Starts at lowestPoint and wrap around the 
	 * points counterclockwise.  For every new vertex v of the convex hull, call nextVertex()
	 * to determine the next vertex, which has the smallest polar angle with respect to v.  Stop 
	 * when the highest point is reached.  
	 * 
	 * Use the stack rightChain to carry out the operation.  
	 * 
	 * Ought to be private, but is made public for testing convenience. 
	 */
	public void createRightChain()
	{
		Point trial= new Point(lowestPoint);
		rightChain.push(trial);
		while(trial!=highestPoint){
			trial=nextVertex(trial);
			rightChain.push(trial);
		}
		
	}
	
	
	/**
	 * Construct the left chain of the convex hull.  Starts at highestPoint and continues the 
	 * counterclockwise wrapping.  Stop when lowestPoint is reached.  
	 * 
	 * Use the stack leftChain to carry out the operation. 
	 * 
	 * Ought to be private, but is made public for testing convenience. 
	 */
	public void createLeftChain()
	{
		Point trial= new Point(highestPoint);
		while(trial!=lowestPoint){
			trial=nextVertex(trial);
			leftChain.push(trial);
		}
		
	}
	
	
	/**
	 * Return the next vertex, which is less than all other points by polar angle with respect
	 * to the current vertex v. When there is a tie, pick the point furthest from v. Comparison 
	 * is done using a PolarAngleComparator object created by the constructor call 
	 * PolarAngleCompartor(v, false).
	 * 
	 * Ought to be private. Made public for testing. 
	 * 
	 * @param v  current vertex 
	 * @return
	 */
	public Point nextVertex(Point v)
	{
		PolarAngleComparator n =new PolarAngleComparator(v, false);
		quicksorter.quickSort(n);
		quicksorter.getSortedPoints(pointsNoDuplicate);
		Point p= pointsNoDuplicate[0];

		return p; 
	}
}
