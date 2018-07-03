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

import br.edu.ifpe.petpalacy.model.entidades.Empresa;
import br.edu.ifpe.petpalacy.model.entidades.Endereco;
import br.edu.ifpe.petpalacy.model.entidades.Servico;
import java.util.List;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class RepositorioEmpresaImplDBTest {
   /* @Test
    @Ignore
    public void salvarTest() {
        Empresa empresa = new Empresa();
        empresa.setNome("Pet Cao");
        empresa.setCnpj("11111111111111");
        empresa.setTelefone("22222222222");
        empresa.setEmail("petcao@ifpe.com");
        empresa.setSenha("petcao12345");
        
        Endereco endereco = new Endereco();
        endereco.setLogradouro("Av Correia Dutra 123");
        endereco.setBairro("Heliopolis");
        endereco.setCidade("Garanhuns");
        
        empresa.setEndereco(endereco);
        
        RepositorioServicoImplDB repServico = new RepositorioServicoImplDB();
        List<Servico> servicos = repServico.listar();
        
        empresa.setServicos(servicos);
        
        RepositorioEmpresaImplDB repEmpresa = new RepositorioEmpresaImplDB();
        repEmpresa.salvar(empresa);
        
        Assert.assertEquals("Pet Cao", empresa.getNome());
        Assert.assertEquals("Av Correia Dutra 123", empresa.getEndereco().getLogradouro());
    }
    
    @Test
    @Ignore
    public void listarTest() {
        RepositorioEmpresaImplDB repEmpresa = new RepositorioEmpresaImplDB();
        List<Empresa> empresas = repEmpresa.listar();
        
        for(Empresa empresa : empresas) {
            System.out.println(empresa.getNome());
        }
        
        Assert.assertEquals("Pet Cao", empresas.get(0).getNome());
    }
   
    @Test
    @Ignore
    public void buscarTest() {
        RepositorioEmpresaImplDB repEmpresa = new RepositorioEmpresaImplDB();
        
        Empresa empresa = repEmpresa.buscar(1);
        System.out.println(empresa.getNome());
        
        Assert.assertEquals("Pet Cao", empresa.getNome());
    } 
    
    @Test
    @Ignore
    public void editarTest() {
        RepositorioEmpresaImplDB repEmpresa = new RepositorioEmpresaImplDB();
        
        Empresa empresa = repEmpresa.buscar(1);
        empresa.setNome("PetMix");
            
        repEmpresa.editar(empresa);
        
        Empresa emp = repEmpresa.buscar(1);
        Assert.assertEquals("PetMix", emp.getNome());
    }
    
    @Test
    @Ignore
    public void excluirTest() {
        RepositorioEmpresaImplDB repEmpresa = new RepositorioEmpresaImplDB();
        
        Empresa empresa = repEmpresa.buscar(1);
      
        repEmpresa.deletar(empresa);
    }
    
    @Test
    @Ignore
    public void autenticarTest() {
        RepositorioEmpresaImplDB repEmpresa= new RepositorioEmpresaImplDB();
        Empresa empresa = repEmpresa.autenticar("petcao@ifpe.com", "petcao12345");
        System.out.println(empresa.getEmail());
        
        Assert.assertEquals("petcao@ifpe.com", empresa.getEmail());
    }
   */ 
}
