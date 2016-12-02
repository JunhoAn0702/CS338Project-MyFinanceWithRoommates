package fin;

/*
 * [Junho An]
 * [ja565@drexel.edu]
 * CS338:GUI, Project *
 */

/**
 * @author junhoan
 * This is a CreateScreen class for create GUI Screen.
 */
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

public class CreateScreen extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	// Attributes for Buttons
	private JButton createOk = new JButton("Ok");
	private JButton createCancel = new JButton("Cancel");
	private JTextField fileName = new JTextField();

	/**
	 * @return the createOk
	 */
	public JButton getCreateOk() {
		return createOk;
	}

	/**
	 * @param createOk
	 *            the createOk to set
	 */
	public void setCreateOk(JButton createOk) {
		this.createOk = createOk;
	}

	/**
	 * @return the createCancel
	 */
	public JButton getCreateCancel() {
		return createCancel;
	}

	/**
	 * @param loadCancel
	 *            the loadCancel to set
	 */
	public void setCreateCancel(JButton createCancel) {
		this.createCancel = createCancel;
	}

	public JTextField getFileName() {
		return fileName;
	}

	public void setFileName(JTextField fileName) {
		this.fileName = fileName;
	}

	/**
	 * Create the frame.
	 */
	public CreateScreen() {
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
				"Create: Please enter the file name");
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
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c, 1, 6));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c, 0, 7));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c, 0, 8));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c, 0, 9));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c, 1, 9));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c, 0, 10));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c, 0, 11));
		ScreenPanel.add(createOk, setGridBagConstraints(c, 0, 12));
		ScreenPanel.add(createCancel, setGridBagConstraints(c, 1, 12));

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
