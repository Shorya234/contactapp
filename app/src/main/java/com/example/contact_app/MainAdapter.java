package com.example.contact_app;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

    public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
        Context activity;
        ArrayList<ContactModel> arrayList;
        public MainAdapter(Context activity,ArrayList<ContactModel> arrayList) {
            this.activity = activity;
            this.arrayList = arrayList;

        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_contact,parent,false);
            return new ViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            ContactModel model =arrayList.get(position);
            holder.tvName.setText(model.getName());
            holder.tvNumber.setText(model.getNumber());

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvName;
            TextView tvNumber;
            ImageButton messageButton;
            ImageButton callButton;


            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tvName=itemView.findViewById(R.id.textView3);
                tvNumber=itemView.findViewById(R.id.textView5);
                messageButton=itemView.findViewById(R.id.imageButton);
                callButton=itemView.findViewById(R.id.imageButton3);
                callButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" +arrayList.get(getAdapterPosition()).getNumber()));
                        activity.startActivity(intent);
                    }
                });
                messageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i=new Intent(Intent.ACTION_SENDTO,Uri.parse("smsto:" + arrayList.get(getAdapterPosition()).getNumber()));
                        activity.startActivity(i);
                    }
                });

            }
        }
    }

