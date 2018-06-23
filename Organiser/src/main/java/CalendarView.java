import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import java.awt.Dimension;

public class CalendarView{
	private CalendarModel model;
    private MONTHS[] arrayOfMonths = MONTHS.values();
    private int maxDays;

    private JFrame frame = new JFrame("Calendar");
    private JPanel monthViewPanel = new JPanel();
    private JLabel monthLabel = new JLabel();
    private JButton create = new JButton("Create");
    private JButton nextDay = new JButton("Next");
    private JButton prevDay = new JButton("Prev");
    private JTextPane dayTextPane = new JTextPane();
    
    /**
     * TWORZENIE KALENDARZA
     */
    public CalendarView(CalendarModel model) {
        this.model = model;
        maxDays = model.getMaxDays();
        monthViewPanel.setLayout(new GridLayout(0, 7));
        dayTextPane.setPreferredSize(new Dimension(300, 150));
        dayTextPane.setEditable(false);

        JButton prevMonth = new JButton("<");
        prevMonth.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.prevMonth();
                create.setEnabled(false);
                nextDay.setEnabled(false);
                prevDay.setEnabled(false);
                dayTextPane.setText("");
            }
        });
        JButton nextMonth = new JButton(">");
        nextMonth.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.nextMonth();
                create.setEnabled(false);
                nextDay.setEnabled(false);
                prevDay.setEnabled(false);
                dayTextPane.setText("");
            }
        });

        JPanel monthContainer = new JPanel();
        monthContainer.setLayout(new BorderLayout());
        monthLabel.setText(arrayOfMonths[model.getCurrentMonth()] + " " + model.getCurrentYear());
        monthContainer.add(monthLabel, BorderLayout.NORTH);
        monthContainer.add(new JLabel("       S             M             T             W             T              F             S"), BorderLayout.CENTER);
        monthContainer.add(monthViewPanel, BorderLayout.SOUTH);

        JPanel dayViewPanel = new JPanel();
        dayViewPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        JScrollPane dayScrollPane = new JScrollPane(dayTextPane);
        dayScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        dayViewPanel.add(dayScrollPane, c);
        JPanel btnsPanel = new JPanel();
        nextDay.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.nextDay();
            }
        });
        prevDay.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                model.prevDay();
            }
        });
        btnsPanel.add(prevDay);
        btnsPanel.add(create);
        btnsPanel.add(nextDay);
        c.gridx = 0;
        c.gridy = 1;
        dayViewPanel.add(btnsPanel, c);

        JButton quit = new JButton("Quit");

        frame.add(prevMonth);
        frame.add(monthContainer);
        frame.add(nextMonth);
        frame.add(dayViewPanel);
        frame.add(quit);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}