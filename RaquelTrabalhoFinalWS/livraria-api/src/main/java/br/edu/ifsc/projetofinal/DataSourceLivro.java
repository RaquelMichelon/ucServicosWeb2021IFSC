package br.edu.ifsc.projetofinal;

import java.util.ArrayList;
import java.util.List;

public class DataSourceLivro {
	//lista definida, criada na memória, mas ainda sem objetos
	private static List<Livro> listaLivros = new ArrayList<>();
	

	public static void setListaLivros(List<Livro> listaLivros) {
		DataSourceLivro.listaLivros = listaLivros;
	}
	
	// i) método para iniciar a listaLivros com alguns livros
	//MOCK DE DADOS
	public static void criarLista() {
		listaLivros.add(new Livro(1, 987653457, "O alienista", "Machado de Assis", "Globo", 20.00));
		listaLivros.add(new Livro(2, 982364036, "Dom Casmurro", "Machado de Assis", "LPM", 12.30));
		listaLivros.add(new Livro(3, 193874233, "Duna", "Frank Herbert", "Parábola", 59.99));
		listaLivros.add(new Livro(4, 983742873, "Água Viva", "Clarice Lispector", "Editora 34", 39.50));
		listaLivros.add(new Livro(5, 652182173, "Introdução ao Java", "Marcos André Pisching", "IFSC", 250.88));
	}
	
	// ii) metodo estático para adicionar um novo livro à lista
	public static void adicionar(Livro livro) {
		listaLivros.add(livro);
	}
	
	// iii) para retornar todos os livros da lista, cada qual com todo os seus dados (atributos)
	public static List<Livro> getAll() {
		return listaLivros;
	}
	
	// iv) retornar todos os dados de um livro conforme o seu código ISBN.
	public static Livro getPorIsbn(int isbn) {
		for (Livro livro : listaLivros) {
			if (livro.getIsbn() == isbn) {
				return livro;
			}
		}
		//se não encontrar nada:
		Livro livro = new Livro(0, 0, "Não Encontrado", "", "", 0.0);
		return livro;
	}
	
	// v) para retornar uma lista de livros dado o nome do autor
	public static List<Livro> getPorAutor(String autor) {
		List<Livro> resultado = new ArrayList<>();
		for (Livro livro : listaLivros) {
			if (livro.getAutor().equalsIgnoreCase(autor)) {
				resultado.add(livro);
				}
		}
		return resultado;
	}
	
		
	// vi) para retornar um livro conforme o seu título
	public static Livro getPorTitulo(String titulo) {
		if (listaLivros != null) {
			for (Livro livro : listaLivros) {
				if (livro.getTitulo().equalsIgnoreCase(titulo)) {
					return livro;
				}
			}	
		}
		return null;
	}
	
	// vii) retorna um objeto DTO contendo título, autor, editora e preço.
	public static LivroDTO getPorIsbnDTO(int isbn) {
		
		for (Livro livro : listaLivros) {
			if (livro.getIsbn() == isbn) {
				LivroDTO livroDTO = new LivroDTO(livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getPreco());
				return livroDTO;
			}
		}
		return null;
	}
	
	
	// viii) retorna os atributos título, autor, editora e preço de todos os livros.
	public static List<LivroDTO> getAllDTO() {
		List<LivroDTO> resultado = new ArrayList<>();
		for (Livro livro: listaLivros) {
			LivroDTO livroDTO = new LivroDTO(livro.getTitulo(),livro.getAutor(), livro.getEditora(), livro.getPreco());
			resultado.add(livroDTO);
		}
		return resultado;
	}
	

	// ix) método para reajustar o preço de um livro da lista conforme o seu id. 
	//O reajuste será feito de acordo com a taxa recebida no parâmetro	
	public static Livro reajustarPrecoPorId(int id, int taxa) {
		Livro livro = DataSourceLivro.getPorId(id);
		livro.reajustarPreco(taxa);
		return livro;
	}
	
	public static Livro getPorId(int id) {
		for (Livro livro : listaLivros) {
			if (livro.getId() == id) {
				return livro;
			}
		}
		return null;
	}
	
	// x) reajusta o preço de todos os livros conforme a taxa informada por parâmetro
	public static List<Livro> reajustarPreco(int taxa) {
		for (Livro livro : listaLivros) {
			livro.reajustarPreco(taxa);
		}
		return listaLivros;
	}
}
