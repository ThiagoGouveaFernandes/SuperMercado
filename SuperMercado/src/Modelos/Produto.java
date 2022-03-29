package Modelos;

//Essa classe � responsavel por guardar as info��es do objeto produto
public class Produto {

	private String categoria;
	private String nome;
	private Marca marca;

	//Esse metodo � responsavel por as informa��es da mensagem
	public Produto(String dados) {
		String[] atributos = dados.split(",");
		
		String[] categoria = atributos[1].split(":");
		String[] nome = atributos[2].split(":");
		
		Marca marcaProd = new Marca(atributos);
		
		this.categoria = categoria[1].trim();
		this.nome = nome[1].trim();
		this.marca = marcaProd;
	}
	
	public Produto() {
		
	}
	
	//Esse metodo � responsavel por retornar a categoria
	public String getCategoria() {
		return categoria;
	}
	
	//Esse metodo � responsavel por salvar a categotia
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	//Esse metodo � responsavel por pegar o nome
	public String getNome() {
		return nome;
	}
	
	//Esse metodo � responsavel por salvar o nome
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Esse metodo � responsavel por retornar o as informa��es da marca
	public Marca getMarca() {
		return marca;
	}
	
	////Esse metodo � responsavel por salvar a marca
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	//Esse metodo � responsavel por retorna uma string com as informa��es do objeto
	@Override
	public String toString() {
		return "=================================" + ", Categoria: " + categoria + ", Nome: " + nome + ", Marca: " + marca 
				+ ", =================================";
	}



}
