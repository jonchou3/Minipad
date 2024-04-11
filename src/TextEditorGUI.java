 import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;

public class TextEditorGUI implements ActionListener{
	
	private JFrame frame;
	private JScrollPane panel;
	private JTextArea textArea;
	private JMenuBar menuBar;
	private JMenu menuFile, menuEdit, menuFormat, menuView;
	private JMenuItem fileNew, fileOpen, fileSave, fileSaveAs;
	private JMenuItem editUndo, editRedo, editFind, editReplace, editTimeDate;
	private JMenuItem formatWordWrap, formatFont, formatDarkMode;
	private JMenuItem viewZoom, viewZoomIn, viewZoomOut, viewZoomDefault, viewStatusBar;
	private Font myFont;
	private KeyHandler kh;
	
	private FileIO file = new FileIO(this);
	public TextEditorGUI() {
		myFont = new Font("Helvetica",Font.PLAIN, 20);
		createFrame();
		createTextArea();
		createMenuBar();
		getFrame().setVisible(true);
		kh = new KeyHandler(this);
		
	}
	public void createFrame() {
		setFrame(new JFrame("Text Editor (❁´◡`❁)"));
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().setSize(500,500);
		getFrame().setLocationRelativeTo(null);		
	}
	public void createTextArea() {
		
		setTextArea(new JTextArea());
		getTextArea().setSize(new Dimension(800,800));
		getTextArea().setFont(myFont);
		getTextArea().addKeyListener(kh);
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
		
		fileSaveAs = new JMenuItem("Save As");
		fileSaveAs.addActionListener(this);
		menuFile.add(fileSaveAs);
	}
	public void createEditMenu() {
		editUndo = new JMenuItem("Undo");
		editUndo.addActionListener(this);
		menuEdit.add(editUndo);
		
		editRedo = new JMenuItem("Redo");
		editRedo.addActionListener(this);
		menuEdit.add(editRedo);
		
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
		
		formatDarkMode = new JMenuItem("Dark Mode (On/Off)");
		formatDarkMode.addActionListener(this);
		menuFormat.add(formatDarkMode);
	}
	public void createViewMenu() {
		viewZoom = new JMenu("Zoom");
		menuView.add(viewZoom);
		
		viewZoomIn = new JMenuItem("Zoom In");
		viewZoomIn.addActionListener(this);
		viewZoom.add(viewZoomIn);
		
		viewZoomOut = new JMenuItem("Zoom Out");
		viewZoomOut.addActionListener(this);
		viewZoom.add(viewZoomOut);
		
		viewZoomDefault = new JMenuItem("Zoom Default");
		viewZoomDefault.addActionListener(this);
		viewZoom.add(viewZoomDefault);
		
		viewStatusBar = new JMenuItem("Status Bar");
		viewStatusBar.addActionListener(this);
		menuView.add(viewStatusBar);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == fileNew) {
			int response = JOptionPane.showConfirmDialog(null, "Do you want to save your changes?","",JOptionPane.YES_NO_OPTION);
			//yes, no , if yes, call new 
			if(response == JOptionPane.YES_OPTION){
				file.save();
				textArea.setText("");
			}
			else if(response == JOptionPane.NO_OPTION) {
				textArea.setText("");
			}
			
		}
		if(e.getSource() == fileOpen) {
			file.open();
		}
		if(e.getSource() == fileSave) {
			file.save();
		}
		if(e.getSource() == fileSaveAs) {
			file.saveAs();
		}
		if(e.getSource() == editUndo) {
			
		}
		if(e.getSource() == editRedo) {
			
		}
		if(e.getSource() == editFind) {
			
		}
		if(e.getSource() == editReplace) {
			
		}
		if(e.getSource() == editTimeDate) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();
			textArea.append(formatter.format(now));
		}
		if(e.getSource() == formatWordWrap) {
			textArea.setLineWrap(!textArea.getLineWrap());
		}
		if(e.getSource() == formatFont) {
			
		}
		if(e.getSource() == formatDarkMode) {
			if(textArea.getBackground().equals(Color.WHITE)) {
				textArea.setBackground(Color.DARK_GRAY);
				textArea.setForeground(Color.WHITE);
			}
			else {
				textArea.setBackground(Color.WHITE);
				textArea.setForeground(Color.BLACK);
			}
		}
		if(e.getSource() == viewZoomIn) {
			System.out.println(textArea.getFont());
		}
		if(e.getSource() == viewZoomOut) {
			
		}
		if(e.getSource() == viewZoomDefault) {
			
		}
		if(e.getSource() == viewStatusBar) {
			
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
