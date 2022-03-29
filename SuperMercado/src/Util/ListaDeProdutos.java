package Util;

import java.util.ArrayList;
import java.util.List;

import Modelos.Produto;

//Essa classe � responsavel por criar a lista de produtos
public class ListaDeProdutos {
	
	private static List<Produto> listaDeProdutos = new ArrayList<Produto>();
	
	//Esse metodo vai retornar a lista
	public static List<Produto> getInstance(){
		return listaDeProdutos;
	}
}
