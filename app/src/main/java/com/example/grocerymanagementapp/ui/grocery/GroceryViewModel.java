package com.example.grocerymanagementapp.ui.grocery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GroceryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GroceryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
