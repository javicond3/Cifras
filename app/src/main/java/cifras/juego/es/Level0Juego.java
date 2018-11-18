package cifras.juego.es;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

public class Level0Juego extends AppCompatActivity implements View.OnClickListener{

    private Button button0, button1, button2,button3,button4,button5,button6,button7, buttonMas,
            buttonMenos, buttonPor, buttonClear, buttonNueva;
    private TextView textViewCalcuadora, textViewHistorial, textViewBuscado;
    private Button[] botones;
    private Level0 juego;
    private int operador = -1;
    private boolean[] fuePulsado;
    private int calcula = 0;
    private ProgressBar barra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego0);
        botones = new Button[8];
        fuePulsado = new boolean[8];
        botones[0] = (Button) findViewById(R.id.button0);
        botones[1] = (Button) findViewById(R.id.button1);
        botones[2] = (Button) findViewById(R.id.button2);
        botones[3] = (Button) findViewById(R.id.button3);
        botones[4] = (Button) findViewById(R.id.button4);
        botones[5] = (Button) findViewById(R.id.button5);
        botones[6] = (Button) findViewById(R.id.button6);
        botones[7] = (Button) findViewById(R.id.button7);
        buttonMas = (Button) findViewById(R.id.buttonMas);
        buttonMenos = (Button) findViewById(R.id.buttonMenos);
        buttonPor = (Button) findViewById(R.id.buttonPor);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonNueva = (Button) findViewById (R.id.buttonNueva);
        buttonNueva.setOnClickListener(this);
        buttonMas.setOnClickListener(this);
        buttonPor.setOnClickListener(this);
        buttonMenos.setOnClickListener(this);
        buttonClear.setOnClickListener(this);

        barra = (ProgressBar) findViewById(R.id.barra);


        textViewBuscado = (TextView) findViewById(R.id.textViewBuscado);
        textViewHistorial = (TextView) findViewById(R.id.textViewHistorial);
        textViewCalcuadora = (TextView) findViewById(R.id.textViewCalculadora);



        for(int i = 0; i<botones.length; i++)
            botones[i].setEnabled(false);
        buttonMas.setEnabled(false);
        buttonMenos.setEnabled(false);
        buttonPor.setEnabled(false);
        buttonClear.setEnabled(false);

    }

    public void onClick (View v){
        if(v.getId() == R.id.buttonNueva){
            new RssRetrieveTask().execute();


        } else if (v.getId() == R.id.buttonClear){
            calcula=0;
            operador = -1;
            textViewHistorial.setText("Historial: ");
            textViewCalcuadora.setText("Calculadora: ");
            for(int i = 0; i<botones.length; i++){
                botones[i].setEnabled(true);
                fuePulsado[i]=false;


            }

            buttonMas.setEnabled(false);
            buttonMenos.setEnabled(false);
            buttonPor.setEnabled(false);




        }else if (v.getId() == R.id.buttonMas){
            operador= 0;
            for(int i = 0; i<botones.length; i++){
                if(!fuePulsado[i])
                    botones[i].setEnabled(true);
            }

            buttonMas.setEnabled(true);
            buttonMenos.setEnabled(true);
            buttonPor.setEnabled(true);



        }else if (v.getId() == R.id.buttonMenos){
            operador = 1;
            for(int i = 0; i<botones.length; i++){
                if(!fuePulsado[i])
                    botones[i].setEnabled(true);
            }
            buttonMas.setEnabled(true);
            buttonMenos.setEnabled(true);
            buttonPor.setEnabled(true);

        }else if (v.getId() == R.id.buttonPor){

            operador = 2;
            for(int i = 0; i<botones.length; i++){
                if(!fuePulsado[i])
                    botones[i].setEnabled(true);
            }
            buttonMas.setEnabled(true);
            buttonMenos.setEnabled(true);
            buttonPor.setEnabled(true);

        }

    }

    public void imprime(View v){
        int masProximo = Integer.MAX_VALUE;
        if(v.getId() == R.id.button0){
            switch (operador){
                case -1:
                    calcula = 0 + juego.getArray()[0];
                    break;
                case 0:
                    calcula = calcula + juego.getArray()[0];
                    break;
                case 1:
                    calcula = calcula - juego.getArray()[0];
                    break;
                case 2 :
                    calcula = calcula * juego.getArray()[0];
                    break;


            }
            fuePulsado[0]= true;

        } else if (v.getId() == R.id.button1){
            switch (operador){
                case -1:
                    calcula = 0 + juego.getArray()[1];
                    break;
                case 0:
                    calcula = calcula + juego.getArray()[1];
                    break;
                case 1:
                    calcula = calcula - juego.getArray()[1];
                    break;
                case 2 :
                    calcula = calcula * juego.getArray()[1];
                    break;

            }
            fuePulsado[1]= true;


        }else if (v.getId() == R.id.button2){

            switch (operador){
                case -1:
                    calcula = 0 + juego.getArray()[2];
                    break;
                case 0:
                    calcula = calcula + juego.getArray()[2];
                    break;
                case 1:
                    calcula = calcula - juego.getArray()[2];
                    break;
                case 2 :
                    calcula = calcula * juego.getArray()[2];
                    break;


            }
            fuePulsado[2]= true;


        }else if (v.getId() == R.id.button3){
            switch (operador){
                case -1:
                    calcula = 0 + juego.getArray()[3];
                    break;
                case 0:
                    calcula = calcula + juego.getArray()[3];
                    break;
                case 1:
                    calcula = calcula - juego.getArray()[3];
                    break;
                case 2 :
                    calcula = calcula * juego.getArray()[3];
                    break;


            }
            fuePulsado[3]= true;

        }else if (v.getId() == R.id.button4){
            switch (operador){
                case -1:
                    calcula = 0 + juego.getArray()[4];
                    break;
                case 0:
                    calcula = calcula + juego.getArray()[4];
                    break;
                case 1:
                    calcula = calcula - juego.getArray()[4];
                    break;
                case 2 :
                    calcula = calcula * juego.getArray()[4];
                    break;


            }
            fuePulsado[4]= true;

        }else if (v.getId() == R.id.button5){
            switch (operador){
                case -1:
                    calcula = 0 + juego.getArray()[5];
                    break;
                case 0:
                    calcula = calcula + juego.getArray()[5];
                    break;
                case 1:
                    calcula = calcula - juego.getArray()[5];
                    break;
                case 2 :
                    calcula = calcula * juego.getArray()[5];
                    break;


            }
            fuePulsado[5]= true;

        }else if (v.getId() == R.id.button6){
            switch (operador){
                case -1:
                    calcula = 0 + juego.getArray()[6];
                    break;
                case 0:
                    calcula = calcula + juego.getArray()[6];
                    break;
                case 1:
                    calcula = calcula - juego.getArray()[6];
                    break;
                case 2 :
                    calcula = calcula * juego.getArray()[6];
                    break;


            }
            fuePulsado[6]= true;

        }else if (v.getId() == R.id.button7){
            switch (operador){
                case -1:
                    calcula = 0 + juego.getArray()[7];
                    break;
                case 0:
                    calcula = calcula + juego.getArray()[7];
                    break;
                case 1:
                    calcula = calcula - juego.getArray()[7];
                    break;
                case 2 :
                    calcula = calcula * juego.getArray()[7];
                    break;


            }
            fuePulsado[7]= true;


        }
        for(int i = 0; i<botones.length; i++)
            botones[i].setEnabled(false);
        buttonMas.setEnabled(true);
        buttonMenos.setEnabled(true);
        buttonPor.setEnabled(true);
        textViewCalcuadora.setText("" +calcula);
        if (Math.abs(calcula - juego.getBase()) < Math.abs(masProximo - juego.getBase()))
            masProximo = calcula;
        if (this.cambiarActividad()){
            Intent intent = new Intent(this, FinJuego.class);
            intent.putExtra("base", juego.getBase());

            startActivityForResult(intent, 5);
        }


    }

    public boolean cambiarActividad(){

        return calcula == juego.getBase();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){

        if (resultCode == RESULT_OK)
            this.onClick(buttonNueva);
        else
            this.onClick(buttonClear);
    }

    private class RssRetrieveTask extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute(){
            barra = (ProgressBar) findViewById(R.id.barra);
            barra.setVisibility(View.VISIBLE);
            for(int i = 0; i<botones.length; i++) {
                botones[i].setEnabled(false);
                fuePulsado[i]=false;

            }
            buttonClear.setEnabled(false);
            buttonMenos.setEnabled(false);
            buttonMas.setEnabled(false);
            buttonPor.setEnabled(false);
            buttonNueva.setEnabled(false);
            textViewHistorial.setText("Historial: ");
            textViewCalcuadora.setText("Calculadora: ");

        }

        @Override
        protected Void doInBackground(Void... params){

            try {
                juego = new Level0();
                juego.generar();


            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;


        }

        @Override
        protected void onPostExecute(Void v){
            barra = (ProgressBar) findViewById(R.id.barra);
            barra.setVisibility(View.INVISIBLE);
            String base ="" +juego.getBase();
            textViewBuscado.setText(base);
            for(int i = 0; i<botones.length; i++) {
                base = ""+ juego.getArray()[i];
                botones[i].setText(base);
                botones[i].setEnabled(true);
                fuePulsado[i]=false;

            }
            buttonClear.setEnabled(true);
            buttonMenos.setEnabled(false);
            buttonMas.setEnabled(false);
            textViewHistorial.setText("Historial: ");
            textViewCalcuadora.setText("Calculadora: ");
            buttonNueva.setEnabled(true);
            calcula=0;
            operador = -1;


        }
    }
}

