package Aplicacao;

import Modelos.Produto;
import Util.ListaDeProdutos;
import BancoDeDados.ManipulacaoArquivoTXT;
import BancoDeDados.ManipulacaoArquivoXML;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import Modelos.Marca;

//Essa classe é responsavel por administrar os metodos que manipulam os dados do produto
public class CRUDProduto {

	//esse metodo que salvara as informações que o usuario digitar do produto na lista de produtos
	public static void SalvarProd(BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException {
		
		Produto prod = new Produto();
		Marca marca = new Marca();
		
		String[] dados = View.Menus.MenuCadastro(reader);

		try {
			prod.setCategoria(dados[0]);
			prod.setNome(dados[1]);
			marca.setNomeMarca(dados[2]);
			marca.setPreco(Integer.parseInt(dados[3]));
			prod.setMarca(marca);

			ListaDeProdutos.getInstance().add(prod);
			
			ManipulacaoArquivoTXT.SalvarArquivoTXT();
			ManipulacaoArquivoXML.SalvarArquivoXML();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Esse metodo é responsavel por ler a lista de produtos
	public static void LerProdSalv(int op) throws FileNotFoundException, IOException, ParserConfigurationException, SAXException {
		ListaDeProdutos.getInstance().clear();
		
		//ManipulacaoArquivoTXT.LerArquivoTXT();
		
		ManipulacaoArquivoXML.LerArquivoXML();
		
		if(op == 0) {
		View.Menus.ListaDeAlunoEditada();
		}
	}
	
	//Esse metodo é responsavel por deletar alguma informação das lista de produtos
	public static void DeletarProd(BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException {

		ListaDeProdutos.getInstance().remove(View.Menus.MenuDeletarProd(reader));

		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();
	}
	
	//Esse metodo é responsavel por editar as informações da lista de produtos
	public static void EditarProd (BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException {
		
		String[] dados = View.Menus.MenuEditarProd(reader);
		
		int op = Integer.parseInt(dados[0]);
		String nvValor = dados[1];
		
		Produto prod = ListaDeProdutos.getInstance().get(Integer.parseInt(dados[2]));
		
		
		switch(op) {
		case 1:
			prod.setCategoria(nvValor);
			break;
		case 2:
			prod.setNome(nvValor);
			break;
		case 3:
			prod.getMarca().setNomeMarca(nvValor);
			break;
		case 4:
			prod.getMarca().setPreco(Integer.parseInt(nvValor));
			break;
		}
		
		ListaDeProdutos.getInstance().set(Integer.parseInt(dados[2]), prod);
		
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();
	}
}
