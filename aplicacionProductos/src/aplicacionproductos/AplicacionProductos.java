/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionproductos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import aplicacionproductos.VentanaProductos;
import java.awt.Color;
import aplicacionproductos.Productos;
import javax.swing.table.DefaultTableModel;
import aplicacionproductos.Ticket;
import aplicacionproductos.Ticket;

public class AplicacionProductos extends JFrame implements ActionListener {

    private JButton btnAgregarProducto, btnCancelar, btnCobrar;
    // private JButton btn7,btn8,btn9,btn4,btn5,btn6,btn1,btn2,btn3;
    // private JPanel jpanel;
    //creando el JTable
    //  Object titulos [] = {"Nombre","Rfc","Producto","Precio"};
    // Object celdas [][] = new Object[10][4];
    JScrollPane scroll = new JScrollPane();
    JTable tabla = new JTable();

    public AplicacionProductos() {
        setLayout(null);
        //propiedades del JTable
        scroll.setViewportView(tabla);
        scroll.setBounds(10, 10, 280, 200);
        add(scroll);
        Crear_Modelo();

        btnAgregarProducto = new JButton();
        btnAgregarProducto.setText("Agregar producto");
        btnAgregarProducto.setBounds(300, 10, 150, 40);
        btnAgregarProducto.setBackground(Color.decode("#0069BB"));
        //Cambiar el color del texto
        btnAgregarProducto.setForeground(Color.WHITE);
        add(btnAgregarProducto);
        btnAgregarProducto.addActionListener(this);

        btnCancelar = new JButton();
        btnCancelar.setText("Cancelar");
        btnCancelar.setBounds(300, 60, 150, 40);
        btnCancelar.setBackground(Color.decode("#8C0000"));
        //cambiar el color del texto
        btnCancelar.setForeground(Color.WHITE);
        add(btnCancelar);

        btnCobrar = new JButton();
        btnCobrar.setText("Generar Ticket");
        btnCobrar.setBounds(300, 120, 150, 40);
        btnCobrar.setBackground(Color.decode("#008C17"));
        btnCobrar.setForeground(Color.WHITE);
        add(btnCobrar);

        btnCobrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               Ticket ticket = new Ticket();
               ticket.setVisible(true);
               ticket.setBounds(100,100,260,400);
               
            }

        });
        
        btnCancelar.addActionListener(new ActionListener(){
            Productos producto = new Productos();
           public void actionPerformed(ActionEvent e){
              for(int i = 0; i < VentanaProductos.arregloProductos.size(); i++){
                  producto = (Productos) VentanaProductos.arregloProductos.remove(i);
                 JOptionPane.showMessageDialog(null,"Se elimino el producto "+producto.getNombreProducto());
              }
           } 
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAgregarProducto) {
            VentanaProductos vp = new VentanaProductos();
            vp.setVisible(true);
            vp.setSize(350, 300);

        }
    }
    //Modelo para las filas y columnas del JTable
    public static DefaultTableModel modelo;

    private void Crear_Modelo() {
        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Nombre", "RFC", "Producto", "Precio"}) {
                Class[] types = new Class[]{
                    java.lang.String.class, java.lang.String.class,
                    java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
            //establecemos el modelo en el JTable
            tabla.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error2");
        }
    }

    public static void main(String[] args) {
        AplicacionProductos app = new AplicacionProductos();
        app.setVisible(true);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
        app.setSize(500, 500);

    }

}
