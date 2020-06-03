package com.example.grocerymanagementapp.ui.grocery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grocerymanagementapp.R;
import com.example.grocerymanagementapp.models.Item;
import com.example.grocerymanagementapp.ui.adapter.RecyclerItemButtonClickListener;
import com.example.grocerymanagementapp.ui.adapter.RecyclerViewAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class GroceryFragment extends Fragment {

    private GroceryViewModel groceryViewModel;
    private View view;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
      view = inflater.inflate(R.layout.fragment_grocery, container, false);
      return view;

        /*dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_grocery, container, false);
        final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;*/
    }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

  private void setupAddFab(){
    FloatingActionButton addFab = view.findViewById(R.id.add_fab);
    addFab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //MockAdd
        Toast.makeText(getActivity(), "Download Finished", Toast.LENGTH_SHORT).show();
      }
    });
  }

  private void setupRecyclerView(){
    RecyclerView recyclerView = view.findViewById(R.id.grocery_rv);

    //Mockliste
    ArrayList<Item> itemList = new ArrayList<Item>();
    itemList.add(new Item("Kartoffel"));
    itemList.add(new Item("Kartoffel"));
    itemList.add(new Item("Kartoffel"));

    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
    RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getActivity(),itemList,R.layout.recycler_item);
    recyclerViewAdapter.setOnButtonClickListener(new RecyclerItemButtonClickListener() {
      @Override
      public void onButtonClick(int position) {
        Toast.makeText(getActivity(), "Download Finished", Toast.LENGTH_SHORT).show();
      }
    });
    recyclerView.setAdapter(recyclerViewAdapter);
    recyclerView.setLayoutManager(layoutManager);

  }
}
