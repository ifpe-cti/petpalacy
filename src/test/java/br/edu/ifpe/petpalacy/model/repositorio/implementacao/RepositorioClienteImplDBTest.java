/*MIT License

 Copyright (c) 2018 Daniel da Silva Calado, Izaquiel Cavalcante da Silva, 
                   Kaio Cesar Bezerra da Silva e Wemerson Diogenes da Silva

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */
package br.edu.ifpe.petpalacy.model.repositorio.implementacao;

import br.edu.ifpe.petpalacy.model.dao.PersistenciaDAO;
import br.edu.ifpe.petpalacy.model.entidades.Cliente;
import br.edu.ifpe.petpalacy.model.entidades.Endereco;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Daniel da Silva Calado <danielcalado159@gmail.com>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RepositorioClienteImplDBTest {

    static Endereco endereco = new Endereco("rua duque de caxias", 45, "garanhuns", "bem ali");
    static Cliente cliente = new Cliente("Jose Pedro", "1212121212", "99999999", endereco, "dkpaz@gmail.com", "saosaa");
    static Cliente cliBusca = null;
           RepositorioClienteImplDB repCli = null;
    static ArrayList<Cliente> lista = null;
    
    public RepositorioClienteImplDBTest() {
        repCli = new RepositorioClienteImplDB();
        lista = new ArrayList<>();
    }

    @Test
    public void test1InserirNoBanco(){
        repCli.salvar(cliente);
        cliBusca = repCli.buscarCpf("1212121212");
        Assert.assertEquals("1212121212", cliBusca.getCpf());

    }
    @Test
    public void test2AlterarNoBanco(){
        cliBusca.setCpf("32323232");
        repCli.editar(cliBusca);
        cliBusca = repCli.buscarCpf("32323232");
        Assert.assertEquals("32323232", cliBusca.getCpf());
    }
    @Test
    public void test3ListarTodos(){        
        
        lista = (ArrayList<Cliente>) repCli.listar();
        int cont = 0;
        for(Cliente c: lista){
            cont++;
        }
        Assert.assertNotEquals(0, cont);
    }
    @Test
    public void test4AutenticarUsuario(){

        cliBusca = repCli.autenticar("dkpaz@gmail.com", "saosaa");
        
        Assert.assertEquals("dkpaz@gmail.com", cliBusca.getEmail());
    }
    @Test
    public void test5DeletarDoBanco(){
 
        cliBusca = repCli.buscarCpf("32323232");
        repCli.deletar(cliBusca);
    }
}
