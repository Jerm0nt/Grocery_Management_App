package com.example.grocerymanagementapp.database;

import android.content.Context;

import com.example.grocerymanagementapp.controller.Observable;
import com.example.grocerymanagementapp.controller.Observer;
import com.example.grocerymanagementapp.models.Item;

import java.util.ArrayList;

/**
 * This Class provides access to models and their data.
 */
public class DatabaseAccess implements Observable {

  /**
   * Instance of this class (saved)
   */
  private static DatabaseAccess instance;
  private StorageList storageList;
  private GroceryList groceryList;
  private ArrayList<Observer> onGroceryListChangeListener;
  private ArrayList<Observer> onStorageListChangeListener;

  /**
   * Constructor
   */
  public DatabaseAccess(Context context){
    DatabaseInterface databaseInterface = new DatabaseInterface(context);
    onGroceryListChangeListener = new ArrayList<>();
    onStorageListChangeListener = new ArrayList<>();
  }

  /**
   * Mock-constructor to set Objects
   */
  public DatabaseAccess(StorageList storageListMock, GroceryList groceryListMock){
    storageList = storageListMock;
    groceryList = groceryListMock;

    onStorageListChangeListener = new ArrayList<>();
    onGroceryListChangeListener = new ArrayList<>();
  }

  /**
   * Mock-constructor to set databaseInterface
   */
  public DatabaseAccess(DatabaseInterface databaseInterfaceMock){
    storageList = new StorageList(databaseInterfaceMock);
    groceryList = new GroceryList(databaseInterfaceMock);

  }

  public DatabaseAccess(ArrayList<Item> itemArrayListMock) {

  }

  @Override
  public void onGroceryListChange() {

  }

  @Override
  public void onStorageListChange() {

  }

  public void addItemToGroceryList(Item item) {
  }

  public void addItemToStorageList(Item item) {
  }

  public void deleteItemFromGroceryList(int anyInt) {
  }

  public void deleteItemFromStorageList(int anyInt) {
  }

  public Item getItemFromGroceryList(int anyInt) {
    return null;
  }

  public Item getItemFromStorageList(int anyInt) {
    return null;
  }

  public Item getItemFromGroceryList(String anyString) {
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
