package com.example.admin.fragmentdemoite;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.admin.fragmentdemoite.callback.OnItemClickCallback;

public class MainActivity extends AppCompatActivity
implements OnItemClickCallback {
    ListView listView;
    static final String LIST_FRAGMENT_TAG="LIST_FRAGMENT";
    static final String DETAIL_FRAGMENT_TAG="DETAIL_FRAGMENT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add fragment to activity
        addFragment(null);

    }

    private void addFragment(Fragment fragment){
        FragmentTransaction t=getSupportFragmentManager().beginTransaction();
        ListFragment listFragment=ListFragment.newInstance();
        listFragment.setData("my data");
        t.replace(R.id.container,listFragment,LIST_FRAGMENT_TAG);
        t.commit();
    }

    /*private void replaceFragment(Fragment fragment,String tag){
        FragmentTransaction t=getSupportFragmentManager().beginTransaction();
        t.replace(R.id.container,listFragment,tag);
        t.commit();
    }*/

    @Override
    public void onGetItem(String s) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
        //replace fragment
        DetailFragment  detailFragment=DetailFragment.newInstance();
        //set data
        detailFragment.setData(s);
        FragmentTransaction t=getSupportFragmentManager().beginTransaction();
        t.replace(R.id.container,detailFragment,DETAIL_FRAGMENT_TAG);
        t.addToBackStack(null);
        t.commit();
    }
}
