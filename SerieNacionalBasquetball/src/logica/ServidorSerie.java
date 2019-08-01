package logica;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class ServidorSerie implements Runnable {
	

	private ServerSocket servidor = null; 
	private Socket cliente = null;
	private File DataDeUsuarios;
	private File DataDePassword;
	private File DataDeTipoDeUser;
	private ArrayList<String> usuarios;
	private ArrayList<String> passwords;
	private ArrayList<String> tipodeuser;
	final int PUERTO = 5110;
	private DataInputStream dis;
	private DataOutputStream dos;


//	public void RecibirArchivo( ) throws IOException {
//        // Creamos socket servidor escuchando en el mismo puerto donde se comunica el cliente
//        // en este caso el puerto es el 4400
//        servidor = new ServerSocket( 4400 );
//        System.out.println( "Esperando recepcion de archivos..." ); 
//	}
	public ServidorSerie() {

		usuarios= new ArrayList<String>();
		passwords = new ArrayList<String>();
		tipodeuser = new ArrayList<String>();
		DataDeUsuarios = new File("DataUser.txt");
		DataDePassword = new File("DataPass.txt");
		DataDeTipoDeUser = new File("DataTipo.txt");
		try {
			FileInputStream FiUser = new FileInputStream(DataDeUsuarios);
			ObjectInputStream inputUser = new ObjectInputStream(FiUser);
			usuarios= (ArrayList<String>) inputUser.readObject();
			inputUser.close();
			FiUser.close();
			FileInputStream FiPass = new FileInputStream(DataDePassword);
			ObjectInputStream inputPass = new ObjectInputStream(FiPass);
			passwords = (ArrayList<String>) inputPass.readObject();
			inputPass.close();
			FiPass.close();
			FileInputStream FiTipo = new FileInputStream(DataDeTipoDeUser);
			ObjectInputStream inputTipo= new ObjectInputStream(FiTipo);
			tipodeuser = (ArrayList<String>) inputTipo.readObject();
			inputTipo.close();
			FiTipo.close();
			
	
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("El archivo no fue encontrado" + e1);
			FileOutputStream FoUser;
			try {
				FoUser = new FileOutputStream(DataDeUsuarios);
	
				ObjectOutputStream outputUser = new ObjectOutputStream(FoUser);
				ArrayList<String> temp=new ArrayList<String>();
				temp.add("admin");
				usuarios =passwords=tipodeuser=temp;
				outputUser.writeObject(temp);
				outputUser.close();
				FoUser.close();
				FileOutputStream FoPass = new FileOutputStream(DataDePassword);
				ObjectOutputStream outputPass = new ObjectOutputStream(FoPass);
				outputPass.writeObject(temp);
				outputPass.close();
				FoPass.close();
				FileOutputStream FoTipo = new FileOutputStream(DataDeTipoDeUser);
				ObjectOutputStream outputTipo= new ObjectOutputStream(FoTipo);
				outputTipo.writeObject(temp);;
				outputTipo.close();
				FoTipo.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IOException e2) {
			System.out.println("Error: qq:  " + e2);
			
			FileOutputStream FoUser;
			try {
				FoUser = new FileOutputStream(DataDeUsuarios);
	
				ObjectOutputStream outputUser = new ObjectOutputStream(FoUser);
				ArrayList<String> temp=new ArrayList<String>();
				temp.add("admin");
				usuarios =passwords=tipodeuser=temp;
				outputUser.writeObject(temp);
				outputUser.close();
				FoUser.close();
				FileOutputStream FoPass = new FileOutputStream(DataDePassword);
				ObjectOutputStream outputPass = new ObjectOutputStream(FoPass);
				outputPass.writeObject(temp);
				outputPass.close();
				FoPass.close();
				FileOutputStream FoTipo = new FileOutputStream(DataDeTipoDeUser);
				ObjectOutputStream outputTipo= new ObjectOutputStream(FoTipo);
				outputTipo.writeObject(temp);;
				outputTipo.close();
				FoTipo.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e3) {
			System.out.println("Error: " + e3);
		}
	
	}

	public void run() {
			
		try {
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor Iniciado");
			boolean done;
			while (true) {
				done= false;
				cliente = servidor.accept();
				System.out.println("Cliente conectado");
				try {
					dis = new DataInputStream(cliente.getInputStream());
					dos = new DataOutputStream(cliente.getOutputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Error: " + e);
				}
				while(done==false) {
					try {
						String usuario = "";
						usuario = dis.readUTF();
						String password = "";
						password = dis.readUTF();
//						System.out.println("recibio:" + usuario + " " + password+" ");
//						System.out.println("recibio:" + passwords.get(0) );
						if (usuarios.contains(usuario)==true && passwords.get(usuarios.indexOf(usuario)).equals(password)) {
//							System.out.println("recibio:" + usuario + " " + password+" "+tipodeuser.get(usuarios.indexOf(usuario)));
							dos.writeUTF("Permiso Consedido");
//							System.out.println("granted");
							dos.writeUTF(tipodeuser.get(usuarios.indexOf(usuario)));
							dis.close();
							dos.close();
							done=true;
						} else {
//							System.out.println("incorrecto");
							dos.writeUTF("Permiso Denegado");
						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						System.out.println("Error de comunicacion con el usuario: " + e);
					}
				}
				
			}
		} catch (IOException e1) {
			System.out.println("Error al iniciar el servidor:" + e1);
	
		}
	
	}

	
	public ArrayList<String> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<String> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<String> getPasswords() {
		return passwords;
	}

	public void setPasswords(ArrayList<String> passwords) {
		this.passwords = passwords;
	}

	public ArrayList<String> getTipodeuser() {
		return tipodeuser;
	}

	public void setTipodeuser(ArrayList<String> tipodeuser) {
		this.tipodeuser = tipodeuser;
	}
	
	public void guardardatos() {
		FileOutputStream FoUser;
		try {
			FoUser = new FileOutputStream(DataDeUsuarios);

			ObjectOutputStream outputUser = new ObjectOutputStream(FoUser);
			outputUser.writeObject(usuarios);
			outputUser.close();
			FoUser.close();
			FileOutputStream FoPass = new FileOutputStream(DataDePassword);
			ObjectOutputStream outputPass = new ObjectOutputStream(FoPass);
			outputPass.writeObject(passwords);
			outputPass.close();
			FoPass.close();
			FileOutputStream FoTipo = new FileOutputStream(DataDeTipoDeUser);
			ObjectOutputStream outputTipo= new ObjectOutputStream(FoTipo);
			outputTipo.writeObject(tipodeuser);;
			outputTipo.close();
			FoTipo.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Archivo no encontrado" + e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e);
		}
	}

}
