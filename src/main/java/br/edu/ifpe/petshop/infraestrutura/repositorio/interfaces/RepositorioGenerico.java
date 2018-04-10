/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.petshop.infraestrutura.repositorio.interfaces;

import java.util.List;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public interface RepositorioGenerico<E> {
    public void salvar(E e);
    public E buscar(Integer codigo);
    public void editar(E e);
    public void deletar(E e);
    public List<E> listar();
}
