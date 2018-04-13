package com.example.shree.myapplication5;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by comp on 10-03-2018.
 */

public class ModuleAdapter extends RecyclerView.Adapter<ModuleAdapter.MyViewHolder> {
    private Context mContext;
    private List<Fetch_scheme> data;
    private int cid;


    public ModuleAdapter(Context mContext, List<Fetch_scheme> list, int cid) {
        this.mContext = mContext;
        this.data = list;
        this.cid = cid;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        ImageView forwomen,isnew;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.SchemeName);
            isnew= itemView.findViewById(R.id.isnew);
            forwomen=itemView.findViewById(R.id.forwomen);

        }
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holder, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ModuleAdapter.MyViewHolder holder, final int position) {

        final Fetch_scheme fetch_scheme = data.get(position);
        holder.title.setText(fetch_scheme.getTitle());
        if(data.get(position).getIsnew()==1)
            holder.isnew.setImageResource(R.drawable.newscheme);
        if(data.get(position).getForwomen()==1)
            holder.forwomen.setImageResource(R.drawable.women);
        else
            holder.forwomen.setImageResource(R.drawable.child1);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print("catid:::" + data.get(position).getCatid());
                System.out.print("sid:::" + data.get(position).getSid());

//                int pos = data.get(position).getTransaction_id();
                String module_title = String.valueOf(data.get(position).getTitle());
                Intent current_module = new Intent(mContext, SchemeDetails.class);
                current_module.putExtra("module_title", module_title);
                current_module.putExtra("cid", data.get(position).getCatid());
                current_module.putExtra("sid", data.get(position).getSid());
                current_module.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(current_module);
                Log.d("Module Title", module_title);

            }
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }


}
