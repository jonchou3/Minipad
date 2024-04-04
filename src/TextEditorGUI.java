import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextEditorGUI implements ActionListener{
	
	private JFrame frame;
	private JScrollPane panel;
	private JTextArea textArea;
	private JMenuBar menuBar;
	private JMenu menuFile, menuEdit, menuFormat, menuView;
	private JMenuItem fileNew, fileOpen, fileSave;
	private JMenuItem editUndo, editFind, editReplace, editTimeDate;
	private JMenuItem formatWordWrap, formatFont;
	private JMenuItem viewZoom, viewStatusBar;
	private Font myFont;
	
	public TextEditorGUI() {
		myFont = new Font("Helvetica",Font.PLAIN, 20);
		createFrame();
		createTextArea();
		createMenuBar();
		frame.setVisible(true);
	}
	public void createFrame() {
		frame = new JFrame("Text Editor (❁´◡`❁)");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setLocationRelativeTo(null);		
	}
	public void createTextArea() {
		
		textArea = new JTextArea();
		textArea.setSize(new Dimension(800,800));
		textArea.setFont(myFont);
		panel = new JScrollPane(textArea, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.setBorder(BorderFactory.createBevelBorder(30));
		frame.add(panel);
	}
	public void createMenuBar() {
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);
		menuView = new JMenu("View");
		menuBar.add(menuView);
		
		createFileMenu();
		createEditMenu();
		createFormatMenu();
		createViewMenu();
	}
	public void createFileMenu() {
		fileNew = new JMenuItem("New");
		menuFile.add(fileNew);
		fileOpen = new JMenuItem("Open");
		menuFile.add(fileOpen);
		fileSave = new JMenuItem("Save");
		menuFile.add(fileSave);
	}
	public void createEditMenu() {
		editUndo = new JMenuItem("Edit");
		menuEdit.add(editUndo);
		editFind = new JMenuItem("Find");
		menuEdit.add(editFind);
		editReplace = new JMenuItem("Replace");
		menuEdit.add(editReplace);
		editTimeDate = new JMenuItem("TimeDate");
		menuEdit.add(editTimeDate);
	}
	public void createFormatMenu() {
		formatWordWrap = new JMenuItem("Word Wrap");
		menuFormat.add(formatWordWrap);
		formatFont = new JMenuItem("Font");
		menuFormat.add(formatFont);
	}
	public void createViewMenu() {
		viewZoom = new JMenuItem("Zoom");
		menuView.add(viewZoom);
		viewStatusBar = new JMenuItem("Status Bar");
		menuView.add(viewStatusBar);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fileNew) {
			JOptionPane.showMessageDialog(editFind, e);
			int response = JOptionPane.showConfirmDialog(null, "Choose one","Choose one",JOptionPane.YES_NO_OPTION);
			//yes, no , if yes, call new 
		}
	}
}
