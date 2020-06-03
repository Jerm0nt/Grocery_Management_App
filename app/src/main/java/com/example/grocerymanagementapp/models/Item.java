package com.example.grocerymanagementapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Item class
 * Default name: "Name"
 * Default category: "Food"
 * Default amount: "1"
 */
public class Item<Memento> implements Comparable<Item>, Cloneable, Serializable,
  Parcelable, com.example.grocerymanagementapp.models.Memento {
  /**
   * Item-name
   */
  private String name;

  /**
   * Item-category
   */
  private Category category = Category.DEFAULT;

  /**
   * Item-price
   */
  private Float price;
  /**
   * Default-Amount Value
   */
  private final static int DEFAULT_AMOUNT = 1;
  /**
   * Item-amount
   */
  private int amount = DEFAULT_AMOUNT;

  /**
   * Default-Name
   */
  private final static String DEFAULT_NAME = "Name";

  /**
   * Item-constructor
   */
  public Item() {
    this.name = DEFAULT_NAME;
  }

  /**
   * Item-constructor
   *
   * @param name sets Item-name
   */
  public Item(String name) {
    this.name = name;
  }

  /**
   * Item-constructor
   *
   * @param name     sets item-name
   * @param category sets item-category
   */
  public Item(String name, Category category) {
    this.name = name;
    this.category = category;
  }

  /**
   * Item-constructor
   *
   * @param name     sets item-name
   * @param category sets item-category
   * @param price    sets item-price
   */
  public Item(String name, Category category, Float price, int amount) {
    this.name = name;
    this.category = category;
    this.price = price;
    this.amount = amount;
  }

  protected Item(Parcel in) {
    name = in.readString();
    if (in.readByte() == 0) {
      price = null;
    } else {
      price = in.readFloat();
    }
    amount = in.readInt();
  }

  public static final Creator<Item> CREATOR = new Creator<Item>() {
    @Override
    public Item createFromParcel(Parcel in) {
      return new Item(in);
    }

    @Override
    public Item[] newArray(int size) {
      return new Item[size];
    }
  };

  /**
   * @return default amount
   */
  public static int getDEFAULT_AMOUNT() {
    return DEFAULT_AMOUNT;
  }

  /**
   * @return default name
   */
  public static String getDEFAULT_NAME() {
    return DEFAULT_NAME;
  }

  /**
   * Item-name-getter
   *
   * @return name of requested item
   */
  public String getName() {
    return this.name;
  }

  /**
   * Item-name-setter
   *
   * @param name sets item-name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Item-category-getter
   *
   * @return category of requested item
   */
  public Category getCategory() {
    return category;
  }

  /**
   * Item-category-setter
   *
   * @param category sets item-category
   */
  public void setCategory(Category category) {
    this.category = category;
  }

  /**
   * Item-price-getter
   *
   * @return price of requested item
   */
  public Float getPrice() {
    return price;
  }

  /**
   * Item-price-setter
   *
   * @param price sets item-price
   */
  public void setPrice(Float price) {
    this.price = price;
  }

  /**
   * Item-amount-getter
   *
   * @return amount of requested item
   */
  public int getAmount() {
    return amount;
  }

  /**
   * Item-amount-setter
   *
   * @param amount sets item-amount
   */
  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Override
  public int compareTo(Item other) {
    if (this.getName().compareTo(other.getName()) < 0) {
      return 1;
    }
    if (this.getName().compareTo(other.getName()) > 0) {
      return -1;
    }
    return 0;
  }

  /**
   * clones item
   *
   * @return cloned item
   */
  @Override
  public Item clone() {
    Item clone = null;
    try {
      clone = (Item) super.clone();
    } catch (CloneNotSupportedException e) {
      //Should not occur
    }
    return clone;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(name);
    if (price == null) {
      dest.writeByte((byte) 0);
    } else {
      dest.writeByte((byte) 1);
      dest.writeFloat(price);
    }
    dest.writeInt(amount);
  }
}
