//package homework6;

import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.SwingUtilities;
import java.awt.event.KeyEvent;

class Controller implements MouseListener
{
    Model model;
    View view;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
        //new Timer(50, view).start();
    }

    public void update(Graphics g) {
        model.update(g);
    }

    public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			this.model.addSprite(e.getX(), e.getY());
			this.view.repaint();
			//System.out.println("Left Click");
			// Gets here if left mouse button was clicked
		} else if (SwingUtilities.isRightMouseButton(e))  {
			this.model.updateScene(view.getWidth(), view.getHeight());
			//System.out.println("Right Click");
			this.view.repaint();
			// Gets here if right mouse button was clicked
		}
    }

    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }
    
    public void keyPressed(KeyEvent e)
    {
    	
    }

    public static void main(String[] args) throws Exception {
        //  Use the following line to determine which directory your program
        //  is being executed from, since that is where the image files will
        //  need to be.
        //System.out.println("cwd=" + System.getProperty("user.dir"));
        new Controller();
    }
}

