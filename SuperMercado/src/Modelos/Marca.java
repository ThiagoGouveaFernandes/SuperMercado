package Modelos;

//Essa classe é responsavel por guardar as informações da marca
public class Marca {

	private String nomeMarca;
	private double preco;

	//Esse metodo é responsavel por as informações da mensagem
	public Marca(String[] dados) {
		String[] nomeMarca = dados[3].split(":");
		String[] preco = dados[4].split(":");
		
		this.nomeMarca = nomeMarca[2].trim();
		this.preco = Double.parseDouble(preco[1].trim());
	}
	
	public Marca() {
		
	}
	
	//Esse metodo é responsavel por retornar o nome da marca
	public String getNomeMarca() {
		return nomeMarca;
	}
	
	//Esse metodo é responsavel por retornar o preço
	public double getPreco() {
		return preco;
	}
	
	//Esse metodo é responsavel por salvar o preço
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	//Esse metodo é responsavel por salvar o nome marca
	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	//Esse metodo é responsavel por retornar uma string com as informações da Marca 
	@Override
	public String toString() {
		return "Nome da Marca: " + nomeMarca + ", Preco: " + preco;
	}

	
}
