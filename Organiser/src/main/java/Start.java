import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;


public class Start extends JFrame implements ActionListener {
	
	JMenuBar menuBar;
	JMenu mPliki, mPomoc,mEdycja;
	JMenuItem iNowy, iOtworz, iZapisz, iZapiszJako, iExit, iAutor;
	JMenuItem iCofnij,iPowtorz,iWytnij,iKopiuj,iWklej;
	
	JTextArea notatnik;
	UndoManager manager = new UndoManager();
	
	File plik;
	
	
	
	
	
	
	Start()
	{
		
		super("Notatnik");
		menuBar = new JMenuBar();
		
			mPliki = new JMenu("Pliki");
			mPomoc = new JMenu("Pomoc");
			mEdycja = new JMenu("Edycja");
			
				iNowy = new JMenuItem("Nowy");
				iNowy.addActionListener(this);
				iOtworz = new JMenuItem("Otwórz...");
				iOtworz.addActionListener(this);
				iZapisz = new JMenuItem("Zapisz");
				iZapisz.addActionListener(this);
				iZapiszJako = new JMenuItem("Zapisz jako...");
				iZapiszJako.addActionListener(this);
				iExit = new JMenuItem("Exit");
				iExit.addActionListener(this);
				iCofnij = new JMenuItem("Cofnij");
				iCofnij.addActionListener(this);
				iPowtorz= new JMenuItem("Powtorz");
				iPowtorz.addActionListener(this);
				iWytnij = new JMenuItem("Wytnij");
				iWytnij.addActionListener(this);
				iKopiuj = new JMenuItem("Kopiuj");
				iKopiuj.addActionListener(this);
				iWklej = new JMenuItem("Wklej");
				iWklej.addActionListener(this);
				
				
				
					
				
				
					
				
				
				iAutor = new JMenuItem("Autor Kodu w Java");
				iAutor.addActionListener(this);
				
				mPliki.add(iNowy);
				mPliki.add(iOtworz);
				mPliki.add(iZapisz);
				mPliki.add(iZapiszJako);
				mPliki.addSeparator();
				mPliki.add(iExit);
				
				mEdycja.add(iCofnij);
				mEdycja.add(iPowtorz);
				mEdycja.add(iWytnij);
				mEdycja.add(iKopiuj);
				mEdycja.add(iWklej);
				
				mPomoc.add(iAutor);
		
				menuBar.add(mPliki);
				menuBar.add(mEdycja);
				menuBar.add(mPomoc);
			
			
			
			
			
			
			
			
		notatnik = new JTextArea();notatnik.setFont(new Font("System", Font.PLAIN, 15));
		JScrollPane scrol = new JScrollPane(notatnik); 
		getContentPane().add(scrol);
			
		setJMenuBar(menuBar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600,500);
		setLocationRelativeTo(null);
		setVisible(true);
		manager.setLimit(1000);
		notatnik.getDocument().addUndoableEditListener(new UndoableEditListener() {

			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
			    manager.addEdit(e.getEdit()); 

				}
			});
		
		
		
	
		
	}

	public static void main(String[] args) {
		new Start();
	}

	
	
	
	private void otworz()
	{
		notatnik.setText("");
		JFileChooser fc = new JFileChooser();
		if (fc.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
		{
			plik = fc.getSelectedFile();
			try {
				Scanner scaner = new Scanner(plik);
				while (scaner.hasNext()) notatnik.append(scaner.nextLine()+"\n");
				scaner.close();
				this.setTitle(fc.getName(plik));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void zapisz()
	{
		try {
			PrintWriter pw = new PrintWriter(plik);
			Scanner scaner = new Scanner(notatnik.getText());
			while (scaner.hasNext()) pw.println(scaner.nextLine());
			scaner.close();pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void zapiszJako()
	{
		JFileChooser fc = new JFileChooser();
		fc.setSelectedFile(plik);
		if (fc.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
		{
			plik = fc.getSelectedFile();
			zapisz();
		}
	}

	
	public void cofnij(){
        if(manager.canUndo())
	manager.undo();
}
public void powtorz(){
        if(manager.canRedo())
	manager.redo();
}
	

	
	
	

	
	public void actionPerformed(ActionEvent e) {
		Object cel = e.getSource();
		
		if (cel==iExit) System.exit(0); else
		if (cel==iCofnij) cofnij();else
		if (cel==iPowtorz) powtorz();else
		if (cel==iWytnij) notatnik.cut();else
		if (cel==iKopiuj) notatnik.copy();else
		if (cel==iWklej) notatnik.paste();else
		if (cel==iAutor) JOptionPane.showMessageDialog(this, "Dawid Dziedziak", "Autor", JOptionPane.INFORMATION_MESSAGE);else
		if (cel==iOtworz) otworz();else
		if (cel==iNowy) {notatnik.setText("");this.setTitle("Notatnik");plik=null;}else
		if (cel==iZapiszJako) zapiszJako(); else
		if (cel==iZapisz) {if (plik==null) zapiszJako(); else zapisz();
		
		
		}
		
	}

}