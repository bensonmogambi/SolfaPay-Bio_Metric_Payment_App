package MDT.FingerPrint.cmu;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

    private String firstName;
    private String username;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String password;
    private String DOB;
    private String address2;
    private String address3;
    private String city;
    private String state;
    private String pin;

    public String getDOB() {
        return DOB;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPin() {
        return pin;
    }

    public ArrayList<CreditCard> getCardList() {
        return cardList;
    }

    public String getAddress2() {
        return address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public void setCardList(ArrayList<CreditCard> cardList) {
        this.cardList = cardList;
    }

    private ArrayList<CreditCard> cardList = new ArrayList<CreditCard>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void addCreditCard(CreditCard c) {
        cardList.add(c);
    }

    public ArrayList<CreditCard> getCreditCards() {
        return cardList;

    }

    public ArrayList<Transaction> getTransactionListForCustomer() {
        ArrayList<CreditCard> cardList = this.getCreditCards();
        ArrayList<Transaction> transactionList = new ArrayList<Transaction>();

        Iterator<CreditCard> itCard = cardList.iterator();

        while (itCard.hasNext()) {
            ArrayList<Transaction> currTransactionList = itCard.next().getTransactionList();
            Iterator<Transaction> itTrans = currTransactionList.iterator();
            while (itTrans.hasNext()) {
                transactionList.add(itTrans.next());
            }

        }
        return transactionList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
