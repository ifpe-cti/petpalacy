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

import br.edu.ifpe.petpalacy.model.entidades.Cliente;
import br.edu.ifpe.petpalacy.model.entidades.Endereco;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Wemerson Diogenes da Silva <wemersondiogenes16@gmail.com>
 */
public class NegocioClienteTest {

    private static Cliente cliente;
    private static Endereco endereco;
    private static Cliente clienteSalv;
    private Endereco enderecoSalv;
    private Cliente clienteBuscar;
    private static Cliente clienteDeletar;
    private static ClienteModel negCliente;

    public static final String RUA_ANTONIO = "rua antonio";
    public static final int NUMERO_CASA = 23;
    public static final String BAIRRO_SAO_JOAO = "sao joao";
    public static final String CIDADE_PLANALTO = "planalto";
    public static final String CPF_CLIENTE = "11419189433";
    public static final String TELEFONE_CLIENTE = "39494585439";
    public static final String EMAIL_CLIENTE = "carlos@gmail.com";
    public static final String SENHA_CLIENTE = "dsdsds";
    public static final String NOME_CLIENTE_DELETAR = "toinho";
    public static final String CPF_CLIENTE_DELETAR = "39824885080";
    public static final String TELEFONE_CLIENTE_DELETAR = "5432";
    public static final String EMAIL_CLIENTE_DELETAR = "xx@gmail.com";
    public static final String SENHA_CLIENTE_DELETAR = "siy8i";

    public NegocioClienteTest() {
        negCliente = new ClienteModel();
    }

    @BeforeClass
    public static void AntesDosTestes() throws Exception {
        endereco = new Endereco(RUA_ANTONIO, NUMERO_CASA, BAIRRO_SAO_JOAO, CIDADE_PLANALTO);
        cliente = new Cliente("carlos", CPF_CLIENTE, TELEFONE_CLIENTE, endereco, EMAIL_CLIENTE, SENHA_CLIENTE);
        clienteDeletar = new Cliente(NOME_CLIENTE_DELETAR, CPF_CLIENTE_DELETAR, TELEFONE_CLIENTE_DELETAR, null, EMAIL_CLIENTE_DELETAR, SENHA_CLIENTE_DELETAR);
        negCliente = new ClienteModel();

        negCliente.salvar(cliente);
        negCliente.salvar(clienteDeletar);
    }

    @AfterClass
    public static void DepoisDosTestes() throws Exception {
        negCliente.deletar(cliente);
        negCliente.deletar(clienteSalv);
    }

    @Test
    public void deveSalvarNoBanco() throws Exception {
        enderecoSalv = new Endereco("rua la em cima", 2, "garanhuns", "subida");
        clienteSalv = new Cliente("luana", "11472554400", "99999999", enderecoSalv, "lulu@gmail.com", "sasasa");

        negCliente.salvar(clienteSalv);

        assertNotNull(negCliente.buscarCpf(clienteSalv.getCpf()).getCpf());
    }

    @Test(expected = Exception.class)
    public void deveDispararUmExceptionCPFJaExiste() throws Exception {
        negCliente.salvar(cliente);
    }

    @Test(expected = Exception.class)
    public void deveDispararUmExceptionCPFInvalido() throws Exception {
        cliente.setCpf("1234567890");

        negCliente.salvar(cliente);
    }

    @Test
    public void deveAlterarNoBanco() throws Exception {
        cliente.setEmail("luana@hotmail.com");
        cliente.getEndereco().setCidade("Angelin");

        negCliente.editar(cliente);

        clienteBuscar = negCliente.buscarCpf(cliente.getCpf());

        assertEquals(cliente.getCpf(), clienteBuscar.getCpf());
        assertEquals(cliente.getEndereco().getCidade(), clienteBuscar.getEndereco().getCidade());
    }

    @Test
    public void deveDeletarDoBanco() throws Exception {
        negCliente.deletar(clienteDeletar);

        assertNull(negCliente.buscarCpf(clienteDeletar.getCpf()));

    }

    @Test
    public void deveAutenticarOCliente() {

        clienteBuscar = negCliente.autenticar(cliente.getEmail(), cliente.getSenha());

        assertEquals(cliente.getEmail(), clienteBuscar.getEmail());
        assertEquals(cliente.getSenha(), clienteBuscar.getSenha());
    }

    @Test
    public void deveListarTodos() {
        int cont = negCliente.listar().size();

        assertNotEquals(0, cont);
    }

    @Test
    public void deveBuscarPorCpf() {
        clienteBuscar = negCliente.buscarCpf("11472554400");

        assertEquals(clienteBuscar.getCpf(), "11472554400");
    }

}
