package com.example.grocerymanagementapp.database;

import com.example.grocerymanagementapp.models.Item;

import java.util.ArrayList;

/**
 * Wrapper for an ArrayList with Items
 * @param <Item>
 */
public abstract class ItemList<Item extends Comparable<Item>>{

  /**
   * The actual list
   */
  private ArrayList<Item> itemList;

  /**
   * Serving data-persistance
   */
  private DatabaseInterface databaseInterface;

  public ItemList(DatabaseInterface databaseInterface) {
  }

  public abstract void addItemIntelligent(com.example.grocerymanagementapp.models.Item testItem1);

  public abstract void deleteItem(int anyInt);
}
