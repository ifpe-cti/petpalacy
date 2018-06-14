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
package br.edu.ifpe.petpalacy.model.negocio;

import br.edu.ifpe.petpalacy.model.entidades.Empresa;
import br.edu.ifpe.petpalacy.model.interfaces.InterfaceEmpresa;
import br.edu.ifpe.petpalacy.model.repositorio.implementacao.RepositorioEmpresaImplDB;
import br.edu.ifpe.petpalacy.util.Criptografia;
import br.edu.ifpe.petpalacy.util.Mensagens;
import br.edu.ifpe.petpalacy.util.ValidaCNPJ;
import java.util.List;

/**
 *
 * @author izaquiel cavalcante da silva izaquiel_cavalcante@hotmail.com
 */
public class NegocioEmpresa implements InterfaceEmpresa<Empresa> {

    private RepositorioEmpresaImplDB repoEmp;

    private Empresa emp;

    public NegocioEmpresa() {
        repoEmp = new RepositorioEmpresaImplDB();
    }

    @Override
    public Empresa autenticar(String login, String senha) {
        if (login == null || senha == null) {
            return null;
        } else {
            emp = repoEmp.autenticar(login, Criptografia.criptografar(senha));

            if (emp == null) {
                return null;
            } else {
                return emp;
            }
        }

    }

    @Override
    public Empresa buscarCnpj(String cnpj) {
        if (cnpj == null) {
            return null;
        } else {
            emp = repoEmp.buscarCnpj(cnpj);

            if (emp == null) {
                return null;
            } else {
                return emp;
            }
        }
    }

    @Override
    public void salvar(Empresa e) throws Exception {

        if (e == null || buscarCnpj(e.getCnpj()) != null) {
            throw new Exception("Erro!");
        }
        boolean status = ValidaCNPJ.isCNPJ(e.getCnpj());
        if (status == true) {
            e.setSenha(Criptografia.criptografar(e.getSenha()));
            repoEmp.salvar(e);
        } else {
            throw new Exception("Erro!");
        }
    }

    @Override
    public Empresa buscar(Integer codigo) {
        if (codigo == null) {
            return null;
        } else {
            emp = repoEmp.buscar(codigo);
            if (emp == null) {
                return null;
            } else {
                return emp;
            }
        }
    }

    @Override
    public void editar(Empresa e) throws Exception {

        if (e == null || repoEmp.buscar(e.getIdEmpresa()) == null) {
            throw new Exception("Erro!");
        } else {
            repoEmp.editar(e);
        }
    }

    @Override
    public void deletar(Empresa e) throws Exception {
        if (e == null || repoEmp.buscarCnpj(e.getCnpj()) == null) {
            throw new Exception("Erro!");
        } else {
            repoEmp.deletar(e);
        }

    }

    @Override
    public List<Empresa> listar() {
        List lista = repoEmp.listar();
        if (lista == null) {
            return null;
        } else {
            return lista;
        }
    }

}
