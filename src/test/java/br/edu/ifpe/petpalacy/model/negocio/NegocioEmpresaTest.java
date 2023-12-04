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
import br.edu.ifpe.petpalacy.model.entidades.Endereco;
import br.edu.ifpe.petpalacy.util.Criptografia;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Izaquiel
 */
public class NegocioEmpresaTest {

    private static Empresa empresa;
    private static Empresa empresaPSalvar;
    private static Empresa empresaPDeletar;
    private Empresa empresaEncontrada;
    private static Endereco endereco;
    private Endereco enderecoPSalvar;
    private static EmpresaModel negocioEmpresa;

    public NegocioEmpresaTest() {
        negocioEmpresa = new EmpresaModel();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        endereco = new Endereco("rua cap americo", 23, "brejao", "centro");
        empresa = new Empresa("54357145000173", "ze123", "empresa@hotmail.com", "1930099780", "MultAnimal", endereco);

        empresaPDeletar = new Empresa("88051324000108", "emp123", "Otaempresa@hotmail.com", "991234568", "SalvaAnimal", null);

        negocioEmpresa = new EmpresaModel();
        negocioEmpresa.salvar(empresa);
        negocioEmpresa.salvar(empresaPDeletar);
    }

    @AfterClass
    public static void tearsDownClass() throws Exception {
        empresa.setCnpj("54357145000173");
        negocioEmpresa.deletar(empresa);
        negocioEmpresa.deletar(empresaPSalvar);
    }

    @Test
    public void deveSalvarEmpresaNoBanco() throws Exception {
        enderecoPSalvar = new Endereco("rua mato seco", 2, "brejao", "ladeira");
        empresaPSalvar = new Empresa("87705705000192", "animal123", "Umaempresa@hotmail.com", "9999999999", "SavanaLegal", enderecoPSalvar);

        negocioEmpresa.salvar(empresaPSalvar);

        assertEquals(empresaPSalvar.getCnpj(), negocioEmpresa.buscarCnpj(empresaPSalvar.getCnpj()).getCnpj());

    }

    @Test(expected = Exception.class)
    public void deveDarErroCNPJJaExiste() throws Exception {
        negocioEmpresa.salvar(empresa);
    }

    @Test(expected = Exception.class)
    public void deveDarErroCNPJInvalido() throws Exception {
        empresa.setCnpj("1234567890");

        negocioEmpresa.salvar(empresa);
    }

    @Test
    public void deveBuscarEmpresaPorCNPJ() {
        empresaEncontrada = negocioEmpresa.buscarCnpj("54357145000173");

        assertEquals("54357145000173", empresaEncontrada.getCnpj());
    }

    @Test
    public void deveAlterarEmpresaNoBanco() throws Exception {
        empresa.setNome("PalacioDosGatos");

        negocioEmpresa.editar(empresa);

        empresaEncontrada = negocioEmpresa.buscarCnpj(empresa.getCnpj());

        assertEquals(empresa.getNome(), empresaEncontrada.getNome());

    }

    @Test
    public void deveDeletarEmpresaDoBanco() throws Exception {
        negocioEmpresa.deletar(empresaPDeletar);

        assertNull(negocioEmpresa.buscarCnpj(empresaPDeletar.getCnpj()));
    }

    @Test
    public void deveAutenticarLoginDaEmpresa() {

        empresaEncontrada = negocioEmpresa.autenticar("empresa@hotmail.com", Criptografia.criptografar("ze123"));

//        assertEquals("ze123", empresaEncontrada.getSenha());
        assertEquals("54357145000173", empresaEncontrada.getCnpj());
    }

    @Test
    public void deveListarTodasAsEmpresasDoBanco() {

        assertNotEquals(0, negocioEmpresa.listar().size());
    }

}
