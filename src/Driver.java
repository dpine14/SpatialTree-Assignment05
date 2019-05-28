import edu.princeton.cs.algs4.*;
import java.awt.*;
import java.awt.event.*;


public class Driver {
	public static void main(String[] args) {
		// setup standard draw
		// -- the actual pixel dimensions
		StdDraw.setCanvasSize(512, 512);
		// -- the drawing coordinates
		StdDraw.setXscale(0, 1.0);
		StdDraw.setYscale(0, 1.0);
		
		// current state of user "query"
		// -- these store whether the user is clicking, and where they started
		//    clicking
		boolean previousClickState = false;
		double startClickX = 0.0;
		double startClickY = 0.0;
		
		double currentClickX = 0.0;
		double currentClickY = 0.0;
		
		// draw until the user quits
		for(;;) {
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
			
			// display for a short time (25ms ~= 1/40th of a second
			Point2D p = new Point2D(currentClickX, currentClickY);
			StdDraw.setPenColor(StdDraw.BOOK_RED);
			StdDraw.filledCircle(currentClickX, currentClickY, 0.01);
			
		}

		// kill the application by closing the StdDraw window
		System.exit(0);
	}

}

