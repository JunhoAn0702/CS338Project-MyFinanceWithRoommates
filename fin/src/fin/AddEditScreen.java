package fin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/*
 * [Junho An]
 * [ja565@drexel.edu]
 * CS338:GUI, Project *
 */

/**
 * @author junhoan
 * This is a AddEditScreen class for Add/Edit GUI screen.
 */
public class AddEditScreen extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	// Attributes for Buttons
	private JButton addEditSave = new JButton("Save");
	private JButton addEditCancel = new JButton("Cancel");
	
	
	private JTextField totalAmount = new JTextField();
	private JComboBox<String> category = new JComboBox<String>();
	
	// Attributes for checkboxes
	private JCheckBox split1 = new JCheckBox("RM1");
	private JCheckBox split2 = new JCheckBox("RM2");
	private JCheckBox split3 = new JCheckBox("RM3");
	private JCheckBox received1 = new JCheckBox("RM1");
	private JCheckBox received2 = new JCheckBox("RM2");
	private JCheckBox received3 = new JCheckBox("RM3");
	
	// This is for calendar figure
	private UtilDateModel model = new UtilDateModel();
	private JDatePickerImpl datePicker;

	private expense expenses;

	/**
	 * @return the addEditSave
	 */
	public JButton getAddEditSave() {
		return addEditSave;
	}

	/**
	 * @param addEditSave
	 *            the addEditSave to set
	 */
	public void setAddEditSave(JButton addEditSave) {
		this.addEditSave = addEditSave;
	}
	
	/**
	 * @return the addEditCancel
	 */
	public JButton getAddEditCancel() {
		return addEditCancel;
	}

	/**
	 * @param addEditCancel
	 *            the addEditCancel to set
	 */
	public void setAddEditCancel(JButton addEditCancel) {
		this.addEditCancel = addEditCancel;
	}

	/**
	 * @return the expenses
	 */
	public expense getExpenses() {
		return expenses;
	}

	/**
	 * @param expenses
	 *            the expenses to set
	 */
	public void setExpenses(expense expenses) {
		this.expenses = expenses;
	}
	
	/**
	 * This is a method to set the input data into expenses class
	 * If any field is empty, return false, otherwise return true
	 * @return boolean value 
	 */
	public boolean setExpensesWithData(){
		if(datePicker.getModel().getValue() == null || totalAmount.getText().isEmpty()){
			return false;
		}
		expenses = new expense((Date)datePicker.getModel().getValue(), Double.parseDouble(totalAmount.getText()), split1.isSelected(), split2.isSelected(), split3.isSelected(), received1.isSelected(), received2.isSelected(), received3.isSelected(), category.getSelectedItem().toString());
		return true;
	}

	/**
	 * Create the frame.
	 */
	public AddEditScreen() {
		category.addItem("type1");
		category.addItem("type2");
		category.addItem("type3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		deployTextButton();
	}
	
	/**
	 * Create the frame with parameter expense class.
	 */
	public AddEditScreen(expense expenses) {
		category.addItem("type1");
		category.addItem("type2");
		category.addItem("type3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 270);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(expenses.getDate());
		model.setDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
		int selectedIndex;
		if(expenses.getSelectedCategory().equals("type1")){
			selectedIndex = 0;
		}
		else if(expenses.getSelectedCategory().equals("type2")){
			selectedIndex = 1;
		}
		else{
			selectedIndex = 2;
		}
		category.setSelectedIndex(selectedIndex);
		split1.setSelected(expenses.getSplit1());
		split2.setSelected(expenses.getSplit2());
		split3.setSelected(expenses.getSplit3());
		received1.setSelected(expenses.getReceived1());
		received2.setSelected(expenses.getReceived2());
		received3.setSelected(expenses.getReceived3());
		totalAmount.setText(String.valueOf(expenses.getAmount()));
		setContentPane(contentPane);
		deployTextButton();
	}
	
	/**
	 * Deploy the texts and buttons in the pane.
	 */
	public void deployTextButton() {
		TitledBorder titledBorder = new TitledBorder("Add/Edit an expense");
		JPanel ScreenPanel = new JPanel(new GridBagLayout());
		ScreenPanel.setBorder(titledBorder);
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 0.5;
		JLabel dateLabel = new JLabel("Date:");
		JTextField date = new JTextField();
		
		// Set up for datePicker
		model.setSelected(true);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateComponentFormatter());
		date.setColumns(20);

		// Set up dropdown and checkBox
		JLabel categoryLabel = new JLabel("Category:");
		category.setPreferredSize(new Dimension(255, 30));
		JLabel splitLabel = new JLabel("Split with:");
		JLabel receivedLabel = new JLabel("Received:");
		JLabel totalAmountLabel = new JLabel("Total Amount:");
		totalAmount.setColumns(20);

		// Adding all components into the panel
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c,0,0));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c,0,0));
		ScreenPanel.add(dateLabel, setGridBagConstraints(c,0,1));
		ScreenPanel.add(datePicker, setGridBagConstraints(c,1,1));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c,0,2));
		ScreenPanel.add(categoryLabel, setGridBagConstraints(c,0,3));
		ScreenPanel.add(category, setGridBagConstraints(c,1,3));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c,0,4));
		ScreenPanel.add(splitLabel, setGridBagConstraints(c,0,5));
		JPanel checkSplitBoxPanel = new JPanel(new GridBagLayout());
		checkSplitBoxPanel.add(split1, setGridBagConstraints(c,0,0));
		checkSplitBoxPanel.add(split2, setGridBagConstraints(c,1,0));
		checkSplitBoxPanel.add(split3, setGridBagConstraints(c,2,0));
		ScreenPanel.add(receivedLabel, setGridBagConstraints(c,0,6));
		JPanel checkReceivedBoxPanel = new JPanel(new GridBagLayout());
		checkReceivedBoxPanel.add(received1, setGridBagConstraints(c,0,0));
		checkReceivedBoxPanel.add(received2, setGridBagConstraints(c,1,0));
		checkReceivedBoxPanel.add(received3, setGridBagConstraints(c,2,0));
		ScreenPanel.add(checkSplitBoxPanel, setGridBagConstraints(c,1,5));
		ScreenPanel.add(checkReceivedBoxPanel, setGridBagConstraints(c,1,6));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c,0,7));
		ScreenPanel.add(totalAmountLabel, setGridBagConstraints(c,0,8));
		ScreenPanel.add(totalAmount, setGridBagConstraints(c,1,8));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c,0,9));
		ScreenPanel.add(new JPanel(), setGridBagConstraints(c,0,10));
		ScreenPanel.add(addEditSave, setGridBagConstraints(c,0,11));
		ScreenPanel.add(addEditCancel, setGridBagConstraints(c,1,11));
		
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
