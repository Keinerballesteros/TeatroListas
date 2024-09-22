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

    public void solicitarTurno(String nombre, String documento, String genero ){
        
        Nodoscirculares nuevo= new Nodoscirculares();
        nuevo.setDocumento(documento);
        nuevo.setNombre(nombre);
        nuevo.setGenero(genero);
        nuevo.setSiguiente(nuevo);
        
        if(inicio==null){
            JOptionPane.showMessageDialog(null, "Hola bienvenido, eres el primero en llegar");   
            
               inicio=nuevo;
        }else{
           Nodoscirculares temporal = inicio;
           
           while(temporal.getSiguiente()!=inicio){
               temporal = temporal.getSiguiente();
           }
           // Enlazar el nuevo nodo al final
           temporal.setSiguiente(nuevo);
           nuevo.setSiguiente(inicio);
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
    public int atender(int numeroBoletas) {
    Nodoscirculares temporal = inicio;

    if (temporal == null) {
        JOptionPane.showMessageDialog(null, "La lista está vacía");
        return 0; // No hay clientes para atender
    }

    int totalBoletasAtendidas = 0;

    do {
        // Crear un nuevo nodo para cada cliente
        
        int numeroDeBoletasPorCliente;

        try {
            numeroDeBoletasPorCliente = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "Cliente " + temporal.getNombre() + ", ¿cuántas boletas va a comprar? (Ingrese un número por favor)"));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Debe ingresar un número.");
            continue; // Vuelve a preguntar
        }

        if (numeroDeBoletasPorCliente <= 3) {
            if (numeroDeBoletasPorCliente <= numeroBoletas) {
                Nodossimple nuevo = new Nodossimple();
                nuevo.setDocumento(temporal.getDocumento());
                nuevo.setNombre(temporal.getNombre());
                nuevo.setGenero(temporal.getGenero());
                nuevo.setNboletas(numeroDeBoletasPorCliente);

                // Actualiza el número de boletas disponibles
                numeroBoletas -= numeroDeBoletasPorCliente;
                totalBoletasAtendidas += numeroDeBoletasPorCliente;

                if (inicioNodo == null) {
                    inicioNodo = nuevo;
                    nuevo.setSiguiente(null); // Opcional si es el único nodo
                } else {
                    Nodossimple temporalSimple = inicioNodo;
                    while (temporalSimple.getSiguiente() != null) {
                        temporalSimple = temporalSimple.getSiguiente();
                    }
                    temporalSimple.setSiguiente(nuevo);
                    nuevo.setSiguiente(null); // Opcional
                }
                JOptionPane.showMessageDialog(null, "Cliente atendido o atendida");
            } else {
                JOptionPane.showMessageDialog(null, "Las boletas se agotaron");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Señor o señora, solo puede comprar un máximo de 3 boletas");
        }

        temporal = temporal.getSiguiente();
    } while (temporal != inicio); // Se detiene cuando volvemos al inicio

    return totalBoletasAtendidas; // Retorna el total de boletas atendidas
}
    public void imprimirListaDeBoletas(){
        Nodossimple temporal = inicioNodo;
        int totalDeBoletas=0;
        int totalDeBoletasHombres = 0;
        int totalDeBoletasMujeres = 0;
        while(temporal !=null){
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
