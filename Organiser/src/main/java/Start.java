import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.awt.print.*;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class Start {

	JFrame frame;
	JMenuBar menuBar;
	JMenu mPliki, mPomoc, mEdycja, mFormat;
	JMenuItem iNowy, iOtworz, iZapisz, iZapiszJako, iExit, iAutor;
	JMenuItem iCofnij, iPowtorz, iWytnij, iKopiuj, iWklej;
	JMenuItem iPczcionka, iZczcionka, iPogrubienie, iKursywa, iDrukuj;

	JTextArea notatnik;
	UndoManager manager = new UndoManager();

	File plik;

	/**
	 * Launch the application.
	 */
	public void runFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuBar = new JMenuBar();

		mPliki = new JMenu("Pliki");
		mPomoc = new JMenu("Pomoc");
		mEdycja = new JMenu("Edycja");
		mFormat = new JMenu("Format");

		iNowy = new JMenuItem("Nowy");
		iNowy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notatnik.setText("");
				frame.setTitle("Notatnik");
				plik = null;

			}
		});

		iOtworz = new JMenuItem("Otwórz...");
		iOtworz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				otworz();
			}
		});

		iZapisz = new JMenuItem("Zapisz");
		iZapisz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (plik == null)
					zapiszJako();
				else
					zapisz();

			}
		});

		iZapiszJako = new JMenuItem("Zapisz jako...");
		iZapiszJako.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zapiszJako();

			}
		});

		iExit = new JMenuItem("Exit");
		iExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		iCofnij = new JMenuItem("Cofnij");
		iCofnij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cofnij();
			}
		});

		iPowtorz = new JMenuItem("Powtorz");
		iPowtorz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				powtorz();
			}
		});

		iWytnij = new JMenuItem("Wytnij");
		iWytnij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notatnik.cut();

			}
		});

		iKopiuj = new JMenuItem("Kopiuj");
		iKopiuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notatnik.copy();
			}
		});

		iWklej = new JMenuItem("Wklej");
		iWklej.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notatnik.paste();
			}
		});

		iPczcionka = new JMenuItem("Powiekszenie czcionki");
		iPczcionka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				powiekszenie();
			}
		});

		iZczcionka = new JMenuItem("Zmiejszenie czcionki");
		iZczcionka.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pomniejszenie();
			}
		});

		iPogrubienie = new JMenuItem("Pogrubienie");
		iPogrubienie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pogrubienie();
			}
		});

		iKursywa = new JMenuItem("Kursywa");
		iKursywa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kursywa();
			}
		});

		iDrukuj = new JMenuItem("Drukuj");
		iDrukuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drukuj();
			}
		});

		iAutor = new JMenuItem("Autor Kodu w Java");
		iAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Dawid Dziedziak", "Autor", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		mPliki.add(iNowy);
		mPliki.add(iOtworz);
		mPliki.add(iZapisz);
		mPliki.add(iZapiszJako);

		mPliki.add(iDrukuj);
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
		menuBar.add(mFormat);

		mFormat.add(iPczcionka);
		mFormat.add(iZczcionka);
		mFormat.add(iPogrubienie);
		mFormat.add(iKursywa);

		menuBar.add(mPomoc);

		notatnik = new JTextArea();
		notatnik.setFont(new Font("System", Font.PLAIN, 15));
		JScrollPane scrol = new JScrollPane(notatnik);
		frame.getContentPane().add(scrol);

		frame.setJMenuBar(menuBar);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		manager.setLimit(1000);
		notatnik.getDocument().addUndoableEditListener(new UndoableEditListener() {

			@Override
			public void undoableEditHappened(UndoableEditEvent e) {
				manager.addEdit(e.getEdit());

			}
		});

	}

	private void otworz() {
		notatnik.setText("");
		JFileChooser fc = new JFileChooser();
		if (fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
			plik = fc.getSelectedFile();
			try {
				Scanner scaner = new Scanner(plik);
				while (scaner.hasNext())
					notatnik.append(scaner.nextLine() + "\n");
				scaner.close();
				frame.setTitle(fc.getName(plik));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	private void zapisz() {
		try {
			PrintWriter pw = new PrintWriter(plik);
			Scanner scaner = new Scanner(notatnik.getText());
			while (scaner.hasNext())
				pw.println(scaner.nextLine());
			scaner.close();
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void zapiszJako() {
		JFileChooser fc = new JFileChooser();
		fc.setSelectedFile(plik);
		if (fc.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
			plik = fc.getSelectedFile();
			zapisz();
		}
	}

	private void powiekszenie() {

		Font currentFont = notatnik.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() + 1F);

		notatnik.setFont(newFont);

	}

	private void pomniejszenie() {
		Font currentFont = notatnik.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getSize() - 1F);
		notatnik.setFont(newFont);
	}

	private void pogrubienie() {
		Font currentFont = notatnik.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getStyle() ^ Font.BOLD);
		notatnik.setFont(newFont);

	}

	private void kursywa() {
		Font currentFont = notatnik.getFont();
		Font newFont = currentFont.deriveFont(currentFont.getStyle() ^ Font.ITALIC);
		notatnik.setFont(newFont);

	}

	private void drukuj() {
		PrintSupport.printComponent(notatnik);

	}

	public void cofnij() {
		if (manager.canUndo())
			manager.undo();
	}

	public void powtorz() {
		if (manager.canRedo())
			manager.redo();
	}

}
