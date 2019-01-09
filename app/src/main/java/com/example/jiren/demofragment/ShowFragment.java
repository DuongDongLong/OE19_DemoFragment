package com.example.jiren.demofragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ShowFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;
    public ShowFragment() {
        // Required empty public constructor
    }
    public static ShowFragment newInstance(String param1) {
        ShowFragment fragment = new ShowFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show, container, false);
        TextView tvContent = (TextView) view.findViewById(R.id.tvShow);
        if (!TextUtils.isEmpty(mParam1)) {
            tvContent.setText(mParam1);
        }
        return view;
    }
}
