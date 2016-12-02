package fin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

/*
 * [Junho An]
 * [ja565@drexel.edu]
 * CS338:GUI, Project *
 */

/**
 * @author junhoan
 * This is Main class to add all different actions in different cases
 */
public class main {
	/**
	 * Launch the application.
	 */
	
	// Attribute of expenseFilee
	private static expenseFile expenseFilee;
	
	// Main GUI windows
	private static InitialScreen frame;
	private static mainScreen mainScreenn;
	private static AddEditScreen addEditScreen;
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		// Main Window Gui
		frame = new InitialScreen();
		frame.setVisible(true);
		// Adding actions to all windows
		addAction();
	}
	
	// Adding Actions
	public static void addAction(){
		// Adding an action on clicking load button
		frame.getLoad().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoadScreen loadScreen = new LoadScreen();
				frame.setVisible(false);
				loadScreen.setVisible(true);
				
				// Adding an action on clicking OK button on the load screen
				loadScreen.getLoadOk().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							expenseFilee = new expenseFile(loadScreen.getFileName().getText());
							// If the file exists, call addActionMainScreen method.
							if(expenseFilee.loadFile(loadScreen.getFileName().getText().toString())){
								JOptionPane.showMessageDialog(null,
										"File is loaded successfully!");
								loadScreen.setVisible(false);
								addActionsMainScreen();	
							}
							// Display error message
							else{
								JOptionPane.showMessageDialog(null,
										"File does not exist!");
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				
				// Adding an action on clicking cancel button
				loadScreen.getLoadCancel().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(true);
						loadScreen.setVisible(false);
					}
				});
			}
		});
		// Adding an action on clicking new expense button
		frame.getNewExpense().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CreateScreen createScreen = new CreateScreen();
				frame.setVisible(false);
				createScreen.setVisible(true);
				// Adding an action on clicking OK button in creating new expense screen
				createScreen.getCreateOk().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						expenseFilee = new expenseFile(createScreen.getFileName().getText());
						try {
							// Check if the file name already exists, and call addActionsMainScreen method
							if(expenseFilee.createDir()){
								createScreen.setVisible(false);
								addActionsMainScreen();
							}
							// If already exists, display error message.
							else{
								JOptionPane.showMessageDialog(null, "File already exists! Please enter a different file name.");
							}	
						} catch (IOException e1) {
						}
					}
				});
				
				// Adding an action on clicking cancel button in create new expense screen
				createScreen.getCreateCancel().addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						frame.setVisible(true);
						createScreen.setVisible(false);
					}
				});
			}
		});
	}

	/**
	 * This is a method to retrieve selected value from the table and 
	 * put it into expense object
	 * @param selectedRows
	 * @return expense object
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 */
	public static expense getSelectedExpenseFromTable(
			int selectedRows) throws NumberFormatException, ParseException {
		NumberFormat format = NumberFormat.getCurrencyInstance();
		return new expense((String) mainScreenn.getDataTable().getValueAt(
				selectedRows, 0), Double.parseDouble(format.parse((String) mainScreenn.getDataTable().getValueAt(
				selectedRows, 2)).toString()), (((String) mainScreenn.getDataTable().getValueAt(
				selectedRows, 3)).equals("$0.0") ? false : true), 
				(((String) mainScreenn.getDataTable().getValueAt(
				selectedRows, 5)).equals("$0.0") ? false : true), 
				(((String) mainScreenn.getDataTable().getValueAt(
				selectedRows, 7)).equals("$0.0") ? false : true), 
				(((String) mainScreenn.getDataTable().getValueAt(
				selectedRows, 4)).equals("Y") ? true : false), 
				(((String) mainScreenn.getDataTable().getValueAt(
				selectedRows, 6)).equals("Y") ? true : false), 
				(((String) mainScreenn.getDataTable().getValueAt(
				selectedRows, 8)).equals("Y") ? true : false), 
				(String) mainScreenn.getDataTable().getValueAt(
				selectedRows, 1));
	}
	
	// Method to add actions on the main screen.
	public static void addActionsMainScreen(){
		mainScreenn = new mainScreen(expenseFilee.getExpenseList());
		mainScreenn.setVisible(true);
		// Adding an action on clicking add button.
		mainScreenn.getMainAdd().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				addEditScreen = new AddEditScreen();
				mainScreenn.setVisible(false);
				addEditScreen.setVisible(true);
				// Adding an action on clicking save button in the add expense screen
				addEditScreen.getAddEditSave().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Checking if any field is empty. If not, add the new expense.
						if(addEditScreen.setExpensesWithData()){
							expense newExpense = addEditScreen.getExpenses();
							expenseFilee.getExpenseList().add(newExpense);
							mainScreenn.repaintTable(expenseFilee.getExpenseList());
							mainScreenn.setVisible(true);
							addEditScreen.setVisible(false);
						}
						// Display an error message
						else{
							JOptionPane.showMessageDialog(null, "Please fill all fields!");
						}
					}
				});
				// Adding an action on clicking cancel button in add new expense screen
				addEditScreen.getAddEditCancel().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						addEditScreen.setVisible(false);
						mainScreenn.setVisible(true);
					}
				});
			}
		});
		// Adding an action on clicking edit button
		mainScreenn.getMainEdit().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] indexNumTable = mainScreenn.getDataTable().getSelectedRows();
				// Checking only one row is selcted from the table
				if (indexNumTable.length == 1) {
					expense expenseEdit;
					try {
						expenseEdit = getSelectedExpenseFromTable(
								indexNumTable[0]);
						addEditScreen = new AddEditScreen(expenseEdit);
						mainScreenn.setVisible(false);
						addEditScreen.setVisible(true);
						// Adding an action on clicking cancel button in the edit expense screen
						addEditScreen.getAddEditCancel().addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								mainScreenn.setVisible(true);
								addEditScreen.setVisible(false);
							}
						});
						// Adding an action on clicking add button in the edit expense screen
						addEditScreen.getAddEditSave().addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								// Checking any field is empty. If not, saves the editted expense.
								if (addEditScreen.setExpensesWithData()) {
									// Finding/Updating an existing one from the list 
									for (int i = 0; i < expenseFilee.getExpenseList().size(); i++) {
										if (expenseFilee.getExpenseList().get(i).equals(
												expenseEdit)) {
											expenseFilee.getExpenseList().set(i,
													addEditScreen.getExpenses());
											mainScreenn.repaintTable(expenseFilee.getExpenseList());
											break;
										}
									}
									mainScreenn.setVisible(true);
									addEditScreen.setVisible(false);
								}
								// Display an error message.
								else{
									JOptionPane.showMessageDialog(null, "File already exists! Please enter a different file name.");
								}
							}
						});
					} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				// Display an error message
				else{
					JOptionPane.showMessageDialog(null, "Please select one from the table");
				}
			}
		});
		// Adding an action on clicking delete button
		mainScreenn.getMainDelete().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// whichever is selected, retrieve selected value
				int[] indexNumTable = mainScreenn.getDataTable().getSelectedRows();
				expense expenseRemove;
				
				try {
				expenseRemove = getSelectedExpenseFromTable(
							indexNumTable[0]);
		
				
				// Removing the selected data from the list
				if (indexNumTable.length == 1) {
					for (int i = 0; i < expenseFilee.getExpenseList().size(); i++) {
						if (expenseFilee.getExpenseList().get(i).equals(expenseRemove)) {
							expenseFilee.getExpenseList().remove(i);
							mainScreenn.repaintTable(expenseFilee.getExpenseList());
							break;
						}
					}
				} 
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		// Adding an action on clicking the save button
		mainScreenn.getMainSave().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Saving the file into the created directory.
					if(expenseFilee.saveFile(expenseFilee.getFileName())){
						JOptionPane.showMessageDialog(null,
								"File is successfully saved!");
					}
					// Display an error message
					else{
						JOptionPane.showMessageDialog(null,
								"Unknown Error Occured!");
					}
				} catch (IOException e1) {
					// Display an error message
					JOptionPane.showMessageDialog(null,
							"Unknown Error Occured2!");
				}
			}
		});
	}
}
