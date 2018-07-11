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

import br.edu.ifpe.petpalacy.repositorio.implementacao.RepositorioClienteImplDB;
import br.edu.ifpe.petpalacy.model.entidades.Cliente;
import br.edu.ifpe.petpalacy.model.entidades.Endereco;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class RepositorioClienteImplDBTest {
    private static Cliente cliente = new Cliente();
    
    @Before
    public void pTest() {
        cliente.setNome("Joao");
        cliente.setCpf("22335468934");
        cliente.setTelefone("999999999999");
        cliente.setEmail("joao@ifpe.com");
        cliente.setSenha("joao12345");
        
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua Jose do Amaral");
        endereco.setNumero(45);
        endereco.setBairro("Boa Vista");
        endereco.setCidade("Garanhuns");
        cliente.setEndereco(endereco);
        
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
        repCliente.salvar(cliente);
    }
    
    @After
    public void downTest() {
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
        // saber se existe esse agendamento 
        repCliente.deletar(cliente);  
    }
    
    @Test
    @Ignore
    public void deveSalvarClienteTest() {
        Cliente cli = new Cliente();
        cli.setNome("Pedro");
        cli.setCpf("33333333333");
        cli.setTelefone("88888888888");
        cli.setEmail("pedro@ifpe.com");
        cli.setSenha("pedro12345");
        
        Endereco end = new Endereco();
        end.setLogradouro("AV Joaquim Nabuco");
        end.setNumero(26);
        end.setBairro("Boa Vista");
        end.setCidade("Garanhuns");
        
        cli.setEndereco(end);
        
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
        repCliente.salvar(cli);
        
        assertEquals("Pedro", repCliente.buscar(2).getNome());
    }
    
    @Test
    @Ignore
    public void deveListarTodosClientesTest() {
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
        List<Cliente> clientes = repCliente.listar();
        
        assertEquals(2, clientes.size());
        
    }
   
    @Test
    @Ignore
    public void deveBuscarClientePeloIdTest() {  
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
        
        Cliente cli = repCliente.buscar(cliente.getIdCliente());
        assertEquals(cliente.getIdCliente(), cli.getIdCliente());
    } 
    
    @Test
    @Ignore
    public void deveEditarClienteCadastradoTest() {
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
        Cliente cli = repCliente.buscar(cliente.getIdCliente());
        cli.setNome("Gustavo");
        cli.setCpf("34578934512");
        cli.setTelefone("333333333");
        cli.setEmail("gustavo@ifpe.com");
        cli.setSenha("121212");
        
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Av Frei Caneca");
        endereco.setNumero(112);
        endereco.setBairro("Heliopolis");
        endereco.setCidade("Garanhuns");
        
        cli.setEndereco(endereco);
        
        repCliente.editar(cli);
        assertEquals(cliente.getNome(), cli.getNome());
    }
    
    @Test
    @Ignore
    public void deveDeletarClienteCadastradoTest() {
      RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
      Cliente cli = repCliente.buscar(cliente.getIdCliente());
      
      repCliente.deletar(cli);
    }
    
    @Test
    @Ignore
    public void deveAutenticarClientePeloEmailSenhaTest() {
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
        Cliente cli = repCliente.autenticar("joao@ifpe.com", "joao12345");
        
        assertEquals("joao@ifpe.com", cli.getEmail());
    }

}
