package cifras.juego.es;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonOriginal, buttonNuevo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOriginal = (Button) findViewById(R.id.buttonOriginal);
        buttonNuevo = (Button) findViewById(R.id.buttonNuevo);
        buttonOriginal.setOnClickListener(this);
        buttonNuevo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.buttonOriginal){
            Intent intent = new Intent (this, Level0Juego.class);
            startActivity(intent);

        }

        if(v.getId() == R.id.buttonNuevo){
            Intent intent = new Intent(this, Level1Juego.class);
            startActivity(intent);
        }
    }
}
