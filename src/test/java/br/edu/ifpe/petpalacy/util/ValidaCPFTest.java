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


import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel da Silva Calado <danielcalado159@gmail.com>
 */


public class ValidaCPFTest {
    @Test
    public void testeCpfValido() {
        //cpf valido
        assertTrue(ValidaCPF.isCPF("283.054.260-68"));
        assertTrue(ValidaCPF.isCPF("505.442.260-97"));
        assertTrue(ValidaCPF.isCPF("027.909.430-28"));
        assertTrue(ValidaCPF.isCPF("786.173.170-78"));
        assertTrue(ValidaCPF.isCPF("860.378.950-90"));
        assertTrue(ValidaCPF.isCPF("027.960.620-66"));
        assertTrue(ValidaCPF.isCPF("897.258.520-36"));
        assertTrue(ValidaCPF.isCPF("770.071.230-15"));
    }
    @Test
    public void testeCpfNumerosRepetidos() {
        //numeros repetidos
        assertFalse(ValidaCPF.isCPF("111.111.111-11"));
        assertFalse(ValidaCPF.isCPF("222.222.222-22"));
        assertFalse(ValidaCPF.isCPF("333.333.333-33"));
        assertFalse(ValidaCPF.isCPF("444.444.444-44"));
        assertFalse(ValidaCPF.isCPF("555.555.555-55"));
        assertFalse(ValidaCPF.isCPF("666.666.666-66"));
        assertFalse(ValidaCPF.isCPF("777.777.777-77"));
        assertFalse(ValidaCPF.isCPF("888.888.888-88"));
        assertFalse(ValidaCPF.isCPF("999.999.999-99"));
        assertFalse(ValidaCPF.isCPF("000.000.000-00"));
    }
    @Test
    public void testeCpfMenorMaior() {     
        //numero menor ou maior que onze
        assertFalse(ValidaCPF.isCPF("1234.566-64"));
        assertFalse(ValidaCPF.isCPF("123.456.789.076-4"));

    }
}
