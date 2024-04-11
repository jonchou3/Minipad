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
	public String undo() {
		if(undo.peek() != null) {
			String output = undo.pop();
			redo.push(output);
			return output;
		}
		return "";
	}
	public String redo() {
		if(redo.peek() != null) {
			String output = redo.pop();
			undo.push(output);
			return output;
		}
		return "";
	}
	public String find() {
		return "";
	}
	public String replace() {
		return "";
	}
}
