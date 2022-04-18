package com.github.benchmarksql.jtpcc.model;

import java.io.Serializable;

/**
 * @author Iván Camilo Rincón Saavedra
 * @author Leonardo Galeano
 * @project benchmarksql
 */
public class Grupo implements Serializable {

    /**
     * Generated Id.
     */
    private static final long serialVersionUID = 2576074839582492020L;
    private int g_id;
    private int g_numero;
    private int g_m_id;

    public Grupo() {
    }

    public int getG_id() {
        return g_id;
    }

    public void setG_id(int g_id) {
        this.g_id = g_id;
    }

    public int getG_numero() {
        return g_numero;
    }

    public void setG_numero(int g_numero) {
        this.g_numero = g_numero;
    }

    public int getG_m_id() {
        return g_m_id;
    }

    public void setG_m_id(int g_m_id) {
        this.g_m_id = g_m_id;
    }

    /**
     * describe al grupo.
     */
    @Override
    public final String toString() {
        final StringBuffer ret = new StringBuffer("");
        ret.append("\n***************** Estudiante ********************");
        ret.append("\n*           g_id = " + this.getG_id());
        ret.append("\n*         g_numero = " + this.getG_numero());
        ret.append("\n*         g_m_id = " + this.getG_m_id());
        ret.append("\n**********************************************");
        return ret.toString();
    }
}
