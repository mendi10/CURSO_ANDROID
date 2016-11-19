package com.example.a62.fragment_application;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by 62 on 19/11/2016.
 */

public class MainFragment extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment,container,false);
        Button button = (Button)view.findViewById(R.id.button);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button:
                ((MainActivity)getActivity()).replaceFrament(BlankFragment.newInstance());
                break;
            default:
                break;
        }
    }
}
