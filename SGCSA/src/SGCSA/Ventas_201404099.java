package SGCSA;
	import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class ven{
	int producto,cantidad,empelado,cliente;
	String fechass;
	ven next;
	public ven(int ele, String no,int cantidas, int emple,int client){
		this.producto=ele;
		this.fechass=no;
		this.cantidad=cantidas;
		this.empelado=emple;
		this.cliente=client;
}
}
class cli{
	int clicodigo;
	String clinombre,cliapellido,clinitt;
	cli clinext;
	public cli(int ele, String no,String ap,String ni){
		this.clicodigo=ele;
		this.clinombre=no;
		this.cliapellido=ap;
		this.clinitt=ni;
}
}
class Prod{
	int prodcodigo;
	double prodedad;
	String prodnombre;
	Prod nexta;
	public Prod(int ele, String no, double eda){
		this.prodcodigo=ele;
		this.prodnombre=no;
		this.prodedad=eda;
		
}
}
class empo{
	int empocodigo;
	int empoedad;
	String emponombre,empoapellido,empocargo;
	empo next;
	public empo(int ele, String no,String ap, int eda,String ni){
		this.empocodigo=ele;
		this.emponombre=no;
		this.empoapellido=ap;
		this.empoedad=eda;
		this.empocargo=ni;
}
}
public class Ventas_201404099 extends JFrame implements MouseListener, WindowListener, KeyListener{
	ven inicio= null;
	cli start=null;
	empo beging=null;
	Prod ichi=null;
	void agregarclien(int el, String n,String a,String nittt){
		if (start==null)
			start=new cli(el,n,a,nittt);
		else{
			cli tmp=start;
			start=new cli(el,n,a,nittt);
			start.clinext=tmp;
		}
	}
	void jalarclien(){
		try {
			   String cadena;
			   String[] numerosComoArray = null;
		        FileReader f = new FileReader("C:\\Nueva carpeta\\CLIENTES.clt");
		        BufferedReader b = new BufferedReader(f);
		    
		        while((cadena = b.readLine())!=null){
		        	if (cadena.equals("")==false){
		        	numerosComoArray= cadena.split(",");
		        	agregarclien( Integer.parseInt(numerosComoArray[0]),numerosComoArray[1],numerosComoArray[2],numerosComoArray[3]);
		        	}
		            	}
		        b.close();
		} catch (FileNotFoundException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();
	}
	}
	void buscarclien(int codi){
		cli tmp=start;
		boolean d=false;
		while(tmp!=null){
			if (tmp.clicodigo==codi){
				venta[7].setText(tmp.clinombre);
				tmp=null;
				d=true;
			}
			else
			tmp=tmp.clinext;
		}
		if (d==false){
			venta[7].setText("null");
		}
	}
	
	void agregaremplea(int el, String n,String a,int edad,String nittt){
		if (beging==null)
			beging=new empo(el,n,a,edad, nittt);
		else{
			empo tmp=beging;
			beging=new empo(el,n,a,edad,nittt);
			beging.next=tmp;
		}
	}
	void buscaremplea(int codigos){
		empo tmp=beging;
		boolean d=false;
		while(tmp!=null){
			if (tmp.empocodigo==codigos){
				venta[6].setText(tmp.emponombre);
				tmp=null;
				d=true;		
			}
			else
			tmp=tmp.next;
		}
		if (d==false){
			venta[6].setText("null");
		}
	}
	void jalaremplea(){
		try {
			   String cadena;
			   String[] numerosComoArray = null;
		        FileReader f = new FileReader("C:\\Nueva carpeta\\EMPLEADO.emp");
		        BufferedReader b = new BufferedReader(f);
		      
		        while((cadena = b.readLine())!=null){
		        	if (cadena.equals("")==false){
		        	numerosComoArray= cadena.split(",");
		        	agregaremplea( Integer.parseInt(numerosComoArray[0]),numerosComoArray[1],numerosComoArray[2],Integer.parseInt(numerosComoArray[3]),numerosComoArray[4]);
		        	}
		            	}
		        b.close();
		} catch (FileNotFoundException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();
	}
	}
	void agregarprod(int el, String nittt, double tra){
		if (ichi==null)
			ichi=new Prod(el,nittt,tra);
		else{
			Prod tmpo=ichi;
			ichi=new Prod(el,nittt,tra);
			ichi.nexta=tmpo;
		}
	}
	void jalarprod(){
		try {
			   String cadena;
			   String[] numerosComoArray = null;
		        FileReader f = new FileReader("C:\\Nueva carpeta\\PRODUCTO.prt");
		        BufferedReader b = new BufferedReader(f);
		      
		        while((cadena = b.readLine())!=null){
		        	if (cadena.equals("")==false){
		        	numerosComoArray= cadena.split(",");
		        	agregarprod( Integer.parseInt(numerosComoArray[0]),numerosComoArray[1],Double.parseDouble(numerosComoArray[2]));
		        	}
		            	}
		        b.close();
		} catch (FileNotFoundException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();
	}
	}

