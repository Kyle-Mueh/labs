package edu.iastate.cs228.hw4;

import java.util.Arrays;
import java.util.Comparator;

import edu.iastate.cs228.hw4.Point;

/**
 * This class sorts an array of Point objects using a provided Comparator.  You may 
 * modify your implementation of quicksort from Project 2.  
 */

@SuppressWarnings("unused")
public class QuickSortPoints
{
	private Point[] points;  	// Array of points to be sorted.
	

	/**
	 * Constructor takes an array of Point objects. 
	 * 
	 * @param pts
	 */
	QuickSortPoints(Point[] pts)
	{
		points=pts;
		
	}
	
	
	/**
	 * Copy the sorted array to pts[]. 
	 * 
	 * @param pts  array to copy onto
	 */
	void getSortedPoints(Point[] pts)
	{
		pts=points; 
	}

	
	/**
	 * Perform quicksort on the array points[] with a supplied comparator. 
	 * 
	 * @param arr
	 * @param comp
	 */
	public void quickSort(Comparator<Point> comp)
	{
		quickSortRec(0, points.length -1, comp);
		
	}
	
	
	/**
	 * Operates on the subarray of points[] with indices between first and last. 
	 * 
	 * @param first  starting index of the subarray
	 * @param last   ending index of the subarray
	 */
	private void quickSortRec(int first, int last, Comparator<Point> comp)
	{
		if(first>=last){
			return;
		}
		
		int partition= partition(first, last, comp);
		quickSortRec(first, partition-1, comp);
		quickSortRec(partition+1, last, comp);
		
	}
	

	/**
	 * Operates on the subarray of points[] with indices between first and last.
	 * 
	 * @param first
	 * @param last
	 * @return
	 */
	private int partition(int first, int last, Comparator<Point> comp)
	{
		Point pivot= points[last];
		int i= first-1;
		for( int j= first; j < last; j++){
			if(comp.compare(points[j],  pivot)==-1){
				i++;
				swap(i, j);
			}
		}
		swap(i+1, last);
		return (i+1);
		 
	}
	/*
	 * helper method
	 */
	private void swap(int i, int j){
		Point temp;
		temp=points[i];
		points[i]=points[j];
		points[j]=temp;
	}
}


