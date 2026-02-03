package com.bankapplication.sayali.serviceimpl;



import java.util.Scanner;

import com.bankapplication.sayali.model.Account;
import com.bankapplication.sayali.service.RBI;
import com.validation.Validate;

public class SBI implements RBI {
	Scanner sc = new Scanner(System.in);
	Account[] accounts = new Account[5];
	Account ac = new Account();

	@Override
	public void createAccount() {
		// TODO Auto-generated method stub
		System.out.println("Enter Account creation no");
		int n = sc.nextInt();
		if (n < accounts.length) {
			for (int i = 0; i < n; i++) {
				Account ac = new Account();
				System.out.println("Enter Account No:");
				int accno = sc.nextInt();
				ac.setAccNo(accno);
				//System.out.println("Enter your Name:");
				//ac.setAccName(sc.next());
				ac.setAccName(Validate.validateName());
				//System.out.println("Enter your AdhaarCard no:");
				//ac.setAdhaarCard(sc.next());
				ac.setAdhaarCard(Validate.validateAdhaarcardNo());
				//System.out.println("Enter your PanCard no:");
				//ac.setPanCard(sc.next());
				ac.setPanCard(Validate.validatePANcardNo());
				//System.out.println("Enter your EmailId:");
				//ac.setEmailId(sc.next());
				ac.setEmailId(Validate.validateEmail());
				//System.out.println("Enter your contact:");
				//ac.setContact(sc.nextLong());
				ac.setContact(Validate.ValidMobNo());
				System.out.println("Enter your accountBalance:");
				ac.setAccountBalance(sc.nextDouble());
				// System.out.println("Account Created Successfully please check Details");
				accounts[i] = ac;
				System.out.println("Account created successsfully for:" + i + "th index of" + ac.getAccName());
			}
			System.out.println("acc created succesfully for holder");
		} else {
			System.out.println("Limit exceed" + "");
		}

	}

	@Override
	public void showAccountDetails() {
		// TODO Auto-generated method stub
		// Account ac=new Account();
		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				// System.out.println(accounts[i]);
				System.out.println(accounts[i].getAccNo());

				System.out.println(accounts[i].toString());
			}

		}

	}

	@Override
	public void showAccountBalance() {
		// TODO Auto-generated method stub

		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null) {
				System.out.println(accounts[i].getAccountBalance());
			}
		}
	}

	@Override
	public void withdrawMoney() { // 123 s 456 r==Accounts[i]
		// TODO Auto-generated method stub
		boolean flag = true;
		System.out.println("Enter the account no:");
		int ac = sc.nextInt();// 456

		System.out.println("Enter withdraw amout:");
		double accwithdraw = sc.nextDouble();
		double updatedAmount = 0;

		if (accounts != null && accounts.length > 0) {

			for (int i = 0; i < accounts.length; i++) {

				if (accounts[i] != null && ac == accounts[i].getAccNo()) {
					if (accounts[i].getAccountBalance() >= accwithdraw) {
						double currentBalance = accounts[i].getAccountBalance();
						updatedAmount = currentBalance - accwithdraw;
						System.out.println("Current balance is:" + accounts[i].getAccName() + "is:" + updatedAmount);
						accounts[i].setAccountBalance(updatedAmount);

					} else {
						System.out.println("insufficient balance" + accounts[i].getAccName() + "accounts");
					}
					break;
				}

			}
			if (!flag)
				System.out.println("Account dosnt exists");
		}
	}

	@Override
	public void depositeMoney() {
		// TODO Auto-generated method stub
		boolean flag = true;
		System.out.println("Enter the account no:");
		int ac = sc.nextInt();

		System.out.println("Enter Deposite Amount");
		double accdeposite = sc.nextDouble();

		for (int i = 0; i < accounts.length; i++) {
			if (accounts[i] != null && ac == accounts[i].getAccNo()) {
				if (accdeposite > 0) {
					accdeposite = accounts[i].getAccountBalance() + accdeposite;
					accounts[i].setAccountBalance(accdeposite);
					System.out.println("Deposite Succesful");
				} else {

					System.out.println("Invalid amount");
				}
				break;
			}

		}
		if (!flag) {
			System.out.println("Account dosnt exists");
		}
	}

	@Override
	public void updateAccountDetails() {
		Scanner sc1 = new Scanner(System.in);
		boolean flag = true;
		while (flag) {
			System.out.println("1:update name            |");
			System.out.println("2:Update Mobile no       |");
			System.out.println("3:Update EmailId         |");
			System.out.println("4:Update Adhaar card     |");
			System.out.println("5:Update  PAN            |");
			System.out.println("6:Exit                   |");

			System.out.println("Enter your choice in betwwen 1 to 6 fpr updation");
			int ch = sc1.nextInt();

			switch (ch) {
			case 1:

				System.out.println("Enter the account no:");
				int ac = sc1.nextInt();

				System.out.println("Enter Name to update ");
				String updateNm = sc1.next();

				for (int i = 0; i < accounts.length; i++) {
					if (accounts[i] != null && ac == accounts[i].getAccNo()) {
						accounts[i].setAccName(updateNm);
						System.out.println("Name updated successfully");

						break;
					}
				}

			case 2:
				System.out.println("Enter Mobile No to update");
				long updateMob = sc1.nextLong();
				for (int i = 0; i < accounts.length; i++) {
					if (accounts[i] != null) {
						accounts[i].setContact(updateMob);
						System.out.println("mobile updated successfully");
						break;
					}
				}
			

			case 3:
				System.out.println("Enter EmailId to update");
				String updateEmail = sc1.next();
				for (int i = 0; i < accounts.length; i++) {
					if (accounts[i] != null) {
						accounts[i].setEmailId(updateEmail);
						System.out.println("Email updated successfully");
						// ac.setEmailId(updateEmail);}}
						break;
					}
				}
				
			case 4:
				System.out.println("Enter AdhaarNo update ");
				String updateAdhaar = sc1.next();
				for (int i = 0; i < accounts.length; i++) {
					if (accounts[i] != null) {
						accounts[i].setAdhaarCard(updateAdhaar);
						System.out.println("Adhar updated successfully");
						// ac.setAdhaarCard(updateAdhaar);
						break;
					}
				}
				
			case 5:
				System.out.println("Enter PAN to update");
				String updatePAN = sc.next();
				for (int i = 0; i < accounts.length; i++) {
					if (accounts[i] != null) {
						accounts[i].setPanCard(updatePAN);
						System.out.println("Pan updated successfully");
						// ac.setPanCard(updatePAN);
						break;
					}
				}
				
			case 6:

				System.out.println("Thank you Exiting...");
				flag = false;
				break;

			default:
				System.out.println("Invalid choice please enter choice to continue:");

			}
		}

	}

}