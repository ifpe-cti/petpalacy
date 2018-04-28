/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpe.petshop;

import br.edu.ifpe.petshop.model.entidades.Agendamento;
import br.edu.ifpe.petshop.model.entidades.Cliente;
import br.edu.ifpe.petshop.model.entidades.DatasServico;
import br.edu.ifpe.petshop.model.entidades.Empresa;
import br.edu.ifpe.petshop.model.entidades.Endereco;
import br.edu.ifpe.petshop.model.entidades.Servico;
import br.edu.ifpe.petshop.model.repositorio.implementacao.RepositorioAgendamentoImpDB;
import br.edu.ifpe.petshop.model.repositorio.implementacao.RepositorioClienteImpDB;
import br.edu.ifpe.petshop.model.repositorio.implementacao.RepositorioEmpresaImpDB;
import br.edu.ifpe.petshop.model.repositorio.implementacao.RepositorioServicoImpDB;
import br.edu.ifpe.petshop.model.repositorio.interfaces.RepositorioServico;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jose Junio
 */
public class Teste {
    public static void main(String[] args) {

RepositorioClienteImpDB impb = new RepositorioClienteImpDB();
impb.buscar(1);
      /*  Endereco end = new Endereco(0, "logradouro", "cidade", "bairro");
        Cliente cli = new Cliente(0, "nome", "cpf", "telefone", end, "email", "senha");
        impb.salvar(cli);
        
        RepositorioServico SER  = new RepositorioServicoImpDB();
        DatasServico ds = new DatasServico(null, new Date(), "status");
        ArrayList aa = new ArrayList();
        aa.add(ds);
        Servico s = new Servico(0, "nome", 0, null, aa);
        SER.salvar(s);
        ArrayList ss = new ArrayList();
        ss.add(s);
        
        RepositorioEmpresaImpDB emp = new RepositorioEmpresaImpDB();
        Empresa em = new Empresa("cnpj", "s", "r", "d", "d", ss, end);
        emp.salvar(em);
        
        RepositorioAgendamentoImpDB arg = new RepositorioAgendamentoImpDB();
        Agendamento ag  = new Agendamento(0, ss, cli, em, new Date(), null);
        arg.salvar(ag);
        */
      
    }
}