	void buscarprod(int codigos){
		Prod tmp=ichi;
		boolean d=false;
		while(tmp!=null){
			if (tmp.prodcodigo==codigos){
				venta[5].setText(tmp.prodnombre);
				tmp=null;
				d=true;		
			}
			else
			tmp=tmp.nexta;
		}
		if (d==false){
			venta[5].setText("null");
		}
	}
	
	void agregar(int ele, String no,int cantidas, int emple,int client){
		if (inicio==null)
			inicio=new ven(ele,no,cantidas,emple, client);
		else{
			ven tmp=inicio;
			inicio=new ven(ele,no,cantidas,emple, client);
			inicio.next=tmp;
		}
	}
	
	void jalar(){
		try {
			   String cadena;
			   String[] numerosComoArray = null;
		        FileReader f = new FileReader("C:\\Nueva carpeta\\VENTA.fct");
		        BufferedReader b = new BufferedReader(f);
		      
		        while((cadena = b.readLine())!=null){
		        	if (cadena.equals("")==false){
		        	numerosComoArray= cadena.split(",");
		        	agregar( Integer.parseInt(numerosComoArray[0]),numerosComoArray[1],Integer.parseInt(numerosComoArray[2]),Integer.parseInt(numerosComoArray[3]),Integer.parseInt(numerosComoArray[4]));
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
	JTextField [] venta= new JTextField[8];
	JLabel submit;
	public Ventas_201404099(){
	super("SGCSA: Ventas");
	urls="";
	Calendar fecha = new GregorianCalendar();
	this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	this.setResizable(false);
	this.setLocation(400, 200);
	this.setSize(473, 441);
	JLabel [] titu= new JLabel[6];
	men = new JLabel(new ImageIcon("C:/Nueva carpeta/menu.png"));
	JLabel a = new JLabel(new ImageIcon("C:/Nueva carpeta/fond.jpeg"));
	submit = new JLabel(new ImageIcon("C:/Nueva carpeta/save.png"));
	Font fuente=new Font("Dialog", Font.PLAIN, 20);
	Font fue=new Font("Dialog", Font.PLAIN, 30);
	for(int i=0; i<8; i++){
		venta[i] = new JTextField();
		venta[i].setFont(fuente);
		this.add(venta[i]);
	}
	for(int i=0; i<6; i++){
		titu[i] = new JLabel();
		titu[i].setFont(fuente);
		titu[i].setForeground(Color.white);
		this.add(titu[i]);
	}
	titu[0].setText("FECHA:");
	titu[0].setBounds(30, 100, 150, 30);
	titu[1].setText("PRODUCTO:");
	titu[1].setBounds(30, 160, 150, 30);
	titu[2].setText("CANTIDAD:");
	titu[2].setBounds(30, 220, 150, 30);
	titu[3].setText("EMPLEADO:");
	titu[3].setBounds(30, 280, 150, 30);
	titu[4].setText("CLIENTE:");
	titu[4].setBounds(30, 340, 100, 30);
	titu[5].setText("DATOS DE VENTA");
	titu[5].setFont(fue);
	titu[5].setBounds(90, 20, 350, 30);
	men.setBounds(5, 5, 64, 64);
	venta[0].setBounds(170, 100, 100, 30);
	venta[1].setBounds(170, 160, 100, 30);
	venta[0].setText(fecha.get(Calendar.DAY_OF_MONTH)+"."+(fecha.get(Calendar.MONTH)+1)+"."+fecha.get(Calendar.YEAR));
	venta[2].setBounds(170, 220, 100, 30);
	venta[3].setBounds(170, 280, 100, 30);
	venta[4].setBounds(170, 340, 100, 30);
	venta[5].setBounds(300, 160, 150, 30);
	venta[5].setEditable(false);
	venta[6].setBounds(300, 280, 150, 30);
	venta[6].setEditable(false);
	venta[7].setBounds(300, 340, 150, 30);
	venta[7].setEditable(false);
	submit.setBounds(345, 80, 64, 64);
	a.setBackground(Color.GRAY);
	venta[1].addKeyListener(this);
	venta[3].addKeyListener(this);
	venta[4].addKeyListener(this);
	men.addMouseListener(this);
	submit.addMouseListener(this);
	jalar();
	jalaremplea();
	jalarclien();
	jalarprod();
	this.add(men);
	this.add(submit);
	this.add(a);
	this.setVisible(true);
	this.addWindowListener(this);
	}
	public static void main (String[] args){
		Ventas_201404099 vv = new Ventas_201404099();
		
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
	}
	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource()==submit){
			submit.setIcon(new ImageIcon("C:/Nueva carpeta/save.png"));
		}
		if (e.getSource()==men){
			men.setIcon(new ImageIcon("C:/Nueva carpeta/menu.png"));
		}
	}
	@Override
	public void mousePressed(MouseEvent z) {
		if (z.getSource()==men){	
			this.setVisible(false);
			this.dispose();
			Menu_201404099.main(null);

		}
		
		
		if (z.getSource()==submit){	
			if ((venta[1].getText()).equals("") || (venta[2].getText()).equals("")||(venta[3].getText()).equals("")||(venta[4].getText()).equals(""))
				JOptionPane.showMessageDialog(null,"Debe llenar todos los campos", "SGCSA Advertencia", JOptionPane.WARNING_MESSAGE);
			
			else{
				if ((venta[5].getText()).equals("null") || (venta[6].getText()).equals("null")||(venta[7].getText()).equals("null")){
					JOptionPane.showMessageDialog(null,"Algunos datos no existe", "SGCSA Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				else{
					try{
						FileWriter w = new FileWriter("C:\\Nueva carpeta\\VENTA.fct",true);
						BufferedWriter bw = new BufferedWriter(w);
						PrintWriter wr = new PrintWriter(bw);
						wr.println(venta[1].getText() + ","+ venta[0].getText() + ","+ venta[2].getText() + ","+ venta[3].getText()+","+ venta[4].getText());
						wr.close();
						bw.close();
					}catch(IOException e){};
					venta[1].setText("");
					venta[2].setText("");
					venta[3].setText("");
					venta[4].setText("");
					venta[5].setText("");
					venta[6].setText("");
					venta[7].setText("");
					inicio=null;
					JOptionPane.showMessageDialog(null,"Datos ingresados exitosamente", "SGCSA", JOptionPane.PLAIN_MESSAGE);				
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

	@Override
	public void keyPressed(KeyEvent fuck) {
		if (fuck.getSource()==venta[1]){
		if (fuck.getKeyCode() == KeyEvent.VK_ENTER){
			buscarprod(Integer.parseInt(venta[1].getText()));
		}
		}
		
		if (fuck.getSource()==venta[3]){
			if (fuck.getKeyCode() == KeyEvent.VK_ENTER){
				buscaremplea(Integer.parseInt(venta[3].getText()));
			}
			}
		if (fuck.getSource()==venta[4]){
			if (fuck.getKeyCode() == KeyEvent.VK_ENTER){
				buscarclien(Integer.parseInt(venta[4].getText()));
		}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	}

