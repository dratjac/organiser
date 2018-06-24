import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class notepad {

	private JFrame frmNotepad;
	JTextArea txt = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					notepad window = new notepad();
					window.frmNotepad.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public notepad() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNotepad = new JFrame();
		frmNotepad.setTitle("Notepad");
		frmNotepad.setBounds(100, 100, 450, 313);
		frmNotepad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNotepad.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 434, 274);
		frmNotepad.getContentPane().add(scrollPane);
		
		
		scrollPane.setViewportView(txt);
		
		JMenuBar menuBar = new JMenuBar();
		frmNotepad.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txt.setText("");
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Open");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser open= new JFileChooser();
				int choice = open.showOpenDialog(frmNotepad);
				if(choice== JFileChooser.APPROVE_OPTION)
				{
					try {
						Scanner sc = new Scanner(new FileReader(open.getSelectedFile().getPath()));
						while(sc.hasNext())
						{
							txt.append(sc.nextLine()+"\n");
						}
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
					
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Save");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser save = new JFileChooser();
				int choice= save.showSaveDialog(frmNotepad);
				
				if (choice == JFileChooser.APPROVE_OPTION) {
					
					try {
						BufferedWriter bf = new BufferedWriter(new FileWriter(save.getSelectedFile().getPath()));
						bf.write(txt.getText());
						bf.close();
						
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, e);
					}
				}
				
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("Format");
		menuBar.add(mnNewMenu_1);
	}
}
