/**
 * MIT License
 *
 * Copyright (c) 2018 Daniel da Silva Calado, Izaquiel Cavalcante da Silva,    
 *             Kaio Cesar Bezerra da Silva e Wemerson Diogenes da Silva
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */
package br.edu.ifpe.petshop.model.negocio;

import br.edu.ifpe.petshop.model.entidades.Empresa;
import br.edu.ifpe.petshop.model.negocio.interfaces.EmpresaInterface;
import br.edu.ifpe.petshop.model.repositorio.implementacao.RepositorioEmpresaImpDB;
import java.util.List;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class NegocioEmpresa implements EmpresaInterface<Empresa> {

    private static NegocioEmpresa instance;

    private RepositorioEmpresaImpDB repoEmp;

    private Empresa emp;

    private NegocioEmpresa() {
        repoEmp = RepositorioEmpresaImpDB.getInstance();
    }

    private static NegocioEmpresa getInstance() {

        if (instance == null) {
            instance = new NegocioEmpresa();
        }

        return instance;
    }

    @Override
    public Empresa buscarCNPJ(String cnpj) {
        if (cnpj == null) {
            //Imprimir que não foi passada nenhuma informação.
            return null;
        } else {
            emp = repoEmp.buscarCnpj(cnpj);

            if (emp == null) //Imprimir que não existe essa empresa cadastrada no banco.
            {
                return null;
            } else {
                return emp;
            }
        }
    }

    @Override
    public void salvar(Empresa e) {

        if (e == null) {
            //Imprimir que não foi passada nenhuma informação.
        } else {

            if (buscarCNPJ(e.getCnpj()) != null) {
                //Imprimir que esta empresa Já está cadastrada no banco.
            } else {
                repoEmp.salvar(e);
                //Imprimir Operação realizada com sucesso.
            }
        }
    }

    @Override
    public Empresa buscar(Integer codigo) {
        if (codigo == null) {
            //Imprimir que não foi passada nenhuma informação.
            return null;
        } else {
            emp = repoEmp.buscar(codigo);

            if (emp == null) {
                //Imprimir que não existe essa empresa cadastrada no banco.
                return null;
            } else {
                return emp;
            }
        }
    }

    @Override
    public void editar(Empresa e) {

        if (e == null) {
            //Imprimir que não foi passada nenhuma informação.
        } else {

            emp = repoEmp.buscar(e.getIdEmpresa());

            if (emp == null) {

                System.out.println(""); //Imprimir que não existe essa empresa cadastrada no banco.

            } else {
                repoEmp.editar(e);
                //Imprimir Operação realizada com sucesso.
            }

        }

    }

    @Override
    public void deletar(Empresa e) {
        if (e == null) {
            //Imprimir que não foi passada nenhuma informação.
        } else {

            emp = repoEmp.buscar(e.getIdEmpresa());

            if (emp == null) {

                System.out.println(""); //Imprimir que não existe essa empresa cadastrada no banco.

            } else {
                repoEmp.deletar(e);
                //Imprimir Operação realizada com sucesso.
            }

        }
    }

    @Override
    public List<Empresa> listar() {
        List lista = repoEmp.listar();
        if (lista == null) {
            //Imprimir nada encontrado.
            return null;
        } else {
            return lista;
        }
    }

}
