package Emailapp;

import java.util.Locale;
import java.util.Scanner;

public class Email {

    // Class Variables

    private String firstName;
    private String password;
    private String lastname;
    private String department;
    private String email;
    private  int defaultPasswordLength = 10;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "aeycompany.com";

    // Constructor to receive the first name and last name

    public Email(String firstName, String lastname){
        this.firstName = firstName;
        this.lastname = lastname;
//        System.out.println("EMAIL CREATED: " + this.firstName + " " + this.lastname);

        // Call a method asking for the department - return the department
        this.department = setDepartment();
//        System.out.println("Department: " + this.department);

        // Call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your Password is: " + this.password);

        // Combine elements to geneate email
        email = firstName.toLowerCase()+"."+lastname.toLowerCase() +"@" + department +"." + companySuffix;
//        System.out.println("Your Email is " + email);


    }

    // Ask for department
    private String setDepartment(){
        System.out.print("New worker:" + firstName +  " Department codes: \n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        in.nextInt();
        int depChoice = in.nextInt();
        if(depChoice == 1){
            return "sales";
        } else if(depChoice == 2){
            return "dev";
        } else if(depChoice == 3){
            return "acct";
        } else if(depChoice == 0){
            return "";
        }else {
            return "";
        }
    }

    // Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKMNOPQRSTUWXYZVL0123456789!@#$%";
        char[] password = new char[length];
        for(int i =0; i < length; i++){
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    // Accessors and Mutators - encapsulation

    //Set the mailbox capacity
    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    // Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword(){
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastname +
                "\nCOMPANY EMAIL: " + email+
                "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
