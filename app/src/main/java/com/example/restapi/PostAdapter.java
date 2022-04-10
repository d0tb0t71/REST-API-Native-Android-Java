package com.example.restapi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<PostPojo> dataList;
    private Context context;

    public PostAdapter(List<PostPojo> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.post_row_design,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.postTitle.setText(dataList.get(position).getTitle());
        holder.postBody.setText(dataList.get(position).getBody());

    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView postTitle,postBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            postTitle = itemView.findViewById(R.id.postTitle);
            postBody = itemView.findViewById(R.id.postBody);


        }
    }

}
