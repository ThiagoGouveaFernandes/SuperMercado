package Handler;

import java.util.ArrayList;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import Modelos.Produto;
import Modelos.Marca;
import Util.ListaDeProdutos;

//Essa classe é responsavel por 
public class XMLHandlerProduto extends DefaultHandler{

	private StringBuilder texto;
	Produto prod;
	Marca marca;
	
	//Esse metodo inicia o documento
	@Override
	public void startDocument() throws SAXException {
		
	}

	//Esse metodo termina o documento
	@Override
	public void endDocument() throws SAXException {
		
	}

	//Esse metodo vai verificar e trazer o produto e a marca
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if(qName.equals("produto")) {
			prod = new Produto();
			marca = new Marca();
		}
		else {
			texto = new StringBuilder();
		}
	}

	//Esse metodo vai escrever as informações do arquivo xml no objeto produto
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName.equals("Categoria")) {
			prod.setCategoria(texto.toString());
		}
		else if(qName.equals("Nome")){
			prod.setNome(texto.toString());
		}
		else if(qName.equals("NomeMarca")) {
			marca.setNomeMarca(texto.toString());
		}
		else if(qName.equals("Preço")) {
			marca.setPreco(Double.parseDouble(texto.toString()));
			prod.setMarca(marca);
			ListaDeProdutos.getInstance().add(prod);
		}
	}

	//Esse metodo é responsavel por montar uma string
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		texto.append(ch, start, length);
	}

	//Esse metodo é responsavel por tratar os erros
	@Override
	public void error(SAXParseException e) throws SAXException {
		
	}

}
