package edu.iastate.cs228.hw4;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.ArrayList; 

@SuppressWarnings("unused")
public class GrahamScan extends ConvexHull
{
	/**
	 * Stack used by Grahma's scan to store the vertices of the convex hull of the points 
	 * scanned so far.  At the end of the scan, it stores the hull vertices in the 
	 * counterclockwise order. 
	 */
	private PureStack<Point> vertexStack;  


	/**
	 * Call corresponding constructor of the super class.  Initialize the variables algorithm 
	 * (from the class ConvexHull) and vertexStack. 
	 * 
	 * @throws IllegalArgumentException  if pts.length == 0
	 */
	public GrahamScan(Point[] pts) throws IllegalArgumentException 
	{
		super(pts); 
		if(pts.length==0)
			throw new IllegalArgumentException("empty point array");
		algorithm="Graham's Scan";
		vertexStack= new ArrayBasedStack<Point>();

	}
	

	/**
	 * Call corresponding constructor of the super class.  Initialize algorithm and vertexStack.  
	 * 
	 * @param  inputFileName
	 * @throws FileNotFoundException
	 * @throws InputMismatchException   when the input file contains an odd number of integers
	 */
	public GrahamScan(String inputFileName) throws FileNotFoundException, InputMismatchException
	{
		super(inputFileName); 
		
		algorithm="Graham's Scan";
		
		vertexStack= new ArrayBasedStack<Point>(); 
	}

	
	// -------------
	// Graham's scan
	// -------------
	
	/**
	 * This method carries out Graham's scan in several steps below: 
	 * 
	 *     1) Call the private method setUpScan() to sort all the points in the array 					[X]
	 *        pointsNoDuplicate[] by polar angle with respect to lowestPoint.    
	 *        
	 *     2) Perform Graham's scan. To initialize the scan, push pointsNoDuplicate[0] and 				[X]
	 *        pointsNoDuplicate[1] onto vertexStack.  
	 * 
     *     3) As the scan terminates, vertexStack holds the vertices of the convex hull.  Pop the 		[]
     *        vertices out of the stack and add them to the array hullVertices[], starting at index
     *        vertexStack.size() - 1, and decreasing the index toward 0.    
     *        
     * Two degenerate cases below must be handled: 
     * 
     *     1) The array pointsNoDuplicates[] contains just one point, in which case the convex			[]
     *        hull is the point itself. 
     *     
     *     2) The array contains only two points, in which case the hull is the line segment 			[]
     *        connecting them.   
	 */
	public void constructHull()
	{
		time=System.nanoTime();
		
		if(pointsNoDuplicate.length==1){
			vertexStack.push(pointsNoDuplicate[0]);
		}else if(pointsNoDuplicate.length==2){
			vertexStack.push(pointsNoDuplicate[0]);
			vertexStack.push(pointsNoDuplicate[1]);
		}else{
			
		
			setUpScan();
			
			vertexStack.push(pointsNoDuplicate[0]);
			vertexStack.push(pointsNoDuplicate[1]);
			vertexStack.push(pointsNoDuplicate[2]);
			for(int i=3; i<pointsNoDuplicate.length; i++){
			Point top, mid, bot;
			top=pointsNoDuplicate[i];
			mid=vertexStack.pop();
			
			if(vertexStack.size()<3){
				vertexStack.push(mid);
				vertexStack.push(top);
			}else{
				bot=vertexStack.peek();
			
				PolarAngleComparator comp = new PolarAngleComparator(bot, false);
			
				if(comp.compare(mid, top)<0){
					vertexStack.push(mid);
					vertexStack.push(top);
				}else if(comp.compare(mid, top)>0){ 
					i--;
				}else{
					vertexStack.push(top); 
				}
			}
		}
		vertexStack.push(lowestPoint);
		
		int i=vertexStack.size();
		hullVertices= new Point[i];
			while(vertexStack.size()>0){
				hullVertices[i-1]=vertexStack.pop();
				i--;
			}
			
		}
		time=System.nanoTime()-time;
	}
	
	
	/**
	 * Set the variable quicksorter from the class ConvexHull to sort by polar angle with respect 
	 * to lowestPoint, and call quickSort() from the QuickSortPoints class on pointsNoDupliate[]. 
	 * The argument supplied to quickSort() is an object created by the constructor call 
	 * PolarAngleComparator(lowestPoint, true).       
	 * 
	 * Ought to be private, but is made public for testing convenience. 
	 *
	 */
	public void setUpScan()
	{
		PolarAngleComparator i = new PolarAngleComparator(lowestPoint, true);
		quicksorter.quickSort(i);
		quicksorter.getSortedPoints(pointsNoDuplicate);
		
		
	}	
}
