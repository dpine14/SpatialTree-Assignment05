import java.awt.geom.Point2D;
import java.lang.Math;
import edu.princeton.cs.algs4.*;

public class SpatialTree{
	private Node root;
	
	public SpatialTree() {
		root = null;
	}
	
	public Node getRoot() {
		return root;
	}
	
	/**
	 * 
	 * @param p - point
	 * @param r - root node
	 * @return
	 */
	public Node findNode(Point2D p, Node r)
	{
		//Case 1: Tree is empty
		//This can only be true when the entire tree is empty
		if(r == null){
			//System.out.println("Case 1");
			return null;
		}
		
		//Case 2: We reached a leaf
		if(r.left == null && r.right == null){
			//System.out.println("Case 2");
			return r;
		}
		
		//Case 3: I found the value
		
		if(r.hasParent() && r.parent.isX) {
			//System.out.println("Case 3");
			if(r.getPoint().equals(p)) {
				return r;
			}
			if(r.hasLeft() && r.getPoint().getY()- p.getY() > 0) {
				return findNode(p, r.left);
			}
			if(r.hasRight() && r.getPoint().getY() - p.getY() < 0) {
				return findNode(p, r.right);
			}
		}
		if(r.hasParent() && !r.parent.isX) {
			//System.out.println("Case 3");
			if(r.getPoint().equals(p)) {
				return r;
			}
			if(r.hasLeft() && r.getPoint().getX()- p.getX() > 0) {
				return findNode(p, r.left);
			}
			if(r.hasRight() && r.getPoint().getX() - p.getX() < 0) {
				return findNode(p, r.right);
			}
		}

		return r;
	}
	
	public boolean add(Point2D p)	
	{
		Node n = findNode(p, root);
		
		if(n == null)
		{
			root = new Node(p);
			return true;
		}
		
		//Value already exists in the set
		if(n.getPoint().equals(p) == true)
		{
			return false;
		}
		
		//Value does not exist in the set and n is the parent
		//Case 1: v will be a left child
		if((n.getPoint().getX() - p.getX()) > 0  && n.getPoint().getY() - p.getY() > 0)
		{
			n.setLeft(new Node(p));
		}
		//Case 2: v will be right child
		else
		{
			n.setRight(new Node(p ));
		}
		System.out.println("Node added");
		return true;
	}
	
	public void draw() {
		
	}
	
	private String toStringRecursive(StringBuilder sb, Node root)
	{
		int height = root.height();
		//Print the root
		for(int i=0; i < height; i++)
		{
			sb.append("\t");
		}
		sb.append(root.printPoint() + "\n");
		
		if(root.left != null)
		{
			toStringRecursive(sb, root.left);
		}
		if(root.right != null)
		{
			toStringRecursive(sb, root.right);
		}
		
		return sb.toString();
		
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		return toStringRecursive(sb, root);
	}
}	