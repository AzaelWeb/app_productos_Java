/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionproductos;

import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import aplicacionproductos.Productos;
import aplicacionproductos.VentanaProductos;
//import java.util.Date;

/**
 *
 * @author azael
 */
public class Ticket extends JFrame {

    public static JTextArea jTicket;
    JLabel jlabelNoProductos;
    Calendar c1 = Calendar.getInstance();
    Calendar c2 = new GregorianCalendar();

    String dia = Integer.toString(c1.get(Calendar.DATE));
    String mes = Integer.toString(c1.get(Calendar.MONTH));
    String annio = Integer.toString(c1.get(Calendar.YEAR));
    String hora = Integer.toString(c1.get(Calendar.HOUR));
    String minutos = Integer.toString(c1.get(Calendar.MINUTE));
    String segundos = Integer.toString(c1.get(Calendar.SECOND));

    public Ticket() {
        setLayout(null);
        jTicket = new JTextArea();
        jTicket.setBounds(0, 0, 400, 400);
        jTicket.setEditable(false);
        Productos producto = new Productos();
        
        jlabelNoProductos = new JLabel();
        jlabelNoProductos.setBounds(10,10,210,200);
        jlabelNoProductos.setText("Aun no se han agregado productos!");
    
        jTicket.append(" FECHA: " + dia + "/" + mes + "/" + annio + " " + hora + ":" + minutos + ":" + segundos + "\n ");

        for (int i = 0; i < VentanaProductos.arregloProductos.size(); i++) {
            producto = (Productos) VentanaProductos.arregloProductos.get(i);
            // modelo.setValueAt(prod.getNombre(),i, 0);
            jTicket.append(" \nNombre:  " + producto.getNombre());
            jTicket.append(" \nRFC:  " + producto.getRfc());
            jTicket.append(" \nProducto:  " + producto.getNombreProducto());
            jTicket.append(" \nPrecio:  " + producto.getPrecio());
            jTicket.append("\n " + "------------------------------------------------");
            // jTicket.append(""+producto.SumaProductos());

        }
        if (producto.SumaProductos() == 0) {
              add(jlabelNoProductos);   
        } else {
            jTicket.append("\nTotal: " + producto.SumaProductos());
        }

        //  jTicket.append("\n "+"RFC :"+VentanaProductos.txtRfc.getText());
        //  jTicket.append("\n "+"PRODUCTO: "+VentanaProductos.txtNombreProducto.getText());
        //   jTicket.append("\n "+"PRECIO: "+"$"+VentanaProductos.txtPrecio.getText());
        add(jTicket);
    }
}
