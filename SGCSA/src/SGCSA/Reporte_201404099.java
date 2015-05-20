package SGCSA;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
class supper{
	double totalisimo;
	String codiemple,emplead,fechaa,codpro,productt,cantid,precio;
	supper supra;
	public supper(double uno,String uu,String uuu,String uuuu,String uuuuu,String uuuuuu,String uuuuuuu,String uuuuuuuu){
		this.totalisimo=uno;
		this.codiemple=uu;
		this.emplead=uuu;
		this.fechaa=uuuu;
		this.codpro=uuuuu;
		this.productt=uuuuuu;
		this.cantid=uuuuuuu;
		this.precio=uuuuuuuu;	
	}
}
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
public class Reporte_201404099 extends JFrame implements WindowListener, ActionListener{
	void direcciones(){
    JFileChooser fc = new JFileChooser();
    //FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("FCT, PNG & GIF","jpg","png","gif");
    FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("FCT, CLT, EMP & PRT","fct","clt","emp","prt");
    fc.setFileFilter(filtroImagen);
    int respuesta = fc.showOpenDialog(this);
    if (respuesta == JFileChooser.APPROVE_OPTION)
    {
        urls=fc.getSelectedFile().getAbsolutePath();
      
    }
}

	ven inicio= null;
	cli start=null;
	empo beging=null;
	Prod ichi=null;
	supper high=null;
	
