package com.example.grocerymanagementapp;

import com.example.grocerymanagementapp.controller.ApplicationController;
import com.example.grocerymanagementapp.database.DatabaseAccess;
import com.example.grocerymanagementapp.database.GroceryList;
import com.example.grocerymanagementapp.database.ItemList;
import com.example.grocerymanagementapp.database.StorageList;
import com.example.grocerymanagementapp.models.Category;
import com.example.grocerymanagementapp.models.Item;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.mockito.Mockito.times;

public class DatabaseAccessTest {
  DatabaseAccess databaseAccess;

  private GroceryList groceryListMock = Mockito.mock(GroceryList.class);
  private StorageList storageListMock = Mockito.mock(StorageList.class);

  private Item testItem1;
  private Item testItem2;
  private Item testItem3;

  private final String APFEL = "Apfel";
  private final String SKYR = "Skyr";
  private final String STEAK = "Rinderhueftsteak";
  private final String BIRNE = "Birne";

  private ArrayList<Item> itemArrayListMock = new ArrayList<>();

  @Before
  public void testSetUp() throws Exception{
    testItem1 = new Item(APFEL, Category.FRUIT, (float) 0.49, 1);
    testItem2 = new Item(SKYR, Category.MILK, (float) 0.99,1);
    testItem3 = new Item( STEAK, Category.MEAT, (float) 7.40,1);

    itemArrayListMock.add(testItem1);
    itemArrayListMock.add(testItem2);
    itemArrayListMock.add(testItem3);

    databaseAccess = new DatabaseAccess(itemArrayListMock);

  }

  @Test
  public void addItemToGroceryListTest1()
  {
    databaseAccess.addItemToGroceryList(testItem1);
    Mockito.verify(groceryListMock).addItemIntelligent(testItem1);
  }

  @Test
  public void addItemToStorageListTest1()
  {
    databaseAccess.addItemToStorageList(testItem1);
    Mockito.verify(storageListMock).addItemIntelligent(testItem1);
  }

  @Test
  public void removeItemFromGroceryListTest1()
  {
    int index = 6;
    databaseAccess.deleteItemFromGroceryList(index);
    Mockito.verify(groceryListMock).deleteItem(Mockito.anyInt());
  }

  @Test
  public void removeItemFromGroceryListTest2() {
    databaseAccess.deleteItemFromGroceryList(1);
    databaseAccess.deleteItemFromGroceryList(2);
    databaseAccess.deleteItemFromGroceryList(3);
  }

  @Test
  public void removeItemFromStorageListTest1()
  {
    int index = 6;
    databaseAccess.deleteItemFromStorageList(index);
    Mockito.verify(storageListMock).deleteItem(Mockito.anyInt());
  }

  @Test
  public void removeItemFromStorageListTest2()
  {
    databaseAccess.deleteItemFromStorageList(1);
    databaseAccess.deleteItemFromStorageList(2);
    databaseAccess.deleteItemFromStorageList(3);
    Mockito.verify(storageListMock, times(3)).deleteItem(Mockito.anyInt());
  }
}
