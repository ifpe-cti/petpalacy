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
package br.edu.ifpe.petpalacy.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Daniel Calado <danielcalado159@gmail.com>
 */
public class Mensagens {

    private static Mensagens mensagens;

    private Mensagens() {

    }

    public static Mensagens getInstance() {

        if (mensagens == null) {
            mensagens = new Mensagens();
        }

        return mensagens;
    }

    public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage mensagem = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, mensagem);
    }

    public void nenhumaInformacao() {
        adicionarMensagem(null, "Não foi passada nenhuma Informação!!!", FacesMessage.SEVERITY_ERROR);
    }

    public void jaExisteNoBanco(String texto) {
        adicionarMensagem(null, "Já Existe um(a) " + texto + "igual a esse no banco!!!", FacesMessage.SEVERITY_ERROR);
    }
    
    public void invalido(String texto){
        adicionarMensagem(null, texto + " invalido!! Digite um " + texto + " valido", FacesMessage.SEVERITY_ERROR);
    }
    
    public void salvoComSucesso() {
        adicionarMensagem(null, "Salvo com sucesso!!!", FacesMessage.SEVERITY_INFO);

    }

    public void alteradoComSucesso() {
        adicionarMensagem(null, "Alterado com sucesso!!!", FacesMessage.SEVERITY_INFO);
    }

    public void deletadoComSucesso() {
        adicionarMensagem(null, "Deletado com sucesso!!!", FacesMessage.SEVERITY_INFO);
    }
}
