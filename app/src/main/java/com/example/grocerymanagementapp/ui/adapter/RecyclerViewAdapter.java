package com.example.grocerymanagementapp.ui.adapter;


import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grocerymanagementapp.R;
import com.example.grocerymanagementapp.models.Item;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {
  private ArrayList<Item> itemArrayList;
  private Context context;
  private int ressource;
  private OnItemClickListener onItemClickListener;
  private RecyclerItemButtonClickListener recyclerItemButtonClickListener;

  public RecyclerViewAdapter(Context context, ArrayList<Item> itemFiles, int ressource) {
    this.ressource = ressource;
    this.itemArrayList = itemFiles;
    this.context = context;
  }

  @NonNull
  @Override
  public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
    View view = LayoutInflater.from(parent.getContext()).inflate(ressource, parent, false);
    return new RecyclerViewAdapter.ItemViewHolder(view, this.onItemClickListener);
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerViewAdapter.ItemViewHolder itemViewHolder, final int position) {
    Item currentItem = this.itemArrayList.get(position);
    ItemViewHolder.nameTextView.setText(currentItem.getName());
    ItemViewHolder.deleteButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        recyclerItemButtonClickListener.onButtonClick(position);
      }
    });
  }

  public void setOnButtonClickListener(RecyclerItemButtonClickListener recyclerItemButtonClickListener){
    this.recyclerItemButtonClickListener = recyclerItemButtonClickListener;
  }

  @Override
  public int getItemCount() {
    return itemArrayList.size();
  }

  public Item getFile(int position) {
    return this.itemArrayList.get(position);
  }

  public void setOnItemClickListener(RecyclerViewAdapter.OnItemClickListener listener) {
    this.onItemClickListener = listener;
  }


  public interface OnItemClickListener {
    void onItemClick(int position);
  }


  protected static class ItemViewHolder extends RecyclerView.ViewHolder {

    public static TextView nameTextView;
    public static Button deleteButton;


    public ItemViewHolder(@NonNull View itemView, final RecyclerViewAdapter.OnItemClickListener listener) {
      super(itemView);
      nameTextView = itemView.findViewById(R.id.item_name_tv);
      deleteButton = itemView.findViewById(R.id.delete_button);


      itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if (listener != null) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
              listener.onItemClick(position);
            }
          }
        }
      });

    }
  }


}
