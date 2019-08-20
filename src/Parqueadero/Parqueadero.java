/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parqueadero;
import Modelos.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
/**
 *
 * @author Juan Osorio
 * @since 16/08/2019
 * @serial 1.0
 */
public class Parqueadero {
    
    private int tarifa;
    private double n = 0;
    private HashMap<Date, Automotor> myFechasIn = new HashMap();
    private HashMap<Conductor, Automotor> myUserList = new HashMap();
    private ArrayList<Automotor> myParking = new ArrayList();

    public int obtenerTarifa() {
        
        return tarifa;
    
    }

    public void actualizarTarifa(int nuevaTarifa) {
    
        this.tarifa = nuevaTarifa;
    
    }

    public void ingresarTarifa(int tarifa) {
        
        this.tarifa = tarifa;
    
    }

    
    public void paquearAutomotor(Conductor conductor, Automotor automotor) {
        
        if (n == 149.5) {
            
            if (automotor.getTipo().equalsIgnoreCase("moto")) {
                
                Date fechaIngreso = new Date();
                
                this.myFechasIn.put(fechaIngreso, automotor);
                
                this.myUserList.put(conductor, automotor);

                this.myParking.add(automotor);
                
                this.n+=0.5;
                
                System.out.println("moto parqueada!");
                
            }else{
                
                System.out.println("solo queda espacio para una moto");
            
            }
            
        }
        
        if (n == 149.0) {
            
            if (automotor.getTipo().equalsIgnoreCase("camion")) {
                
                System.out.println("no quedan cupos para camiones");
                
            } else {
                
                if (automotor.getTipo().equalsIgnoreCase("carro")) {
                    
                    Date fechaIngreso = new Date();
                    
                    this.myFechasIn.put(fechaIngreso, automotor);
                    
                    this.myUserList.put(conductor, automotor);
                    
                    this.myParking.add(automotor);
                    
                    System.out.println("carro parqueado!");
                    
                    this.n++;
                    
                } else {
                    
                    Date fechaIngreso = new Date();
                    
                    this.myFechasIn.put(fechaIngreso, automotor);
                    
                    this.myUserList.put(conductor, automotor);
                    
                    this.myParking.add(automotor);
                    
                    this.n+=0.5;
                    
                    System.out.println("moto parqueada!");
                    
                }
                 
            }
            
        }
        
        if (n < 150.0) {
            
            Date fechaIngreso = new Date();
            
            this.myUserList.put(conductor, automotor);
            
            this.myFechasIn.put(fechaIngreso, automotor);
            
            if (automotor.getTipo().equalsIgnoreCase("camion")) {
                
                this.myParking.add(automotor);
                
                this.n += 2;
               
                System.out.println("Camion parqueado!");

            }
            
            if (automotor.getTipo().equalsIgnoreCase("moto")) {
                
                this.myParking.add(automotor);
                
                this.n += 0.5;
                
                System.out.println("moto parqeada!");
                
            }
            
            if (automotor.getTipo().equalsIgnoreCase("carro")) {
                
                this.myParking.add(automotor);
                
                this.n++;
                
                System.out.println("carro parqueado!");
                
            }
            
        } else {
            
            if (n == 150) {
               
                System.out.println("parqueadero lleno!");
                
            }
        }

    }

    
    public double tiempoFinal(String placaSalida) {
        
        double descuento = 0;
        double saldoApagar = 0;
        
        Date fechaSalida = new Date();
        
        //Set salida = this.myFechasIn.entrySet();
        //entryset para obtener los datos de fecha de ingreso y placa del automotor que va a salir y hacer el calculo de la tarifa
        for (Map.Entry<Date, Automotor> salida : this.myFechasIn.entrySet()) {
            
            if (salida.getValue().getPlaca().equals(placaSalida)) {
                
                if (((fechaSalida.getHours()) - (salida.getKey().getHours())) < 12) {
                    
                    saldoApagar = this.tarifa * ((fechaSalida.getHours()) - (salida.getKey().getHours()));
                    
                    this.n--;
                    
                } else {
                    
                    if (((fechaSalida.getHours()) - (salida.getKey().getHours())) == 12) {
                        
                        descuento = 0.15 * (this.tarifa * 12);
                        
                        saldoApagar = (this.tarifa * ((fechaSalida.getHours()) - (salida.getKey().getHours()))) - descuento; 
                        
                        this.n--;
                        
                    } else {
                        
                        if (((fechaSalida.getHours()) - (salida.getKey().getHours())) > 12 && ((fechaSalida.getHours()) - (salida.getKey().getHours())) < 24) {
                            
                            descuento = (this.tarifa * 12) * 0.15;
                            
                            saldoApagar = (this.tarifa * ((fechaSalida.getHours()) - (salida.getKey().getHours()))) - descuento;
                            
                            this.n--;
                            
                        }
                        
                    }
                    
                }
                
            }
            
        }
        
        return saldoApagar;
       
    }
    
}
