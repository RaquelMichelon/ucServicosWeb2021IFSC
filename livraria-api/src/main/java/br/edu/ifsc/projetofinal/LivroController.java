package br.edu.ifsc.projetofinal;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivroController {
	
	// ii)
	@RequestMapping(value="/adicionar_livro", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Livro novoLivro(@RequestBody Livro livro) {
		DataSourceLivro.adicionar(livro);		
		return livro;
	}
	
	// iii)
	@RequestMapping(value="/listar_livros", method = RequestMethod.GET)
	public List<Livro> getLivros() {
		return DataSourceLivro.getAll();
	}
	
	// iv)
	@RequestMapping(value = "/pesquisar_por_isbn/{isbn}", method = RequestMethod.GET)
	public Livro getPorIsbn(
			@PathVariable("isbn") int isbn) {
				return DataSourceLivro.getPorIsbn(isbn);
	}
	
	// v)
	@RequestMapping(value = "/pesquisar_por_autor/{autor}", method = RequestMethod.GET)
	public List<Livro> getPorAutor(
			@PathVariable("autor") String autor) {
				return DataSourceLivro.getPorAutor(autor);
	}
	
	// vi)
	@RequestMapping(value = "/pesquisar_por_titulo/{titulo}", method = RequestMethod.GET)
	public Livro getPorTitulo(
			@PathVariable("titulo") String titulo) {
				return DataSourceLivro.getPorTitulo(titulo);
	}
	
	// vii)
	@RequestMapping(value = "/pesquisar_por_isbnDTO/{isbn}", method = RequestMethod.GET)
	public LivroDTO getPorIsbnDTO(
			@PathVariable("isbn") int isbn) {
				return DataSourceLivro.getPorIsbnDTO(isbn);
	}
	
	// viii)
		@RequestMapping(value = "/livrosDTO", method = RequestMethod.GET)
		public List<LivroDTO> getAllDTO() {
					return DataSourceLivro.getAllDTO();
		}
	
	
	// ix)
	@RequestMapping(value = "/reajustar_preco", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Livro reajusteUmLivro(@RequestBody TaxaDTO livro) {
			return DataSourceLivro.reajustarPrecoPorId(livro.getId(), livro.getTaxa());
	}
	
	// x)
	@RequestMapping(value = "/reajustar_precos", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Livro> reajustarPrecos(@RequestBody TaxaDTO livro) {
			return DataSourceLivro.reajustarPreco(livro.getTaxa());
	}

}
