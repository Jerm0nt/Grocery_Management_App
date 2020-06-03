package com.example.grocerymanagementapp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.example.grocerymanagementapp.controller.ApplicationController;
import com.example.grocerymanagementapp.database.DatabaseAccess;
import com.example.grocerymanagementapp.models.Category;
import com.example.grocerymanagementapp.models.Item;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;

public class ApplicationControllerTest {

  private DatabaseAccess mockDatabaseAccess = Mockito.mock(DatabaseAccess.class);

  private ArrayList<Item> itemArrayList = new ArrayList<>();

  private Item testItem1;
  private Item testItem2;
  private Item testItem3;

  private final String APFEL = "Apfel";
  private final String SKYR = "Skyr";
  private final String STEAK = "Rinderhueftsteak";
  private final String BIRNE = "Birne";


  @Before
  public void testSetUp() throws Exception{
    testItem1 = new Item(APFEL, Category.FRUIT, (float) 0.49, 1);
    testItem2 = new Item(SKYR, Category.MILK, (float) 0.99,1);
    testItem3 = new Item( STEAK, Category.MEAT, (float) 7.40,1);

    itemArrayList.add(testItem1);
    itemArrayList.add(testItem2);
    itemArrayList.add(testItem3);

    ApplicationController.setMockDatabaseAccess(mockDatabaseAccess);
  }

  @Test
  public void addItemToGroceryListTest1()
  {

    ApplicationController.getInstance().addItemToGroceryList(testItem1);
    Mockito.verify(mockDatabaseAccess).addItemToGroceryList(testItem1);
  }

  @Test
  public void addItemToStorageListTest1()
  {

    ApplicationController.getInstance().addItemToStorageList(testItem1);
    Mockito.verify(mockDatabaseAccess).addItemToStorageList(testItem1);
  }

  @Test
  public void deleteItemFromGroceryListTest1()
  {
    int index = 42;
    ApplicationController.getInstance().deleteItemFromGroceryList(index);
    Mockito.verify(mockDatabaseAccess).deleteItemFromGroceryList(anyInt());
  }

  @Test
  public void deleteItemFromGroceryListTest2()
  {
    ApplicationController.getInstance().deleteItemFromGroceryList(1);
    ApplicationController.getInstance().deleteItemFromGroceryList(2);
    ApplicationController.getInstance().deleteItemFromGroceryList(3);
    Mockito.verify(mockDatabaseAccess, times(3))
      .deleteItemFromGroceryList(anyInt());
  }

  @Test
  public void deleteItemFromStorageListTest1()
  {
    int index = 42;
    ApplicationController.getInstance().deleteItemFromStorageList(index);
    Mockito.verify(mockDatabaseAccess).deleteItemFromStorageList(anyInt());
  }

  @Test
  public void deleteItemFromStorageListTest2()
  {
    ApplicationController.getInstance().deleteItemFromStorageList(1);
    ApplicationController.getInstance().deleteItemFromStorageList(2);
    ApplicationController.getInstance().deleteItemFromStorageList(3);
    Mockito.verify(mockDatabaseAccess, times(3))
      .deleteItemFromStorageList(anyInt());
  }

  @Test
  public void getItemFromGroceryListTest1()
  {
    ApplicationController.getInstance().getItemFromGroceryList(3);
    Mockito.verify(mockDatabaseAccess).getItemFromGroceryList(anyInt());
  }

  @Test
  public void getItemFromGroceryListTest2()
  {
    int index = 42;
    ApplicationController.getInstance().getItemFromGroceryList(index);
    Mockito.verify(mockDatabaseAccess).getItemFromGroceryList(index);
  }

  @Test
  public void getItemFromGroceryListTest3()
  {
    Mockito.when(mockDatabaseAccess.getItemFromGroceryList(1)).thenReturn(testItem2);
    Item result = ApplicationController.getInstance().getItemFromGroceryList(1);
    Mockito.verify(mockDatabaseAccess).getItemFromGroceryList(1);
    assertTrue(result.getName().equals(testItem2.getName()));
  }

