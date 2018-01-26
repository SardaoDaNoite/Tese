package com.example.ricardosousa.tese;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.StackView;

import java.util.ArrayList;

public class StackViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_view);

        StackView stackView = (StackView) findViewById(R.id.stack_view);
        ArrayList list = new ArrayList();
        for (int i = 0; i < 100; i++) {
            list.add(new StackItems("Item " + i, "Item " + i));
        }
        StacKAdapter adapter = new StacKAdapter(StackViewActivity.this, list);
        stackView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }
}
