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
 * @version 1.1
 */
public class Parqueadero {
    
    private int carros = 0; 
    private int motos = 0; 
    private int camiones = 0;
    private double tarifa = 0;
    private int ContDescuentos = 0;
    private double n = 0;
    private HashMap<Date, Automotor> myFechasIn = new HashMap();
    private HashMap<Conductor, Automotor> myUserList = new HashMap();
    private ArrayList<Automotor> myParking = new ArrayList();
    private ArrayList<Double> myPrices = new ArrayList();

    /**
     * 
     * @return the price by hours of the specified parking 
     */
    public double obtenerTarifa() {
        
        return tarifa;
    
    }

    /**
     * 
     * @param nuevaTarifa refresh the price of the specified parking 
     */
    public void actualizarTarifa(double nuevaTarifa) {
    
        this.tarifa = nuevaTarifa;
    
    }

    /**
     * 
     * @param tarifa the initial price of the specified parking
     */
    public void ingresarTarifa(double tarifa) {
        
        this.tarifa = tarifa;
    
    }

    /**
     * 
     * @param conductor driver info
     * @param automotor car info
     * @return this funtion put the car in a "place over the parking". But not really, just increase a double variable till it gets 150 as value 
     */
    public void paquearAutomotor(Conductor conductor, Automotor automotor) {
        
        if (n == 149.5) {
            
            if (automotor.getTipo().equalsIgnoreCase("moto")) {
                
                Date fechaIngreso = new Date();
                
                this.myFechasIn.put(fechaIngreso, automotor);
                
                this.myUserList.put(conductor, automotor);

                this.myParking.add(automotor);
                
                this.n+=0.5;
                
                this.motos++;
                
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
                    
                    this.carros++;
                    
                } else {
                    
                    Date fechaIngreso = new Date();
                    
                    this.myFechasIn.put(fechaIngreso, automotor);
                    
                    this.myUserList.put(conductor, automotor);
                    
                    this.myParking.add(automotor);
                    
                    this.n+=0.5;
                    
                    this.motos++;
                    
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
                
                this.camiones++;
               
                System.out.println("Camion parqueado!");

            }
            
            if (automotor.getTipo().equalsIgnoreCase("moto")) {
                
                this.myParking.add(automotor);
                
                this.n += 0.5;
                
                this.motos++;
                
                System.out.println("moto parqeada!");
                
            }
            
            if (automotor.getTipo().equalsIgnoreCase("carro")) {
                
                this.myParking.add(automotor);
                
                this.n++;
                
                this.carros++;
                
                System.out.println("carro parqueado!");
                
            }
            
        } else {
            
            if (n == 150) {
               
                System.out.println("parqueadero lleno!");
                
            }
            
        }

    }

    /**
     * 
     * @param placaSalida id of the leaving car
     * @return the cost of using parking from the leaving car
     */
    public double tiempoFinal(String placaSalida) {
        
        double descuento = 0;
        double saldoApagar = 0;
        
        Date fechaSalida = new Date();
        
        //Set salida = this.myFechasIn.entrySet();
        //entryset para obtener los datos de fecha de ingreso y placa del automotor que va a salir y hacer el calculo de la tarifa
        for (Map.Entry<Date, Automotor> salida : this.myFechasIn.entrySet()) {
            
            if (salida.getValue().getPlaca().equals(placaSalida)) {
                
                if (salida.getValue().getTipo().equalsIgnoreCase("carro")) {
                    
                    this.n--;
                    
                    this.carros--;
                    
                } else {
                    
                    if (salida.getValue().getTipo().equalsIgnoreCase("moto")) {
                        
                        this.n-=0.5;
                        
                        this.motos--;
                        
                    } else {
                        
                        this.n-=2;
                        
                        this.camiones--;
                        
                    }
                    
                }
                
                if (((fechaSalida.getHours()) - (salida.getKey().getHours())) < 12) {
                    
                    saldoApagar = this.tarifa * ((fechaSalida.getHours()) - (salida.getKey().getHours()));
                                        
                } else {
                    
                    if (((fechaSalida.getHours()) - (salida.getKey().getHours())) == 12) {
                        
                        descuento = 0.15 * (this.tarifa * 12);
                        
                        saldoApagar = (this.tarifa * ((fechaSalida.getHours()) - (salida.getKey().getHours()))) - descuento; 
                          
                        this.ContDescuentos++;
                        
                    } else {
                        
                        if (((fechaSalida.getHours()) - (salida.getKey().getHours())) > 12 && ((fechaSalida.getHours()) - (salida.getKey().getHours())) < 24) {
                            
                            descuento = (this.tarifa * 12) * 0.15;
                            
                            saldoApagar = (this.tarifa * ((fechaSalida.getHours()) - (salida.getKey().getHours()))) - descuento;
                            
                            this.ContDescuentos++;
                            
                        }
                        
                    }
                    
                }
                
            }
            
        }
        
        if (saldoApagar == 0.0) {
            
            this.myPrices.add(this.tarifa);
            return this.tarifa;
            
        }else{
            
            this.myPrices.add(saldoApagar);
            return saldoApagar;
        }
       
    }
    
    /**
     * @return A final report about counts and avaliable gaps in the park, furthermore give you how many discounts has been realized during the day
     */
    public void reporteFinal(){
        
        double recaudo = 0;
        
        for (int i = 0; i < this.myPrices.size(); i++) {
            
            recaudo+=this.myPrices.get(i);
            
        }
        
        System.out.println("el recaudo total ha sido de: "+recaudo);
        
        System.out.println("en el parqueadero se encuentran: "+this.motos+" motos, "+this.carros+" carros,"+this.camiones+" camiones.");
        
        System.out.println("quedan "+(150-this.n)+" espacios en el parqueadero");
        
        System.out.println("se realizaron "+this.ContDescuentos+" descuentos");
    }
    
}
