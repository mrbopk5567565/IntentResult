package thinhtien.pntt.phannguyentruongthinh.intentresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtN;
    Button btnLUS;
    TextView txtKetQua;

    int REQUEST_EDIT_CODE = 113;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        AddEvents();
    }

    private void AddEvents() {
        btnLUS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moManHinhXuLyUocSo();
            }
        });
    }

    private void moManHinhXuLyUocSo() {
        Intent intent = new Intent(MainActivity.this,UocSoActivity.class);
        intent.putExtra("N",Integer.parseInt(edtN.getText().toString()));
        startActivityForResult(intent,REQUEST_EDIT_CODE);
    }

    private void AnhXa() {
        edtN = findViewById(R.id.editTextN);
        btnLUS = findViewById(R.id.buttonLayUocSo);
        txtKetQua =  findViewById(R.id.textViewKetQua);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_EDIT_CODE && resultCode == RESULT_OK && data != null){
            ArrayList<Integer> daUS = data.getIntegerArrayListExtra("DSUS");
            txtKetQua.setText("");
            for (int i = 0; i < daUS.size(); i++){
                txtKetQua.append(daUS.get(i) + " ");
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
