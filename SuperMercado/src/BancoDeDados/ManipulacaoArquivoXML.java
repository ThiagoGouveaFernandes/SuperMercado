package BancoDeDados;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import Handler.XMLHandlerProduto;
import Modelos.Produto;
import Util.ListaDeProdutos;

//Essa classe é responsavel por manipular o arquivo xml
public class ManipulacaoArquivoXML {
	
	private static String nomeDoArquivo = "CadastroProd.xml";
	
	//Esse metodo é responsavel por criar, salvar ou atualizar o arquivo xml com as tags
	public static void SalvarArquivoXML() throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException {
		
		DocumentBuilderFactory DBF = DocumentBuilderFactory.newInstance();
		DocumentBuilder DB = DBF.newDocumentBuilder();
		
		Document documento = DB.newDocument();
		
		Element produtosTag = documento.createElement("produtos");
		documento.appendChild(produtosTag);
		
		for(Produto a : ListaDeProdutos.getInstance()) {
			
			Element ProdutoTag = documento.createElement("produto");
			ProdutoTag.setAttribute("id", "1");
			produtosTag.appendChild(ProdutoTag);
			
				Element categoriaTag = documento.createElement("Categoria");
				categoriaTag.setTextContent(a.getCategoria());
				ProdutoTag.appendChild(categoriaTag);
				
				Element nomeTag = documento.createElement("Nome");
				nomeTag.setTextContent(a.getNome());
				ProdutoTag.appendChild(nomeTag);
				
			
			Element marcasTag = documento.createElement("Marca");
			ProdutoTag.appendChild(marcasTag);
				
				Element nomeMarcaTag = documento.createElement("NomeMarca");
				nomeMarcaTag.setTextContent(a.getMarca().getNomeMarca());
				ProdutoTag.appendChild(nomeMarcaTag);
				
				Element precoTag = documento.createElement("Preço");
				precoTag.setTextContent(String.valueOf(a.getMarca().getPreco()));
				ProdutoTag.appendChild(precoTag);
		}

		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();
		
		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
		
		DOMSource source = new DOMSource(documento);
		
		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(nomeDoArquivo), "ISO-8859-1")){
			
			StreamResult result = new StreamResult(osw);
			trans.transform(source, result);
			
		}
	}
	
	
	//Esse metodo é responsavel por ler o arquivo xml ou criar um arquivo xml vazio
	public static void LerArquivoXML() throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException {
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser parser = spf.newSAXParser();
		
		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeDoArquivo), "ISO-8859-1")){
			
			InputSource source = new InputSource(isr);
			XMLHandlerProduto handler = new XMLHandlerProduto();
			
			parser.parse(source, handler);
		}
	}
}
