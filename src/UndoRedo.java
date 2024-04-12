import java.util.Stack;

public class UndoRedo {
	TextEditorGUI gui;
	private Stack<String> undo = new Stack<String>();
	private Stack<String> redo = new Stack<String>();
	public UndoRedo(TextEditorGUI gui) {
		this.gui = gui;
	}
	public void Write(String input) {
		undo.push(input);
	}
	public void undo() {
		gui.um.undo();
	}
	public void redo() {
		gui.um.redo();
	}
	public String find() { 
		return "";
	}
	public String replace() {
		return "";
	}
}
