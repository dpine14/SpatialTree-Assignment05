import edu.princeton.cs.algs4.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.lang.Math;
import java.util.Stack;
import java.util.Random;

public class Driver {
	public static void main(String[] args) {
	
		// setup standard draw
		// -- the actual pixel dimensions
		StdDraw.setCanvasSize(512, 512);
		// -- the drawing coordinates
		StdDraw.setXscale(0, 512.0);
		StdDraw.setYscale(0, 512.0);
		//StdDraw.enableDoubleBuffering();
		// current state of user "query"
		// -- these store whether the user is clicking, and where they started
		//    clicking
		boolean previousClickState = false;
		double startClickX = 0.0;
		double startClickY = 0.0;
		
		double currentClickX = 0.0;
		double currentClickY = 0.0;
		
		//Instantiate the tree
		SpatialTree st = new SpatialTree();
		Random rand = new Random(System.currentTimeMillis());
		for (int i = 0; i <= 100; i++) {

			int randX = rand.nextInt(513);
			int randY = rand.nextInt(513);
			Point2D p = new Point2D.Double(randX, randY);
			System.out.println("Point to add:" + p.toString());
			st.add(p);
			System.out.println(i + "   Height: " + st.getRoot().height());
			System.out.println(st.findNode(p, st.getRoot()));
			try {
				Thread.sleep((long)1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		st.toString();
		
		// draw until the user quits
		while(true) {
			StdDraw.clear();

			///////////////////////////
			// HANDLING MOUSE CLICKS //
			///////////////////////////
			
			// check if the user is currently clicking
			boolean currentClickState = StdDraw.isMousePressed();
			
			// check if the user either just:
			// -- starting clicking
			// -- stopped clicking
			if(currentClickState != previousClickState) {
				if(currentClickState) {
					// started clicking, set initial click location
					startClickX = StdDraw.mouseX();
					startClickY = StdDraw.mouseY();
					System.out.println("Started clicking at (" + startClickX + ", " + startClickY + ")");
				} else {
					// just released, print out the location
					double releaseClickX = StdDraw.mouseX();
					double releaseClickY = StdDraw.mouseY();
				
					
					System.out.println("Stopped clicking at (" + releaseClickX + ", " + releaseClickY + ")");
				}
			}
			
			// update previous mouse state
			previousClickState = currentClickState;
			
			// if the user is clicking, draw a line between their initial click
			// location and their current click location
			if(currentClickState) {
				// get current location of the click
				currentClickX = StdDraw.mouseX();
				currentClickY = StdDraw.mouseY();
				
				

				
				// draw a line from the initial click location to the current
				// location
				StdDraw.line(startClickX, startClickY, currentClickX, currentClickY);
			}
						
			/////////////////////////////
			// HANDLING KEYBOARD INPUT //
			/////////////////////////////
			
			// check for exits
			if(StdDraw.isKeyPressed(KeyEvent.VK_Q)) {
				break;
			}
		}
		// kill the application by closing the StdDraw window
		System.exit(0);
	}

}

