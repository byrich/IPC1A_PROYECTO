
	package SGCSA;
	import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

	class Nodo{
		int codigo;
		String nombre,apellido,nitt;
		Nodo next;
		public Nodo(int ele, String no,String ap,String ni){
			this.codigo=ele;
			this.nombre=no;
			this.apellido=ap;
			this.nitt=ni;
	}
	}
	
	public class Clientes_201404099 extends JFrame implements MouseListener, WindowListener{
		Nodo inicio= null;
		int codini=0;
		
		void agregar(int el, String n,String a,String nittt){
			if (inicio==null)
				inicio=new Nodo(el,n,a,nittt);
			else{
				Nodo tmp=inicio;
				inicio=new Nodo(el,n,a,nittt);
				inicio.next=tmp;
			}
		}
		void ordenar(){
			int auxi;
			String x,y,z;
			Nodo tmp = inicio, otro;
			while (tmp!=null){
				otro=tmp.next;
				while (otro!=null){
					if (tmp.codigo>otro.codigo){
					auxi=tmp.codigo;
					x=tmp.nombre;
					y=tmp.apellido;
					z=tmp.nitt;
					tmp.codigo=otro.codigo;
					tmp.nombre=otro.nombre;
					tmp.apellido=otro.apellido;
					tmp.nitt=otro.nitt;
					otro.codigo=auxi;
					otro.nombre=x;
					otro.apellido=y;
					otro.nitt=z;
					
					}
					otro=otro.next;
					
				}
				tmp=tmp.next;
			}
		}
		void buscar(int codi){
			Nodo tmp=inicio;
			boolean d=false;
			while(tmp!=null){
				if (tmp.codigo==codi){
					nuevoCliente[1].setText(tmp.nombre);
					nuevoCliente[2].setText(tmp.apellido);
					nuevoCliente[3].setText(tmp.nitt);
					tmp=null;
					d=true;
				}
				else
				tmp=tmp.next;
			}
			if (d==false){
				nuevoCliente[1].setText("");
			nuevoCliente[2].setText("");
			nuevoCliente[3].setText("");
				JOptionPane.showMessageDialog(null,"No existe cliente con el codigo: " + nuevoCliente[0].getText(), "SGCSA Advertencia", JOptionPane.WARNING_MESSAGE);
			}
		}
		void mostrar(){
			Nodo tmp=inicio;
			do{
				System.out.print("{");
				System.out.print(tmp.codigo + ",");
				System.out.print(tmp.nombre+ ",");
				System.out.print(tmp.apellido+ ",");
				System.out.print(tmp.nitt);
				System.out.println("}");
				tmp=tmp.next;
			}while(tmp!=null);
		}
		void contador(){
			if (inicio!=null){
				codini=inicio.codigo + 1;
				nuevoCliente[0].setText(codini +"");
			}
			else{
				codini=1;
				nuevoCliente[0].setText(codini + "");	
			}
		}
			void eliminar(int codi){
				int sum=0;
				ordenar();
				Nodo tmp=inicio;
				boolean si=false;
				int joto=JOptionPane.showOptionDialog(null, "Desea eliminar este cliente?", "SGCSA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,null,null );
				if (joto==0){
				try{
					FileWriter w = new FileWriter("C:\\Nueva carpeta\\CLIENTES.clt");
					BufferedWriter bw = new BufferedWriter(w);
					PrintWriter wr = new PrintWriter(bw);
					wr.close();
					bw.close();
				}catch(IOException e){};
				while (tmp!=null){
					sum++;
					if (tmp.codigo!=codi){
						try{
							FileWriter w = new FileWriter("C:\\Nueva carpeta\\CLIENTES.clt",true);
							BufferedWriter bw = new BufferedWriter(w);
							PrintWriter wr = new PrintWriter(bw);
							wr.println(sum + ","+ tmp.nombre + ","+ tmp.apellido + ","+ tmp.nitt);
							wr.close();
							bw.close();
						}catch(IOException e){};
						
					}
					else{
						sum=sum-1;
						si=true;
					}
					tmp=tmp.next;
				}
				if (si){
					nuevoCliente[1].setText("");
					nuevoCliente[2].setText("");
					nuevoCliente[3].setText("");
					JOptionPane.showMessageDialog(null,"Datos eliminado exitosamente", "SGCSA", JOptionPane.PLAIN_MESSAGE);
				}
				else{
					JOptionPane.showMessageDialog(null,"Dato no encontrado, ni eliminado", "SGCSA", JOptionPane.PLAIN_MESSAGE);
				}
				inicio=null;
				sum=0;
				jalar();
				contador();
				}
				
			}
		void jalar(){
			try {
				   String cadena;
				   String[] numerosComoArray = null;
			        FileReader f = new FileReader("C:\\Nueva carpeta\\CLIENTES.clt");
			        BufferedReader b = new BufferedReader(f);
			    
			        while((cadena = b.readLine())!=null){
			        	if (cadena.equals("")==false){
			        	numerosComoArray= cadena.split(",");
			        	agregar( Integer.parseInt(numerosComoArray[0]),numerosComoArray[1],numerosComoArray[2],numerosComoArray[3]);
			        	}
			            	}
			        b.close();
			} catch (FileNotFoundException e) {e.printStackTrace();
			} catch (IOException e) {e.printStackTrace();
		}
		}
		String urls;
		
		JLabel men;
		JLabel bus;
		JLabel dele;
		JTextField [] nuevoCliente = new JTextField[4];
		JLabel submit;
		public Clientes_201404099(){
		super("SGCSA: Clientes");
		urls="";
		
		this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		this.setLocation(400, 200);
		this.setSize(429, 384);
		JLabel [] titu= new JLabel[5];
		bus = new JLabel(new ImageIcon("C:/Nueva carpeta/bus.png"));
		dele = new JLabel(new ImageIcon("C:/Nueva carpeta/elim.png"));
		men = new JLabel(new ImageIcon("C:/Nueva carpeta/menu.png"));
		JLabel a = new JLabel(new ImageIcon("C:/Nueva carpeta/fond.jpeg"));
		submit = new JLabel(new ImageIcon("C:/Nueva carpeta/save.png"));
		Font fuente=new Font("Dialog", Font.PLAIN, 20);
		Font fue=new Font("Dialog", Font.PLAIN, 30);
		for(int i=0; i<4; i++){
			nuevoCliente[i] = new JTextField();
			nuevoCliente[i].setFont(fuente);
			this.add(nuevoCliente[i]);
		}
		for(int i=0; i<5; i++){
			titu[i] = new JLabel();
			titu[i].setFont(fuente);
			titu[i].setForeground(Color.white);
			this.add(titu[i]);
		}
		titu[0].setText("CODIGO:");
		titu[0].setBounds(30, 100, 100, 30);
		titu[1].setText("NOMBRE:");
		titu[1].setBounds(30, 160, 100, 30);
		titu[2].setText("APELLIDO:");
		titu[2].setBounds(30, 220, 150, 30);
		titu[3].setText("NIT:");
		titu[4].setFont(fue);
		titu[3].setBounds(30, 280, 100, 30);
		titu[4].setText("DATOS DEL CLIENTE");
		titu[4].setBounds(90, 20, 350, 30);
		men.setBounds(5, 5, 64, 64);
		bus.setBounds(320, 100, 64, 64);
		dele.setBounds(320, 173, 64, 64);
		nuevoCliente[0].setBounds(150, 100, 50, 30);
		nuevoCliente[1].setBounds(150, 160, 100, 30);
		nuevoCliente[2].setBounds(150, 220, 100, 30);
		nuevoCliente[3].setBounds(150, 280, 100, 30);
		submit.setBounds(320, 246, 64, 64);
		a.setBackground(Color.GRAY);
		bus.addMouseListener(this);
		dele.addMouseListener(this);
		men.addMouseListener(this);
		submit.addMouseListener(this);
		jalar();
		contador();
		this.add(bus);
		this.add(dele);
		
		this.add(men);
		this.add(submit);
		this.add(a);
		this.setVisible(true);
		this.addWindowListener(this);
		}
		public static void main (String[] args){
			Clientes_201404099 c = new Clientes_201404099();
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			if (e.getSource()==submit){
				submit.setIcon(new ImageIcon("C:/Nueva carpeta/save1.png"));
			}
			if (e.getSource()==men){
				men.setIcon(new ImageIcon("C:/Nueva carpeta/menu1.png"));
			}
			if (e.getSource()==bus){
				bus.setIcon(new ImageIcon("C:/Nueva carpeta/bus1.png"));
			}
			if (e.getSource()==dele){
				dele.setIcon(new ImageIcon("C:/Nueva carpeta/elim1.png"));
			}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			if (e.getSource()==submit){
				submit.setIcon(new ImageIcon("C:/Nueva carpeta/save.png"));
			}
			if (e.getSource()==men){
				men.setIcon(new ImageIcon("C:/Nueva carpeta/menu.png"));
			}
			if (e.getSource()==bus){
				bus.setIcon(new ImageIcon("C:/Nueva carpeta/bus.png"));
			}
			if (e.getSource()==dele){
				dele.setIcon(new ImageIcon("C:/Nueva carpeta/elim.png"));
			}
		}
		@Override
		public void mousePressed(MouseEvent z) {
			if (z.getSource()==men){	
				this.setVisible(false);
				this.dispose();
				Menu_201404099.main(null);		
			}
			if (z.getSource()==bus){
				buscar(Integer.parseInt(nuevoCliente[0].getText()));
			}
			if (z.getSource()==dele){
				eliminar(Integer.parseInt(nuevoCliente[0].getText()));
			}
			if (z.getSource()==submit){	
				if ((nuevoCliente[1].getText()).equals("") || (nuevoCliente[2].getText()).equals("")||(nuevoCliente[3].getText()).equals(""))
					JOptionPane.showMessageDialog(null,"Debe llenar todos los campos", "SGCSA Advertencia", JOptionPane.WARNING_MESSAGE);
				
				else{
					if (Integer.parseInt(nuevoCliente[0].getText())==codini){
						try{
							FileWriter w = new FileWriter("C:\\Nueva carpeta\\CLIENTES.clt",true);
							BufferedWriter bw = new BufferedWriter(w);
							PrintWriter wr = new PrintWriter(bw);
							wr.println(nuevoCliente[0].getText() + ","+ nuevoCliente[1].getText() + ","+ nuevoCliente[2].getText() + ","+ nuevoCliente[3].getText());
							wr.close();
							bw.close();
						}catch(IOException e){};
						nuevoCliente[1].setText("");
						nuevoCliente[2].setText("");
						nuevoCliente[3].setText("");
						inicio=null;
						jalar();
						contador();	
						JOptionPane.showMessageDialog(null,"Datos ingresados exitosamente", "SGCSA", JOptionPane.PLAIN_MESSAGE);
						
					}
					else{
						
						JOptionPane.showMessageDialog(null,"Este codigo no es valido, el codigo valido es: "+codini, "SGCSA Advertencia", JOptionPane.WARNING_MESSAGE);
						nuevoCliente[0].setText(codini +"");
					}
					
				}
				
				
				}				
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void windowClosing(WindowEvent arg0) {
			Menu_201404099.main(null);		
		}
		@Override
		public void windowDeactivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void windowDeiconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void windowIconified(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void windowOpened(WindowEvent arg0) {
			
			
		}
		}

