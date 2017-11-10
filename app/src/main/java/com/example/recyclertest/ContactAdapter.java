package com.example.recyclertest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * @version $Rev$
 * @anthor Administrator
 * @dsc ${TOOD}
 * @updateAuthor $Author
 * @updateDsc ${TOOD}
 */
public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {


    private List<Contact> mContacts;

    private Context mContext;

    public ContactAdapter(Context context , List<Contact> contacts){
        this.mContacts = contacts;
        this.mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
         TextView message;
         TextView name;
         TextView time;
         ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            message = (TextView) itemView.findViewById(R.id.contact_message);
            name = (TextView) itemView.findViewById(R.id.contact_name);
            time = (TextView)itemView.findViewById(R.id.message_time);
            image = (ImageView) itemView.findViewById(R.id.contact_image);
        }
    }


    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.contact_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        holder.message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(mContext,MainActivity.class);
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ContactAdapter.ViewHolder holder, int position) {
        Contact contact = mContacts.get(position);
        holder.time.setText(contact.getTime());
        holder.name.setText(contact.getName());
        holder.message.setText(contact.getMessage());
        Glide.with(mContext).load(contact.getImageID()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }


}
