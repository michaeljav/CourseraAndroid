package com.exampleandroiddemottest.miscontantos;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.exampleandroiddemottest.miscontantos.adapter.ContactoAdaptador;
import com.exampleandroiddemottest.miscontantos.adapter.PageAdapter;
import com.exampleandroiddemottest.miscontantos.fragment.PerfilFragment;
import com.exampleandroiddemottest.miscontantos.fragment.RecyclerViewFragment;
import com.exampleandroiddemottest.miscontantos.pojo.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        setUpViewPager();
        if (toolbar != null)
        {
            setSupportActionBar(toolbar);
        }









    }

    //lista de fragmen a mostrar
    private ArrayList<Fragment> agregarFragments(){

    ArrayList<Fragment>  fragments= new ArrayList<>();

    fragments.add(new RecyclerViewFragment());
    fragments.add(new PerfilFragment());

  return  fragments;

    }
    //add list fragmen to  adapter
    private void setUpViewPager(){

        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contacts);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_stars);
    }


}
