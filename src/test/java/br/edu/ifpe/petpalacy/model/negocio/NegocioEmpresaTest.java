/*
MIT License

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
package br.edu.ifpe.petpalacy.model.negocio;

import br.edu.ifpe.petpalacy.model.entidades.Empresa;
import br.edu.ifpe.petpalacy.model.entidades.Endereco;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Daniel Calado <danielcalado159@gmail.com>
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class NegocioEmpresaTest {
    static Endereco endereco = new Endereco("rua do Parque", 145, "sao joao", "la em cima");
    static Empresa empresa = new Empresa("12602190000104", "papapa", "emp@gmail.com", "21212121", "bruno Eletro", endereco);
    static Empresa empBusca = null;
           NegocioEmpresa negEmp = null;
           ArrayList<Empresa> lista = null;
    public NegocioEmpresaTest() {
        negEmp = new NegocioEmpresa();
        lista = new ArrayList<>();
        
    }
    //@Test(expected = Exception.class)
    @Test
    public void test1SalvarNegocioNoBanco() throws Exception{
        negEmp.salvar(empresa);
        empBusca = negEmp.buscarCnpj("12602190000104");
        Assert.assertEquals("12602190000104", empBusca.getCnpj());
    }
    @Test(expected = Exception.class)
    public void test2ExceptionErroAoSalvarNoBanco()throws Exception{
        negEmp.salvar(empresa);    
    }
    @Test(expected = Exception.class)
    public void test3ExceptionErroAoSalvarNoBanco()throws Exception{
        empresa.setCnpj("12602194444104");
        negEmp.salvar(empresa);    
    }
    @Test
    public void test4AlterarNegocioNoBanco() throws Exception{
        empBusca.setCnpj("50523378000148");
        negEmp.editar(empBusca);
        empBusca = negEmp.buscarCnpj("50523378000148");
        Assert.assertEquals("50523378000148", empBusca.getCnpj());       
    }
    @Test(expected = Exception.class)
    public void test5ExceptionErroAoAlterarNoBanco()throws Exception{
        empresa.setIdEmpresa(2);
        negEmp.editar(empresa);
    
    }
    @Test
    public void test6ListarTodosNegocio(){        
        
        lista = (ArrayList<Empresa>) negEmp.listar();
        int cont = 0;
        for(Empresa e: lista){
            cont++;
        }
        Assert.assertNotEquals(0, cont);
    }
@Test
    public void test7AutenticarUsuarioNegocio(){

        empBusca = negEmp.autenticar("emp@gmail.com", "papapa");
        
        Assert.assertEquals("emp@gmail.com", empBusca.getEmail());
    }   
   @Test(expected = Exception.class)
    public void test8ExceptionErroAoDeletarNoBanco()throws Exception{
        empBusca.setCnpj("1260219666104");
        negEmp.deletar(empBusca);
    
    }
    @Test
    public void test9DeletarNegocioNoBanco() throws Exception{
        empBusca = negEmp.buscarCnpj("50523378000148");
        negEmp.deletar(empBusca);
    }
}
