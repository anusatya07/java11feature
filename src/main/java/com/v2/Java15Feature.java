package com.v2;

public class Java15Feature {

	public static void main(String[] args) {

		// Text Blocks
		String dbSchema = """
				CREATE TABLE 'TEST'.'EMPLOYEE'
				(
				  'ID' INT NOT NULL DEFAULT 0 ,
				  'FIRST_NAME' VARCHAR(100) NOT NULL ,
				  'LAST_NAME' VARCHAR(100) NULL ,
				  'STAT_CD' TINYINT NOT NULL DEFAULT 0
				);
				        """;

	}

	/** sealed class */
	sealed class Account permits CurrentAccount, SavingAccount, LoanAccount {
	}

	final class CurrentAccount extends Account {
	}

	non-sealed class SavingAccount extends Account {
	}

	sealed class LoanAccount extends Account permits HomeloanAccount, AutoloanAccount {
	}

	final class HomeloanAccount extends LoanAccount {
	}

	final class AutoloanAccount extends LoanAccount {
	}
	/** Pattern Matching for instanceof */
//	if (obj instanceof String s) {
//	    // can use s here
//	} else {
//	    // can't use s here
//	}
//	 
//	//Example
//	 
//	if(customer instanceof PersonalCustomer pCustomer)
//	{
//	    customerName = String.join(" ", pCustomer.getFirstName(), 
//	                            pCustomer.getMiddleName(), 
//	                            pCustomer.getLastName());
//	}
//	else if(customer instanceof BusinessCustomer bCustomer)
//	{
//	    customerName = bCustomer.getLegalName();
//	}
}
