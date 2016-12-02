package fin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class mainScreen extends JFrame {

	private JPanel contentPane;

	// Attributes for JButtons
	private JButton mainAdd = new JButton("Add");
	private JButton mainEdit = new JButton("Edit");
	private JButton mainDelete = new JButton("Delete");
	private JButton mainSave = new JButton("Save");
	
	// Attributes for JTable
	private JTable dataTable;
	private DefaultTableModel expenseTable = new DefaultTableModel();
	
	// Attributes for Pie/Bar Charts
	private DefaultPieDataset pieDatasetIndv = new DefaultPieDataset();
	private DefaultPieDataset pieDatasetGroup = new DefaultPieDataset();
	private DefaultCategoryDataset datasetIndv = new DefaultCategoryDataset();
	private DefaultCategoryDataset datasetGroup = new DefaultCategoryDataset();
	
	// Attribute for expenseList
	private ArrayList<expense> expenseList = new ArrayList<expense>();

	// Final Static String
	private final static String date = "Date"; 
	private final static String category = "Category"; 
	private final static String totalAmount = "Total Amount"; 
	private final static String split = "Split"; 
	private final static String roommate1 = "R(1)"; 
	private final static String roommate1R = "R(1) Received(Y/N)"; 
	private final static String roommate2 = "R(2)"; 
	private final static String roommate2R = "R(2) Received(Y/N)"; 
	private final static String roommate3 = "R(3)"; 
	private final static String roommate3R = "R(3) Received(Y/N)"; 
	private final static String yourAmount = "Your Amount"; 

	/**
	 * @return the mainAdd
	 */
	public JButton getMainAdd() {
		return mainAdd;
	}

	/**
	 * @param mainAdd the mainAdd to set
	 */
	public void setMainAdd(JButton mainAdd) {
		this.mainAdd = mainAdd;
	}

	/**
	 * @return the mainEdit
	 */
	public JButton getMainEdit() {
		return mainEdit;
	}

	/**
	 * @param mainEdit the mainEdit to set
	 */
	public void setMainEdit(JButton mainEdit) {
		this.mainEdit = mainEdit;
	}

	/**
	 * @return the mainDelete
	 */
	public JButton getMainDelete() {
		return mainDelete;
	}

	/**
	 * @param mainDelete the mainDelete to set
	 */
	public void setMainDelete(JButton mainDelete) {
		this.mainDelete = mainDelete;
	}

	/**
	 * @return the mainSave
	 */
	public JButton getMainSave() {
		return mainSave;
	}

	/**
	 * @param mainSave the mainSave to set
	 */
	public void setMainSave(JButton mainSave) {
		this.mainSave = mainSave;
	}

	/**
	 * @return the dataTable
	 */
	public JTable getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable the dataTable to set
	 */
	public void setDataTable(JTable dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * @return the expenseTable
	 */
	public DefaultTableModel getExpenseTable() {
		return expenseTable;
	}

	/**
	 * @param expenseTable the expenseTable to set
	 */
	public void setExpenseTable(DefaultTableModel expenseTable) {
		this.expenseTable = expenseTable;
	}

	/**
	 * @return the pieDatasetIndv
	 */
	public DefaultPieDataset getPieDatasetIndv() {
		return pieDatasetIndv;
	}

	/**
	 * @param pieDatasetIndv the pieDatasetIndv to set
	 */
	public void setPieDatasetIndv(DefaultPieDataset pieDatasetIndv) {
		this.pieDatasetIndv = pieDatasetIndv;
	}

	/**
	 * @return the pieDatasetGroup
	 */
	public DefaultPieDataset getPieDatasetGroup() {
		return pieDatasetGroup;
	}

	/**
	 * @param pieDatasetGroup the pieDatasetGroup to set
	 */
	public void setPieDatasetGroup(DefaultPieDataset pieDatasetGroup) {
		this.pieDatasetGroup = pieDatasetGroup;
	}

	/**
	 * @return the datasetIndv
	 */
	public DefaultCategoryDataset getDatasetIndv() {
		return datasetIndv;
	}

	/**
	 * @param datasetIndv the datasetIndv to set
	 */
	public void setDatasetIndv(DefaultCategoryDataset datasetIndv) {
		this.datasetIndv = datasetIndv;
	}

	/**
	 * @return the datasetGroup
	 */
	public DefaultCategoryDataset getDatasetGroup() {
		return datasetGroup;
	}

	/**
	 * @param datasetGroup the datasetGroup to set
	 */
	public void setDatasetGroup(DefaultCategoryDataset datasetGroup) {
		this.datasetGroup = datasetGroup;
	}

	/**
	 * @return the expenseList
	 */
	public ArrayList<expense> getExpenseList() {
		return expenseList;
	}

	/**
	 * @param expenseList the expenseList to set
	 */
	public void setExpenseList(ArrayList<expense> expenseList) {
		this.expenseList = expenseList;
	}

	/**
	 * Create the frame.
	 */
	public mainScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		deployTextButton();
		}
	
	/**
	 * Create the frame wtih a parameter of expenseList.
	 */
	public mainScreen(ArrayList<expense> expenseList) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		deployTextButton();
		this.expenseList = expenseList;
		this.repaintTable(expenseList);
		}
		
		/**
		 * Deploy the texts and buttons in the pane.
		 */
		public void deployTextButton() {
			TitledBorder titledBorder = new TitledBorder("Your Expense");
			JPanel ScreenPanel = new JPanel(new GridBagLayout());
			ScreenPanel.setBorder(titledBorder);
			GridBagConstraints c = new GridBagConstraints();
			JPanel tablePanel = new JPanel(new GridBagLayout());
			tablePanel.setPreferredSize(new Dimension(1000, 200));
			
			// Adding columns to the table
			expenseTable.addColumn(date);
			expenseTable.addColumn(category);
			expenseTable.addColumn(totalAmount);
			expenseTable.addColumn(roommate1);
			expenseTable.addColumn(roommate1R);
			expenseTable.addColumn(roommate2);
			expenseTable.addColumn(roommate2R);
			expenseTable.addColumn(roommate3);
			expenseTable.addColumn(roommate3R);
			expenseTable.addColumn(yourAmount);

			// Initializing JTable with not editable fields
			dataTable = new JTable(expenseTable) {
				private static final long serialVersionUID = 1L;

				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			
			// Setting each JTable's column width
			dataTable.getColumn(date).setPreferredWidth(100);
			dataTable.getColumn(category).setPreferredWidth(100);
			dataTable.getColumn(totalAmount).setPreferredWidth(100);
			dataTable.getColumn(roommate1).setPreferredWidth(90);
			dataTable.getColumn(roommate1R).setPreferredWidth(110);
			dataTable.getColumn(roommate2).setPreferredWidth(90);
			dataTable.getColumn(roommate2R).setPreferredWidth(110);
			dataTable.getColumn(roommate3).setPreferredWidth(90);
			dataTable.getColumn(roommate3R).setPreferredWidth(110);
			dataTable.getColumn(yourAmount).setPreferredWidth(100);
			
			// Adding JTable into ScrollPane
			JScrollPane scrollTablePane = new JScrollPane();
			scrollTablePane.setPreferredSize(new Dimension(1000, 200));
			scrollTablePane.setViewportView(dataTable);
			tablePanel.add(scrollTablePane, c);
			
			// Adding components to screenPanel
			ScreenPanel.add(new JPanel(), setGridBagConstraints(c,0,0));
			ScreenPanel.add(new JPanel(), setGridBagConstraints(c,0,1));
			ScreenPanel.add(new JPanel(), setGridBagConstraints(c,0,2));
			JPanel datePanel = new JPanel(new GridBagLayout());
			ScreenPanel.add(datePanel, setGridBagConstraints(c,0,3));
			ScreenPanel.add(tablePanel, setGridBagConstraints(c,0,4));
	        
			// Initializing Pie Charts data
			pieDatasetIndv.setValue("type1", new Integer(0));
			pieDatasetIndv.setValue("type2", new Integer(0));
			pieDatasetIndv.setValue("type3", new Integer(0));
			pieDatasetGroup.setValue("type1", new Integer(0));
			pieDatasetGroup.setValue("type2", new Integer(0));
			pieDatasetGroup.setValue("type3", new Integer(0));
	        JFreeChart chart1 = ChartFactory.createPieChart
	        		("Spending Trend Individual",pieDatasetIndv,true,true,false );
	        JFreeChart chart2 = ChartFactory.createPieChart
	        		("Spending Trend Group",pieDatasetGroup,true,true,false );
	        
			// Initializing Bar Charts data
	        datasetIndv.setValue(0, "Amount($)", "Type1");
	        datasetIndv.setValue(0, "Amount($)", "Type2");
	        datasetIndv.setValue(0, "Amount($)", "Type3");
	        datasetGroup.setValue(0, "Amount($)", "Type1");
	        datasetGroup.setValue(0, "Amount($)", "Type2");
	        datasetGroup.setValue(0, "Amount($)", "Type3");
	        JFreeChart chart3 = ChartFactory.createBarChart("Spending Trend Individual",
	        "Category", "Amount($)", datasetIndv, PlotOrientation.VERTICAL,
	        false, true, false);
	        JFreeChart chart4 = ChartFactory.createBarChart("Spending Trend Group",
	    	        "Category", "Amount($)", datasetGroup, PlotOrientation.VERTICAL,
	    	        false, true, false);
	        
	        // Putting charts into ChartPanel and Setting the size
	        ChartPanel CP = new ChartPanel(chart1);
	        CP.setPreferredSize(new Dimension(300,125));
	        ChartPanel CP1 = new ChartPanel(chart2);
	        CP1.setPreferredSize(new Dimension(300,125));
	        ChartPanel CP2 = new ChartPanel(chart3);
	        CP2.setPreferredSize(new Dimension(600,125));
	        ChartPanel CP3 = new ChartPanel(chart4);
	        CP3.setPreferredSize(new Dimension(600,125));
	        
	        // Adding components to the screen panel.
	        JPanel chartPanel = new JPanel(new GridBagLayout());
	        chartPanel.add(CP, setGridBagConstraints(c,0,0));
	        chartPanel.add(CP2, setGridBagConstraints(c,1,0));
			chartPanel.add(CP1, setGridBagConstraints(c,0,1));
			chartPanel.add(CP3, setGridBagConstraints(c,1,1));
			contentPane.add(ScreenPanel, BorderLayout.NORTH);
			contentPane.add(chartPanel, BorderLayout.CENTER);
			JPanel butoonPanel = new JPanel(new GridBagLayout());
			butoonPanel.add(mainAdd, setGridBagConstraints(c,0,0));
			butoonPanel.add(mainEdit, setGridBagConstraints(c,1,0));
			butoonPanel.add(mainDelete, setGridBagConstraints(c,2,0));
			butoonPanel.add(mainSave, setGridBagConstraints(c,3,0));
			contentPane.add(butoonPanel, BorderLayout.SOUTH);
		}
		
		/**
		 * This is a method to set the GridBagContratins constraints(gridx, and gridy)
		 * @param c
		 * @param gridX
		 * @param gridY
		 * @return gridBagConstratins
		 */
		public GridBagConstraints setGridBagConstraints(GridBagConstraints c, int gridX, int gridY){
			c.gridx = gridX;
			c.gridy = gridY;
			return c;
		}
		
	/**
	 * This is a method to repaint list and table from the given input
	 * 
	 * @param estateListTableInput
	 */
	public void repaintTable(ArrayList<expense> expenseList) {

		for (int i = expenseTable.getRowCount() - 1; i >= 0; i--) {
			expenseTable.removeRow(i);
		}

		// Initializing ArrayList<realEstate> for list and table
		ArrayList<expense> expenseTableInput = new ArrayList<expense>();
		
		// Initializing variables to store tabulated data.
		double IndvType1 = 0;
		double IndvType2 = 0;
		double IndvType3 = 0;
		double GroupType1 = 0;
		double GroupType2 = 0;
		double GroupType3 = 0;
		double totalAmount = 0;
		double totalYourAmount = 0;
		double AmountReceivableR1 = 0;
		double AmountReceivableR2 = 0;
		double AmountReceivableR3 = 0;
		double AmountReceivedR1 = 0;
		double AmountReceivedR2 = 0;
		double AmountReceivedR3 = 0;
		
		// Adding the table array to JTable row
		// Tabulating expenses
		for (expense ex : expenseList) {
			totalAmount += ex.getAmount();
			totalYourAmount += ex.getYourAmount();

			if (ex.getSplit1() && !ex.getReceived1()) {
				AmountReceivableR1 += ex.getRm1Amount();
			}

			if (ex.getSplit2() && !ex.getReceived2()) {
				AmountReceivableR2 += ex.getRm2Amount();
			}

			if (ex.getSplit1() && !ex.getReceived3()) {
				AmountReceivableR3 += ex.getRm3Amount();
			}

			if (ex.getSplit1() && ex.getReceived1()) {
				AmountReceivedR1 += ex.getRm1Amount();
			}

			if (ex.getSplit2() && ex.getReceived2()) {
				AmountReceivedR2 += ex.getRm2Amount();
			}

			if (ex.getSplit1() && ex.getReceived3()) {
				AmountReceivedR3 += ex.getRm3Amount();
			}

			if (ex.getPersonal()) {
				if (ex.getSelectedCategory().equals("type1")) {
					IndvType1 += ex.getAmount();
				} else if (ex.getSelectedCategory().equals("type2")) {
					IndvType2 += ex.getAmount();
				} else if (ex.getSelectedCategory().equals("type3")) {
					IndvType3 += ex.getAmount();
				}
			} else {
				if (ex.getSelectedCategory().equals("type1")) {
					GroupType1 += ex.getAmount();
				} else if (ex.getSelectedCategory().equals("type2")) {
					GroupType2 += ex.getAmount();
				} else if (ex.getSelectedCategory().equals("type3")) {
					GroupType3 += ex.getAmount();
				}
			}
			expenseTable.addRow(new Object[] { ex.getDateString(),
					ex.getSelectedCategory(), "$" + ex.getAmount(),
					"$" + ex.getRm1Amount(), ex.getReceived1String(),
					"$" + ex.getRm2Amount(), ex.getReceived2String(),
					"$" + ex.getRm3Amount(), ex.getReceived3String(),
					"$" + ex.getYourAmount() });
		}
		
		// Adding tabulated data into the JTable
		expenseTable.addRow(new Object[] {});
		expenseTable.addRow(new Object[] { "Total Amount ", "Spent by ",
				"Group : ", "$" + totalAmount });
		expenseTable.addRow(new Object[] { "Total Amount ", "Spent by ",
				"You : ", "$" + totalYourAmount });
		expenseTable
				.addRow(new Object[] {
						"Total Amount ",
						"Receivable ",
						"from Group : ",
						"$"
								+ (AmountReceivableR1 + AmountReceivableR2 + AmountReceivableR3) });
		expenseTable.addRow(new Object[] { "Total Amount ", "Receivable ",
				"from R(1) : ", "$" + AmountReceivableR1 });
		expenseTable.addRow(new Object[] { "Total Amount ", "Receivable ",
				"from R(2) : ", "$" + AmountReceivableR2 });
		expenseTable.addRow(new Object[] { "Total Amount ", "Receivable ",
				"from R(3) : ", "$" + AmountReceivableR3 });
		expenseTable
				.addRow(new Object[] {
						"Total Amount ",
						"Received ",
						"from Group : ",
						"$"
								+ (AmountReceivedR1 + AmountReceivedR2 + AmountReceivedR3) });
		expenseTable.addRow(new Object[] { "Total Amount ", "Received ",
				"from R(1) : ", "$" + AmountReceivedR1 });
		expenseTable.addRow(new Object[] { "Total Amount ", "Received ",
				"from R(2) : ", "$" + AmountReceivedR2 });
		expenseTable.addRow(new Object[] { "Total Amount ", "Received ",
				"from R(3) : ", "$" + AmountReceivedR3 });
		
		// Updating Pie Charts with tabulated data
		pieDatasetIndv.setValue("type1", new Double(IndvType1));
		pieDatasetIndv.setValue("type2", new Double(IndvType2));
		pieDatasetIndv.setValue("type3", new Double(IndvType3));
		pieDatasetGroup.setValue("type1", new Double(GroupType1));
		pieDatasetGroup.setValue("type2", new Double(GroupType2));
		pieDatasetGroup.setValue("type3", new Double(GroupType3));

		// Updating Bar Charts with tabulated data
		datasetIndv.setValue(IndvType1, "Amount($)", "Type1");
		datasetIndv.setValue(IndvType2, "Amount($)", "Type2");
		datasetIndv.setValue(IndvType3, "Amount($)", "Type3");
		datasetGroup.setValue(GroupType1, "Amount($)", "Type1");
		datasetGroup.setValue(GroupType2, "Amount($)", "Type2");
		datasetGroup.setValue(GroupType3, "Amount($)", "Type3");
	}

	}