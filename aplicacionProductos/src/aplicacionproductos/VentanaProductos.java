/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionproductos;

import aplicacionproductos.Productos;
import aplicacionproductos.AplicacionProductos;
import static aplicacionproductos.AplicacionProductos.modelo;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author azael
 */
public class VentanaProductos extends JFrame {

    private JLabel jlNombre, jlRfc, jlNombreProducto, jlPrecio;
    public static JTextField txtNombre, txtRfc, txtNombreProducto, txtPrecio;
    private JButton btnGuardar, btnMostrarProductos, btnDescuento;
    public static ArrayList arregloProductos = new ArrayList();
    Productos producto = new Productos();
    public static float descuento = 0;
    public static int porcentaje = 0;
   // public static float n = 0;//  private JButton btnAgregarProducto, btnCancelar, btnCobrar;
            //private JButton btn7,btn8,btn9,btn4,btn5,btn6,btn1,btn2,btn3;


    public VentanaProductos() {
        setLayout(null);
        jlNombre = new JLabel();
        jlNombre.setText("Nombre:");
        jlNombre.setBounds(10, 10, 200, 30);
        add(jlNombre);

        jlRfc = new JLabel();
        jlRfc.setText("Rfc:");
        jlRfc.setBounds(10, 45, 200, 30);
        add(jlRfc);

        jlNombreProducto = new JLabel();
        jlNombreProducto.setText("Producto:");
        jlNombreProducto.setBounds(10, 80, 200, 30);
        add(jlNombreProducto);

        jlPrecio = new JLabel();
        jlPrecio.setText("Precio:");
        jlPrecio.setBounds(10, 120, 200, 30);
        add(jlPrecio);

        txtNombre = new JTextField();
        txtNombre.setBounds(70, 15, 130, 20);
        add(txtNombre);

        txtRfc = new JTextField();
        txtRfc.setBounds(70, 50, 130, 20);
        add(txtRfc);

        txtNombreProducto = new JTextField();
        txtNombreProducto.setBounds(70, 85, 130, 20);
        add(txtNombreProducto);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(70, 125, 130, 20);
        add(txtPrecio);

        btnGuardar = new JButton();
        btnGuardar.setText("Guardar Producto");
        btnGuardar.setBounds(5, 200, 140, 25);
        add(btnGuardar);
        //btnGuardar.addActionListener(this);

        btnMostrarProductos = new JButton();
        btnMostrarProductos.setText("Mostrar Productos");
        btnMostrarProductos.setBounds(150, 200, 144, 25);
        add(btnMostrarProductos);
        //btnMostrarProductos.addActionListener(this);

        btnDescuento = new JButton();
        btnDescuento.setText("Descuento");
        btnDescuento.setBounds(220, 80, 100, 25);
        add(btnDescuento);

        btnDescuento.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String prec = txtPrecio.getText();

                if (prec.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingresa primero el precio, para hacer un descuento ", "Ingresa un precio", JOptionPane.ERROR_MESSAGE);
                } else {
                    porcentaje = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el descuento"));
                    producto.setPrecio(Float.parseFloat(prec));
                    descuento = producto.getPrecio() - (producto.getPrecio() * porcentaje / 100);
                   // n = descuento - producto.SumaProductos();
                    System.out.println(descuento);
                }

            }
        });

        btnGuardar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String nom = txtNombre.getText();
                String rfc = txtRfc.getText();
                String nomProd = txtNombreProducto.getText();
                String prec = txtPrecio.getText();

                if (!nom.isEmpty()) {
                    if (!rfc.isEmpty()) {
                        if (!nomProd.isEmpty()) {
                            if (!prec.isEmpty()) {
                                Productos nuevo_producto = new Productos();
                                nuevo_producto.setNombre(nom);
                                nuevo_producto.setRfc(rfc);
                                nuevo_producto.setNombreProducto(nomProd);
                                nuevo_producto.setPrecio(Float.parseFloat(prec));
                                arregloProductos.add(nuevo_producto);
                                JOptionPane.showMessageDialog(null, "Producto capturado con exito!");

                            } else {
                                JOptionPane.showMessageDialog(null, "Debes ingresar el precio del producto", "Ingresa los datos", JOptionPane.WARNING_MESSAGE);
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Debes ingresar el nombre del producto", "Ingresa los datos", JOptionPane.WARNING_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Debes ingresar el rfc!", "Ingresa los datos", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debes ingresar un nombre!", "Ingresa los datos", JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        btnMostrarProductos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object O[] = null;

                if (arregloProductos.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debes ingresar y guardar primero los datos", "Datos no ingresados", JOptionPane.ERROR_MESSAGE);
                } else {
                    for (int i = 0; i < arregloProductos.size(); i++) {
                        Productos prod = (Productos) arregloProductos.get(i);
                        modelo.addRow(O);
                        modelo.setValueAt(prod.getNombre(), i, 0);
                        modelo.setValueAt(prod.getRfc(), i, 1);
                        modelo.setValueAt(prod.getNombreProducto(), i, 2);
                        modelo.setValueAt(prod.getPrecio(), i, 3);
                    }
                }

            }

        });
    }
}
