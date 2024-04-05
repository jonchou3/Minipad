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
		getFrame().setVisible(true);
	}
	public void createFrame() {
		setFrame(new JFrame("Text Editor (❁´◡`❁)"));
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setSize(800,800);
		getFrame().setLocationRelativeTo(null);		
	}
	public void createTextArea() {
		
		setTextArea(new JTextArea());
		getTextArea().setSize(new Dimension(800,800));
		getTextArea().setFont(myFont);
		panel = new JScrollPane(getTextArea(), 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.setBorder(BorderFactory.createBevelBorder(30));
		getFrame().add(panel);
	}
	public void createMenuBar() {
		menuBar = new JMenuBar();
		getFrame().setJMenuBar(menuBar);
		
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
		fileNew.addActionListener(this);
		fileOpen = new JMenuItem("Open");
		fileOpen.addActionListener(this);
		menuFile.add(fileOpen);
		fileSave = new JMenuItem("Save");
		fileSave.addActionListener(this);
		menuFile.add(fileSave);
	}
	public void createEditMenu() {
		editUndo = new JMenuItem("Edit");
		editUndo.addActionListener(this);
		menuEdit.add(editUndo);
		editFind = new JMenuItem("Find");
		editFind.addActionListener(this);
		menuEdit.add(editFind);
		editReplace = new JMenuItem("Replace");
		editUndo.addActionListener(this);
		menuEdit.add(editReplace);
		editTimeDate = new JMenuItem("TimeDate");
		editTimeDate.addActionListener(this);
		menuEdit.add(editTimeDate);
	}
	public void createFormatMenu() {
		formatWordWrap = new JMenuItem("Word Wrap");
		formatWordWrap.addActionListener(this);
		menuFormat.add(formatWordWrap);
		formatFont = new JMenuItem("Font");
		formatFont.addActionListener(this);
		menuFormat.add(formatFont);
	}
	public void createViewMenu() {
		viewZoom = new JMenuItem("Zoom");
		viewZoom.addActionListener(this);
		menuView.add(viewZoom);
		viewStatusBar = new JMenuItem("Status Bar");
		viewStatusBar.addActionListener(this);
		menuView.add(viewStatusBar);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fileNew) {
			int response = JOptionPane.showConfirmDialog(null, "Do you want to save your changes?","",JOptionPane.YES_NO_OPTION);
			//yes, no , if yes, call new 
			if(response == 1){
				//save 
			}
			else if(response == 2) {
				//save as
			}
			textArea.setText("");
		}
		if(e.getSource() == fileOpen) {
			FileIO.open()
		}
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
}
