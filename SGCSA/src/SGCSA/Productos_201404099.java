package SGCSA;

import java.awt.Color;
import java.awt.Font;
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

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class Pro{
	int codigo;
	double edad;
	String nombre;
	Pro next;
	public Pro(int ele, String no, double eda){
		this.codigo=ele;
		this.nombre=no;
		this.edad=eda;
		
}
}

public class Productos_201404099 extends JFrame implements MouseListener, WindowListener{
	Pro inicio= null;
	int codini=0;
	
	void agregar(int el, String nittt, double tra){
		if (inicio==null)
			inicio=new Pro(el,nittt,tra);
		else{
			Pro tmp=inicio;
			inicio=new Pro(el,nittt,tra);
			inicio.next=tmp;
		}
	}
	void ordenar(){
		int auxi;
		double xx;
		String z;
		Pro tmp = inicio, otro;
		while (tmp!=null){
			otro=tmp.next;
			while (otro!=null){
				if (tmp.codigo>otro.codigo){
				auxi=tmp.codigo;
				xx=tmp.edad;
				z=tmp.nombre;
				tmp.codigo=otro.codigo;
				tmp.nombre=otro.nombre;
				tmp.edad=otro.edad;
				otro.codigo=auxi;
				otro.nombre=z;
				otro.edad=xx;
				}
				otro=otro.next;
				
			}
			tmp=tmp.next;
		}
	}
	void buscar(int codigos){
		Pro tmp=inicio;
		boolean d=false;
		while(tmp!=null){
			if (tmp.codigo==codigos){
				Product[2].setText(tmp.edad + "");
				Product[1].setText(tmp.nombre);
				tmp=null;
				d=true;		
			}
			else
			tmp=tmp.next;
		}
		if (d==false){
		Product[1].setText("");
		Product[2].setText("");
			JOptionPane.showMessageDialog(null,"No existe producto con el codigo: " + Product[0].getText(), "SGCSA Advertencia", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	void mostrar(){
		Pro tmp=inicio;
		do{
			System.out.print("{");
			System.out.print(tmp.codigo + ",");
			System.out.print(tmp.edad+ ",");
			System.out.print(tmp.nombre);
			System.out.println("}");
			tmp=tmp.next;
		}while(tmp!=null);
	}
	void contador(){
		if (inicio!=null){
			codini=inicio.codigo + 1;
			Product[0].setText(codini +"");
		}
		else{
			codini=1;
			Product[0].setText(codini + "");	
		}
	}
		void eliminar(int codi){
			int sum=0;
			ordenar();
			Pro tmp=inicio;
			boolean si=false;
			int joto=JOptionPane.showOptionDialog(null, "Desea eliminar este producto?", "SGCSA", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,null,null );
			if (joto==0){
			try{
				FileWriter w = new FileWriter("C:\\Nueva carpeta\\PRODUCTO.prt");
				BufferedWriter bw = new BufferedWriter(w);
				PrintWriter wr = new PrintWriter(bw);
				wr.close();
				bw.close();
			}catch(IOException e){};
			while (tmp!=null){
				sum++;
				if (tmp.codigo!=codi){
					try{
						FileWriter w = new FileWriter("C:\\Nueva carpeta\\PRODUCTO.prt",true);
						BufferedWriter bw = new BufferedWriter(w);
						PrintWriter wr = new PrintWriter(bw);
						wr.println(sum + ","+ tmp.nombre + ","+ tmp.edad);
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
				Product[1].setText("");
				Product[2].setText("");
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
		        FileReader f = new FileReader("C:\\Nueva carpeta\\PRODUCTO.prt");
		        BufferedReader b = new BufferedReader(f);
		      
		        while((cadena = b.readLine())!=null){
		        	if (cadena.equals("")==false){
		        	numerosComoArray= cadena.split(",");
		        	agregar( Integer.parseInt(numerosComoArray[0]),numerosComoArray[1],Double.parseDouble(numerosComoArray[2]));
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
	JTextField [] Product= new JTextField[3];
	JLabel submit;
	public Productos_201404099(){
	super("SGCSA: Productos");
	urls="";
	
	this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	this.setResizable(false);
	this.setLocation(400, 200);
	this.setSize(473, 387);
	JLabel [] titu= new JLabel[4];
	
	bus = new JLabel(new ImageIcon("C:/Nueva carpeta/bus.png"));
	dele = new JLabel(new ImageIcon("C:/Nueva carpeta/elim.png"));
	men = new JLabel(new ImageIcon("C:/Nueva carpeta/menu.png"));
	JLabel a = new JLabel(new ImageIcon("C:/Nueva carpeta/fond.jpeg"));
	submit = new JLabel(new ImageIcon("C:/Nueva carpeta/save.png"));
	Font fuente=new Font("Dialog", Font.PLAIN, 20);
	Font fue=new Font("Dialog", Font.PLAIN, 30);
	for(int i=0; i<3; i++){
		Product[i] = new JTextField();
		Product[i].setFont(fuente);
		this.add(Product[i]);
	}
	for(int i=0; i<4; i++){
		titu[i] = new JLabel();
		titu[i].setFont(fuente);
		titu[i].setForeground(Color.white);
		this.add(titu[i]);
	}
	titu[0].setText("CODIGO:");
	titu[0].setBounds(30, 100, 100, 30);
	titu[1].setText("DESCRIPCION:");
	titu[1].setBounds(30, 160, 150, 30);
	titu[2].setText("PRECIO:");
	titu[2].setBounds(220, 100, 150, 30);
	titu[3].setText("DATOS DEL PRODUCTO");
	titu[3].setFont(fue);
	titu[3].setBounds(90, 20, 370, 30);
	men.setBounds(5, 5, 64, 64);
	bus.setBounds(30, 240, 64, 64);
	dele.setBounds(196, 240, 64, 64);
	Product[0].setBounds(150, 100, 50, 30);
	Product[1].setBounds(220, 160, 210, 30);
	Product[2].setBounds(330, 100, 100, 30);
	submit.setBounds(366, 240, 64, 64);
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
		Productos_201404099 P = new Productos_201404099();
		
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
			
			buscar(Integer.parseInt(Product[0].getText()));
		}
		if (z.getSource()==dele){
			eliminar(Integer.parseInt(Product[0].getText()));
		}
		if (z.getSource()==submit){	
			if ((Product[1].getText()).equals("") || (Product[2].getText()).equals(""))
				JOptionPane.showMessageDialog(null,"Debe llenar todos los campos", "SGCSA Advertencia", JOptionPane.WARNING_MESSAGE);
			
			else{
				if (Integer.parseInt(Product[0].getText())==codini){
					try{
						FileWriter w = new FileWriter("C:\\Nueva carpeta\\PRODUCTO.prt",true);
						BufferedWriter bw = new BufferedWriter(w);
						PrintWriter wr = new PrintWriter(bw);
						wr.println(Product[0].getText() + ","+ Product[1].getText() + ","+ Product[2].getText());
						wr.close();
						bw.close();
					}catch(IOException e){};
					Product[1].setText("");
					Product[2].setText("");
					inicio=null;
					jalar();
					contador();	
					JOptionPane.showMessageDialog(null,"Datos ingresados exitosamente", "SGCSA", JOptionPane.PLAIN_MESSAGE);
					
				}
				else{
					
					JOptionPane.showMessageDialog(null,"Este codigo no es valido, el codigo valido es: "+codini, "SGCSA Advertencia", JOptionPane.WARNING_MESSAGE);
					Product[0].setText(codini +"");
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
