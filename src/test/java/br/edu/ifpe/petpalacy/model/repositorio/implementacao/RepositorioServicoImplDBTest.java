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

import br.edu.ifpe.petpalacy.model.entidades.Servico;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Kaio César Bezerra da Silva <kaio_gus@outlook.com>
 */
public class RepositorioServicoImplDBTest {
   /* @Test
    @Ignore
    public void salvarTest() {
        Servico serv = new Servico();
        serv.setNome("Tosa");
        serv.setDuracao(30);
        serv.setValor(new BigDecimal(13));                
        
        RepositorioServicoImplDB repServico = new RepositorioServicoImplDB();
        repServico.salvar(serv);
        
        Assert.assertEquals("Tosa", serv.getNome());
    }
    
    @Test
    @Ignore
    public void listarTest() {
        RepositorioServicoImplDB repServico = new RepositorioServicoImplDB();
        List<Servico> servicos = repServico.listar();
        
        for(Servico servico : servicos) {
            System.out.println(servico);
        }
        
        Assert.assertEquals("Tosa", servicos.get(0).getNome());
    }
   
    @Test
    @Ignore
    public void buscarTest() {
        RepositorioServicoImplDB serv = new RepositorioServicoImplDB();
        
        Servico servico = serv.buscar(1);
        System.out.println(servico.getNome());
        
        Assert.assertEquals("Tosa", servico.getNome());
    } 
    
    @Test
    @Ignore
    public void editarTest() {
        RepositorioServicoImplDB repServico = new RepositorioServicoImplDB();
        Servico servico = repServico.buscar(1);
        servico.setNome("Banho");
            
        repServico.editar(servico);
        
        Servico serv = repServico.buscar(1);
        Assert.assertEquals("Banho", serv.getNome());
    }
    
    @Test
    @Ignore
    public void excluirTest() {
        RepositorioServicoImplDB repServico = new RepositorioServicoImplDB();
        Servico servico = repServico.buscar(2);
      
        repServico.deletar(servico);
    }
  */  
}
