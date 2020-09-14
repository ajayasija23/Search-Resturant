package com.asijaandroidsolution.searchresturants.activity.search.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.asijaandroidsolution.searchresturants.R;
import com.asijaandroidsolution.searchresturants.model.CollectionModel;
import com.bumptech.glide.Glide;

import java.util.List;

public class ResturantsAdapter extends RecyclerView.Adapter<ResturantsAdapter.MyViewHolder> {

    private Context mContext;
    private List<CollectionModel.RestaurantsBean> restaurantsList;

    public ResturantsAdapter(List<CollectionModel.RestaurantsBean> restaurants) {
        this.restaurantsList=restaurants;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        mContext=parent.getContext();
        View view= LayoutInflater.from(mContext).inflate(R.layout.adapter_resturant,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        String imageUrl=restaurantsList.get(position).getRestaurant().getFeaturedImage();
        Glide.with(mContext)
                .load(imageUrl)
                .placeholder(R.drawable.no_image)
                .into(holder.resImage);
        holder.resName.setText(restaurantsList.get(position).getRestaurant().getName());
        holder.resAddress.setText(restaurantsList.get(position).getRestaurant().getLocation().getAddress());
        holder.resContact.setText(restaurantsList.get(position).getRestaurant().getPhoneNumbers());

    }

    @Override
    public int getItemCount() {
        return restaurantsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView resImage;
        TextView resName,resAddress,resContact;
        public MyViewHolder(@NonNull View view) {
            super(view);
            resImage=view.findViewById(R.id.ivResImage);
            resName=view.findViewById(R.id.tvResName);
            resAddress=view.findViewById(R.id.tvAddress);
            resContact=view.findViewById(R.id.tvContact);
        }
    }
}