package com.tryoasnafi.mylistview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tryoasnafi.mylistview.R;
import com.tryoasnafi.mylistview.model.Hero;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class HeroAdapter extends BaseAdapter {
    private Context ctx;
    private ArrayList<Hero> heroes = new ArrayList<>();

    // Constructor Context
    public HeroAdapter(Context ctx) {
        this.ctx = ctx;
    }

    // Setter arraylist
    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public int getCount() {
        return heroes.size();
    }

    @Override
    public Object getItem(int position) {
        return heroes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(ctx).inflate(R.layout.item_hero, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Hero hero = (Hero) getItem(position);
        viewHolder.bind(hero);
        return itemView;
    }

    private class ViewHolder {
        private CircleImageView imgHero;
        private TextView tvName;
        private TextView tvDescription;

        ViewHolder(View view) {
            imgHero = view.findViewById(R.id.img_hero);
            tvName = view.findViewById(R.id.tv_name);
            tvDescription = view.findViewById(R.id.tv_description);
        }

        void bind(Hero hero){
            tvName.setText(hero.getName());
            tvDescription.setText(hero.getDescription());
            imgHero.setImageResource(hero.getPhoto());
        }
    }
}
