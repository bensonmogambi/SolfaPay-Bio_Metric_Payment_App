/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MDT.FingerPrint.cmu;

import java.util.HashMap;

/**
 *
 * @author arjunmehrotra
 */
public class Order {
    private String tranNumber;
    private    String tranDate;
    private    String vendorName;
    private    String total;
    
    private HashMap<String,String> items;

    public Order(String tranNumber, String tranDate, String vendorName, String total, HashMap<String, String> items) {
        this.tranNumber = tranNumber;
        this.tranDate = tranDate;
        this.vendorName = vendorName;
        this.total = total;
        this.items = items;
    }

    public void setTranNumber(String tranNumber) {
        this.tranNumber = tranNumber;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public void setItems(HashMap<String, String> items) {
        this.items = items;
    }

    public String getTranNumber() {
        return tranNumber;
    }

    public String getTranDate() {
        return tranDate;
    }

    public String getVendorName() {
        return vendorName;
    }

    public String getTotal() {
        return total;
    }

    public HashMap<String, String> getItems() {
        return items;
    }

}
