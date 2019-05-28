import java.awt.geom.Point2D;
import java.lang.Math;
import edu.princeton.cs.algs4.*;

public class SpatialTree{
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
		if(r.getLeft() == null && r.getRight() == null){
			return r;
		}
		
		//Case 3: I found the value
		if((r.getPoint().getX() - p.getX()) == 0  && (r.getPoint().getY() - p.getY()) == 0){
			return r;
		}
		if(r.getLeft() != null && (r.getPoint().getX() - p.getX()) == 0  && (r.getPoint().getY() - p.getY()) > 0){
			return findNode(p, r.getLeft());
		}
		if(r.getRight() != null && (r.getPoint().getX() - p.getX()) == 0  && (r.getPoint().getY() - p.getY()) < 0){
			return findNode(p, r.getRight());
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
		if(n.getPoint().equals(p) == true)
		{
			
			return false;
		}
		
		//Value does not exist in the set and n is the parent
		//Case 1: v will be a left child
		if((n.getPoint().getX() - p.getX()) > 0  && (n.getPoint().getY() - p.getY()) > 0)
		{
			n.setLeft(new Node(p, n));
		}
		//Case 2: v will be right child
		else
		{
			n.setRight(new Node(p, n));
		}
		return true;
	}
	
	private String toStringRecursive(StringBuilder sb, Node root, int level)
	{
		//Print the root
		for(int i=0; i < level; i++)
		{
			sb.append("\t");
		}
		sb.append(root + "\n");
		
		if(root.getLeft() != null)
		{
			toStringRecursive(sb, root.getLeft(), level+1);
		}
		if(root.getRight() != null)
		{
			toStringRecursive(sb, root.getRight(), level+1);
		}
		
		return sb.toString();
		
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		return toStringRecursive(sb, root, 0);
	}
}	