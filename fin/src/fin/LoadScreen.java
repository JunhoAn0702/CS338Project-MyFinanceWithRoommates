package fin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

/*
 * [Junho An]
 * [ja565@drexel.edu]
 * CS338:GUI, Project *
 */

/**
 * @author junhoan This is a LoadScreen class for load GUI Screen.
 */
public class LoadScreen extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	// Attributes for Buttons
	private JButton loadOk = new JButton("Ok");
	private JButton loadCancel = new JButton("Cancel");
	private JTextField fileName = new JTextField();

	/**
	 * @return the loadOk
	 */
	public JButton getLoadOk() {
		return loadOk;
	}

	/**
	 * @param loadOk
	 *            the loadOk to set
	 */
	public void setLoadOk(JButton loadOk) {
		this.loadOk = loadOk;
	}

	/**
	 * @return the loadCancel
	 */
	public JButton getLoadCancel() {
		return loadCancel;
	}

	/**
	 * @param loadCancel
	 *            the loadCancel to set
	 */
	public void setLoadCancel(JButton loadCancel) {
		this.loadCancel = loadCancel;
	}

	/**
	 * @return the fileName
	 */
	public JTextField getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(JTextField fileName) {
		this.fileName = fileName;
	}

	/**
	 * Create the frame.
	 */
	public LoadScreen() {
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
				"Load: Please enter the file name");
		JPanel ScreenPanel = new JPanel(new GridBagLayout());
		ScreenPanel.setBorder(titledBorder);
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.5;
		JLabel fileNameLabel = new JLabel("File Name:");
		fileName.setColumns(20);

		ScreenPanel.add(new JPanel(), setGridBagConstraints(c, 0, 0));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c, 0, 1));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c, 0, 2));
		ScreenPanel.add(fileNameLabel, setGridBagConstraints(c, 0, 3));
		ScreenPanel.add(fileName, setGridBagConstraints(c, 1, 3));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c, 0, 4));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c, 0, 5));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c, 0, 6));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c, 0, 8));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c, 0, 9));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c, 0, 10));
		ScreenPanel.add(loadOk, setGridBagConstraints(c, 0, 11));
		ScreenPanel.add(loadCancel, setGridBagConstraints(c, 1, 11));

		contentPane.add(ScreenPanel, BorderLayout.NORTH);

	}

	/**
	 * This is a method to set the GridBagContratins constraints(gridx, and
	 * gridy)
	 * 
	 * @param c
	 * @param gridX
	 * @param gridY
	 * @return gridBagConstratins
	 */
	public GridBagConstraints setGridBagConstraints(GridBagConstraints c,
			int gridX, int gridY) {
		c.gridx = gridX;
		c.gridy = gridY;
		return c;
	}

}
