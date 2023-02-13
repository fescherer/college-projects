package view;

import java.awt.event.ActionListener;
import java.util.Collection;

import entidade.Produto;

public interface View {
	
	/**
	 * Define (adiciona) um ActionListener para iniciar a 
	 * ação de exibir uma coleção de produtos
	 * @param al ActionListener com ação para exibir uma 
	 * coleção de produtos
	 */
	public void setMostraProdutoListener(ActionListener al);
	
	public void trocaFuncoes(ActionListener al);
	
	public String getButtonChangeText();
	
	public void setPerisiblePanel();
	
	public void setButtonChangeText(String txt);
	
	/**
	 * Exibe uma coleção de produtos para o usuário final
	 * @param produtos Coleção de produtos a serem exibidos
	 */
	public void mostraProdutos(Collection<Produto> produtos);
	
	
	/**
	 * Define (adiciona) um ActionListener para iniciar a 
	 * ação de cadastrar um produto
	 * @param al ActionListener com ação para cadastrar um produto
	 */
	public void setCadastraProdutoListener(ActionListener al);
	
	/**
	 * Retorna o id do produto para cadastrar
	 * @return id do produto para cadastrar
	 */
	public int getIdProduto();
	
	/**
	 * Retorna o nome do produto para cadastrar
	 * @return nome do produto para cadastrar
	 */
	public String getNomeProduto();
	
	/**
	 * Retorna o valor do produto para cadastrar
	 * @return valor do produto para cadastrar
	 */
	public double getValorProduto();

}
