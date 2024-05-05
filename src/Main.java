import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int op;
        System.out.println("Bienvenido al menu de empleados");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Empleado empleado1 = new Empleado();
        do{
            System.out.println("Seleccione la opcion que desea realizar: ");
            System.out.println("1. Ingresar datos de empleado");
            System.out.println("2. Modificar salario");
            System.out.println("3. Mostrar datos y prestaciones");
            System.out.println("4. Salir");
            System.out.println("Opcion: ");
            op = Integer.parseInt(br.readLine());

            switch(op){
                case 1:
                    empleado1.ingresarDatos();
                    break;
                case 2:
                    float ns;
                    //Control para que el neuvo salario no sea negativo
                    do{
                        System.out.println("Ingrese el nuevo salario: ");
                        ns = Float.parseFloat(br.readLine());
                        if(ns < 0){
                            System.out.println("Ingrese un salario positivo.");
                        }else{
                            empleado1.modificarSalario(ns);
                        }

                    }while(ns < 0);

                    break;
                case 3:
                    empleado1.mostrarDatos();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion no existente.");
                    break;
            }
        }while(op != 4);
    }
}