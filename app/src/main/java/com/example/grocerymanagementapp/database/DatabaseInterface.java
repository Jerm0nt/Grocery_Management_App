package com.example.grocerymanagementapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseInterface<DatabaseNaming> extends SQLiteOpenHelper implements com.example.grocerymanagementapp.database.DatabaseNaming {

  /**
   * Log tag
   */
  private final String TAG = this.getClass().getSimpleName();
  private Context context;

  /**
   * Database interface constructor
   *
   * @param context sets context
   */
  public DatabaseInterface(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
    this.context = context;
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    String createGroceryTable = CREATE_TABLE + TABLE_GROCERY + " (" + COLUMN_GROCERY_ID +
      " INTEGER PRIMARY KEY, " +
      COLUMN_GROCERY_NAME + " TEXT NOT NULL, " +
      COLUMN_GROCERY_CATEGORY + " TEXT, " +
      COLUMN_GROCERY_AMOUNT + " INTEGER, " +
      COLUMN_GROCERY_PRICE + " FLOAT );";
    String createStorageTable = CREATE_TABLE + TABLE_STORAGE + " (" + COLUMN_STORAGE_ID +
      " INTEGER PRIMARY KEY, " +
      COLUMN_STORAGE_NAME + " TEXT NOT NULL, " +
      COLUMN_STORAGE_CATEGORY + " TEXT, " +
      COLUMN_STORAGE_AMOUNT + " INTEGER, " +
      COLUMN_STORAGE_PRICE + "FLOAT );";
    db.execSQL(createGroceryTable);
    db.execSQL(createStorageTable);

  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    db.execSQL(DROP_TABLE + TABLE_GROCERY);
    db.execSQL(DROP_TABLE + TABLE_STORAGE);

  }
}
