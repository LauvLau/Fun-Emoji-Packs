package com.example.funemojipacks.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.funemojipacks.R;

public class home_hottest extends Fragment {
    private Context context;
    private GridView gridView;
    private View view;

    public home_hottest() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_hottest, container, false);
        initView();
        return view;
//        return inflater.inflate(R.layout.fragment_home_hottest,container,false);
    }

    private void initView() {
        final int[] faces = {R.drawable.make1, R.drawable.make2, R.drawable.make3,
                R.drawable.make4, R.drawable.make5};
        gridView=(GridView) view.findViewById(R.id.home_hottest_grid);
        gridView.setAdapter(new HomeImageAdapter(getActivity(),faces));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(),Browse.class);
                Bundle bundle=new Bundle();
                bundle.putInt("image",faces[position]);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
