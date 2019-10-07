
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;


public class Bank_Account {
	static Scanner user_input= new Scanner(System.in);
	static Scanner option= new Scanner(System.in);
	int Account_Number=123456789;
	int Account_Balance=50;
	String Account_Holder="Manny";
	String Account_email="Manny12@gmail.com";
	int phone=123654;
	int new_amount;
	int no_of_transactions=0;
	int withdrawal_amount;
	int deposit_limit_day=1500;
	int deposit_limit_transaction=500;
	List<String> transaction_history=new ArrayList<String>();
	public void Account_type()
	{
		System.out.println("Welcome: "+Account_Holder);
		System.out.println("Please select type of account: \nPress 1 for Savings \nPress 2 for Checking");
		int option=user_input.nextInt();
		switch(option)
		{
		case 1: Savings_Menu();
				break;
		}
	}
	// Savings Menu
	public void Savings_Menu()
	{
		System.out.println("Welcome: "+Account_Holder);
		System.out.println("Please select type of account: \nPress 1 for Account Details \nPress 2 for Deposit\nPress 3 for Withdrawals\nPress 4 for Transaction History\nPress 5 for Exit");
		int choice=user_input.nextInt(); 
		        switch(choice)
		        {
	 		     case 1: Account_details();
 						break;
	 		     case 2: deposit_funds();
						break;	
	 		     case 3: withdraw_funds();
						break;
	 		     case 4: transaction_history();
	 		     		break;
	 		     case 5: System.out.println("Thank you and Goodbye");
	 		     		break;
		
	 		     default:System.out.println("Invalid Option");
	 		     		break;
		
		        }
	}	 
	// Display User Account Details
	public void Account_details()
	{
		System.out.println("Account holder name: "+Account_Holder);
		System.out.println("Account Number: "+Account_Number);
		System.out.println("Account Email: "+Account_email);
		System.out.println("Phone Number: "+phone);
		if(Account_Balance>new_amount)
		System.out.println("Current Balance: $"+Account_Balance);
		else
		System.out.println("Current Balance: $"+new_amount);
		System.out.println("Current time: "+LocalDateTime.now());
		question();
	}
	// Allowing user to deposit funds 
	public int deposit_funds()
	{	
		System.out.println("Would you like to deposit");
		System.out.println("Press 1 for Yes, 2 for No ");
		int choice=user_input.nextInt();
		switch(choice)
		{
		 case 1:  if(no_of_transactions<3)
		 		{
			 		if(Account_Balance>=50)
		 			{
			 		
			 		System.out.println("Enter the amount to be deposited");
			 		new_amount=user_input.nextInt();			
			 			if(new_amount > 50 && new_amount < 500)
			 			{
			 				Account_Balance=new_amount+Account_Balance;
			 				System.out.println("Your new account balance: $"+Account_Balance);
			 				transaction_history.add(" Deposited: $"+new_amount+" on: "+LocalDateTime.now()+"\n");
			 			}
			 			else
			 			{
			 			System.out.println("You cannot deposit less than $50 or more than $500 per transaction");
			 			}
			 			
		 			}
			 		no_of_transactions++;
		 		}
		 		else
		 		{
		 			System.out.println("Cannot make more than 3 transactions");
		 		}	
		 		
		 case 2: 
			 		break;
		 
		}
		
		question();
		return 0;
	}
	// Allowing user to withdraw funds 
	public int withdraw_funds()
	{
		System.out.println("Would to like to make a withdraw");
		System.out.println("Press 1 for Yes, 2 for No");
		int choice= user_input.nextInt();
		switch(choice)
		{
		case 1: System.out.println("Please enter the withdrawal amount");
				withdrawal_amount=user_input.nextInt();
				
				if(Account_Balance>=withdrawal_amount)
				{
					System.out.println("Your previous account balance was $"+Account_Balance);
					Account_Balance=Account_Balance-withdrawal_amount;
					System.out.println("Your new balance is $"+Account_Balance);
					transaction_history.add(" Amount Withdrawn: $"+withdrawal_amount+" on: "+LocalTime.now()+"\n");
				}
				else
				{
					System.out.println("Withdrawal Denied");
					System.out.println("Name: "+Account_Holder+" Current balance: "+Account_Balance);
				}
		case 2: 
				break;
		}
		
		question();
		return 0;
	}
	public void question()
	{
		System.out.println("Would you like to proceed ?");
		System.out.println("To proceed enter 9");
		System.out.println("If you wish to quit press 0");
		switch(option.nextInt())
		{
		case 0: System.out.println("Thank you and Goodbye");
				break;
		case 9: System.out.println("Please Proceed");
				Savings_Menu();
				break;
		}
	}
	public void transaction_history()
	{
		if(transaction_history==null)
		{
			System.out.println("No transactions are recorded yet");
		}
		else
		{
		System.out.println(transaction_history);
		}
		question();
	}
	
}
