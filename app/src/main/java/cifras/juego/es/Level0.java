package cifras.juego.es;

import java.util.*;

public class Level0 {

    private int[] numeros;
    private int base;
    private Random random;

    public Level0(){
        random = new Random();


        numeros = new int[8];

    }

    public int[] getArray(){
        return this.numeros;
    }

    public int getBase(){
        return this.base;
    }

    public int generate0(){
        int suma = random.nextInt(9)+1;
        base = base + suma;
        return suma;
    }

    public int generate1(){
        int resta = random.nextInt(9)+1;
        base = base - resta;
        return resta;
    }

    public int generate2(){

        int multiplica = random.nextInt(8)+2;
        base = base * multiplica;
        return multiplica;
    }

    public void generar(){

        while(base < 75) {
            base = random.nextInt(8)+2;
            numeros[0] = base;
            int nmult = 0;
            for (int i = 1; i < 5; i++) {
                int j = random.nextInt(3);
                while ((nmult >1) && j == 2)
                    j = random.nextInt(3);

                int k;
                switch (j) {
                    case 0: {
                        k = this.generate0();
                        System.out.print("+");
                        break;
                    }
                    case 1: {
                        k = this.generate1();
                        System.out.print("-");
                        break;
                    }
                    default: {
                        k = this.generate2();
                        System.out.println("x");
                        break;
                    }
                }
                if (j == 2)
                    nmult ++;
                numeros[i] = k;

            }


        }


        for (int i=5; i<numeros.length; i++)
            numeros[i] = random.nextInt(9)+1;
        this.numeros = this.mezclar(this.numeros);
    }


    //mezclar un array
    public int[] mezclar (int [] array){
        int[]salida = new int[array.length];
        boolean [] cogido = new boolean[array.length];
        for (int i =0; i<array.length; i++){
            int j =random.nextInt(8);
            while(cogido[j])
                j= random.nextInt(8);

            cogido[j]=true;
            salida[i]= array[j];
        }
        return salida;
    }

}