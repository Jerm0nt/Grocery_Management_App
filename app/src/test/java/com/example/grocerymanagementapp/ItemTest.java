package com.example.grocerymanagementapp;

import com.example.grocerymanagementapp.models.Category;
import com.example.grocerymanagementapp.models.Item;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class ItemTest {
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
  }

  /**
   * Tests Item-constructor with no attributes
   * name, category, amount should be default
   */
  @Test
  public void constructorTest1(){
    Item test = new Item();
    assertTrue(test.getName().equals(test.getDEFAULT_NAME())
      && test.getAmount() == test.getDEFAULT_AMOUNT()
      && test.getCategory() == Category.DEFAULT);
  }

  /**
   * Tests Item-constructor with name attribute set
   * Category, price & amount should be default, price null
   */
  @Test
  public void constructorTest2(){
    Item test = new Item(BIRNE);
    assertTrue(test.getName().equals(BIRNE)&& test.getAmount() == test.getDEFAULT_AMOUNT()
      && test.getCategory() == Category.DEFAULT);
  }

  /**
   * Tests item-constructor wth name & category set
   * Amount should be default, price 0.0
   */
  @Test
  public void constructorTest3(){
    Item test = new Item(BIRNE, Category.FRUIT);
    assertTrue(test.getName().equals(BIRNE) &&
      test.getPrice()== (float) 0.0 &&
      test.getAmount()==test.getDEFAULT_AMOUNT() &&
      test.getCategory()==Category.FRUIT);
  }
  /**
   * Tests item-constructor with name, category, price & amount set
   */
  @Test
  public void constructorTest4(){
    Item test = new Item(BIRNE,Category.FRUIT,(float)0.79,2);
    assertTrue(test.getName().equals(BIRNE) &&
      test.getPrice()== (float) 0.79 &&
      test.getAmount()==2 &&
      test.getCategory()==Category.FRUIT);
  }
  /**
   * Runs getDEFAULT_AMOUNT-method, returned value should be int
   */
  @Test
  public void getDEFAULT_AMOUNTTest1(){
    int test = Item.getDEFAULT_AMOUNT();
  }
  /**
   * Runs getDEFAULT_NAME-method, returned value should be String
   */
  @Test public void getDEFAULT_NAMETest1(){
    String test = Item.getDEFAULT_NAME();
  }
  /**
   * Expects 1 as DEFAULT_NAME & "Name" as DEFAULT_NAME
   */
  @Test public void DEFAULTSettingTest1(){
    assertTrue(Item.getDEFAULT_NAME().equals("Name") &&
      Item.getDEFAULT_AMOUNT()==1);
  }
  /**
   * Tests getName-method call on correct result
   */
  @Test
  public void getNameTest1(){
    assertTrue(testItem1.getName().equals(APFEL) &&
      testItem2.getName().equals(SKYR) &&
      testItem3.getName().equals(STEAK));
  }

  /**
   * Calls setName-method without exception been thrown, tests with BIRNE
   */
  @Test
  public void setNameTest1(){
    testItem1.setName(BIRNE);
  }

  /**
   * Calls setName-Method & tests correct result with getName-method
   */
  @Test
  public void setNameTest2(){
    assertTrue(testItem1.getName().equals(APFEL));
    testItem1.setName(BIRNE);
    assertTrue(testItem1.getName().equals(BIRNE));
  }

  /**
   * Tests getCategory-method call on correct result
   */
  @Test
  public void getCategoryTest1(){
    assertTrue(testItem1.getCategory().equals(Category.FRUIT) &&
      testItem2.getCategory().equals(Category.MILK) &&
      testItem3.getCategory().equals(Category.MEAT));
  }

  /**
   * Calls setCategory-method without exception been thrown, tests with VEGETABLE
   */
  @Test
  public void setCategoryTest1(){
    testItem1.setCategory(Category.FRUIT);
  }

  /**
   * Calls setCategory-Method & tests correct result with getCategory-method
   */
  @Test
  public void setCategoryTest2(){
    assertTrue(testItem1.getCategory().equals(Category.FRUIT));
    testItem1.setCategory(Category.VEGETABLE);
    assertTrue(testItem1.getCategory().equals(Category.VEGETABLE));
  }
  /**
   * Tests getPrice-method call on correct result
   */
  @Test
  public void getPriceTest1(){
    assertTrue(testItem1.getPrice().equals((float)0.49) &&
      testItem2.getPrice().equals((float)0.99) &&
      testItem3.getPrice().equals((float)7.40));
  }

  /**
   * Calls setPrice-method without exception been thrown, tests with 1.20
   */
  @Test
  public void setPriceTest1(){
    testItem1.setPrice((float)1.20);
  }

  /**
   * Calls setPrice-Method & tests correct result with getPrice-method
   */
  @Test
  public void setPriceTest2(){
    assertTrue(testItem1.getPrice()==(float)0.49);
    testItem1.setPrice((float)5.00);
    assertTrue(testItem1.getPrice()==(float)5.00);
  }

  /**
   * Tests getAmount-method call on correct result
   */
  @Test
  public void getAmountTest1(){
    assertTrue(testItem1.getAmount()==1 &&
      testItem2.getAmount()==1 &&
      testItem3.getAmount()==1);
  }

  /**
   * Calls setAmount-method without exception been thrown, tests with 5
   */
  @Test
  public void setAmountTest1(){
    testItem1.setAmount(5);
  }

  /**
   * Calls setAmount-Method & tests correct result with getAmount-method
   */
  @Test
  public void setAmountTest2(){
    assertTrue(testItem1.getAmount()==1);
    testItem1.setAmount(5);
    assertTrue(testItem1.getAmount()==5);
  }
}
