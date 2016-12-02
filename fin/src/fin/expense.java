package fin;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/*
 * [Junho An]
 * [ja565@drexel.edu]
 * CS338:GUI, Project *
 */

/**
 * @author junhoan This is a expenseFile class for saving file.
 */

public class expense implements Serializable {
	// Attributes
	private static final long serialVersionUID = 1L;
	private Date date;
	private String dateString;
	private double amount;
	private boolean split1;
	private boolean split2;
	private boolean split3;
	private double rm1Amount;
	private double rm2Amount;
	private double rm3Amount;
	private boolean received1;
	private boolean received2;
	private boolean received3;
	private String received1String;
	private String received2String;
	private String received3String;
	private double yourAmount;
	private List<String> category;
	private String selectedCategory;
	private boolean isPersonal;
	private Format formatter = new SimpleDateFormat("yyyy/MM/dd");

	// Constructor
	public expense() {
		this.date = new Date();
		this.amount = 0;
		this.split1 = false;
		this.split2 = false;
		this.split3 = false;
		this.received1 = false;
		this.yourAmount = 0;
		this.category = new ArrayList<String>(Arrays.asList("", "Type1",
				"Type2", "Type3", "Type4", "Type5"));
		this.selectedCategory = "";
		this.isPersonal = false;
	}

	// Constructor and initialize the attributes with given parameters.
	public expense(Date date, double amount, boolean split1, boolean split2,
			boolean split3, boolean received1, boolean received2,
			boolean received3, String selectedCategory) {
		this.date = date;
		this.dateString = formatter.format(date);
		this.amount = amount;
		this.split1 = split1;
		this.split2 = split2;
		this.split3 = split3;
		this.received1 = received1;
		this.received2 = received2;
		this.received3 = received3;
		this.received1String = received1 ? "Y" : "N";
		this.received2String = received2 ? "Y" : "N";
		this.received3String = received3 ? "Y" : "N";
		int count = 1;
		if (split1) {
			count += 1;
		}
		if (split2) {
			count += 1;
		}
		if (split3) {
			count += 1;
		}
		this.yourAmount = amount / count;
		if (split1) {
			this.rm1Amount = amount / count;
		} else {
			this.received1 = false;
			this.received1String = "";
		}
		if (split2) {
			this.rm2Amount = amount / count;
		} else {
			this.received2 = false;
			this.received2String = "";
		}
		if (split3) {
			this.rm3Amount = amount / count;
		} else {
			this.received3 = false;
			this.received3String = "";
		}
		this.selectedCategory = selectedCategory;
		if (split1 || split2 || split3) {
			this.isPersonal = false;
		} else {
			this.isPersonal = true;
		}
	}

