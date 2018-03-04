package com.example.carson_ho.toptabbar;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by pclx on 2018/3/1.
 */

public class Fragment01 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInsranceState){
        View view = inflater.inflate(R.layout.fragment01, container,false);
        return view;
    }

}
