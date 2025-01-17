package edu.iastate.cs228.hw5;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;

/**
 * @author Kyle Muehlenthaler
 */
public class ABTreeSet<E extends Comparable<? super E>> extends AbstractSet<E> {

	final class ABTreeIterator implements Iterator<E> {
		// TODO add private fields here

		ABTreeIterator() {
			// TODO

		}

		@Override
		public boolean hasNext() {
			// TODO

			return false;
		}

		@Override
		public E next() {
			// TODO

			return null;
		}

		@Override
		public void remove() {
			// TODO

		}
	}

	final class Node implements BSTNode<E> {
		private int count;
		private E data;
		private BSTNode<E> node;
		// TODO add private fields here
		private BSTNode<E> parent, left, right;
		

		Node(E data) {
			// TODO

		}

		@Override
		public int count() {
			return count;
		}

		@Override
		public E data() {
			// TODO//

			return data;
		}

		@Override
		public BSTNode<E> left() {
			// TODO//

			return left;
		}

		@Override
		public BSTNode<E> parent() {
			// TODO//

			return parent;
		}

		@Override
		public BSTNode<E> right() {
			// TODO//

			return right;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	// TODO add private fields here

	/**
	 * Default constructor. Builds a non-self-balancing tree.
	 */
	public ABTreeSet() {
		// TODO

	}

	/**
	 * If <code>isSelfBalancing</code> is <code>true</code> <br>
	 * builds a self-balancing tree with the default value alpha = 2/3.
	 * <p>
	 * If <code>isSelfBalancing</code> is <code>false</code> <br>
	 * builds a non-self-balancing tree.
	 * 
	 * @param isSelfBalancing
	 */
	public ABTreeSet(boolean isSelfBalancing) {
		// TODO

	}

	/**
	 * If <code>isSelfBalancing</code> is <code>true</code> <br>
	 * builds a self-balancing tree with alpha = top / bottom.
	 * <p>
	 * If <code>isSelfBalancing</code> is <code>false</code> <br>
	 * builds a non-self-balancing tree (top and bottom are ignored).
	 * 
	 * @param isSelfBalancing
	 * @param top
	 * @param bottom
	 * @throws IllegalArgumentException
	 *             if (1/2 < alpha < 1) is false
	 */
	public ABTreeSet(boolean isSelfBalancing, int top, int bottom) {
		// TODO

	}

	/**
	 * {@inheritDoc}
	 * 
	 * @throws NullPointerException
	 *             if e is null.
	 */
	@Override
	public boolean add(E e) {
		// TODO

		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO

		return false;
	}

	/**
	 * @param e
	 * @return BSTNode that contains e, null if e does not exist
	 */
	public BSTNode<E> getBSTNode(E e) {
		// TODO

		return null;
	}

	/**
	 * Returns an in-order list of all nodes in the given sub-tree.
	 * 
	 * @param root
	 * @return an in-order list of all nodes in the given sub-tree.
	 */
	public List<BSTNode<E>> inorderList(BSTNode<E> root) {
		// TODO

		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO

		return null;
	}

	/**
	 * Returns an pre-order list of all nodes in the given sub-tree.
	 * 
	 * @param root
	 * @return an pre-order list of all nodes in the given sub-tree.
	 */
	public List<BSTNode<E>> preorderList(BSTNode<E> root) {
		// TODO

		return null;
	}

	/**
	 * Performs a re-balance operation on the subtree rooted at the given node.
	 * 
	 * @param bstNode
	 */
	public void rebalance(BSTNode<E> bstNode) {
		// TODO

	}

	@Override
	public boolean remove(Object o) {
		// TODO

		return false;
	}

	/**
	 * Returns the root of the tree.
	 * 
	 * @return the root of the tree.
	 */
	public BSTNode<E> root() {
		// TODO

		return null;
	}

	public void setSelfBalance(boolean isSelfBalance) {
		// TODO

	}

	@Override
	public int size() {
		// TODO

		return 0;
	}

	public BSTNode<E> successor(BSTNode<E> node) {
		// TODO

		return null;
	}

	@Override
	public String toString() {
		// TODO

		return null;
	}

}
