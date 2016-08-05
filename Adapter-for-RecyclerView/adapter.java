package com.theelitelabel.quotes;

import android.app.Notification;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.fabric.sdk.android.Fabric;

/**
 * Created by cfarl_000 on 7/25/2016.
 */
public class QuoteAdapter extends RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>{
    private ArrayList<Quotes> dataQuotes;




    public class QuoteViewHolder extends RecyclerView.ViewHolder{


        private TextView quote;
        private TextView name;
        private ImageButton share;
        


        public QuoteViewHolder(View itemview){
            super(itemview);
            name = (TextView)itemview.findViewById(R.id.name);
            quote = (TextView)itemview.findViewById(R.id.quote);
            share = (ImageButton)itemview.findViewById(R.id.imageButton);
            Context context = itemView.getContext();
            //itemview.setOnClickListener(this);
            

        }

    }

    public QuoteAdapter(ArrayList<Quotes> dataQuotes) {
        this.dataQuotes = dataQuotes;
    }
    /*public void updateList(List<Quotes> quotes){
        mQuotes = quotes;
        notifyDataSetChanged();
    }*/

    @Override
    public QuoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.quote_row,parent,false);
        QuoteViewHolder viewHolder = new QuoteViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(QuoteViewHolder holder, final int position) {
        final TextView name = holder.name;
        final TextView quote = holder.quote;
        ImageButton share = holder.share;
        name.setText(dataQuotes.get(position).getName());
        quote.setText(dataQuotes.get(position).getQuote());
        


    }

    @Override
    public int getItemCount() {
        return dataQuotes.size();
    }
    public void addItem(int position,Quotes quote){
        dataQuotes.add(position,quote);
        notifyItemInserted(position);
    }
    public void removeItem(int position){
        dataQuotes.remove(position);
        notifyItemRemoved(position);
    }
}
