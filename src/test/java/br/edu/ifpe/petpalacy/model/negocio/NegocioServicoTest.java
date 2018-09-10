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

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package br.edu.ifpe.petpalacy.model.negocio;

import br.edu.ifpe.petpalacy.model.entidades.Empresa;
import br.edu.ifpe.petpalacy.model.entidades.Horarios;
import br.edu.ifpe.petpalacy.model.entidades.Servico;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Wemerson Diogenes da Silva <wemersondiogenes16@gmail.com>
 */
public class NegocioServicoTest {
    
    private static Servico servico;
    private static Empresa empresa;
    private static Servico servicoSalvar;
    private Servico servicoBuscar;
    private static Servico servicoDeletar;
    private static NegocioServico negServico;
    private static NegocioEmpresa negEmpresa;
    
    public NegocioServicoTest() {
        negServico = new NegocioServico();
    }
    
    @BeforeClass
    public static void AntesDosTeste() throws Exception{
        ArrayList<Horarios> horas = new ArrayList<>();
        Horarios hora1 = new Horarios("08:20");
        Horarios hora2 = new Horarios("11:15");
        Horarios hora3 = new Horarios("15:40");
        
        horas.add(hora1);
        horas.add(hora2);
        horas.add(hora3);
        
        empresa = new Empresa("92602190020104", "123emp", "empresa@gmail.com", "99218121", "Seu Pet", null);
        servico = new Servico("Tosa", 20, new BigDecimal(50.00), empresa, horas);
        servicoDeletar = new Servico("Aparar Pelos", 45, new BigDecimal(20), empresa, horas);
        negServico = new NegocioServico();
        
        negEmpresa.salvar(empresa);
        negServico.salvar(servicoDeletar);
    }
    
    @AfterClass
    public static void depoisDosTestes() throws Exception {
        negServico.deletar(servico);
        negServico.deletar(servicoSalvar);
    }
    
    @Before
    public void setup()throws Exception{
        negServico.salvar(servico);
    }

    @Test
    public void testDeveSalvarNoBanco() throws Exception {
        assertNotNull(negServico.buscar(servicoSalvar.getIdServico()).getIdServico());
    }

    @Test
    public void testDeveEditarNoBanco() throws Exception {
        servico.setDuracao(20);
        servico.setValor(new BigDecimal(40));
        
        negServico.editar(servico);
        servicoBuscar = negServico.buscar(servico.getIdServico());
    }

    @Test
    public void testDeveDeletarNoBanco() throws Exception {
        negServico.deletar(servicoDeletar);
        
        assertNull(negServico.buscar(servicoDeletar.getIdServico()));
    }

    @Test
    public void testDeveListarTodos() {
        int cont = negServico.listar().size();
        
        assertNotEquals(0, cont);
    }
    
    @Test
    public void testDeveBuscarNoBanco() {
        servicoBuscar = negServico.buscar(servicoSalvar.getIdServico());
        assertNotNull(servicoBuscar);
    }
    
}
