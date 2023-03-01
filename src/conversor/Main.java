package conversor;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

import View.InterfaceGUI;
import controller.Valor;

public class Main {

	public static void main(String[] args) {
		InterfaceGUI gui = new InterfaceGUI();
		Valor v = new Valor();
		int repetir = 0;
		
		if(repetir == 0) {
			try {
				do {
					
					//cria a tela principal
					gui.telaPrincipal();
					
					//verifica o tipo de conversão desejada
					if(gui.getTelaPrincipal().equals("Conversor de Moedas")) {
						
						//trata o field em branco
						gui.inputEmBranco();
						
						//valida a entrada do usuário.
						while(!gui.getEntradaUsuario().trim().matches("\\d{1,}[.,]?\\d{0,}")) {
							gui.telaErro();
							gui.telaInputValor();
						}
						
						//parse de string para BigDecimal; troca o símbolo de ponto flutuante
						v.setValor(new BigDecimal(gui.getEntradaUsuario().trim().replace(",", ".")));
						
						//Tela de escolha de tipo de moedas para conversão
						gui.telaEscolhaMoedas();
						
						//invoca o método de conversao da classe Valor
						v.conversao(gui.getTelaConversao());
						
						//Mostra o resultado
						JOptionPane.showMessageDialog(null, "O valor é: " + v.getResultado());
						
					}else {
						//trata o field em branco
						gui.inputEmBranco();
						
						//valida a entrada do usuário.
						while(!gui.getEntradaUsuario().trim().matches("\\d{1,}[.,]?\\d{0,}")) {
							gui.telaErro();
							gui.telaInputValor();
						}
						
						//parse de string para double; troca o símbolo de ponto flutuante
						v.setInputTemperatura(gui.getEntradaUsuario().trim().replace(",", "."));
						
						//Tela de escolha de tipo de sistema de temperatura para conversão
						gui.telaConversaoTemperatura();
						
						//invoca o método de conversao da classe Valor
						v.conversaoTemperatura(gui.getSistemas());
						
						//Mostra o resultado
						JOptionPane.showMessageDialog(null, "O valor é: " + v.getResultadoTemperatura());
						
					}//fim else
					
					//Verifica se usuário deseja repetir alguma conversão
					repetir = JOptionPane.showConfirmDialog(null, "Deseja Continuar? ", "E agora?", JOptionPane.YES_NO_OPTION);
					
					//seta entradaUsuario em "" para receber novo valor
					gui.setEntradaUsuario("");
					
				}while(repetir == JOptionPane.YES_OPTION);

				JOptionPane.showMessageDialog(null, "Programa Finalizado!", "Até Mais!", 1);
				
			}catch(NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Programa cancelado pelo usuário", "Programa cancelado", 0);
			}
		}
		
		
		
		
		
	}//fim main
}//fim classe
