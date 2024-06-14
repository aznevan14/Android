package mx.fca.examena;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends Activity {

    TextView txvInfo;
    Button btnResultado, btnAnterior;
    EditText editTextNumber;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txvInfo = findViewById(R.id.txvInfo);
        btnResultado = findViewById(R.id.btnResultado);
        editTextNumber = findViewById(R.id.editTextNumber);

        btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editTextNumber.getText().toString();
                try {
                    int number = Integer.parseInt(inputText);
                    int sqrt = (int) Math.sqrt(number);
                    if (sqrt * sqrt == number) {
                        showPantalla2(number);
                    }
                } finally {

                }
            }
        });
    }

    private void showPantalla2(int number) {
        setContentView(R.layout.pantalla2);

        recyclerView = findViewById(R.id.RecyclerV);
        btnAnterior = findViewById(R.id.btnAnterior);

        int columns = (int) Math.sqrt(number);
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        recyclerView.setAdapter(new VistaHolder(number));

        btnAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_main);

                txvInfo = findViewById(R.id.txvInfo);
                btnResultado = findViewById(R.id.btnResultado);
                editTextNumber = findViewById(R.id.editTextNumber);

                btnResultado.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String inputText = editTextNumber.getText().toString();
                        try {
                            int number = Integer.parseInt(inputText);
                            int sqrt = (int) Math.sqrt(number);
                            if (sqrt * sqrt == number) {
                                showPantalla2(number);
                            }
                    } finally {

                        }
                        }
                });
            }
        });
    }
}
