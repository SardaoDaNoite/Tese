package com.example.ricardosousa.tese;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class Add_Pacient extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__pacient);

        final EditText nferidas = (EditText)findViewById(R.id.nFeridas_Paciente);
        nferidas.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @TargetApi(Build.VERSION_CODES.M)
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void afterTextChanged(Editable editable) {
                int numero =  Integer.parseInt(nferidas.getText().toString());
                LinearLayout feridas = (LinearLayout)findViewById(R.id.layout_feridas);
                int count = feridas.getChildCount();
                View v = null;
                for (int i = 0; i < count; i++) {
                    v = feridas.getChildAt(i);
                    String nome = getResources().getResourceEntryName(v.getId());
                    if (nome.contains("Feridan")) {
                        v.setVisibility(View.GONE);
                    }
                }
                EditText Descriçao = new EditText(getApplicationContext());
                LinearLayout.LayoutParams params= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                float d = getApplicationContext().getResources().getDisplayMetrics().density;
                params.setMargins((int)(10*d),(int)(10*d),(int)(10*d),(int)(10*d));
                Descriçao.setBackground(getDrawable(R.drawable.edittext));
                Descriçao.setElevation(10*d);
                Descriçao.setEms(10);
                Descriçao.setPadding((int)(8*d),(int)(8*d),(int)(8*d),(int)(8*d));
                Descriçao.setTextColor(getColor(R.color.branco));
                Descriçao.setHintTextColor(getColor(R.color.branco));
                Descriçao.setSingleLine(false);
                Descriçao.setImeOptions(EditorInfo.IME_FLAG_NO_ENTER_ACTION);

                for (int i = 0; i < numero; i++) {
                    Descriçao.setId(9000+i);
                    Descriçao.setHint("Descriçao");
                    feridas.addView(Descriçao,params);
                }
            }
        });
    }
}