	// Constructor and initialize the attributes with given parameters.
	public expense(String date, double amount, boolean split1, boolean split2,
			boolean split3, boolean received1, boolean received2,
			boolean received3, String selectedCategory) {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		try {
			this.date = df.parse(date);
			this.dateString = formatter.format(this.date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		this.amount = amount;
		this.split1 = split1;
		this.split2 = split2;
		this.split3 = split3;
		this.received1 = received1;
		this.received2 = received2;
		this.received3 = received3;
		this.received1String = received1 ? "Y" : "N";
		this.received2String = received2 ? "Y" : "N";
		this.received3String = received3 ? "Y" : "N";
		int count = 1;
		if (split1) {
			count += 1;
		}
		if (split2) {
			count += 1;
		}
		if (split3) {
			count += 1;
		}
		this.yourAmount = amount / count;
		if (split1) {
			this.rm1Amount = amount / count;
		} else {
			this.received1 = false;
			this.received1String = "";
		}
		if (split2) {
			this.rm2Amount = amount / count;
		} else {
			this.received2 = false;
			this.received2String = "";
		}
		if (split3) {
			this.rm3Amount = amount / count;
		} else {
			this.received3 = false;
			this.received3String = "";
		}
		this.selectedCategory = selectedCategory;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the dateString
	 */
	public String getDateString() {
		return dateString;
	}

	/**
	 * @param dateString
	 *            the dateString to set
	 */
	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount
	 *            the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	/**
	 * @return the split1
	 */
	public boolean getSplit1() {
		return split1;
	}

	/**
	 * @param split1
	 *            the split1 to set
	 */
	public void setSplit1(boolean split1) {
		this.split1 = split1;
	}

	/**
	 * @return the split2
	 */
	public boolean getSplit2() {
		return split2;
	}

	/**
	 * @param split2
	 *            the split2 to set
	 */
	public void setSplit2(boolean split2) {
		this.split2 = split2;
	}

	/**
	 * @return the split3
	 */
	public boolean getSplit3() {
		return split3;
	}

	/**
	 * @param split3
	 *            the split3 to set
	 */
	public void setSplit3(boolean split3) {
		this.split3 = split3;
	}

	/**
	 * @return the rm1Amount
	 */
	public double getRm1Amount() {
		return rm1Amount;
	}

	/**
	 * @param rm1Amount
	 *            the rm1Amount to set
	 */
	public void setRm1Amount(double rm1Amount) {
		this.rm1Amount = rm1Amount;
	}

	/**
	 * @return the rm2Amount
	 */
	public double getRm2Amount() {
		return rm2Amount;
	}

	/**
	 * @param rm2Amount
	 *            the rm2Amount to set
	 */
	public void setRm2Amount(double rm2Amount) {
		this.rm2Amount = rm2Amount;
	}

	/**
	 * @return the rm3Amount
	 */
	public double getRm3Amount() {
		return rm3Amount;
	}

	/**
	 * @param rm3Amount
	 *            the rm3Amount to set
	 */
	public void setRm3Amount(double rm3Amount) {
		this.rm3Amount = rm3Amount;
	}

	/**
	 * @return the received1
	 */
	public boolean getReceived1() {
		return received1;
	}

	/**
	 * @param received1
	 *            the received1 to set
	 */
	public void setReceived1(boolean received1) {
		this.received1 = received1;
	}

	/**
	 * @return the received2
	 */
	public boolean getReceived2() {
		return received2;
	}

	/**
	 * @param received2
	 *            the received2 to set
	 */
	public void setReceived2(boolean received2) {
		this.received2 = received2;
	}

	/**
	 * @return the received3
	 */
	public boolean getReceived3() {
		return received3;
	}

	/**
	 * @param received3
	 *            the received3 to set
	 */
	public void setReceived3(boolean received3) {
		this.received3 = received3;
	}

	/**
	 * @return the received1String
	 */
	public String getReceived1String() {
		return received1String;
	}

	/**
	 * @param received1String
	 *            the received1String to set
	 */
	public void setReceived1String(String received1String) {
		this.received1String = received1String;
	}

	/**
	 * @return the received2String
	 */
	public String getReceived2String() {
		return received2String;
	}

	/**
	 * @param received2String
	 *            the received2String to set
	 */
	public void setReceived2String(String received2String) {
		this.received2String = received2String;
	}

	/**
	 * @return the received3String
	 */
	public String getReceived3String() {
		return received3String;
	}

	/**
	 * @param received3String
	 *            the received3String to set
	 */
	public void setReceived3String(String received3String) {
		this.received3String = received3String;
	}

	/**
	 * @return the yourAmount
	 */
	public double getYourAmount() {
		return yourAmount;
	}

	/**
	 * @param yourAmount
	 *            the yourAmount to set
	 */
	public void setYourAmount(double yourAmount) {
		this.yourAmount = yourAmount;
	}

	/**
	 * @return the category
	 */
	public List<String> getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(List<String> category) {
		this.category = category;
	}

	/**
	 * @return the selectedCategory
	 */
	public String getSelectedCategory() {
		return selectedCategory;
	}

	/**
	 * @param selectedCategory
	 *            the selectedCategory to set
	 */
	public void setSelectedCategory(String selectedCategory) {
		this.selectedCategory = selectedCategory;
	}

	/**
	 * @return the isPersonal
	 */
	public boolean getPersonal() {
		return isPersonal;
	}

	/**
	 * @param isPersonal
	 *            the isPersonal to set
	 */
	public void setPersonal(boolean isPersonal) {
		this.isPersonal = isPersonal;
	}

	/**
	 * @return the formatter
	 */
	public Format getFormatter() {
		return formatter;
	}

	/**
	 * @param formatter
	 *            the formatter to set
	 */
	public void setFormatter(Format formatter) {
		this.formatter = formatter;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		expense other = (expense) obj;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		}
		if (dateString == null) {
			if (other.dateString != null)
				return false;
		} else if (!dateString.equals(other.dateString))
			return false;
		if (formatter == null) {
			if (other.formatter != null)
				return false;
		} else if (!formatter.equals(other.formatter))
			return false;
		if (received1 != other.received1)
			return false;
		if (received1String == null) {
			if (other.received1String != null)
				return false;
		} else if (!received1String.equals(other.received1String))
			return false;
		if (received2 != other.received2)
			return false;
		if (received2String == null) {
			if (other.received2String != null)
				return false;
		} else if (!received2String.equals(other.received2String))
			return false;
		if (received3 != other.received3)
			return false;
		if (received3String == null) {
			if (other.received3String != null)
				return false;
		} else if (!received3String.equals(other.received3String))
			return false;
		if (Double.doubleToLongBits(rm1Amount) != Double
				.doubleToLongBits(other.rm1Amount))
			return false;
		if (Double.doubleToLongBits(rm2Amount) != Double
				.doubleToLongBits(other.rm2Amount))
			return false;
		if (Double.doubleToLongBits(rm3Amount) != Double
				.doubleToLongBits(other.rm3Amount))
			return false;
		if (selectedCategory == null) {
			if (other.selectedCategory != null)
				return false;
		} else if (!selectedCategory.equals(other.selectedCategory))
			return false;
		if (split1 != other.split1)
			return false;
		if (split2 != other.split2)
			return false;
		if (split3 != other.split3)
			return false;
		if (Double.doubleToLongBits(yourAmount) != Double
				.doubleToLongBits(other.yourAmount))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "expense [date=" + date + ", dateString=" + dateString
				+ ", amount=" + amount + ", split1=" + split1 + ", split2="
				+ split2 + ", split3=" + split3 + ", rm1Amount=" + rm1Amount
				+ ", rm2Amount=" + rm2Amount + ", rm3Amount=" + rm3Amount
				+ ", received1=" + received1 + ", received2=" + received2
				+ ", received3=" + received3 + ", received1String="
				+ received1String + ", received2String=" + received2String
				+ ", received3String=" + received3String + ", yourAmount="
				+ yourAmount + ", category=" + category + ", selectedCategory="
				+ selectedCategory + ", formatter=" + formatter + "]";
	}

}
