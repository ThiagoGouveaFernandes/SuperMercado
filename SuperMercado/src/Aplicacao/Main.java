//esse pacote vai conter as classes que administrâo as outras classes e metodos
package Aplicacao;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import Modelos.Marca;
import Modelos.Produto;
import View.Menus;

//Essa classe é classe principal, ou seja, a primeira a ser executada
public class Main {

	//Esse metodo é responsavel por chamar as outras classes e metodos conforme a interação com o usuario
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		CRUDProduto.LerProdSalv(1);
		
		int op = 0;
		while(op < 5) {
			
			op = View.Menus.MenuPrinicpal(reader);

			switch(op){
			case 1:
				CRUDProduto.SalvarProd(reader);
				Menus.MensFinal(0);
				break;

			case 2:
				CRUDProduto.LerProdSalv(0);
				break;

			case 3:
				CRUDProduto.DeletarProd(reader);
				Menus.MensFinal(1);
				break;
			
			case 4:
				CRUDProduto.EditarProd(reader);
				Menus.MensFinal(2);
				break;
				
			case 5:
				Menus.MensFinal(3);
				break;
			}
		}
	}
}
