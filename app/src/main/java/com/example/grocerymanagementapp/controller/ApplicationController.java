package com.example.grocerymanagementapp.controller;

import com.example.grocerymanagementapp.database.DatabaseAccess;
import com.example.grocerymanagementapp.models.Item;

public class ApplicationController {

  private static DatabaseAccess databaseAccess;

  private static ApplicationController instance;

  public static void setMockDatabaseAccess(DatabaseAccess mockDataAccess) {
  }

  public static ApplicationController getInstance()
  {
    if (instance == null)
    {
      instance = new ApplicationController();
    }
    return instance;
  }
  public void addItemToGroceryList(Item item)
  {
    this.databaseAccess.addItemToGroceryList(item);
  }

  public void addItemToStorageList(Item item) {
    this.databaseAccess.addItemToStorageList(item);
  }

  public void deleteItemFromGroceryList(int index) {
  }

  public void deleteItemFromStorageList(int index) {
  }

  public Item getItemFromGroceryList(int i) {
    return null;
  }

  public Item getItemFromStorageList(int i) {
    return null;
  }
  public Item getItemFromGroceryList(String name){
    return null;
  }
  public Item getItemFromStorageList(String name){
    return null;
  }

  public void editItemOnGroceryList(int i, Item item) {
  }

  public void editItemOnStorageList(int i, Item item) {
  }

  public void transferItemFromGroceryToStorageList(int i) {
  }

  public void transferItemFromStorageToGroceryList(int i) {
  }
}
