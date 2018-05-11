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
package be.edu.ifpe.petpalacy.model.dao;

import br.edu.ifpe.petpalacy.model.dao.PersistenciaDAO;
import br.edu.ifpe.petpalacy.model.entidades.Cliente;
import br.edu.ifpe.petpalacy.model.entidades.Endereco;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class PersistenciaDAOTest {
    @Test
    @Ignore
    public void salvarTest() {
        Cliente cliente = new Cliente();
        cliente.setNome("Paulo");
        cliente.setCpf("33333333333");
        cliente.setTelefone("33333333333");
        cliente.setEmail("paulo@ifpe.com");
        cliente.setSenha("paulo12345");
        
        Endereco end = new Endereco();
        end.setLogradouro("Av Pedro Falcao 50");
        end.setBairro("Sao Jose");
        end.setCidade("Garanhuns");
        
        cliente.setEndereco(end);
        PersistenciaDAO.getInstance().salvar(cliente);
        
        String sql = "SELECT c FROM Cliente c";
        Cliente cli = (Cliente) PersistenciaDAO.getInstance().listar(sql).get(0);
        Assert.assertEquals("Paulo", cli.getNome());
    }
    
    @Test
    @Ignore
    public void listarTest() {
        String sql = "SELECT a FROM Cliente a", email = "joaoemail", senha = "joao12345";
        Cliente cliente = (Cliente) PersistenciaDAO.getInstance().autenticar(sql, email, senha);
        Assert.assertEquals("Joao", cliente.getNome());
    }
    
    @Test
    @Ignore
    public void editarTest() {
        String sql = "SELECT c FROM Cliente c";
        Cliente cliente = (Cliente) PersistenciaDAO.getInstance().listar(sql).get(0);
        
        cliente.setNome("Mario");
        cliente.setCpf("22222222222");
        cliente.setTelefone("333333333");
        cliente.setEmail("mario@ifpe.com");
        cliente.setSenha("121212");
        
        Endereco endereco = new Endereco();
        endereco.setLogradouro("AV Frei Caneca 112");
        endereco.setBairro("Heliopolis");
        endereco.setCidade("Garanhuns");
        
        cliente.setEndereco(endereco);
        PersistenciaDAO.getInstance().editar(cliente);
        
        Cliente cli = (Cliente) PersistenciaDAO.getInstance().listar(sql).get(0);
        Assert.assertEquals("Mario", cli.getNome());
    }
    
    @Test
    @Ignore
    public void deletarTest() {
        String sql = "SELECT c FROM Cliente c";
        Cliente cliente = (Cliente) PersistenciaDAO.getInstance().listar(sql).get(2);
        PersistenciaDAO.getInstance().deletar(cliente);
    } 
    
    @Test
    @Ignore
    public void buscarTest() {
        String sql = "SELECT c FROM Cliente c";
        Cliente cliente = (Cliente) PersistenciaDAO.getInstance().listar(sql).get(0);
        System.out.println(cliente.getNome());
        
        Assert.assertEquals("Mario", cliente.getNome());
    }
    
    @Test
    @Ignore
    public void autenticarTest() {
        String sql = "SELECT a FROM Cliente a", email = "mario@ifpe.com", senha = "121212";
        Cliente cliente  = (Cliente) PersistenciaDAO.getInstance().autenticar(sql, email, senha);
        
        System.out.println(cliente.getEmail());
        
        Assert.assertEquals("mario@ifpe.com", cliente.getEmail());
    }
    
}
