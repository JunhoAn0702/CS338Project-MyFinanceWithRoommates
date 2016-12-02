package fin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/*
 * [Junho An]
 * [ja565@drexel.edu]
 * CS338:GUI, Project *
 */

/**
 * @author junhoan This is a InitialScreen class for intial GUI Screen.
 */
public class InitialScreen extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	// Attributes for Buttons
	private JButton load = new JButton("Load");
	private JButton newExpense = new JButton("New Expense");

	/**
	 * @return the load
	 */
	public JButton getLoad() {
		return load;
	}

	/**
	 * @param load
	 *            the load to set
	 */
	public void setLoad(JButton load) {
		this.load = load;
	}

	/**
	 * @return the newExpense
	 */
	public JButton getNewExpense() {
		return newExpense;
	}

	/**
	 * @param newExpense
	 *            the newExpense to set
	 */
	public void setNewExpense(JButton newExpense) {
		this.newExpense = newExpense;
	}

	/**
	 * Create the frame.
	 */
	public InitialScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		deployTextButton();
	}

	/**
	 * Deploy the texts and buttons in the pane.
	 */
	public void deployTextButton() {
		TitledBorder titledBorder = new TitledBorder(
				"Welcome to My Finance with Roommates!");
		JPanel ScreenPanel = new JPanel(new GridBagLayout());
		ScreenPanel.setBorder(titledBorder);
		GridBagConstraints c = new GridBagConstraints();
		c.gridy = 0;
		ScreenPanel.add(new JPanel(), c);
		c.gridy = 1;
		ScreenPanel.add(new JPanel(), c);
		c.gridy = 2;
		load.setPreferredSize(new Dimension(200, 50));
		ScreenPanel.add(load, c);
		c.gridy = 3;
		ScreenPanel.add(new JPanel(), c);
		c.gridy = 4;
		ScreenPanel.add(new JPanel(), c);
		c.gridy = 5;
		newExpense.setPreferredSize(new Dimension(200, 50));
		ScreenPanel.add(newExpense, c);
		c.gridy = 6;
		ScreenPanel.add(new JPanel(), c);
		c.gridy = 7;
		ScreenPanel.add(new JPanel(), c);
		JLabel instruction = new JLabel(
				"Please select the Load button, if you already have a file.");
		c.gridy = 8;
		ScreenPanel.add(instruction, c);
		contentPane.add(ScreenPanel, BorderLayout.NORTH);
	}

}
