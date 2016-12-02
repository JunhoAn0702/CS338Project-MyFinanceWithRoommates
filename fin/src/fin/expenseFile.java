package fin;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/*
* [Junho An]
* [ja565@drexel.edu]
* CS338:GUI, Project *
*/

/**
 * @author junhoan This is a expenseFile class for saving file.
 */
public class expenseFile implements Serializable{
	// Attributes
	private static final long serialVersionUID = 1L;
	private ArrayList<expense> expenseList = new ArrayList<expense>();
	private String fileName;
	private String filePath;
	
	// Constructor 
	public expenseFile(String fileName){
		this.expenseList = new ArrayList<expense>();
		this.fileName = fileName;
		this.filePath = "./" + this.fileName;
	}
	
	// Getter/Setter methods for expenseList
	public ArrayList<expense> getExpenseList() {
		return expenseList;
	}
	public void setExpenseList(ArrayList<expense> expenseList) {
		this.expenseList = expenseList;
	}
	
	// Getter/Setter methods for fileName
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	// Getter/Setter methods for filePath
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	// Method to create Dir.
	public boolean createDir() throws IOException {
		File file = new File(this.filePath);

		// If the file exists, the program recursively asks the your to input a
		// valid survey/test name.
		if (file.exists()) {
			return false;
		}
		file.mkdir();
		return true;
	}
	
	// Method to save the file.
	public boolean saveFile(String fileName) throws IOException {
		try {
			FileOutputStream file = new FileOutputStream("./" + this.fileName + "/"
					+ fileName);
			ObjectOutputStream out = new ObjectOutputStream(file);
			out.writeObject(this.getExpenseList());
			out.close();
			file.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	// Method to load the file
	@SuppressWarnings("unchecked")
	public boolean loadFile(String fileName) throws IOException {
		try {
			FileInputStream file = new FileInputStream("./" + fileName + "/"
					+ fileName);
			ObjectInputStream in = new ObjectInputStream(file);
			this.setFileName(fileName);
			this.setFilePath("./" + this.getFileName());
			this.setExpenseList((ArrayList<expense>) in.readObject());
			in.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}
