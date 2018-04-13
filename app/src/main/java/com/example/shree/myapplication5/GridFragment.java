package com.example.shree.myapplication5;

/**
 * Created by comp on 24-03-2018.
 */


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;




public class GridFragment extends Fragment {

    int[] images = {
            R.drawable.health,
            R.drawable.edu,
            R.drawable.emp,
            R.drawable.safety,
            R.drawable.wel,
            R.drawable.finance,
            R.drawable.labour,
            R.drawable.justice,
            R.drawable.family
    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.recycler, container, false);

        // ImageView imageView = rootview.findViewById(R.id.coverimage);
        RecyclerView recyclerView = rootview.findViewById(R.id.itemslist);
//        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        String[] items = {"Health", "Education", "Employment", "Safety", "Welfare", "Finance", "Labour", "Justice", "Family"};
        recyclerView.setAdapter(new GridAdapter(this.getActivity().getApplicationContext(), items, images));
        return rootview;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
