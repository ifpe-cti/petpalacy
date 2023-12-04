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
package br.edu.ifpe.petpalacy.util;


import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author 20161d13gr0031
 */


public class ValidaCNPJTest {
    
     @Test
    public void testeCnpjValido() {
        //cnpj valido
        assertTrue(ValidaCNPJ.isCNPJ("12.679.625/0001-00"));
        assertTrue(ValidaCNPJ.isCNPJ("83.402.395/0001-86"));
        assertTrue(ValidaCNPJ.isCNPJ("19.413.465/0001-00"));
        assertTrue(ValidaCNPJ.isCNPJ("88.958.275/0001-83"));
        assertTrue(ValidaCNPJ.isCNPJ("99.329.767/0001-26"));
        assertTrue(ValidaCNPJ.isCNPJ("12.177.146/0001-96"));
        assertTrue(ValidaCNPJ.isCNPJ("40.523.545/0001-05"));
        assertTrue(ValidaCNPJ.isCNPJ("69.104.320/0001-98"));
    }
    @Test
    public void testeCnpjNumerosRepetidos() {
        //numeros repetidos
        assertFalse(ValidaCNPJ.isCNPJ("00.000.000/0000-00"));
        assertFalse(ValidaCNPJ.isCNPJ("11.111.111/1111-11"));
        assertFalse(ValidaCNPJ.isCNPJ("22.222.222/2222-22"));
        assertFalse(ValidaCNPJ.isCNPJ("33.333.333/3333-33"));
        assertFalse(ValidaCNPJ.isCNPJ("44.444.444/4444-44"));
        assertFalse(ValidaCNPJ.isCNPJ("55.555.555/5555-55"));
        assertFalse(ValidaCNPJ.isCNPJ("66.666.666/6666-66"));
        assertFalse(ValidaCNPJ.isCNPJ("77.777.777/7777-77"));
        assertFalse(ValidaCNPJ.isCNPJ("88.888.888/8888-88"));
        assertFalse(ValidaCNPJ.isCNPJ("99.999.999/9999-99"));

    }
    @Test
    public void testeCnpjMenorMaior() {     
        //numero menor ou maior que onze
        assertFalse(ValidaCNPJ.isCNPJ("69.104.320/0001-988"));
        assertFalse(ValidaCNPJ.isCNPJ("69.104.320/0001"));


    }
}
