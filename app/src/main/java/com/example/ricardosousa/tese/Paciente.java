package com.example.ricardosousa.tese;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

/*
        <android.support.v7.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="?attr/actionBarSize"
                android:background="?attr/colorPrimary"
                app:layout_scrollFlags="scroll|enterAlways"
                app:popupTheme="@style/ThemeOverlay.AppCompat.Light" />
*/

public class Paciente extends AppCompatActivity {

    private PageAdapter adapter;
    private ViewPager view;
    private ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paciente);

        adapter = new PageAdapter(getSupportFragmentManager());
        view = (ViewPager) findViewById(R.id.viewpager);
        SetupPage(view);
        TabLayout tab = (TabLayout) findViewById(R.id.tabs);
        tab.setupWithViewPager(view);
    }

    private void SetupPage(ViewPager viewpage){
        PageAdapter a = new PageAdapter(getSupportFragmentManager());
        a.AddFragment(new Pacientes_Frag(),getResources().getString(R.string.pacientes));
        a.AddFragment(new Pacientes_Estat_Frag(),getResources().getString(R.string.estatisticas));
        viewpage.setAdapter(a);
    }
}

