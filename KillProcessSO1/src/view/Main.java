package view;
import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController k = new KillController();
		String sistema = k.os(); //chama função para identificação de SO
		int opc = 0;
		String processo = ""; //processo linux ou windows para matar processo por pid/nome
		
		k.listaProcessos(sistema, processo); //método para listar processos em aberto
		
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1-Matar processo por PID; 2-Matar processo por nome; 9-Sair."));
			
			switch (opc) {
			case 1:
				k.mataPID(sistema, processo);
				break;
			case 2:
				k.mataNome(sistema, processo);
				break;
			case 9: 
				System.out.println("Fim do programa.");
				break;
			default:
				System.out.println("Opção inválida.");
				break;
			}
			
		} while (opc !=9);
		
	}

}
