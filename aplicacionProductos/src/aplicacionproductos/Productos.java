/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionproductos;
import aplicacionproductos.VentanaProductos;
import aplicacionproductos.Ticket;
import static aplicacionproductos.VentanaProductos.arregloProductos;
/**
 *
 * @author azael
 */
public class Productos {
    String nombre;
    String rfc;
    String nombreProducto;
    float precio;
  
    
    
    public  String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getRfc(){
       return rfc; 
    }
    
    public void setRfc(String rfc){
        
        this.rfc = rfc;
    }
    
    public String getNombreProducto(){
        return nombreProducto;
    }
    
    public void setNombreProducto(String nombreProducto){
        this.nombreProducto = nombreProducto;
    }
    
    public float getPrecio(){
        return precio;
    }
    
    public void setPrecio(float precio){
        this.precio = precio;
        
    }
    //sumar productos
   public float SumaProductos(){
       float precioTotal = 0;
       Productos producto = new Productos();
       
       

       for(int i = 0; i<arregloProductos.size(); i++){
           producto = (Productos) VentanaProductos.arregloProductos.get(i);
           
         precioTotal += producto.getPrecio();
          
       }
      
       
       return precioTotal;
   }
    
}
