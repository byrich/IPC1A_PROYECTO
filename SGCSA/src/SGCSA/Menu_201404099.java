package SGCSA;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Menu_201404099 extends JFrame implements MouseListener {
		JLabel clientes;
		JLabel productos;
		JLabel empleados;
		JLabel venta;
		JLabel reporte;
		public  Menu_201404099(){
		super("Menú");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(200, 200);
		this.setSize(805, 360);
		clientes = new JLabel(new ImageIcon("C:/Nueva carpeta/clientes.png"));
		JLabel a = new JLabel(new ImageIcon("C:/Nueva carpeta/fond.jpeg"));
		productos = new JLabel(new ImageIcon("C:/Nueva carpeta/productos.png"));
		empleados = new JLabel(new ImageIcon("C:/Nueva carpeta/empleados.png"));
		venta = new JLabel(new ImageIcon("C:/Nueva carpeta/ventas.png"));
		reporte = new JLabel(new ImageIcon("C:/Nueva carpeta/reporte.png"));
		clientes.setBounds(10, 10, 250, 150);
		productos.setBounds(270, 10, 250, 150);
		empleados.setBounds(530, 10, 250, 150);
		venta.setBounds(150, 170, 250, 150);
		reporte.setBounds(415, 170, 250, 150);
		a.setBackground(Color.GRAY);
		//submit.addActionListener(this);
		this.add(clientes);
		this.add(productos);
		this.add(empleados);
		this.add(venta);
		this.add(reporte);
		clientes.addMouseListener(this);
		empleados.addMouseListener(this);
		productos.addMouseListener(this);
		venta.addMouseListener(this);
		reporte.addMouseListener(this);
		
		this.add(a);
		this.setVisible(true);
		}
		public static void main (String[] args){
			Menu_201404099 m = new Menu_201404099();
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent z) {
			if (z.getSource()==clientes){			
			clientes.setIcon(new ImageIcon("C:/Nueva carpeta/clientes1.png"));
			}	
			if (z.getSource()==productos){			
				productos.setIcon(new ImageIcon("C:/Nueva carpeta/productos1.png"));
				}	
			if (z.getSource()==empleados){			
				empleados.setIcon(new ImageIcon("C:/Nueva carpeta/empleados1.png"));
				}	
			if (z.getSource()==venta){			
				venta.setIcon(new ImageIcon("C:/Nueva carpeta/ventas1.png"));
				}	
			if (z.getSource()==reporte){			
				reporte.setIcon(new ImageIcon("C:/Nueva carpeta/reporte1.png"));
				}	
			
		}
		@Override
		public void mouseExited(MouseEvent z) {
			if (z.getSource()==clientes){			
				clientes.setIcon(new ImageIcon("C:/Nueva carpeta/clientes.png"));
				}	
			if (z.getSource()==productos){			
				productos.setIcon(new ImageIcon("C:/Nueva carpeta/productos.png"));
				}	
			if (z.getSource()==empleados){			
				empleados.setIcon(new ImageIcon("C:/Nueva carpeta/empleados.png"));
				}	
			if (z.getSource()==venta){			
				venta.setIcon(new ImageIcon("C:/Nueva carpeta/ventas.png"));
				}	
			if (z.getSource()==reporte){			
				reporte.setIcon(new ImageIcon("C:/Nueva carpeta/reporte.png"));
				}	
			
		}
		@Override
		public void mousePressed(MouseEvent z) {
			if (z.getSource()==clientes){			
				this.setVisible(false);
				this.dispose();
				Clientes_201404099.main(null);
				}
			if (z.getSource()==empleados){			
				this.setVisible(false);
				this.dispose();
				Empleado_201404099.main(null);
				}
			if (z.getSource()==productos){			
				this.setVisible(false);
				this.dispose();
				Productos_201404099.main(null);
				}
			if (z.getSource()==venta){			
				this.setVisible(false);
				this.dispose();
				Ventas_201404099.main(null);
				}
			if (z.getSource()==reporte){			
				this.setVisible(false);
				this.dispose();
				Reporte_201404099.main(null);
				}
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		}
