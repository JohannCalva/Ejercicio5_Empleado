import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Empleado {
    String cedula;
    String nombre;
    String genero;
    float salario;
    int diaNac, mesNac, anioNac;
    int diaIng, mesIng, anioIng;
    int diaAct, mesAct, anioAct;
    int edad;
    int antiguedad;
    float prestaciones;
    //Instancio la clase scanner para la entrada de datos por consola
    Scanner sc = new Scanner(System.in);
    //El constructor, al momento que se instancia, define la fecha actual
    public Empleado(){
        fechaActual();

    }

    public void fechaActual(){

        GregorianCalendar grCal = new GregorianCalendar();
        this.diaAct = grCal.get(Calendar.DAY_OF_MONTH);
        this.mesAct = grCal.get(Calendar.MONTH) + 1;
        this.anioAct = grCal.get(Calendar.YEAR);
        //Obtiene la fecha actual gracias a la calse Gregorian Calendar
    }

    public void ingresarDatos(){
        System.out.println("Cedula: ");
        this.cedula = sc.nextLine();
        System.out.println("Nombres y Apellidos: ");
        this.nombre = sc.nextLine();
        System.out.println("Genero: ");
        this.genero = sc.nextLine();
        do{
            System.out.println("Salario: ");
            this.salario = Float.parseFloat(sc.nextLine());
            if(this.salario < 0){
                System.out.println("Ingrese un salario positivo.");
            }//Control de numeros negativos
        }while(this.salario < 0);
        System.out.println("Fecha de Nacimiento:");
        System.out.print("Dia: ");
        this.diaNac = Integer.parseInt(sc.nextLine());
        System.out.print("Mes: ");
        this.mesNac = Integer.parseInt(sc.nextLine());
        System.out.print("Anio: ");
        this.anioNac = Integer.parseInt(sc.nextLine());
        System.out.println("Fecha de Ingreso a la empresa: ");
        System.out.print("Dia: ");
        this.diaIng = Integer.parseInt(sc.nextLine());
        System.out.print("Mes: ");
        this.mesIng = Integer.parseInt(sc.nextLine());
        System.out.print("Anio: ");
        this.anioIng = Integer.parseInt(sc.nextLine());
    }

    public void modificarSalario(float nuevoSalario){
        this.salario = nuevoSalario;//Se asigna el nuevo salario a la variable de salario
        System.out.println("El nuevo salario es: " + salario);
    }

    public void calcularEdad(){
        this.edad = this.anioAct - anioNac;//Primero se resta el anio actual al anio de nacimiento
        if(mesAct < mesNac){//Se verifica si el mes actual es menor al del mes de nacimiento
            this.edad--;
        }else if(mesAct == mesNac){//Si es menor o igual, se revisa el caso que sea el mismo mes
            if(diaAct < diaNac){//si el dia actual es menor que el dia de nacimiento entonces aun no cumple anios
                this.edad--;
            }
        }
        System.out.println("La edad es "+this.edad);
    }

    public void calcularPrestaciones(){
        this.antiguedad = this.anioAct - anioIng;
        if(mesAct < mesIng){
            this.antiguedad--;
        }else if(mesAct == mesIng){
            if(diaAct < diaIng){
                this.antiguedad--;
            }
        }
        System.out.println("La antiguedad es "+this.antiguedad);
        this.prestaciones = (this.antiguedad * this.salario)/12;
        System.out.println("Las prestaciones son: "+String.format("%.2f",prestaciones));
    }

    public void mostrarDatos(){
        calcularEdad();
        calcularPrestaciones();
        System.out.println("\n_________Datos del Empleado_________");
        System.out.println("Fecha: "+diaAct+"/"+mesAct+"/"+anioAct);
        System.out.println("C.I.: "+ cedula);
        System.out.println("Nombre: "+nombre);
        System.out.println("Genero: "+genero);
        System.out.println("Salario: $"+salario);
        System.out.println("Edad: "+edad);
        System.out.println("Anios de servicio: "+antiguedad);
        System.out.println("Prestaciones: $"+prestaciones);
    }//muestra los datos
}
