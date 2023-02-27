package View;

import javax.swing.JOptionPane;

import controller.Valor;

public class InterfaceGUI {

	String telaPrincipal;
	String telaConversao;
	String entradaUsuario = "";
	String sistemas;
	Valor v = new Valor();
	
	//cria o array com os tipos de moedas
	Object[] opcoesConversaoMoedas = {
			"De Reais a Dólares",
			"De Reais a Euros",
			"De Reais a Libras",
			"De Reais a Yenes",
			"De Reais a Won Coreano",
			"De Dólares a Reais",
			"De Euros a Reais",
			"De Libras a Reais",
			"De Yenes a Reais",
			"De Won Coreano a Reais"
	};
	
	//cria o array com os tipos de conversão de temperatura
	Object[] opConversaoTemperatura = {
			"De Celsius para Farenheit",
			"De Farenheit para Celsius"
	};

	//cria o array com os tipos de conversão
	Object[] opcoes = {"Conversor de Moedas", "Conversor de Temperatura"};
	
	public String getTelaPrincipal() {
		return telaPrincipal;
	}
	
	public String getEntradaUsuario() {
		return entradaUsuario;
	}
	public void setEntradaUsuario(String entradaUsuario) {
		this.entradaUsuario = entradaUsuario;
	}
	public String getTelaConversao() {
		return telaConversao;
	}
	public String getSistemas() {
		return sistemas;
	}
	
	public void telaPrincipal() {
		//cria a tela principal
				telaPrincipal = (String)JOptionPane.showInputDialog(
						 null, "Escolha uma opção", "Menu", 2, null, opcoes, "Conversor de Moedas" );
	}
	
	public void telaInputValor() {
		entradaUsuario = JOptionPane.showInputDialog("Insira um valor");
	}
	
	
	public void validaInputValor() {
		boolean expressao = entradaUsuario.trim().matches("\\d{1,}[.,]?\\d{0,}");
		//return expressao;
		
		while(!expressao) {
			JOptionPane.showMessageDialog(null, "Erro: Digite apenas números!", "Erro", JOptionPane.ERROR_MESSAGE);
			telaInputValor();	
		}
	}
	
	public void telaErro() {
		JOptionPane.showMessageDialog(null, "Erro: Digite apenas números!", "Erro", JOptionPane.ERROR_MESSAGE);
	}
	
	public void inputEmBranco() {
		while(entradaUsuario.isBlank()) {
			telaInputValor();
		}
	}
	
	public void telaEscolhaMoedas() {
		telaConversao = (String) JOptionPane.showInputDialog(
				null, "Escolha uma uma moeda para qual você deseja converter seu dinheiro", 
				"Moedas", 2, null, opcoesConversaoMoedas, "De Reais a Dólares" );
	}
	
	public void telaConversaoTemperatura() {
		sistemas = (String) JOptionPane.showInputDialog(null, "Escolha para qual temperatura deseja converter", 
				"Temperatura", 2, null, opConversaoTemperatura, "De Celsius para Farenheit" );
	}
	
}//fim classe
