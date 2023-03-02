package controller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.JOptionPane;

public class KillController {
	
	public KillController() {
		super();
	}
	
	
	
	public String os () {
		String os = System.getProperty("os.name");
		String arch = System.getProperty("os.arch");
		String version = System.getProperty("os.version");
		return os + " - v." +version+ " - arquitetura " +arch;
	}
	
	
	
	public void listaProcessos (String so, String p) {
		
		if (so.contains("Windows")) {
			p = "TASKLIST /FO TABLE";
		} else {
			if (so.contains("Linux")) {
				p = "ps -ef";
			}
		}
		
		try {
			
			Process proc = Runtime.getRuntime().exec(p);
			InputStream f = proc.getInputStream();
			InputStreamReader leitor = new InputStreamReader(f); 
			BufferedReader b = new BufferedReader(leitor);
			String linha = b.readLine();
			
			while (linha != null) {
				System.out.println(linha);
				linha = b.readLine();
			}
			
			b.close();
			leitor.close();
			f.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public void mataPID(String so, String p) {
		StringBuffer buffer = new StringBuffer();
		int pid = Integer.parseInt(JOptionPane.showInputDialog("Informe o PID:"));
		
		if (so.contains("Windows")) {
			buffer.append(" TASKKILL /PID ");
			buffer.append(pid);
			p = buffer.toString();
			System.out.println(p);
		} else {
			if (so.contains("Linux")) {
				buffer.append(" kill -9 ");
				buffer.append(pid);
				p = buffer.toString();
				System.out.println(p); 
			}
		}
		
		try {
			Process proc = Runtime.getRuntime().exec(p);
			InputStream f = proc.getInputStream();
			InputStreamReader leitor = new InputStreamReader(f); 
			BufferedReader b = new BufferedReader(leitor);
			String linha = b.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = b.readLine();
			}
			
			b.close();
			leitor.close();
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	
	public void mataNome(String so, String p) {
		StringBuffer buffer = new StringBuffer();
		String pid = JOptionPane.showInputDialog("Informe o nome do processo:");
		
		if (so.contains("Windows")) {
			buffer.append(" TASKKILL /IM ");
			buffer.append(pid);
			p = buffer.toString();
			System.out.println(p); 
		} else {
			if (so.contains("Linux")) {
				buffer.append(" pkill -f ");
				buffer.append(pid);
				p = buffer.toString();
				System.out.println(p);
			}
		}
		
		try {
			Process proc = Runtime.getRuntime().exec(p);
			InputStream f = proc.getInputStream();
			InputStreamReader leitor = new InputStreamReader(f); 
			BufferedReader b = new BufferedReader(leitor);
			String linha = b.readLine();
			while (linha != null) {
				System.out.println(linha);
				linha = b.readLine();
			}
			
			b.close();
			leitor.close();
			f.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
	}
	
}
