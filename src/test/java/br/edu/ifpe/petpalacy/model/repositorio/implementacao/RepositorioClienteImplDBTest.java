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

import br.edu.ifpe.petpalacy.model.entidades.Cliente;
import br.edu.ifpe.petpalacy.model.entidades.Endereco;
import java.util.List;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class RepositorioClienteImplDBTest {
    @Test
    @Ignore
    public void salvarTest() {
        Cliente cli = new Cliente();
        cli.setNome("Pedro");
        cli.setCpf("33333333333");
        cli.setTelefone("88888888888");
        cli.setEmail("pedro@ifpe.com");
        cli.setSenha("pedro12345");
        
        Endereco end = new Endereco();
        end.setLogradouro("AV Joaquim Nabuco 100");
        end.setBairro("Boa Vista");
        end.setCidade("Garanhuns");
        
        cli.setEndereco(end);
        
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
        repCliente.salvar(cli);
        
        Assert.assertEquals("Pedro", repCliente.buscar(1).getNome());
    }
    
    @Test
    @Ignore
    public void listarTest() {
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
        List<Cliente> clientes = repCliente.listar();
        
        for(Cliente cliente : clientes) {
            System.out.println(cliente);
        }
        
        Assert.assertEquals("Pedro", clientes.get(0).getNome());
        
    }
   
    @Test
    @Ignore
    public void buscarTest() {
        
        RepositorioClienteImplDB cli = new RepositorioClienteImplDB();
        
        Cliente cliente = cli.buscar(1);
        System.out.println(cliente.getNome());
    } 
    
    @Test
    @Ignore
    public void editarTest() {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1);
        cliente.setNome("Mario");
        cliente.setCpf("22222222222");
        cliente.setTelefone("333333333");
        cliente.setEmail("gustavo@ifpe.com");
        cliente.setSenha("121212");
        
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Frei Caneca 112");
        endereco.setBairro("Heliopolis");
        endereco.setCidade("Garanhuns");
        
        cliente.setEndereco(endereco);
        
        RepositorioClienteImplDB cli = new RepositorioClienteImplDB();
        cli.editar(cliente);
        
        Cliente c = cli.buscar(1);
        Assert.assertEquals("Mario", c.getNome());
    }
    
    @Test
    @Ignore
    public void deletarTest() {
      RepositorioClienteImplDB cli = new RepositorioClienteImplDB();
      Cliente cliente = cli.buscar(1);
      
      cli.deletar(cliente);

    }
    
    @Test
    @Ignore
    public void autenticarTest() {
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
        Cliente cliente = repCliente.autenticar("gustavo@ifpe.com", "121212");
        System.out.println(cliente.getEmail());
        
        Assert.assertEquals("gustavo@ifpe.com", cliente.getEmail());
    }
    
}
