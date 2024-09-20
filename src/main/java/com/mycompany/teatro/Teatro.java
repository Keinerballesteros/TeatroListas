/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.teatro;

import javax.swing.JOptionPane;

/**
 *
 * @author EXITOPC
 */
public class Teatro {
    //Ejecutar Consultar por documento despues de atender
    Nodoscirculares inicio;
    Nodossimple inicioNodo;
    
    
    Teatro(){
    inicio=null;
    inicioNodo=null;
    }

   
    
    public void solicitarTurno( String nombre, String documento, String genero ){
        
        Nodoscirculares nuevo= new Nodoscirculares();
        nuevo.setDocumento(documento);
        nuevo.setNombre(nombre);
        nuevo.setGenero(genero);
        nuevo.setSiguiente(nuevo);
        
        if(inicio==null){
            JOptionPane.showMessageDialog(null, "La lista esta vacia");   
            
               inicio=nuevo;
        
        }else{
            
          nuevo.setSiguiente(inicio);
          
          inicio.setSiguiente(nuevo);
          
          inicio=nuevo;     
        
        }
        
        
        
        
        
        
        
        
    
    
    }
    
    public void imprimir(){        
    Nodoscirculares temporal=inicio;
    
    if(inicio==null){    
        JOptionPane.showMessageDialog(null, "La lista esta vacia");
    
    }
    else{
        
        do{       
              JOptionPane.showMessageDialog(null, "Documento "+
                      temporal.getDocumento()+" Nombre " + temporal.getNombre() +" Genero "+ temporal.getGenero()
                     );
              
              temporal=temporal.getSiguiente();       
        
        }while(temporal!=inicio);
   
    }


    
        
        
        
        }   
    
    
    public void atender(){
        Nodoscirculares temporal=inicio;
       temporal = temporal.getSiguiente(); //Debemos comenzar desde el siguiente nodo despues del inicio, para iterar desde atras hacia delante
        Nodossimple nuevo = new Nodossimple();
        
        do{       
              int numeroDeBoletas = Integer.parseInt(JOptionPane.showInputDialog(null, 
                      " cliente " + temporal.getNombre() + "cuantas boletas va a comprar: (Ingrese un número por favor"
                     ));
              if(numeroDeBoletas<=3){
                  nuevo.setDocumento(temporal.getDocumento());
                  nuevo.setNombre(temporal.getNombre());
                  nuevo.setGenero(temporal.getGenero());
                  nuevo.setNboletas(numeroDeBoletas);
                  
                  if(inicioNodo==null){
                      inicioNodo = nuevo;
                      JOptionPane.showMessageDialog(null, "cliente atendido o atendida");
                  }
                  else{
                    Nodossimple temporalSimple;
                    temporalSimple = inicioNodo;
                    while(temporalSimple.getSiguiente()!=null) {
                    temporalSimple = temporalSimple.getSiguiente();
                    temporalSimple.setSiguiente(nuevo);
                    }
                }
              }
              else{
                  JOptionPane.showMessageDialog(null, "Señor o señora, solo puede comprar un maximo de 3 boletas");
               }
              
              temporal=temporal.getSiguiente();       
        
        }while(temporal!=inicio.getSiguiente());//Se detiene cuando volvemos al inicio
           
    }
    
    public void imprimirListaDeBoletas(){
        Nodossimple temporal = inicioNodo;
        int totalDeBoletas=0;
        int totalDeBoletasHombres = 0;
        int totalDeBoletasMujeres = 0;
        while(temporal !=inicioNodo){
            totalDeBoletas += temporal.getNboletas();
            if(temporal.getGenero().equalsIgnoreCase("M")){
                totalDeBoletasHombres += temporal.getNboletas();
            }
            else if(temporal.getGenero().equalsIgnoreCase("F")){
                totalDeBoletasMujeres += temporal.getNboletas();
            }
            
            temporal = temporal.getSiguiente();
        }
        
        JOptionPane.showMessageDialog(null, "Se vendieron un total de "+totalDeBoletas +" boletas");
        JOptionPane.showMessageDialog(null, "Se vendieron un total de "+totalDeBoletasHombres +" boletas para los hombres" );
        JOptionPane.showMessageDialog(null, "Se vendieron un total de "+totalDeBoletasMujeres +" boletas para las mujeres" );
    }
    
    public void consultarPorDocumento(String documento){
        Nodossimple temporal = inicioNodo;
        boolean encontrado = false;
        while(temporal!=null){
            if(temporal.getDocumento().equalsIgnoreCase(documento)){
                JOptionPane.showMessageDialog(null, "Documento: "+temporal.getDocumento() +" Nombre: "+temporal.getNombre() +" Genero "+temporal.getGenero() + " Numero de boletas compradas" +temporal.getNboletas());
                encontrado = true;
                break;
            }
            
            temporal = temporal.getSiguiente();
        }
        if(encontrado){
            JOptionPane.showMessageDialog(null, "cliente encontrado");
        }
        else{
           JOptionPane.showMessageDialog(null, "cliente no encontrado"); 
        }
    }
    
}
