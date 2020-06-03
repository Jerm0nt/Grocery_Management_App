package com.example.grocerymanagementapp.database;

public interface DatabaseNaming {
  /**
   * database-name
   */
  String DATABASE_NAME = "groceryManagement.db";
  /**
   * database-version
   */
  int DATABASE_VERSION = 3;
  /**
   * grocery-table-name
   */
  String TABLE_GROCERY = "grocery_table";
  /**
   * unique id to identify grocery-article
   */
  String COLUMN_GROCERY_ID = "ID";//Primary Key
  /**
   * grocery table name (item) column
   */
  String COLUMN_GROCERY_NAME = "NAME";
  /**
   * grocery table amount (item) column
   */
  String COLUMN_GROCERY_AMOUNT = "AMOUNT";
  /**
   * grocery table category (item) column
   */
  String COLUMN_GROCERY_CATEGORY = "CATEGORY";
  /**
   * grocery table price (item) column
   */
  String COLUMN_GROCERY_PRICE = "PRICE";
  /**
   * storage-table-name
   */
  String TABLE_STORAGE = "storage_table";
  /**
   * unique id to identify storage-article
   */
  String COLUMN_STORAGE_ID = "ID";//Primary Key
  /**
   * storage table name (item) column
   */
  String COLUMN_STORAGE_NAME = "NAME";
  /**
   * storage table amount (item) column
   */
  String COLUMN_STORAGE_AMOUNT = "AMOUNT";
  /**
   * storage table category (item) column
   */
  String COLUMN_STORAGE_CATEGORY = "CATEGORY";
  /**
   * storage table price (item) column
   */
  String COLUMN_STORAGE_PRICE = "PRICE";
  /**
   * create table if not exist
   */
  String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS ";
  /**
   * drop table if exist
   */
  String DROP_TABLE = "DROP TABLE IF EXIST ";
}
