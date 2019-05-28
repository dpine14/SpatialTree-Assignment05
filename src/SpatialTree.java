import java.awt.geom.Point2D;
import java.lang.Math;
import edu.princeton.cs.algs4.*;

public class SpatialTree {
	private Node root;
	
	public SpatialTree() {
		root = null;
	}
	
	private Node findNode(Point2D p, Node r)
	{
		//Case 1: Tree is empty
		//This can only be true when the entire tree is empty
		if(r == null){
			return null;
		}
		
		//Case 2: We reached a leaf
		if(r.left == null && r.right == null){
			return r;
		}
		
		//Case 3: I found the value
		if((r.point.getX() - p.getX()) == 0  && (r.point.getY() - p.getY()) == 0){
			return r;
		}
		if(r.left != null && (r.point.getX() - p.getX()) == 0  && (r.point.getY() - p.getY()) > 0){
			return findNode(p, r.left);
		}
		if(r.right != null && (r.point.getX() - p.getX()) == 0  && (r.point.getY() - p.getY()) < 0){
			return findNode(p, r.right);
		}
		return r;
	}
	
	public boolean add(Point2D p)	
	{
		Node n = findNode(p, root);
		
		if(n == null)
		{
			root = new Node(p, null);
			return true;
		}
		
		//Value already exists in the set
		if(n.point.equals(p) == true)
		{
			
			return false;
		}
		
		//Value does not exist in the set and n is the parent
		//Case 1: v will be a left child
		if((n.point.getX() - p.getX()) > 0  && (n.point.getY() - p.getY()) > 0)
		{
			n.left = new Node(p, n);
		}
		//Case 2: v will be right child
		else
		{
			n.right = new Node(p, n);
		}
		return true;
	}
	
	private class Node{
		private Node left, right, parent;
		private Point2D point;
		private boolean isX = true;
		
		public Node(Point2D p, Node parent) {
			left = null;
			right = null;
			this.parent = parent;
			this.isX = isX;
		}
	}
}

