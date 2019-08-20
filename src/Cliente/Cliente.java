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
        Date fsistema = new Date();
        System.out.println(fsistema);
        SimpleDateFormat formatoNuevo = new SimpleDateFormat("hh: mm: ss a dd-MMM-aaaa");
        System.out.println("hh: mm: ss a dd-MMM-aaaa");
        //Scanner reader = new Scanner (System.in);
        //Scanner reader2 = new Scanner (System.in);
        
        //Date ingreso = objSDF.parse(reader.nextLine()); 
        //Date salida = objSDF.parse(reader.nextLine());
        System.out.println(fsistema.getMinutes()+2);
        System.out.println("====================================================");
        System.out.println(formatoNuevo.format(fsistema));  
    
    }
    
}
