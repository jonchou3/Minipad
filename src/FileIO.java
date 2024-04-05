import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class FileIO {
	//turn function file into file io
	TextEditorGUI gui;
	String fileName, fileAddress;
	public FileIO(TextEditorGUI gui) {
		this.gui = gui;
	}
	
	public void newFile() {
		gui.getTextArea().setText("");
		gui.getFrame().setTitle("New");
	}
	public void open() {
		FileDialog fd = new FileDialog(gui.getFrame(), "Open", FileDialog.LOAD);
		fd.setVisible(true);
		
		try {
			if(fd.getFile() != null) {
				fileName = fd.getFile();
				fileAddress = fd.getDirectory();
				gui.getFrame().setTitle(fileName);
			}
			BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
			gui.getTextArea().setText("");
			String textLine = null;
			while((textLine = br.readLine()) != null){
				gui.getTextArea().append(textLine + "\n");
			}
			br.close();
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error loading file");
		}
	}
	public void save() {
		
	}
	public void saveAs() {
//		FileDialog fd = new FileDialog(gui.getFrame(), "Save", FileDialog.SAVE);
//		fd.setVisible(true);
//		
		
	}
}
