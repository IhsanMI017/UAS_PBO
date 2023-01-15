package id.ac.poliban.mi.ihsan.fdae020320017.adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.ac.poliban.mi.ihsan.fdae020320017.R;
import id.ac.poliban.mi.ihsan.fdae020320017.domain.CategoryDomain;

public class CategoryAdaptor extends RecyclerView.Adapter<CategoryAdaptor.ViewHolder>{
    ArrayList<CategoryDomain> categorys;

    public CategoryAdaptor(ArrayList<CategoryDomain> categorys) {
        this.categorys = categorys;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cat,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.categoryName.setText(categorys.get(position).getTittle());
    String picUrl="";
    switch (position){
        case 0:{
            picUrl="cat_1";
            holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background1));
        break;
        }
        case 1:{
            picUrl="cat_2";
            holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background2));
        break;
        }
        case 2:{
            picUrl="cat_3";
            holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background3));
        break;
        }
        case 3:{
            picUrl="cat_4";
            holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background4));
        break;
        }
        case 4:{
            picUrl="cat_5";
            holder.mainLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.cat_background5));
        break;
        }
        }
        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(picUrl, "drawable",
                holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.categoryPic);
    }

    @Override
    public int getItemCount() {
        return categorys.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView categoryName;
        ImageView categoryPic;
        ConstraintLayout mainLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName=itemView.findViewById(R.id.categoryName);
            categoryPic=itemView.findViewById(R.id.categoryPic);
            mainLayout=itemView.findViewById(R.id.mainLayout);
        }
    }
}
