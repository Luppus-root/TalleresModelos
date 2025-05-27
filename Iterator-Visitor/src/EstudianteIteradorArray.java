/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.miempresa.politicosapp.iterador;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author estudiantes
 */
public class EstudianteIteradorArray implements Iterator{

  private ArrayList<Estudiante> estudiantesArray;
  private int posicionActual;
  private Notificador notificador;
  
  
  public EstudianteIteradorArray(){
      
      this.posicionActual = 0;
      this.estudiantesArray = new ArrayList<Estudiante>();
  }
  
    public boolean hasNext() {
        
        return this.posicionActual < estudiantesArray.size();
    
    }

    @Override
    public Object next() {
        
       if (!this.hasNext()){
           
           return null;
       }
       
       notificador = new Notificador();
       boolean falta;
       
       for (Estudiante estudiante: estudiantesArray ){
       
           
           String codigoEstudiante = estudiantesArray.get(posicionActual).getCodigo();
       notificador.enviarMensaje(codigoEstudiante);  
       }
       

       
       
    
    }
    
}
