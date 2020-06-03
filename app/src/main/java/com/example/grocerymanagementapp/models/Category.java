package com.example.grocerymanagementapp.models;

public enum Category {
  DEFAULT("Food"),
  FRUIT("Fruit/fruit products"),
  VEGETABLE("Vegetables and legumes"),
  NUTS("Nuts and seeds"),
  MILK("Milk and dairy products"),
  MEAT("Meat and meat products"),
  CEREALS("Cereals and cereal products"),
  FISH("Fish and fish products"),
  POTATOS("Potatoes and potato products");

  private String name;

  Category(String catName) {
    this.name = catName;
  }

  public String getName() {
    return name;
  }
}
