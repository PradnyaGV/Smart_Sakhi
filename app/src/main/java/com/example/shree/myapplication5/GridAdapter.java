package com.example.shree.myapplication5;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    private String[] data;
    Context mContext;
    private int grid_images[];

    public GridAdapter(Context mContext, String[] data, int img[]) {
        this.mContext = mContext;
        this.data = data;
        this.grid_images = img;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.singlegrid, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, final int position) {
        String title = data[position];
        holder.textView.setText(title);
        holder.iconimg.setImageResource(grid_images[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                int pos = safetyModuleList.get(position).getTransaction_id();
                String module_title = data[position];
                if (module_title == "Request") {

                    Intent current_module = new Intent(mContext, HealthSchemes.class);
                    current_module.putExtra("module_title", module_title); // Pass Title
                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    current_module.putExtra("cid", position); // Pass Id
//                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(current_module);
                    Log.d("Module Title", module_title);
                }

                if (module_title == "Health") {
                    Intent current_module = new Intent(mContext, HealthSchemes.class);
                    current_module.putExtra("module_title", module_title); // Pass Title
                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    current_module.putExtra("cid", position); // Pass Id
//                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(current_module);
                    Log.d("Module Title", module_title);
                }

                if (module_title == "Education") {
                    Intent current_module = new Intent(mContext, HealthSchemes.class);
                    current_module.putExtra("module_title", module_title); // Pass Title
                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    current_module.putExtra("cid", position); // Pass Id
//                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(current_module);
                    Log.d("Module Title", module_title);
                }

                if (module_title == "Employment") {
                    Intent current_module = new Intent(mContext, HealthSchemes.class);
                    current_module.putExtra("module_title", module_title); // Pass Title
                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    current_module.putExtra("cid", position); // Pass Id
//                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(current_module);
                    Log.d("Module Title", module_title);
                }

                if (module_title == "Safety") {
                    Intent current_module = new Intent(mContext, HealthSchemes.class);
                    current_module.putExtra("module_title", module_title); // Pass Title
                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    current_module.putExtra("cid", position); // Pass Id
//                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(current_module);
                    Log.d("Module Title", module_title);
                }

                if (module_title == "Welfare") {
                    Intent current_module = new Intent(mContext, HealthSchemes.class);
                    current_module.putExtra("module_title", module_title); // Pass Title
                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    current_module.putExtra("cid", position); // Pass Id
//                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(current_module);
                    Log.d("Module Title", module_title);
                }

                if (module_title == "Finance") {
                    Intent current_module = new Intent(mContext, HealthSchemes.class);
                    current_module.putExtra("module_title", module_title); // Pass Title
                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    current_module.putExtra("cid", position); // Pass Id
//                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(current_module);
                    Log.d("Module Title", module_title);
                }

                if (module_title == "Labour") {
                    Intent current_module = new Intent(mContext, HealthSchemes.class);
                    current_module.putExtra("module_title", module_title); // Pass Title
                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    current_module.putExtra("cid", position); // Pass Id
//                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(current_module);
                    Log.d("Module Title", module_title);
                }
                if (module_title == "Justice") {
                    Intent current_module = new Intent(mContext, HealthSchemes.class);
                    current_module.putExtra("module_title", module_title); // Pass Title
                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    current_module.putExtra("cid", position); // Pass Id
//                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(current_module);
                    Log.d("Module Title", module_title);
                }
                if (module_title == "Family") {
                    Intent current_module = new Intent(mContext, HealthSchemes.class);
                    current_module.putExtra("module_title", module_title); // Pass Title
                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    current_module.putExtra("cid", position); // Pass Id
//                    current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(current_module);
                    Log.d("Module Title", module_title);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return data.length;
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView iconimg;
        TextView textView;

        public GridViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.grid_text);
            iconimg = itemView.findViewById(R.id.grid_img);
        }


    }
}

