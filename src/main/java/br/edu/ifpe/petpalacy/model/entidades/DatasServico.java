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
package br.edu.ifpe.petpalacy.model.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
  @author Daniel Calado <danielcalado159@gmail.com>
 */
@Entity
public class DatasServico implements Serializable {
     @Id
     @GeneratedValue
     private Integer id;
     private Date data;
     private String status;
     private DiaSemana diaSemana;
     private Status statusData;

    public DatasServico() {
    }

    public DatasServico(Integer id, Date data, String status, DiaSemana diaSemana, Status statusData) {
        this.id = id;
        this.data = data;
        this.status = status;
        this.diaSemana = diaSemana;
        this.statusData = statusData;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DiaSemana getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(DiaSemana diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Status getStatusData() {
        return statusData;
    }

    public void setStatusData(Status statusData) {
        this.statusData = statusData;
    }

    @Override
    public String toString() {
        return "DatasServico{" + "id=" + id + ", data=" + data + ", status=" + status + ", diaSemana=" + diaSemana + ", statusData=" + statusData + '}';
    }

 
     
}
