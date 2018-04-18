import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;


public class QualityCalculator {
    public static void main(String... args) throws IOException {
        String A;;
        float IF=0,IE=0,PS=0,Si=0, Mi=0, Ti=0, CLDC=0;
        double Ei1=0,Ei2=0,Ei3=0,Ei4=0;
        int Pasos=0, Ei=0, Ws=10,Wm=3,Wt=1;

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("\nIngrese nombre de la empresa: ");
        A = br.readLine();
        System.out.print("Ingrese cantidad de pasos de verificación: ");
        Pasos = Integer.parseInt(br.readLine());
        //for (int i=0;i<=Pasos;i++){
            System.out.print("Ingrese numero de etapa (1:Diseño y codigo, 2:Justo antes de pruebas, 3:Durante prueba, 4: Pos impl): ");
            Ei = Integer.parseInt(br.readLine());
        switch(Ei){
            case 1:
            Ei1=0.01;
                break;
                case 2:
                Ei1=0.605;
                    break;
                    case 3:
                    Ei1=0.15;
                        break;
                        case 4:
                            System.out.print("Ingrese el porcentaje de costo de error (47~60): ");
                            Ei1 = Float.parseFloat(br.readLine());
                break;
        }

            System.out.print("Ingrese cantidad de defectos graves: ");
            Si = Float.parseFloat(br.readLine());
            System.out.print("Ingrese cantidad de defectos moderados: ");
            Mi = Float.parseFloat(br.readLine());
            System.out.print("Ingrese cantidad de defectos leves: ");
            Ti = Float.parseFloat(br.readLine());
            System.out.print("Ingrese cantidad de Lineas de codigo o tamaño del sistema: ");
            PS = Float.parseFloat(br.readLine());
            System.out.print("Ingrese el costo de linea de codigo: ");
            CLDC = Float.parseFloat(br.readLine());



            IF=(Ws*(Si/Ei)+Wm*(Mi/Ei)+Wt*(Ti/Ei));
            System.out.println("\nEl IF (indice acumulativo de error) de " + A + " es: " +IF);

            int num=1;
            float sum=0;
            while (num<=Pasos){
                IE=num*IF;
                sum=sum+IE;
                num++;
            }

            System.out.println("\nEl IE (indice de error) de " + A + " es: " +sum/PS+"%");
        System.out.println("\nEl costo de los defectos de " + A + " es: " +((Si+Mi+Ti)*(Ei1)*(CLDC))+"\n");

    }
}
