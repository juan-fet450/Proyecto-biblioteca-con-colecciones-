/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import Modelos.*;
import Parqueadero.*;
/**
 *
 * @author Juan Osorio
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Parqueadero park = new Parqueadero();
        
        System.out.println("*=*=*PARKING THE GOOD DRIVER*=*=*");
        System.out.println("ingrese una opcion entre 1 y 4");
        System.out.println("1 parquear vehiculo");
        System.out.println("2 precio a pagar del vehiculo saliente");
        System.out.println("3 poner una tarifa inicial (horas)");
        System.out.println("4 actualizar la tarifa (horas) ");
        System.out.println("5 reporte del dia (usar al final del dia para una mejor visializacion)");
        System.out.println("6 SALIR");
      
        int op = 0;
        
        while (op!=6) {   
            System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/¿OPCION?/*/*/*/*/*/*/*/*/*/*/*/*");
            Scanner reader = new Scanner(System.in);
            Scanner reader2 = new Scanner(System.in);
            Scanner reader3 = new Scanner(System.in);
            Scanner reader4 = new Scanner(System.in);
            Scanner reader5 = new Scanner(System.in);
            Scanner reader6 = new Scanner(System.in);
            Scanner reader7 = new Scanner(System.in);
            Scanner reader8 = new Scanner(System.in);
            Scanner reader9 = new Scanner(System.in);
            Scanner reader10 = new Scanner(System.in);
            Scanner reader11 = new Scanner(System.in);
            Scanner reader12 = new Scanner(System.in);
            //variable op que cambia segun scanner 
            op=reader.nextInt();
            
            switch (op) {
                
                case 1:
                    
                    System.out.println("DATOS DEL CONDUCTOR");
                    System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
                    System.out.println("nombre");
                    String nombre = reader2.nextLine();
                    System.out.println("telefono");
                    String telefono = reader3.nextLine();
                    System.out.println("cedula");
                    String cedula = reader4.nextLine();
                    System.out.println("DATOS DEL VEHICULO ENTRANTE");
                    System.out.println("----------------------------------------");
                    ////////////////////////////////////////////////////////////
                    System.out.println("tipo");
                    String tipo = reader5.nextLine();
                    System.out.println("placa");
                    String placa = reader6.nextLine();
                    System.out.println("marca");
                    String marca = reader7.nextLine();
                    System.out.println("color");
                    String color = reader8.nextLine();
                    System.out.println("modelo");
                    String modelo = reader9.nextLine();
                    System.out.println("====================================================");
                    park.paquearAutomotor(new Conductor(nombre, telefono, cedula),new Automotor(tipo, placa, marca, color, modelo));
                    
                    break;
                case 2:
                    
                    System.out.println("ingrese la placa del automotor saliente");
                    String placasalida = reader11.nextLine();
                    System.out.println(park.tiempoFinal(placasalida));
                    
                    break;
                    
                case 3:
                    
                    System.out.println("ingresar tarifa inicial");
                    park.ingresarTarifa(reader.nextDouble());
                    
                    break;
                
                case 4:
                    
                    System.out.println("ingrese la nueva tarifa");
                    park.actualizarTarifa(reader.nextDouble());
                    
                    break;
                    
                case 5:
                    
                    System.out.println("REPORTE FINAL");
                    park.reporteFinal();
                    
                    break;
            
            }
            
        }
        
    }
    
}
