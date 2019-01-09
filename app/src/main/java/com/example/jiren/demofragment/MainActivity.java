package com.example.jiren.demofragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements ListFragment.OnFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListFragment firstFragment = new ListFragment();
        if (findViewById(R.id.frameLayout) != null) {
            if (savedInstanceState != null) {
                getSupportFragmentManager().executePendingTransactions();
                Fragment fragmentById =
                        getSupportFragmentManager().findFragmentById(R.id.frameLayout);
                if (fragmentById != null) {
                    getSupportFragmentManager().beginTransaction().remove(fragmentById).commit();
                }
            }
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frameLayout, firstFragment)
                    .commit();
        } else {
            if (savedInstanceState != null) {
                getSupportFragmentManager().executePendingTransactions();
                Fragment firstFragmentById =
                        getSupportFragmentManager().findFragmentById(R.id.firstFram);
                if (firstFragmentById != null) {
                    getSupportFragmentManager().beginTransaction()
                            .remove(firstFragmentById)
                            .commit();
                }
                Fragment secondFragmentById =
                        getSupportFragmentManager().findFragmentById(R.id.secondFram);
                if (secondFragmentById != null) {
                    getSupportFragmentManager().beginTransaction()
                            .remove(secondFragmentById)
                            .commit();
                }
            }
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.firstFram, firstFragment)
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction(String value1) {
        ShowFragment secondFragment = ShowFragment.newInstance(value1);
        if (findViewById(R.id.frameLayout) != null) {
            // Found the ID of only one Fragment ==> Portrait mode
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, secondFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        } else {
            // Landscape mode
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.secondFram, secondFragment)
                    .commit();
        }
    }

   /* @Override
    protected void onSaveInstanceState(Bundle outState) {
        TextSave=textView.getText().toString();
        outState.putString("TEXT","asdasds");
        super.onSaveInstanceState(outState);
    }*/
}
