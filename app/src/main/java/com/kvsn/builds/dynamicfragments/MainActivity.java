package com.kvsn.builds.dynamicfragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void b1(View v)
    {
        int k = v.getId();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(k == R.id.b1)
        {
            //ft.add(R.id.frag , new Fragment1());
            // new add method the last parameter i.e., tag makes it easy to identify the fragment
            ft.add(R.id.frag , new Fragment1() , "One");
        }
        else if(k == R.id.b2)
        {
            //ft.add(R.id.frag , new Fragment2());
            ft.add(R.id.frag , new Fragment2() , "Two");
        }
        else if(k == R.id.b3)
        {
            //ft.add(R.id.frag , new Fragment3());
            ft.add(R.id.frag , new Fragment3() , "Three");
        }
        else if(k == R.id.b4)
        {
            //as the fragments are added dynamically , we cant decide which on to remove as we can remove only one fragment at a time
            //so , we add the fragments with another method that takes two parameters
            Fragment f = getSupportFragmentManager().findFragmentByTag("Two");
            if(f != null)
            {
                ft.remove(f);
            }
        }
        //ft.addToBackStack(null);
        ft.commit();
    }
}
