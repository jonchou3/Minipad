import java.awt.FileDialog;

public class FunctionFile{
	TextEditorGUI gui;
	public FunctionFile(TextEditorGUI gui) {
		this.gui = gui;
	}
	
	public void newFile() {
		gui.textArea.setText("");
		gui.frame.setTitle("New");
	}
	public void open() {
		FileDialog fd = new FileDialog(gui.frame, "Open", FileDialog.LOAD);
		fd.setVisible(true);
	}
}
