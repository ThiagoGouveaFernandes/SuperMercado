package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import Modelos.Produto;
import Util.ListaDeProdutos;

//Essa classe é responsavel por todos os menus do programa
public class Menus {
	
	//Esse metodo vai mostrar as mensages do menu principal e retornar a escolha do usuario
	public static int MenuPrinicpal(BufferedReader reader) throws NumberFormatException, IOException {
		
		System.out.println("Bem Vindo ao Menu de Cadastro!!");
		System.out.println("Escolha a opção desejada:"
				+ "\n[1] Cadastrar um produto"
				+ "\n[2] Mostrar produtos cadastrados"
				+ "\n[3] Deletar Cadastros de Produtos"
				+ "\n[4] Editar Cadastros de Produtos"
				+ "\n[5] Sair");
		
		
		return Integer.parseInt(reader.readLine());
	}
	
	//Esse metodo vai mostrar as mensages do menu de cadastro e retornar os dados
	public static String[] MenuCadastro(BufferedReader reader) throws IOException {
		String[] mens = new String[4];
		String[] dados = new String[4];
		
		mens[0] = "Digite a categoria do Produto: ";
		mens[1] = "Digite o nome do Produto: ";
		mens[2] = "Digite o nome da Marca: ";
		mens[3] = "Digite o preço do Produto: ";
		
		
		for(int i = 0; i < 4; i++) {
			System.out.println(mens[i]);
			dados[i] = reader.readLine();
		}
		
		return dados;
	}
	
	//Esse metodo vai montar como sera mostrado a lista para o usuario
	public static void ListaDeAlunoEditada() {
		
		for(Produto a : ListaDeProdutos.getInstance()) {
			System.out.println("---------------------------------");
			System.out.println("- Categoria       = " + a.getCategoria()
						  + "\n- Nome do Produto = " + a.getNome()
						  + "\n- Nome da marca   = " + a.getMarca().getNomeMarca()
						  + "\n- Preço           = " + a.getMarca().getPreco());
			System.out.println("---------------------------------");
		}
	}
	
	//Esse metodo vai mostrar as mensages do menu deletar e o indice
	public static int MenuDeletarProd(BufferedReader reader) throws NumberFormatException, IOException{
		
	for(int i = 0; i < ListaDeProdutos.getInstance().size(); i++)
		System.out.println(i + " - " + ListaDeProdutos.getInstance().get(i));

	System.out.println();
	System.out.println("Qual o indice do produto da lista a cima que você deseja deletar");
		
		return Integer.parseInt(reader.readLine());
	}
	
	//Esse metodo vai mostrar as mensages do menu editar e retornar os dados
	public static String[] MenuEditarProd(BufferedReader reader) throws NumberFormatException, IOException{
		
		String[] dados = new String[3];
		
		for(int i = 0; i < ListaDeProdutos.getInstance().size(); i++)
			System.out.println(i + " - " + ListaDeProdutos.getInstance().get(i));

		System.out.println();
		System.out.println("Dentre a lista acima, escolha o indice do produto que deseja editar");
		dados[2] = reader.readLine();
		
		System.out.println("Escolha o Atributo que deseja alterar: "
				+ "\n[1] Categoria"
				+ "\n[2] Nome do Produto"
				+ "\n[3] Nome da Marca"
				+ "\n[4] Preço");
		dados[0] = reader.readLine();
		
		System.out.println("Escreva o novo valor do atributo");
		dados[1] = reader.readLine();
		
		return dados;
	}
	
	//Esse metodo vai mostrar as mensages finais de cada processo
	public static void MensFinal(int op) {
		String[] msgfinal = {"Produto Salvo com Sucesso!!! :)",
							"Produto Deletado com Sucesso!!! :)",
							"Produto Editado com Sucesso!!! :)",
							"Volte Sempre!  :)"};
		System.out.println(msgfinal[op]);
	}
}
