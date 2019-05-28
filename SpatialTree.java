import java.awt.geom.Point2D;
import java.lang.Math;

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
		if(Math.abs(r.point.getX() - p.getX()) == 0  && Math.abs(r.point.getY() - p.getY()) == 0){
			return r;
		}
		if(r.left != null && Math.abs(r.point.getX() - p.getX()) == 0  && Math.abs(r.point.getY() - p.getY()) > 0){
			return findNode(p, r.left);
		}
		if(r.right != null && Math.abs(r.point.getX() - p.getX()) == 0  && Math.abs(r.point.getY() - p.getY()) < 0){
			return findNode(p, r.right);
		}
		return r;
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

