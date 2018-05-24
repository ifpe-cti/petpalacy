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

import br.edu.ifpe.petpalacy.model.entidades.Servico;
import br.edu.ifpe.petpalacy.model.interfaces.InterfaceServico;
import br.edu.ifpe.petpalacy.model.repositorio.implementacao.RepositorioServicoImplDB;
import br.edu.ifpe.petpalacy.util.Mensagens;
import java.util.List;

/**
 *
 * @author Wemerson Diogenes da Silva <wemersondiogenes16@gmail.com>
 */


public class NegocioServico implements InterfaceServico<Servico>{
    
    private RepositorioServicoImplDB repoServico;
    private Servico serv;
    
    public NegocioServico(){
        repoServico = new RepositorioServicoImplDB();
    }
    
    @Override
    public void salvar(Servico servico){
        if (servico == null) {
            Mensagens.getInstance().nenhumaInformacao();
        }else{
            if(buscar(servico.getIdServico()) != null){
                Mensagens.getInstance().jaExisteNoBanco("Serviço");
            }else{
                repoServico.salvar(servico);
                Mensagens.getInstance().salvoComSucesso();
            }
        }
    }
    
    @Override
    public Servico buscar(Integer codigo){
        if(codigo == null){
            Mensagens.getInstance().nenhumaInformacao();
            return null;
        }else{
            serv = repoServico.buscar(codigo);
            if(serv == null){
                Mensagens.getInstance().nenhumaInformacao();
                return null;
            }else{
                return serv;
            }
        }
    }
    
    @Override
    public void editar(Servico servico){
        if(servico == null){
            Mensagens.getInstance().nenhumaInformacao();
        }else{
            serv = repoServico.buscar(servico.getIdServico());
            if(serv == null){
                Mensagens.getInstance().nenhumaInformacao();
            }else{
                repoServico.editar(servico);
                Mensagens.getInstance().alteradoComSucesso();
            }
        }
    }
    
    @Override
    public void deletar(Servico servico){
        if(servico == null){
            Mensagens.getInstance().nenhumaInformacao();
        }else{
            serv = repoServico.buscar(servico.getIdServico());
            if(serv == null){
                Mensagens.getInstance().nenhumaInformacao();
            }else{
                repoServico.deletar(servico);
                Mensagens.getInstance().deletadoComSucesso();
            }
        }
    }
    
    @Override
    public List<Servico> listar(){
        List lista = repoServico.listar();
        if(lista == null){
            Mensagens.getInstance().nenhumaInformacao();
            return null;
        }else{
            return lista;
        }
    }
    
}

