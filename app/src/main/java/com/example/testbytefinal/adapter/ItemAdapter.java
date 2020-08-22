package com.example.testbytefinal.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testbytefinal.R;
import com.example.testbytefinal.model.Acount;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemAdapterHolder> {
    private List<Acount> list;

    public ItemAdapter(List<Acount> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ItemAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent,false);
        return new ItemAdapterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemAdapterHolder holder, int position) {
        Acount acount = list.get(position);
        holder.name.setText(acount.getName());
        holder.datet.setText(acount.getDate());
        holder.amount.setText(acount.getAmount());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setdata(List<Acount> items){
        this.list = items;
        notifyDataSetChanged();
    }
    public class ItemAdapterHolder extends RecyclerView.ViewHolder{
        private TextView name,datet,amount;
        public ItemAdapterHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.txname);
            datet = itemView.findViewById(R.id.txdate);
            amount = itemView.findViewById(R.id.txamount);
        }
    }
}
