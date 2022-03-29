package Modelos;

//Essa classe é responsavel por guardar as infoções do objeto produto
public class Produto {

	private String categoria;
	private String nome;
	private Marca marca;

	//Esse metodo é responsavel por as informações da mensagem
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
	
	//Esse metodo é responsavel por retornar a categoria
	public String getCategoria() {
		return categoria;
	}
	
	//Esse metodo é responsavel por salvar a categotia
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	//Esse metodo é responsavel por pegar o nome
	public String getNome() {
		return nome;
	}
	
	//Esse metodo é responsavel por salvar o nome
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	//Esse metodo é responsavel por retornar o as informações da marca
	public Marca getMarca() {
		return marca;
	}
	
	////Esse metodo é responsavel por salvar a marca
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	//Esse metodo é responsavel por retorna uma string com as informações do objeto
	@Override
	public String toString() {
		return "=================================" + ", Categoria: " + categoria + ", Nome: " + nome + ", Marca: " + marca 
				+ ", =================================";
	}



}
