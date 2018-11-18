package cifras.juego.es;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Level1Juego extends AppCompatActivity implements View.OnClickListener{

    private Button  buttonMas,buttonMenos, buttonPor, buttonClear, buttonNueva, buttonCalc1, buttonCalc2;
    private TextView textViewCalc1, textViewCalc2, textViewBuscado;
    private Button[] botones;
    private Level1 juego;
    private int operador = -1;
    private boolean[] fuePulsado;
    private int calcula1 = 0;
    private int calcula2=0;
    private Spinner spinner;
    private ProgressBar barra1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juego1);
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
        buttonCalc1 = (Button) findViewById(R.id.buttonCalc1);
        buttonCalc2= (Button) findViewById(R.id.buttonCalc2);
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


        textViewBuscado = (TextView) findViewById(R.id.textViewBuscado);
        textViewCalc2 = (TextView) findViewById(R.id.textViewCalc2);
        textViewCalc1 = (TextView) findViewById(R.id.textViewCalc1);
        spinner = (Spinner) findViewById(R.id.spinner);
        barra1= (ProgressBar) findViewById(R.id.barra1);



        for(int i = 0; i<botones.length; i++)
            botones[i].setEnabled(false);
        buttonMas.setEnabled(false);
        buttonMenos.setEnabled(false);
        buttonPor.setEnabled(false);
        buttonClear.setEnabled(false);
        buttonCalc1.setEnabled(false);
        buttonCalc2.setEnabled(false);

    }

    public void onClick (View v){
        if(v.getId() == R.id.buttonNueva){
            new RsTask().execute();


        } else if (v.getId() == R.id.buttonClear){
            calcula1 =0;
            calcula2 =0;
            operador = -1;
            textViewCalc2.setText("Calculadora2: 0 ");
            textViewCalc1.setText("Calculadora1: 0 ");
            for(int i = 0; i<botones.length; i++){
                botones[i].setEnabled(true);
                fuePulsado[i]=false;

            }

            buttonMas.setEnabled(false);
            buttonMenos.setEnabled(false);
            buttonPor.setEnabled(false);
            buttonCalc1.setEnabled(false);
            buttonCalc2.setEnabled(false);


        }else if (v.getId() == R.id.buttonMas){
            operador= 0;
            for(int i = 0; i<botones.length; i++){
               if(!fuePulsado[i])
                   botones[i].setEnabled(true);
            }

            buttonCalc1.setEnabled(true);
            buttonCalc2.setEnabled(true);
            if(calcula1==0)
                buttonCalc1.setEnabled(false);
            if(calcula2==0)
                buttonCalc2.setEnabled(false);



            buttonMas.setEnabled(true);
            buttonMenos.setEnabled(true);
            buttonPor.setEnabled(true);



        }else if (v.getId() == R.id.buttonMenos){
            operador = 1;
            for(int i = 0; i<botones.length; i++){
                if(!fuePulsado[i])
                    botones[i].setEnabled(true);
            }
            buttonCalc1.setEnabled(true);
            buttonCalc2.setEnabled(true);
            if(calcula1==0)
                buttonCalc1.setEnabled(false);
            if(calcula2==0)
                buttonCalc2.setEnabled(false);
            buttonMas.setEnabled(true);
            buttonMenos.setEnabled(true);
            buttonPor.setEnabled(true);

        }else if (v.getId() == R.id.buttonPor){

            operador = 2;
            for(int i = 0; i<botones.length; i++){
                if(!fuePulsado[i])
                    botones[i].setEnabled(true);
            }
            buttonCalc1.setEnabled(true);
            buttonCalc2.setEnabled(true);
            if(calcula1==0)
                buttonCalc1.setEnabled(false);
            if(calcula2==0)
                buttonCalc2.setEnabled(false);
            buttonMas.setEnabled(true);
            buttonMenos.setEnabled(true);
            buttonPor.setEnabled(true);

        }

    }

    public void imprime(View v){

        if(v.getId() == R.id.button0){
            int j=0;
            switch (operador){
               case -1:
                   if(spinner.getSelectedItemPosition()==0)
                       calcula1= 0 +juego.getArray()[j];
                   if(spinner.getSelectedItemPosition()==1)
                       calcula2= 0 +juego.getArray()[j];
                   break;
               case 0:
                   if(spinner.getSelectedItemPosition()==0)
                       calcula1= calcula1 +juego.getArray()[j];
                   if(spinner.getSelectedItemPosition()==1)
                       calcula2= calcula2 +juego.getArray()[j];
                   break;
               case 1:
                   if(spinner.getSelectedItemPosition()==0)
                       calcula1= calcula1 -juego.getArray()[j];
                   if(spinner.getSelectedItemPosition()==1)
                       calcula2= calcula2 -juego.getArray()[j];
                   break;
               case 2 :
                   if(spinner.getSelectedItemPosition()==0)
                       calcula1= calcula1 *juego.getArray()[j];
                   if(spinner.getSelectedItemPosition()==1)
                       calcula2= calcula2 *juego.getArray()[j];
                   break;


           }
           fuePulsado[j]= true;


        } else if (v.getId() == R.id.button1){
            int j=1;
            switch (operador){
                case -1:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= 0 +juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= 0 +juego.getArray()[j];
                    break;
                case 0:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 +juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 +juego.getArray()[j];
                    break;
                case 1:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 -juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 -juego.getArray()[j];
                    break;
                case 2 :
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 *juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 *juego.getArray()[j];
                    break;


            }
            fuePulsado[j]= true;


        }else if (v.getId() == R.id.button2){

            int j=2;
            switch (operador){
                case -1:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= 0 +juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= 0 +juego.getArray()[j];
                    break;
                case 0:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 +juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 +juego.getArray()[j];
                    break;
                case 1:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 -juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 -juego.getArray()[j];
                    break;
                case 2 :
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 *juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 *juego.getArray()[j];
                    break;


            }
            fuePulsado[j]= true;


        }else if (v.getId() == R.id.button3){
            int j=3;
            switch (operador){
                case -1:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= 0 +juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= 0 +juego.getArray()[j];
                    break;
                case 0:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 +juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 +juego.getArray()[j];
                    break;
                case 1:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 -juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 -juego.getArray()[j];
                    break;
                case 2 :
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 *juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 *juego.getArray()[j];
                    break;


            }
            fuePulsado[j]= true;


        }else if (v.getId() == R.id.button4){
            int j=4;
            switch (operador){
                case -1:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= 0 +juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= 0 +juego.getArray()[j];
                    break;
                case 0:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 +juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 +juego.getArray()[j];
                    break;
                case 1:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 -juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 -juego.getArray()[j];
                    break;
                case 2 :
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 *juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 *juego.getArray()[j];
                    break;


            }
            fuePulsado[j]= true;



        }else if (v.getId() == R.id.button5){
            int j=5;
            switch (operador){
                case -1:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= 0 +juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= 0 +juego.getArray()[j];
                    break;
                case 0:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 +juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 +juego.getArray()[j];
                    break;
                case 1:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 -juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 -juego.getArray()[j];
                    break;
                case 2 :
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 *juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 *juego.getArray()[j];
                    break;


            }
            fuePulsado[j]= true;


        }else if (v.getId() == R.id.button6){
            int j=6;
            switch (operador){
                case -1:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= 0 +juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= 0 +juego.getArray()[j];
                    break;
                case 0:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 +juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 +juego.getArray()[j];
                    break;
                case 1:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 -juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 -juego.getArray()[j];
                    break;
                case 2 :
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 *juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 *juego.getArray()[j];
                    break;


            }
            fuePulsado[j]= true;



        }else if (v.getId() == R.id.button7){
            int j=7;
            switch (operador){
                case -1:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= 0 +juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= 0 +juego.getArray()[j];
                    break;
                case 0:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 +juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 +juego.getArray()[j];
                    break;
                case 1:
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 -juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 -juego.getArray()[j];
                    break;
                case 2 :
                    if(spinner.getSelectedItemPosition()==0)
                        calcula1= calcula1 *juego.getArray()[j];
                    if(spinner.getSelectedItemPosition()==1)
                        calcula2= calcula2 *juego.getArray()[j];
                    break;


            }
            fuePulsado[j]= true;



        }
        else if (v.getId() == R.id.buttonCalc2){
            switch (operador){
                case -1:
                    if(spinner.getSelectedItemPosition()==0){
                        calcula1= 0 +calcula2;
                        calcula2=0;
                    }

                    if(spinner.getSelectedItemPosition()==1){
                        Toast.makeText(this, "Selecciona otra calculadora", Toast.LENGTH_SHORT).show();

                    }
                    break;
                case 0:
                    if(spinner.getSelectedItemPosition()==0){
                        calcula1= calcula1 +calcula2;
                        calcula2 = 0;
                    }

                    if(spinner.getSelectedItemPosition()==1){
                        Toast.makeText(this, "Selecciona otra calculadora", Toast.LENGTH_SHORT).show();
                        buttonMas.setEnabled(true);
                        buttonMenos.setEnabled(true);
                        buttonPor.setEnabled(true);
                        buttonClear.setEnabled(true);

                    }

                    break;
                case 1:
                    if(spinner.getSelectedItemPosition()==0){
                        calcula1= calcula1 -calcula2;
                        calcula2= 0;
                    }

                    if(spinner.getSelectedItemPosition()==1){
                        Toast.makeText(this, "Selecciona otra calculadora", Toast.LENGTH_SHORT).show();
                        buttonMas.setEnabled(true);
                        buttonMenos.setEnabled(true);
                        buttonPor.setEnabled(true);
                        buttonClear.setEnabled(true);

                    }
                    break;

                case 2 :
                    if(spinner.getSelectedItemPosition()==0){

                        calcula1= calcula2 *calcula1;
                        calcula2=0;
                    }
                    if(spinner.getSelectedItemPosition()==1){
                        Toast.makeText(this, "Selecciona otra calculadora", Toast.LENGTH_SHORT).show();
                        buttonMas.setEnabled(true);
                        buttonMenos.setEnabled(true);
                        buttonPor.setEnabled(true);
                        buttonClear.setEnabled(true);

                    }
                    break;


            }

        }
        else if (v.getId() == R.id.buttonCalc1){
            switch (operador){
                case -1:
                    if(spinner.getSelectedItemPosition()==1){
                        calcula2= 0 +calcula1;
                        calcula1=0;
                    }

                    if(spinner.getSelectedItemPosition()==0){
                        Toast.makeText(this, "Selecciona otra calculadora", Toast.LENGTH_SHORT).show();

                    }
                    break;
                case 0:
                    if(spinner.getSelectedItemPosition()==1){
                        calcula2= calcula2 +calcula1;
                        calcula1=0;
                    }

                    if(spinner.getSelectedItemPosition()==0){
                        Toast.makeText(this, "Selecciona otra calculadora", Toast.LENGTH_SHORT).show();
                        buttonMas.setEnabled(true);
                        buttonMenos.setEnabled(true);
                        buttonPor.setEnabled(true);
                        buttonClear.setEnabled(true);

                    }
                    break;
                case 1:
                    if(spinner.getSelectedItemPosition()==1){
                        calcula2= calcula2 -calcula1;
                        calcula1=0;
                    }


                    if(spinner.getSelectedItemPosition()==0){
                        Toast.makeText(this, "Selecciona otra calculadora", Toast.LENGTH_SHORT).show();
                        buttonMas.setEnabled(true);
                        buttonMenos.setEnabled(true);
                        buttonPor.setEnabled(true);
                        buttonClear.setEnabled(true);

                    }
                    break;

                case 2 :
                    if(spinner.getSelectedItemPosition()==1){
                        calcula2= calcula1 *calcula2;
                        calcula1=0;
                    }

                    if(spinner.getSelectedItemPosition()==0){
                        Toast.makeText(this, "Selecciona otra calculadora", Toast.LENGTH_SHORT).show();
                        buttonMas.setEnabled(true);
                        buttonMenos.setEnabled(true);
                        buttonPor.setEnabled(true);
                        buttonClear.setEnabled(true);

                    }

                    break;


            }


        }
        for(int i = 0; i<botones.length; i++)
            botones[i].setEnabled(false);
        buttonMas.setEnabled(true);
        buttonMenos.setEnabled(true);
        buttonPor.setEnabled(true);
        buttonCalc1.setEnabled(false);
        buttonCalc2.setEnabled(false);
        textViewCalc1.setText("Calcuadora1 :" + calcula1);
        textViewCalc2.setText("Calcuadora2 :" + calcula2);

        if (this.cambiarActividad()){
            Intent intent = new Intent(this, FinJuego.class);
            intent.putExtra("base", juego.getBase());

            startActivityForResult(intent, 5);
        }


    }

    public boolean cambiarActividad(){
        return (calcula1 == juego.getBase() || calcula2 == juego.getBase());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent){

            if (resultCode == RESULT_OK)
                this.onClick(buttonNueva);
            else
                this.onClick(buttonClear);
        }

    private class RsTask extends AsyncTask<Void,Void,Void> {

        @Override
        protected void onPreExecute(){

            barra1.setVisibility(View.VISIBLE);
            for(int i = 0; i<botones.length; i++) {
                botones[i].setEnabled(false);
                fuePulsado[i]=false;

            }
            buttonClear.setEnabled(false);
            buttonMenos.setEnabled(false);
            buttonMas.setEnabled(false);
            buttonPor.setEnabled(false);
            buttonNueva.setEnabled(false);
            buttonCalc1.setEnabled(false);
            buttonCalc2.setEnabled(false);
            textViewCalc1.setText("Calculadora1: ");
            textViewCalc2.setText("Calculadora2: ");

        }

        @Override
        protected Void doInBackground(Void... params){

            try {
                juego = new Level1();
                juego.generar();


            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;


        }

        @Override
        protected void onPostExecute(Void v){
            barra1 = (ProgressBar) findViewById(R.id.barra1);
            barra1.setVisibility(View.INVISIBLE);
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
            buttonCalc1.setEnabled(false);
            buttonCalc2.setEnabled(false);

            textViewCalc1.setText("Calculadora1: ");
            textViewCalc2.setText("Calculadora2: ");
            buttonNueva.setEnabled(true);
            calcula1=0;
            calcula2=0;
            operador = -1;


        }
    }
    }

