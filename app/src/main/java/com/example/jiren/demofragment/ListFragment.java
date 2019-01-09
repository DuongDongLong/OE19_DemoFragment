package com.example.jiren.demofragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private ListView mListView;
    private ListItemAdapter mListItemAdapter;
    List<ItemObject> data;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_list, container, false);
        mListView = view.findViewById(R.id.lvItem);
        data= new ArrayList<>();
        data.add(new ItemObject("HINH 1"));
        data.add(new ItemObject("HINH 2"));
        data.add(new ItemObject("HINH 3"));
        data.add(new ItemObject("HINH 4"));
        data.add(new ItemObject("HINH 5"));
        data.add(new ItemObject("HINH 6"));
        mListItemAdapter=new ListItemAdapter(R.layout.item_list, getActivity(),data);
        mListView.setAdapter(mListItemAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mListener.onFragmentInteraction(data.get(position).getString());
            }
        });

        return view;
    }
    // TODO: Rename method, update argument and hook method into UI event
  /*  public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }*/
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String value1);
    }
}
