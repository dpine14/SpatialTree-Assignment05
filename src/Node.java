import java.awt.geom.Point2D;
public class Node{
	// private member variables:
	// -- note: we leave these as public, because we expect the user to
	//          modify them.  that is, i would just have made a getter
	//          and a setter for each one anyway
	// -- note: this is "allowed" because i don't really want to be
	//          hiding this information, i want the user to freely access
	//          it.
	Point2D p;					 // the value of the node
	public Node left, right; // the children of the node
	public Node parent;      // the parent of the node
	public boolean isX;

	// constructor:
	public Node(Point2D point) {
		this.p = point;
		this.left = null;
		this.right = null;
		this.parent = null;
	}

	// helper methods, to identify properties of this node
	public boolean hasLeft() { return left != null; }
	public boolean hasRight() { return right != null; }
	public boolean hasParent() { return parent != null; }

	// more descriptive helper methods
	public boolean isLeaf() {
		return !hasLeft() && !hasRight();
	}

	public boolean isInternal() {
		return hasLeft() || hasRight();
		// return !isLeaf();
	}

	public boolean isRoot() {
		return !hasParent();
	}

	// methods to attach nodes, which maintain our class invariants
	// (1) if n.left == m, then m.parent == n
	// (2) if n.right == m, then m.parent == n
	// (3) if m.parent == n, then n.left == m or n.right == m
	public void attachLeft(Node left) {
		// attaches the given node as the left child
		this.left = left;

		// update parent on that left child
		if(left != null)
			left.parent = this;
	}

	public void attachRight(Node right) {
		// attaches the given node as the left child
		this.right = right;

		// update parent on that left child
		if(right != null)
			right.parent = this;
	}

	// how do we print? recursively!
	public String preorderString() {
		// print order: <value> <left> <right>
		String ret = "";

		ret += p.toString();
		if(hasLeft())
			ret += " " + left.preorderString();
		if(hasRight())
			ret += " " + right.preorderString();

		return ret;
	}

	public String postorderString() {
		// print order: <left> <right> <value>
		String ret = "";

		if(hasLeft())
			ret += left.postorderString() + " ";
		if(hasRight())
			ret += right.postorderString() + " ";
		ret += p.toString();

		return ret;
	}

	public String inorderString() {
		// print order: <left> <value> <right>
		String ret = "";

		if(hasLeft())
			ret += left.inorderString() + " ";
		ret += p.toString();
		if(hasRight())
			ret += " " + right.inorderString();

		return ret;
	}

	// calculate depth
	public int depth() {
		// recursively
		if(isRoot()) {
			return 0;
		} else {
			return parent.depth() + 1;
		}
		// ternary:
		// return isRoot() ? 0 : (parent.depth() + 1);
	}

	// calculate height
	public int height() {
		//		int lh;
		//		if(hasLeft()) {
		//			lh = left.height();
		//		} else {
		//			lh = -1;
		//		}
		// note: this is why we define height(empty) to be -1
		int lh = hasLeft() ? left.height() : -1;
		int rh = hasRight() ? right.height() : -1;
		return Math.max(lh, rh) + 1;
	}
}


