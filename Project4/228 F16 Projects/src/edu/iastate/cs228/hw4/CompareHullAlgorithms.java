package edu.iastate.cs228.hw4;

/**
 *  
 * @author Kyle Muehlenthaler
 *
 */

/**
 * 
 * This class executes four sorting algorithms: selection sort, insertion sort, mergesort, and
 * quicksort, over randomly generated integers as well integers from a file input. It compares the 
 * execution times of these algorithms on the same input. 
 *
 */

import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.Random; 


public class CompareHullAlgorithms 
{
	/**
	 * Repeatedly take points either randomly generated or read from files. Perform Graham's scan and 
	 * Jarvis' march over the input set of points, comparing their performances.  
	 * 
	 * @param args
	 **/
	public static void main(String[] args) 
	{		
		
		System.out.println("Comparison between Convex Hull Algorithms \nEnter 1 for random points to be added \nEnter 2 for a file to be read \nEnter any other number to terminate the loop \n \n");
		
		String fileName="";
		int trial=1;
		int choice=0;
		Random rand= new Random();
		int value=0;
		boolean terminate=false;
		Point[] pts= null;
		
		ConvexHull[] algorithms = new ConvexHull[2]; 
		
		Scanner in= new Scanner(System.in);
		
		while(! terminate){
		System.out.println("Trial " +trial+": ");
		choice= in.nextInt();
		
		if(choice==1){
			System.out.println("Enter number of random points: ");
			value= in.nextInt();
			pts=generateRandomPoints(value, rand);
			algorithms[0]= new GrahamScan(pts);
			algorithms[1]= new JarvisMarch(pts);
			
			algorithms[0].constructHull();
			algorithms[1].constructHull();
			
			algorithms[0].draw();
			algorithms[1].draw();
		}
		if(choice==2){
			System.out.println("Points from a file \nFile name: ");
			fileName= in.next();
			try{
			algorithms[0]= new GrahamScan(fileName);
			algorithms[1]= new JarvisMarch(fileName);
			}catch(FileNotFoundException e){
				System.out.println("no such file");
			}
			
			algorithms[0].constructHull();
			algorithms[1].constructHull();
			
			algorithms[0].draw();
			algorithms[1].draw();
		}
		
		
		if(choice!=1 && choice!= 2){
			terminate=true;
		}else{
			
		// TODO 
		// 
		// Conducts multiple rounds of convex hull construction. Within each round, performs the following: 
		// 
		//    1) If the input are random points, calls generateRandomPoints() to initialize an array 
		//       pts[] of random points. Use pts[] to create two objects of GrahamScan and JarvisMarch, 
		//       respectively.
		//
		//    2) If the input is from a file, construct two objects of the classes GrahamScan and  
		//       JarvisMarch, respectively, using the file.     
		//
		//    3) Have each object call constructHull() to build the convex hull of the input points.
		//
		//    4) Meanwhile, prints out the table of runtime statistics.
		// 
		// A sample scenario is given in Section 4 of the project description. 
		// 	

			
			System.out.print("algorithm \t size \t time (ns) \n --------------------------------------- \n");
			System.out.println(algorithms[0].stats());
			System.out.println(algorithms[1].stats());
			System.out.println("--------------------------------------- \n");
		}
		// Within a hull construction round, have each algorithm call the constructHull() and draw()
		// methods in the ConvexHull class.  You can visually check the result. (Windows 
		// have to be closed manually before rerun.)  Also, print out the statistics table 
		// (see Section 4). 
		trial++;
		}
		in.close();
	}
	
	
	/**
	 * This method generates a given number of random points.  The coordinates of these points are 
	 * pseudo-random numbers within the range [-50,50] × [-50,50]. 
	 * 
	 * Reuse your implementation of this method in the CompareSorter class from Project 2.
	 * 
	 * @param numPts  	number of points
	 * @param rand      Random object to allow seeding of the random number generator
	 * @throws IllegalArgumentException if numPts < 1
	 */
	private static Point[] generateRandomPoints(int numPts, Random rand) throws IllegalArgumentException
	{ 
		if(numPts<1){
			throw new IllegalArgumentException("no points");
		}
		Point[] p= new Point[numPts];
		for(int i=0; i<numPts; i++){
			p[i]=new Point(rand.nextInt(101)-50, rand.nextInt(101)-50);
		}
		return p;  
	}
}
