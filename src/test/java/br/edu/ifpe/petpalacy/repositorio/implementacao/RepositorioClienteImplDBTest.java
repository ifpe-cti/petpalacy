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
package br.edu.ifpe.petpalacy.repositorio.implementacao;

import br.edu.ifpe.petpalacy.model.entidades.Cliente;
import br.edu.ifpe.petpalacy.model.entidades.Endereco;
import java.util.List;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class RepositorioClienteImplDBTest {
    private static int codigoUsuario = 0;
    
    @BeforeClass
    //@Ignore
    public static void deveSalvarClienteTest() {
        Cliente cliente = new Cliente();
        cliente.setNome("UsuarioTeste");
        cliente.setCpf("33333333333");
        cliente.setTelefone("88888888888");
        cliente.setEmail("usuarioteste@ifpe.com");
        cliente.setSenha("usuarioteste12345");
        
        Endereco endereco = new Endereco();
        endereco.setLogradouro("AV Joaquim Nabuco");
        endereco.setNumero(26);
        endereco.setBairro("Boa Vista");
        endereco.setCidade("Garanhuns");
        
        cliente.setEndereco(endereco);
        
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
        repCliente.salvar(cliente);
        
        List<Cliente> clientes = repCliente.listar();
        for (Cliente clienteLista : clientes) {
            if("UsuarioTeste".equals(clienteLista.getNome())) {
                codigoUsuario = clienteLista.getIdCliente();
            }
        }
        
        assertEquals("UsuarioTeste", repCliente.buscar(codigoUsuario).getNome());
    }
    
    @Test
    //@Ignore
    public void deveListarTodosClientesTest() {
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
        List<Cliente> clientes = repCliente.listar();
        boolean listou = clientes.size()>0;
        assertEquals(true, listou);    
    }
   
    @Test
    //@Ignore
    public void deveBuscarClientePeloIdTest() {  
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();        
        assertEquals("UsuarioTeste", repCliente.buscar(codigoUsuario).getNome());
    } 
    
    @Test
    //@Ignore
    public void deveEditarClienteCadastradoTest() {
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
        
        Cliente cliente = repCliente.buscar(codigoUsuario);
        cliente.setNome("UsuarioTeste2");
        cliente.setCpf("34578934512");
        cliente.setTelefone("333333333");
        cliente.setEmail("usuarioteste2@ifpe.com");
        cliente.setSenha("usuarioteste2");
        
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Av Frei Caneca");
        endereco.setNumero(112);
        endereco.setBairro("Heliopolis");
        endereco.setCidade("Garanhuns");
        
        cliente.setEndereco(endereco);
        
        repCliente.editar(cliente);
        assertEquals("UsuarioTeste2", repCliente.buscar(codigoUsuario).getNome());
    }
    
    @Test
    //@Ignore
    public void deveAutenticarClientePeloEmailSenhaTest() {
        RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
        Cliente cliente = repCliente.autenticar("usuarioteste@ifpe.com", "usuarioteste12345");
        
        assertEquals("usuarioteste@ifpe.com", cliente.getEmail());
    }
    
    @AfterClass
    //@Ignore
    public static void deveDeletarClienteCadastradoTest() {
      RepositorioClienteImplDB repCliente = new RepositorioClienteImplDB();
      Cliente cliente = repCliente.buscar(codigoUsuario);
      
      repCliente.deletar(cliente);
    }
    
}
