package com.covid19.coronavirus.tampilan;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import com.covid19.coronavirus.R;

public class InformasiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_informasi);

        TextView textView = findViewById(R.id.instagram);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