  @Test
  public void getItemFromStorageListTest1()
  {
    ApplicationController.getInstance().getItemFromStorageList(3);
    Mockito.verify(mockDatabaseAccess).getItemFromStorageList(anyInt());
  }

  @Test
  public void getItemFromStorageListTest2()
  {
    int index = 42;
    ApplicationController.getInstance().getItemFromStorageList(index);
    Mockito.verify(mockDatabaseAccess).getItemFromStorageList(index);
  }

  @Test
  public void getItemFromStorageListTest3()
  {
    Mockito.when(mockDatabaseAccess.getItemFromGroceryList(1)).thenReturn(testItem2);
    Item result = ApplicationController.getInstance().getItemFromGroceryList(1);
    Mockito.verify(mockDatabaseAccess).getItemFromGroceryList(1);
    assertTrue(result.getName().equals(testItem2.getName()));
  }

  @Test
  public void getItemFromGroceryListNameTest1()
  {
    ApplicationController.getInstance().getItemFromGroceryList(APFEL);
    Mockito.verify(mockDatabaseAccess).getItemFromGroceryList(Mockito.anyString());
  }

  @Test
  public void getItemFromGroceryListNameTest2()
  {
    mockDatabaseAccess.getItemFromGroceryList(APFEL);
    Mockito.verify(mockDatabaseAccess).getItemFromGroceryList(APFEL);
  }

  @Test
  public void getItemFromStorageListNameTest1()
  {
    ApplicationController.getInstance().getItemFromStorageList(APFEL);
    Mockito.verify(mockDatabaseAccess).getItemFromStorageList(Mockito.anyString());
  }

  @Test
  public void getItemFromStorageListNameTest2()
  {
    mockDatabaseAccess.getItemFromStorageList(APFEL);
    Mockito.verify(mockDatabaseAccess).getItemFromStorageList(APFEL);
  }

  @Test
  public void editItemOnGroceryListTest1()
  {
    ApplicationController.getInstance().editItemOnGroceryList(1, testItem2);
    Mockito.verify(mockDatabaseAccess).editItemOnGroceryList(anyInt(),
        Mockito.any(testItem1.getClass()));
  }

  @Test
  public void editItemOnGroceryListTest2()
  {
    ApplicationController.getInstance().editItemOnGroceryList(2, testItem2);
    ApplicationController.getInstance().editItemOnGroceryList(2, testItem2);
    ApplicationController.getInstance().editItemOnGroceryList(2, testItem2);
    Mockito.verify(mockDatabaseAccess, times(3))
      .editItemOnGroceryList(anyInt(), Mockito.any(testItem1.getClass()));
  }
  @Test
  public void editItemOnStorageListTest1()
  {
    ApplicationController.getInstance().editItemOnStorageList(1, testItem2);
    Mockito.verify(mockDatabaseAccess).editItemOnStorageList(anyInt(),
      Mockito.any(testItem1.getClass()));
  }

  @Test
  public void editItemOnStorageListTest2()
  {
    ApplicationController.getInstance().editItemOnStorageList(2, testItem2);
    ApplicationController.getInstance().editItemOnStorageList(2, testItem2);
    ApplicationController.getInstance().editItemOnStorageList(2, testItem2);
    Mockito.verify(mockDatabaseAccess, times(3))
      .editItemOnStorageList(anyInt(), Mockito.any(testItem1.getClass()));
  }
  @Test
  public void transferItemFromGroceryToStorageListTest1()
  {
    ApplicationController.getInstance().transferItemFromGroceryToStorageList(3);
    Mockito.verify(mockDatabaseAccess).transferItemFromGroceryToStorageList(anyInt());
  }

  @Test
  public void transferItemFromStorageToGroceryListTest1()
  {
    ApplicationController.getInstance().transferItemFromStorageToGroceryList(3);
    Mockito.verify(mockDatabaseAccess).transferItemFromStorageToGroceryList(anyInt());
  }
}
