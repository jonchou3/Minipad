import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	TextEditorGUI gui;
	public KeyHandler(TextEditorGUI gui) {
		this.gui = gui;
	}
	@Override
	public void keyTyped(KeyEvent e) {		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
			//save
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
