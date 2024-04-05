import java.awt.FileDialog;

public class FunctionFile{
	TextEditorGUI gui;
	public FunctionFile(TextEditorGUI gui) {
		this.gui = gui;
	}
	
	public void newFile() {
		gui.getTextArea().setText("");
		gui.getFrame().setTitle("New");
	}
	public void open() {
		FileDialog fd = new FileDialog(gui.getFrame(), "Open", FileDialog.LOAD);
		fd.setVisible(true);
	}
}
