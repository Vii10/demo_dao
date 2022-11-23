package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface SellerDao {

	// Operação responsável por inserir o objeto no banco de dados
	void insert(Seller department); // Sem retorno

	// Operação responsável por atualizar o objeto do banco de dados
	void update(Seller department); // Sem retorno

	// Operação que deleta um conteúdo com base em um ID informado
	void deleteById(Integer id); // Sem retorno

	// Operação que encontrará um vendedor por ID
	Seller findById(Integer id); // Retorna um Seller

	// Operação que retornará todos os vendedores
	List<Seller> findAll();
	/*
	 * Retornará uma lista de vendedores sem a necessidade de passar um parâmetro
	 */
	//Retorna um vendedor por departamento
	List<Seller> findByDepartment(Department department);
}
