package MDT.FingerPrint.cmu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.math.BigDecimal;


public class Item {
  private String code;
  private String name;
  private String description;
  private int price;

  /**
   * Parameterized constructor
   * @param code
   * @param name
   * @param description
   * @param price 
   */
  public Item(String code,String name,String description,int price) {
    this.code=code;
    this.name=name;
    this.description=description;
    this.price=price;
  }

  /**
   * getter to retrieve the code
   * @return code
   */
  public String getCode() {
    return code;
  }

  /**
   * getter to retrieve the name
   * @return Name
   */
  public String getName() {
    return name;
  }

  /**
   * getter to retrieve the description
   * @return Description
   */
  public String getDescription() {
    return description;
  }

  /**
   * getter to retrieve the price
   * @return Price
   */
  public int getPrice() {
    return price;
  }

  /**
   * getter to retrieve the formatted price
   * @return Formatted Price
   */
  public String getFormattedPrice() {
    return "$"+new BigDecimal(price).movePointLeft(2);
  }

  /**
   * boolean method to check equality
   * @return True/False
   */
  public boolean equals(Object o) {
    if (this == o) return true;
    if (this == null) return false;
    if (!(o instanceof Item)) return false;
    return ((Item)o).getCode().equals(this.code);
  }
}
