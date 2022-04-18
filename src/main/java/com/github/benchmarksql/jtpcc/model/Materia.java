package com.github.benchmarksql.jtpcc.model;

import java.io.Serializable;

/**
 * @author Iván Camilo Rincón Saavedra
 * @author Leonardo Galeano
 * @project benchmarksql
 */
public class Materia implements Serializable {

    /**
     * Generated Id.
     */
    private static final long serialVersionUID = 7605103867655461879L;
    private String m_sigla;
    private String m_nombre;
    private int m_creditos;

    public Materia() {
    }

    public String getM_sigla() {
        return m_sigla;
    }

    public void setM_sigla(String m_sigla) {
        this.m_sigla = m_sigla;
    }

    public String getM_nombre() {
        return m_nombre;
    }

    public void setM_nombre(String m_nombre) {
        this.m_nombre = m_nombre;
    }

    public int getM_creditos() {
        return m_creditos;
    }

    public void setM_creditos(int m_creditos) {
        this.m_creditos = m_creditos;
    }

    /**
     * describe a la materia.
     */
    @Override
    public final String toString() {
        final StringBuffer ret = new StringBuffer("");
        ret.append("\n***************** Materia ********************");
        ret.append("\n*           m_sigla = " + this.getM_sigla());
        ret.append("\n*         m_nombre = " + this.getM_nombre());
        ret.append("\n*         m_creditos = " + this.getM_creditos());
        ret.append("\n**********************************************");
        return ret.toString();
    }
}
