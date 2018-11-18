package cifras.juego.es;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinJuego extends AppCompatActivity  implements View.OnClickListener {

    private TextView textView, textView2, textView3;
    private Button buttonNew, buttonRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin_juego);

        int base = getIntent().getIntExtra("base",8);

        textView = (TextView) findViewById(R.id.textView);

        textView3 = (TextView) findViewById(R.id.textView3);

        buttonNew = (Button) findViewById(R.id.buttonNew);
        buttonRestart = (Button) findViewById(R.id.buttonRestart);

        buttonNew.setOnClickListener(this);
        buttonRestart.setOnClickListener(this);


        textView.setText("Objetivo: " + base );

        textView3.setVisibility(View.VISIBLE);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.buttonNew){
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        } else if (v.getId() == R.id.buttonRestart){
            Intent intent = new Intent();
            setResult(RESULT_CANCELED, intent);
            finish();
        }


    }
}
