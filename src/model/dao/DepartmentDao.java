/* Compreende-se que: Qualquer interface que realize alterações
 * em classes do pacote model, também deverão estar no pacote model */

package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {

	// Operação responsável por inserir o objeto no banco de dados
	void insert(Department department); // Sem retorno

	// Operação responsável por atualizar o objeto do banco de dados
	void update(Department department); // Sem retorno

	// Operação que deleta um conteúdo com base em um ID informado
	void deleteById(Integer id); // Sem retorno

	// Operação que encontrará um departamento por ID
	Department findById(Integer id); // Retorna um Department

	// Operação que retornará todos os departamentos
	List<Department> findAll();
	/*
	 * Retornará uma lista de departamentos sem a necessidade de passar um parâmetro
	 */
}
