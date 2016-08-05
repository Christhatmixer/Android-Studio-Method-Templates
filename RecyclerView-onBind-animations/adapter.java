

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by cfarl_000 on 7/29/2016.
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    private ArrayList<Person> dataPerson;
    private int lastPosition = -1;
    private final static int FADE_DURATION = 1000;



    public class PersonViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        private ImageButton email;
        private ImageButton phone;
        private ImageView logo;
        private TextView company;
        private CardView Card;




        public PersonViewHolder(View itemView){
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.person_name);
            email = (ImageButton) itemView.findViewById(R.id.emailButton);
            phone = (ImageButton)itemView.findViewById(R.id.phoneButton);
            logo = (ImageView)itemView.findViewById(R.id.logo_imageView);
            company = (TextView)itemView.findViewById(R.id.company);
            Card = (CardView)itemView.findViewById(R.id.person1_card);


        }
    }
    public PersonAdapter(ArrayList<Person> dataPerson) {
        this.dataPerson = dataPerson;
    }




    @Override
    public PersonAdapter.PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.person_row,parent,false);
        PersonViewHolder viewHolder = new PersonViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(PersonAdapter.PersonViewHolder holder, final int position) {
        final TextView name = holder.name;
        final ImageButton email = holder.email;
        final ImageButton phone = holder.phone;
        final ImageView logo = holder.logo;
        final TextView company = holder.company;
        final CardView Card = holder.Card;
        final Animation shrink = AnimationUtils.loadAnimation(holder.Card.getContext(), R.anim.shrink);
       
        setFadeAnimation(holder.itemView);




    }
    
    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(FADE_DURATION);
        view.startAnimation(anim);
    }
    private void setScaleAnimation(View view, int position) {
        if (position > lastPosition) {
            ScaleAnimation anim = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
            anim.setDuration(FADE_DURATION);
            view.startAnimation(anim);
            lastPosition = position;
    }}



    @Override
    public int getItemCount() {
        return dataPerson.size();
    }

}
