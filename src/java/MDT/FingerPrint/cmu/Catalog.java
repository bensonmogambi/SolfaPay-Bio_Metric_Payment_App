package MDT.FingerPrint.cmu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;

public class Catalog {

  private static Map<String,Item> items;

  static {
   items = new HashMap<String,Item>(); 
   items.put("cappuccino001",new Item("cappuccino001","Cappuccino","Everyone loves our Cappuccino...",499));
   items.put("lattee001",new Item("lattee001","Caffee Latte","The best Caffe Latte..",565));
   items.put("banana001",new Item("banana001","Banana Nut Loaf","2 loaf of Banana Nut",299));
   items.put("hotchoc001",new Item("hotchoc001","Hot Chocolate","Hot Chocolate for all season", 600));
   items.put("sizzbrown001",new Item("sizzbrown001","Sizzling Brownie","Sizzling Brownie with Vanilla Ice Creme Scoop..", 799));
   items.put("choccros001",new Item("choccros001","chocolate croissant","Chocoloate Croissant - Buttery Delicious", 499));
  }

  /**
   * Retrieve all Items from the Map collection
   * @return Items
   */
  public Collection<Item> getAllItems() {
    return items.values();
  }

  /**
   * Check if an item exists in the Map
   * @param itemCode
   * @return True/False
   */
  public boolean containsItem(String itemCode) {
    return items.containsKey(itemCode);
  }

   /**
   * Get an Item given an item code
   * @param itemCode input
   * @return Item
   */
  public Item getItem(String itemCode) {
    return items.get(itemCode);
  }

}
