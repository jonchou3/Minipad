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
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N) {
			gui.newFile();
		}
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O) {
			gui.file.open();
		}
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
			gui.file.save();
		}
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
			gui.um.undo();
		}
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Y) {
			gui.um.redo();
		}
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_F) {
			//editFind
		}
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_PLUS) {
			gui.zoomIn();
		}
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_MINUS) {
			gui.zoomOut();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

}
