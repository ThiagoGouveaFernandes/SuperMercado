package BancoDeDados;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import Modelos.Produto;
import Util.ListaDeProdutos;

//Essa classe é responsavel por manipular o arquivo txt
public class ManipulacaoArquivoTXT {
	
	//Esse metodo é responsavel por criar o txt, salvar as informações da lista no txt e atualizar, quando necessario, as informações do txt
	public static void SalvarArquivoTXT() throws IOException {
		try(BufferedWriter buffer = new BufferedWriter(new FileWriter("CadastroProd.txt"));
				PrintWriter pw = new PrintWriter(buffer)){
			for(Produto a : ListaDeProdutos.getInstance())
				pw.println(a);
		}
	}
	
	//Esse metodo é responsavel por ler as informações do arquivo txt
	public static void LerArquivoTXT() throws FileNotFoundException, IOException {
		
		try(FileWriter arq = new FileWriter("CadastroProd.txt", true)){};
		
		String line = "";
		
		try(BufferedReader leitor = new BufferedReader(new FileReader("CadastroProd.txt"))){
			while((line = leitor.readLine()) != null) {
				Produto prod = new Produto(line);
				ListaDeProdutos.getInstance().add(prod);
			}
		} 
	}
}