	void agregarsuper(double el, String n,String a,String nittt,String nn,String aa,String nitt,String ni){
		if (high==null)
			high=new supper(el,n,a,nittt,nn,aa,nitt,ni);
		else{
			supper tmp=high;
			high=new supper(el,n,a,nittt,nn,aa,nitt,ni);
			high.supra=tmp;
		}
	}
	void ordenarsuper(){
		double auxi;
		String a,b,c,d,e,f,g;
		supper tmp = high, otro;
		while (tmp!=null){
			otro=tmp.supra;
			while (otro!=null){
				if (tmp.totalisimo<otro.totalisimo){
				auxi=tmp.totalisimo;
				a=tmp.codiemple;
				b=tmp.emplead;
				c=tmp.fechaa;
				d=tmp.codpro;
				e=tmp.productt;
				f=tmp.cantid;
				g=tmp.precio;	
				tmp.totalisimo=otro.totalisimo;
				tmp.codiemple=otro.codiemple;
				tmp.emplead=otro.emplead;
				tmp.fechaa=otro.fechaa;
				tmp.codpro=otro.codpro;
				tmp.productt=otro.productt;
				tmp.cantid=otro.cantid;
				tmp.precio=otro.precio;
				otro.totalisimo=auxi;
				otro.codiemple=a;
				otro.emplead=b;
				otro.fechaa=c;
				otro.codpro=d;
				otro.productt=e;
				otro.cantid=f;
				otro.precio=g;
				
				}
				otro=otro.supra;
				
			}
			tmp=tmp.supra;
		}
	}
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
	void buscarventas(int codi){
		ven tmp=inicio;
		while(tmp!=null){
			if (tmp.empelado==codi){
				putasventas++;
				tmp=tmp.next;
			}
			else
			tmp=tmp.next;
		}
	}
	void buscarv(int codi){
		ven tmp=inicio;
		while(tmp!=null){
			if (tmp.cliente==codi){
				putasventas++;
				tmp=tmp.next;
			}
			else
			tmp=tmp.next;
		}
	}
	void buscarclien(int codi){
		cli tmp=start;
		while(tmp!=null){
			if (tmp.clicodigo==codi){
				clientetemporal=tmp.clinombre+" "+tmp.cliapellido;
				
				tmp=null;
			}
			else
			tmp=tmp.clinext;
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
		while(tmp!=null){
			if (tmp.empocodigo==codigos){
				temporal=tmp.emponombre+" "+tmp.empoapellido;
				tmp=null;
				
			}
			else
			tmp=tmp.next;
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
		while(tmp!=null){
			if (tmp.prodcodigo==codigos){
				tempopro=tmp.prodnombre;
				temporecio=tmp.prodedad;
				tmp=null;
				
			}
			else
			tmp=tmp.nexta;
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
	double tot;
	String urls;
	String temporal;
	String tempopro;
	double temporecio;
	String clientetemporal;
	JLabel men;
	JLabel bus;
	JLabel dele;
	JButton [] tipo= new JButton[6];
	JLabel submit;
	int putasventas=0;
	Calendar fecha = new GregorianCalendar();
	public Reporte_201404099(){
	super("SGCSA: Reportes");
	urls="";
	
	this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
	this.setResizable(false);
	this.setLocation(400, 200);
	this.setSize(473, 480);
	JLabel titu= new JLabel("TIPOS DE REPORTE");
	men = new JLabel(new ImageIcon("C:/Nueva carpeta/menu.png"));
	JLabel a = new JLabel(new ImageIcon("C:/Nueva carpeta/fond.jpeg"));
	Font fuente=new Font("Dialog", Font.PLAIN, 20);
	Font fue=new Font("Dialog", Font.PLAIN, 30);
	for(int i=0; i<6; i++){
		tipo[i] = new JButton();
		tipo[i].setFont(fuente);
		this.add(tipo[i]);
	}
	
	titu.setFont(fue);
	titu.setForeground(Color.WHITE);
	titu.setBounds(90, 20, 350, 30);
	men.setBounds(5, 5, 64, 64);
	tipo[0].setBounds(110, 100, 250, 30);
	tipo[1].setBounds(110, 160, 250, 30);
	tipo[2].setBounds(110, 220, 250, 30);
	tipo[3].setBounds(110, 280, 250, 30);
	tipo[4].setBounds(110, 340, 250, 30);
	tipo[5].setBounds(110, 400, 250, 30);
	tipo[0].setText("Ventas");
	tipo[1].setText("Ventas por Empleado");
	tipo[2].setText("Ventas por Fecha");
	tipo[3].setText("Compras por clientes");
	tipo[4].setText("Ordenado por Compras");
	tipo[5].setText("Ordenado por Ventas");
	tipo[0].addActionListener(this);
	tipo[1].addActionListener(this);
	tipo[2].addActionListener(this);
	tipo[3].addActionListener(this);
	tipo[4].addActionListener(this);
	tipo[5].addActionListener(this);
	jalar();
	jalaremplea();
	jalarclien();
	jalarprod();
	this.add(titu);
	this.add(men);
	this.add(a);
	this.setVisible(true);
	this.addWindowListener(this);
	}
	public static void main (String[] args){
		Reporte_201404099 r = new Reporte_201404099();
		
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

	
	public void actionPerformed(ActionEvent but) {
		if (but.getSource()==tipo[0]){
			JOptionPane.showMessageDialog(null,"Para este reporte se necesitan los archivos: \nVENTAS ,EMPLEADOS Y PRODUCTOS", "SGCSA", JOptionPane.PLAIN_MESSAGE);
			direcciones();
			direcciones();
			direcciones();
			try{
				FileWriter w = new FileWriter("C:\\Nueva carpeta\\reporteporventa.html");
				BufferedWriter bw = new BufferedWriter(w);
				PrintWriter wr = new PrintWriter(bw);
				wr.println("<HTML><HEAD><TITLE>Reporte por ventas</TITLE></HEAD><BODY>");
				wr.println("<center><TABLE BORDER><TR><TH COLSPAN=8 BGCOLOR=#646771>REPORTE POR VENTAS</TH></TR>");
				wr.println("<TR BGCOLOR=#90FF40 ><TD>Cod. empleado</TD> <TD>Empleado</TD> <TD>Fecha</TD> <TD>Cod. producto</TD> <TD>Producto</TD> <TD>Cantidad</TD> <TD>Precio</TD> <TD>Total</TD></TR>");
				
				ven tmp=inicio;
				
				while(tmp!=null){	
					buscaremplea(tmp.empelado);
					buscarprod(tmp.producto);
					double suma=0;
					suma=temporecio*tmp.cantidad;
				wr.println("<TR BGCOLOR=#C5FF9C><TD>"+ tmp.empelado +"</TD> <TD>"+ temporal +"</TD> <TD>"+ tmp.fechass +"</TD> <TD>"+ tmp.producto +"</TD> <TD>"+ tempopro +"</TD> <TD>"+ tmp.cantidad +"</TD> <TD>"+ temporecio +"</TD> <TD>"+suma+"</TD></TR>");
				tot=tot+suma;
				tmp=tmp.next;
				}
				wr.println("<TR><TH COLSPAN=7  BGCOLOR=#2855DC>TOTAL</TH><TH COLSPAN=1  BGCOLOR=#89A6FC>"+tot+"</TH></TR></TABLE></BODY></HTML>");
								
				wr.close();
				bw.close();
			}catch(IOException e){};
			tot=0;
			 try {

		            File objetofile = new File ("C:\\Nueva carpeta\\reporteporventa.html");
		            Desktop.getDesktop().open(objetofile);

		     }catch (IOException ex) {

		     }
		}
		if (but.getSource()==tipo[1]){
			JOptionPane.showMessageDialog(null,"Para este reporte se necesitan los archivos: \nEMPLEADOS Y VENTAS", "SGCSA", JOptionPane.PLAIN_MESSAGE);
			direcciones();
			direcciones();
			try{
				FileWriter w = new FileWriter("C:\\Nueva carpeta\\ventaporempleado.html");
				BufferedWriter bw = new BufferedWriter(w);
				PrintWriter wr = new PrintWriter(bw);
				wr.println("<HTML><HEAD><TITLE>Reporte de ventas por Empleado</TITLE></HEAD><BODY>");
				wr.println("<center><TABLE BORDER><TR><TH COLSPAN=4 BGCOLOR=#646771>REPORTE DE VENTAS POR EMPLEADO</TH></TR>");
				wr.println("<TR BGCOLOR=#90FF40 ><TD>Cod. empleado</TD> <TD>Empleado</TD> <TD>Fecha</TD> <TD>ventas</TD></TR>");
				
				empo tmp=beging;
				
				while(tmp!=null){	
					buscarventas(tmp.empocodigo);
				wr.println("<TR BGCOLOR=#C5FF9C><TD>"+ tmp.empocodigo +"</TD> <TD>"+ tmp.emponombre+ " "+tmp.empoapellido +"</TD> <TD>"+ fecha.get(Calendar.DAY_OF_MONTH)+"."+(fecha.get(Calendar.MONTH)+1)+"."+fecha.get(Calendar.YEAR) +"</TD> <TD>"+ putasventas +"</TD></TR>");
				putasventas=0;
				tmp=tmp.next;
				}
				wr.println("</TABLE></BODY></HTML>");
								
				wr.close();
				bw.close();
			}catch(IOException e){};
			 try {

		            File objetofile = new File ("C:\\Nueva carpeta\\ventaporempleado.html");
		            Desktop.getDesktop().open(objetofile);

		     }catch (IOException ex) {

		     }
		}
		if (but.getSource()==tipo[2]){
			JOptionPane.showMessageDialog(null,"Para este reporte se necesitan los archivos: \nPRODUCTOS Y VENTAS", "SGCSA", JOptionPane.PLAIN_MESSAGE);
			direcciones();
			direcciones();
			try{
				FileWriter w = new FileWriter("C:\\Nueva carpeta\\porfecha.html");
				BufferedWriter bw = new BufferedWriter(w);
				PrintWriter wr = new PrintWriter(bw);
				wr.println("<HTML><HEAD><TITLE>Reporte por intervalo</TITLE></HEAD><BODY>");
				wr.println("<center><TABLE BORDER><TR><TH COLSPAN=5 BGCOLOR=#646771>REPORTE DE VENTAS POR INTERVALO DE TIEMPO</TH></TR>");
				wr.println("<TR BGCOLOR=#90FF40 ><TD>Fecha</TD> <TD>Producto</TD> <TD>Cantidad</TD> <TD>Precio</TD><TD>Total</TD></TR>");
				
				ven tmp=inicio;
				
				while(tmp!=null){
					buscarprod(tmp.producto);
					double suma=0;
					suma=temporecio*tmp.cantidad;
				wr.println("<TR BGCOLOR=#C5FF9C><TD>"+ tmp.fechass +"</TD> <TD>"+ tempopro+ "</TD> <TD> "+tmp.cantidad +"</TD> <TD>"+ temporecio +"</TD> <TD>"+ suma +"</TD></TR>");
				tot=tot+suma;
				tmp=tmp.next;
				}
				wr.println("<TR><TH COLSPAN=4  BGCOLOR=#2855DC>TOTAL</TH><TH COLSPAN=1  BGCOLOR=#89A6FC>"+tot+"</TH></TR></TABLE></BODY></HTML>");
				wr.close();
				bw.close();
			}catch(IOException e){};
			 try {

		            File objetofile = new File ("C:\\Nueva carpeta\\porfecha.html");
		            Desktop.getDesktop().open(objetofile);

		     }catch (IOException ex) {

		     }
		}
		if (but.getSource()==tipo[3]){
			JOptionPane.showMessageDialog(null,"Para este reporte se necesitan los archivos: \nCLIENTES Y VENTAS", "SGCSA", JOptionPane.PLAIN_MESSAGE);
			direcciones();
			direcciones();
			try{
				FileWriter w = new FileWriter("C:\\Nueva carpeta\\comprasclientes.html");
				BufferedWriter bw = new BufferedWriter(w);
				PrintWriter wr = new PrintWriter(bw);
				wr.println("<HTML><HEAD><TITLE>Reporte de compras por Cliente</TITLE></HEAD><BODY>");
				wr.println("<center><TABLE BORDER><TR><TH COLSPAN=5 BGCOLOR=#646771>REPORTE DE COMPRAS POR CLIENTE</TH></TR>");
				wr.println("<TR BGCOLOR=#90FF40 ><TD>Cod. cliente</TD> <TD>Cliente</TD> <TD>No. de compras</TD></TR>");
				
				cli tmp=start;
				
				while(tmp!=null){
					buscarv(tmp.clicodigo);
				wr.println("<TR BGCOLOR=#C5FF9C><TD>"+ tmp.clicodigo +"</TD> <TD>"+ tmp.clinombre+ " "+tmp.cliapellido+ "</TD> <TD> "+putasventas +"</TD> </TR>");
				putasventas=0;
				tmp=tmp.clinext;
				}
				wr.println("</TABLE></BODY></HTML>");
				wr.close();
				bw.close();
			}catch(IOException e){};
			 try {

		            File objetofile = new File ("C:\\Nueva carpeta\\comprasclientes.html");
		            Desktop.getDesktop().open(objetofile);

		     }catch (IOException ex) {

		     }
		}
		if (but.getSource()==tipo[4]){
			tot=0;
			JOptionPane.showMessageDialog(null,"Para este reporte se necesitan los archivos: \nEMPLEADOS Y VENTAS", "SGCSA", JOptionPane.PLAIN_MESSAGE);
			direcciones();
			direcciones();
			direcciones();
			try{
				ven tmp=inicio;
				high=null;
				while(tmp!=null){	
					buscaremplea(tmp.empelado);
					buscarprod(tmp.producto);
					double suma=0;
					suma=temporecio*tmp.cantidad;

					agregarsuper(suma,Integer.toString(tmp.empelado),temporal,tmp.fechass,Integer.toString(tmp.producto),tempopro,Integer.toString(tmp.cantidad),Double.toString(temporecio));
					tmp=tmp.next;
					}
				ordenarsuper();
				FileWriter w = new FileWriter("C:\\Nueva carpeta\\reporteporventa.html");
				BufferedWriter bw = new BufferedWriter(w);
				PrintWriter wr = new PrintWriter(bw);
				wr.println("<HTML><HEAD><TITLE>Reporte por ventas</TITLE></HEAD><BODY>");
				wr.println("<center><TABLE BORDER><TR><TH COLSPAN=8 BGCOLOR=#646771>REPORTE POR VENTAS</TH></TR>");
				wr.println("<TR BGCOLOR=#90FF40 ><TD>Cod. empleado</TD> <TD>Empleado</TD> <TD>Fecha</TD> <TD>Cod. producto</TD> <TD>Producto</TD> <TD>Cantidad</TD> <TD>Precio</TD> <TD>Total</TD></TR>");
				supper otrotemp=high;
				while(otrotemp!=null){
					wr.println("<TR BGCOLOR=#C5FF9C><TD>"+ otrotemp.codiemple +"</TD> <TD>"+ otrotemp.emplead +"</TD> <TD>"+ otrotemp.fechaa +"</TD> <TD>"+ otrotemp.codpro +"</TD> <TD>"+ otrotemp.productt +"</TD> <TD>"+ otrotemp.cantid +"</TD> <TD>"+ otrotemp.precio +"</TD> <TD>"+otrotemp.totalisimo+"</TD></TR>");
					tot=tot+otrotemp.totalisimo;
					otrotemp=otrotemp.supra;
				}
				wr.println("<TR><TH COLSPAN=7  BGCOLOR=#2855DC>TOTAL</TH><TH COLSPAN=1  BGCOLOR=#89A6FC>"+tot+"</TH></TR></TABLE></BODY></HTML>");
				wr.close();
				bw.close();
			}catch(IOException e){};
			
			 try {

		            File objetofile = new File ("C:\\Nueva carpeta\\reporteporventa.html");
		            Desktop.getDesktop().open(objetofile);

		     }catch (IOException ex) {

		     }
			 tot=0;
		}
		if (but.getSource()==tipo[5]){
			direcciones();
		}

		
	}
	}