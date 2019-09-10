package thinhtien.pntt.phannguyentruongthinh.intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class UocSoActivity extends AppCompatActivity {

    TextView txtN;
    Button btnResult;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uoc_so);

        AddControls();
        AddEvents();
    }

    private void AddEvents() {
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xuLyTraUocSo();
            }
        });
    }

    private void xuLyTraUocSo() {
        int n = Integer.parseInt(txtN.getText().toString());
        ArrayList<Integer> dsUS = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            if (n % i == 0){
                dsUS.add(i);
            }
        }
        intent.putExtra("DSUS",dsUS);
        setResult(RESULT_OK,intent);
        finish();
    }

    private void AddControls() {
        intent = getIntent();
        int n = intent.getIntExtra("N",0);
        AnhXa();
        txtN.setText(n + "");
    }

    private void AnhXa() {
        txtN = findViewById(R.id.textViewN);
        btnResult = findViewById(R.id.buttonResult);
    }
}
