
import br.edu.ifpe.petpalacy.controller.ControllerServico;
import br.edu.ifpe.petpalacy.model.entidades.Agendamento;
import br.edu.ifpe.petpalacy.model.entidades.Cliente;
import br.edu.ifpe.petpalacy.model.entidades.Empresa;
import br.edu.ifpe.petpalacy.model.entidades.Endereco;
import br.edu.ifpe.petpalacy.model.entidades.Horarios;
import br.edu.ifpe.petpalacy.model.entidades.Servico;
import br.edu.ifpe.petpalacy.model.entidades.StatusAgen;
import br.edu.ifpe.petpalacy.model.negocio.NegocioAgendamento;
import br.edu.ifpe.petpalacy.model.negocio.NegocioCliente;
import br.edu.ifpe.petpalacy.model.negocio.NegocioEmpresa;
import br.edu.ifpe.petpalacy.model.negocio.NegocioServico;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

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
/**
 *
 * @author Daniel Calado <danielcalado159@gmail.com>
 */
public class TESTE {
    public static void main(String[] args) throws Exception {
     
    Endereco end = new Endereco("rua duque de caxias", 34, "são Joao", "planalto");
        Cliente cli = new Cliente("cicero", "11472554400", "0000000", end,"danielcalado159@gmail.com", "sasa");
    Empresa ep = new Empresa("72522856000138", "saosap", "dkinforgames15@gmail.com", "00000000", "petCao", end);
        Horarios hor = new Horarios("12:00");
        Horarios hor1 = new Horarios("11:00");
        Horarios hor2 = new Horarios("12:30");
        Horarios hor3 = new Horarios("01:00");
        Horarios hor4 = new Horarios("01:30");
        Horarios hor5 = new Horarios("02:00");
        ArrayList<Horarios> ho = new ArrayList<>();
        ho.add(hor);
        ho.add(hor1);
        ho.add(hor2);
        ho.add(hor3);
        ho.add(hor4);
        ho.add(hor5);
    Servico ser = new Servico("banho", 20, new BigDecimal(20.90), ep, ho);
    Servico ser1 = new Servico("tosa", 40, new BigDecimal(20.90), ep, null);
    Servico ser2 = new Servico("vacina", 15, new BigDecimal(20.90), ep, null);
    Servico ser3 = new Servico("banho", 20, new BigDecimal(87.90), ep, null);
    Servico ser4 = new Servico("adestramento", 56, new BigDecimal(54.90), ep, null);
        Agendamento ar = new Agendamento(ser4, cli, "20/12/1998", null, StatusAgen.ESPERA);
                Agendamento ar2 = new Agendamento(ser4, cli, "20/12/1998", null, StatusAgen.ESPERA);
        Agendamento ar3 = new Agendamento(ser4, cli, "20/12/1998", null, StatusAgen.AGENDADO);
        Agendamento ar4 = new Agendamento(ser4, cli, "20/12/1998", null, StatusAgen.REALIZADO);

        NegocioCliente c = new NegocioCliente();
    NegocioEmpresa neg = new NegocioEmpresa();
    NegocioServico nes = new NegocioServico();
        NegocioAgendamento ag = new NegocioAgendamento();
    c.salvar(cli);
    neg.salvar(ep);
    ser.setEmpresa(neg.buscar(35));
    //    ControllerServico cro = new ControllerServico();
        //cro.setListaHorarios(ho);
        //cro.setHoras(hor5);
        //cro.adicionarHorarios();
        //cro.setServico(ser);
        //cro.salvar();
    nes.salvar(ser);
    nes.salvar(ser1);
    nes.salvar(ser2);
    nes.salvar(ser3);
    nes.salvar(ser4);
    ag.salvar(ar);
    ag.salvar(ar2);
    ag.salvar(ar3);
    ag.salvar(ar4);

    
            }
}
