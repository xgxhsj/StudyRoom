package com.example.carson_ho.toptabbar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carson_Ho on 16/7/22.
 */
public class Fragment1 extends Fragment{
    MainActivity mainActivity;
    private Button login_b;
    private ListView listView;
    private LvTAdapter adapter;
    private List<ListviewT> dataList = new ArrayList<>();

    @Nullable
    @Override
  /*    protected void onCreat(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment1);
    }*/
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1,container,false);
        mainActivity = (MainActivity)getActivity();
        login_b = (Button)  view.findViewById(R.id.login_button);
        listView = (ListView) view.findViewById(R.id.list_view);
        initText();
        adapter = new LvTAdapter(getContext(), android.R.layout.simple_list_item_1,dataList);
        listView.setAdapter(adapter);


        login_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mainActivity,Login.class);
                startActivity(intent);
            }
        });
        return view;
    }
    private void initText(){
        //ListView的素材
        ListviewT lv1 = new ListviewT("一个人的成就不在于智商，而是在于自制力",R.drawable.sucai);
        dataList.add(lv1);
    }
   // @Override
  /*  public  void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
       // listView.setOnClickListener(new AdapterView.OnClickListener() {});
    }*/



  //  private void startActivity(Class<Login> loginClass) {}


}
