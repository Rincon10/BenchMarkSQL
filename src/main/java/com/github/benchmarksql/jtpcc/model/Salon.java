package com.github.benchmarksql.jtpcc.model;

import java.io.Serializable;

/**
 * @author Iván Camilo Rincón Saavedra
 * @author Leonardo Galeano
 * @project benchmarksql
 */
public class Salon implements Serializable {
    /**
     * Generated Id.
     */
    private static final long serialVersionUID = 3640594164299091999L;
    private int s_id;
    private String s_edificio;
    private int s_numero;

    public Salon() {
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_edificio() {
        return s_edificio;
    }

    public void setS_edificio(String s_edificio) {
        this.s_edificio = s_edificio;
    }

    public int getS_numero() {
        return s_numero;
    }

    public void setS_numero(int s_numero) {
        this.s_numero = s_numero;
    }

    @Override
    public final String toString() {
        final StringBuffer ret = new StringBuffer("");
        ret.append("\n***************** Salon ********************");
        ret.append("\n*           s_id = " + this.getS_id());
        ret.append("\n*         s_edificio = " + this.getS_edificio());
        ret.append("\n*         s_numero = " + this.getS_numero());
        ret.append("\n**********************************************");
        return ret.toString();
    }
}
