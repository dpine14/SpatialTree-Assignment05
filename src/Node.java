import java.awt.geom.Point2D;

public class Node{
	private Node left, right, parent;
	private Point2D point;
	private boolean X = true;
		
	public Node(Point2D p, Node parent) {
		left = null;
		right = null;
		this.parent = parent;
		this.X = X;
		this.point = p;
	}
	//Getters
	public Node getLeft() {
		return this.left;
	}
	
	public Node getRight() {
		return this.right;
	}
	
	public Node getParent() {
		return this.parent;
	}
	
	public boolean isX() {
		return this.X;
	}
	
	public Point2D getPoint() {
		return this.point;
	}
	
	//Setters
	public void setLeft(Node n) {
		this.left = n;	
	}
	
	public void setRight(Node n) {
		this.right = n;
	}
	
	public void setX(boolean b) {
		this.X = b;
	}
}


