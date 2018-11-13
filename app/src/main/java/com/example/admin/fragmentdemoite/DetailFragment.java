package com.example.admin.fragmentdemoite;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.fragmentdemoite.callback.OnItemClickCallback;


public class DetailFragment extends Fragment {

    static DetailFragment fragment;
    String data;
    TextView textView;
    public void setData(String data){
        this.data=data;
    }

    public  static DetailFragment newInstance(){
        if(fragment==null)
            fragment=new DetailFragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_detail_layout,container,false);
        textView=view.findViewById(R.id.result);
        return view;
    }


    
    //bind data
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textView.setText(data);
    }
}
