package controller;

import java.math.BigDecimal;
import java.math.MathContext;

public class Valor{

	
	private BigDecimal valor;
	private BigDecimal resultado = null;
	private Double resultadoTemperatura;
	private String inputTemperatura;
	private static final BigDecimal DOLAR = new BigDecimal("0.19");
	private static final BigDecimal WON = new BigDecimal("252.34");
	private static final BigDecimal EURO = new BigDecimal("0.18");
	private static final BigDecimal LIBRAS = new BigDecimal("0.16");
	private static final BigDecimal YENE = new BigDecimal("26.19");
	
	
	//constante que formata a visualização da moeda
	//private static final DecimalFormat FORMATO = new DecimalFormat("#,###,##0.00");
	
	//construtores
	public Valor(String valor) {
		this.valor = new BigDecimal(valor);
	}

	public Valor() {
		
	}
	
	//getters e setters
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	public BigDecimal getResultado() {
		return resultado;
	}
	public String getInputTemperatura() {
		return inputTemperatura;
	}
	public void setInputTemperatura(String resultadoTemperatura) {
		this.inputTemperatura = resultadoTemperatura;
	}
	public Double getResultadoTemperatura() {
		return resultadoTemperatura;
	}
	
	//método de conversão de valores monetários
	public BigDecimal conversao(String opcao) {
		if(opcao.equals("De Reais a Dólares")) {
			resultado = valor.divide(DOLAR,MathContext.DECIMAL32);
		}else if(opcao.equals("De Dólares a Reais")) {
			resultado = valor.multiply(DOLAR,MathContext.DECIMAL32);
		}
		else if(opcao.equals("De Reais a Euros")) {
			resultado = valor.multiply(EURO,MathContext.DECIMAL32);
		}else if(opcao.equals("De Reais a Libras")) {
			resultado = valor.multiply(LIBRAS,MathContext.DECIMAL32);
		}else if(opcao.equals("De Reais a Yenes")) {
			resultado = valor.multiply(YENE,MathContext.DECIMAL32);
		}else if(opcao.equals("De Reais a Won Coreano")) {
			resultado = valor.multiply(WON,MathContext.DECIMAL32);
		}else if(opcao.equals("De Euros a Reais")) {
			resultado = valor.divide(EURO,MathContext.DECIMAL32);
		}else if(opcao.equals("De Libras a Reais")) {
			resultado = valor.divide(LIBRAS,MathContext.DECIMAL32);
		}else if(opcao.equals("De Yenes a Reais")) {
			resultado = valor.divide(YENE,MathContext.DECIMAL32);
		}else if(opcao.equals("De Won Coreano a Reais")) {
			resultado = valor.divide(WON,MathContext.DECIMAL32);
		}
		return resultado;
	}
	
	public Double conversaoTemperatura(String opcao) {
		
		if(opcao.equals("De Celsius para Farenheit")) {
			
			resultadoTemperatura = Double.parseDouble(inputTemperatura)*1.8 + 32;
			
		}else if(opcao.equals("De Farenheit para Celsius")){
			
			resultadoTemperatura = (Double.parseDouble(inputTemperatura)-32)/1.8;	
		}
		return resultadoTemperatura;
	}
	
}
