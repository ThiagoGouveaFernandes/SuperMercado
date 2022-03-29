package Modelos;

//Essa classe � responsavel por guardar as informa��es da marca
public class Marca {

	private String nomeMarca;
	private double preco;

	//Esse metodo � responsavel por as informa��es da mensagem
	public Marca(String[] dados) {
		String[] nomeMarca = dados[3].split(":");
		String[] preco = dados[4].split(":");
		
		this.nomeMarca = nomeMarca[2].trim();
		this.preco = Double.parseDouble(preco[1].trim());
	}
	
	public Marca() {
		
	}
	
	//Esse metodo � responsavel por retornar o nome da marca
	public String getNomeMarca() {
		return nomeMarca;
	}
	
	//Esse metodo � responsavel por retornar o pre�o
	public double getPreco() {
		return preco;
	}
	
	//Esse metodo � responsavel por salvar o pre�o
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	//Esse metodo � responsavel por salvar o nome marca
	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	//Esse metodo � responsavel por retornar uma string com as informa��es da Marca 
	@Override
	public String toString() {
		return "Nome da Marca: " + nomeMarca + ", Preco: " + preco;
	}

	
}
