package com.ca.mvp.sample.catimeline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    ArrayList<Model> list;
    @BindView(R.id.rv_list)
    RecyclerView rvList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        list=new ArrayList<>();

        Model model1=new Model("Order Placed","Order successfully placed",true);
        Model model2=new Model("Order Ready","Order successfully Ready",true);
        Model model3=new Model("Order Dispatch","Order successfully Dispatch",true);
        Model model4=new Model("Order Deliver","Order successfully Deliver",false);
        list.add(model1);
        list.add(model2);
        list.add(model3);
        list.add(model4);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rvList.setLayoutManager(layoutManager);
        rvList.setAdapter(new Adapter(this,list));
    }
}
