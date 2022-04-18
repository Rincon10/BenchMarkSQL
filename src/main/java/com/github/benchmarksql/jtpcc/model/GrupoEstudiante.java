package com.github.benchmarksql.jtpcc.model;

import java.io.Serializable;

/**
 * @author Iván Camilo Rincón Saavedra
 * @author Leonardo Galeano
 * @project benchmarksql
 */
public class GrupoEstudiante implements Serializable {
    /**
     * Generated Id.
     */
    private static final long serialVersionUID = -5735456083947093098L;
    private int ge_e_id;
    private int ge_g_id;

    public GrupoEstudiante() {
    }

    public int getGe_e_id() {
        return ge_e_id;
    }

    public void setGe_e_id(int ge_e_id) {
        this.ge_e_id = ge_e_id;
    }

    public int getGe_g_id() {
        return ge_g_id;
    }

    public void setGe_g_id(int ge_g_id) {
        this.ge_g_id = ge_g_id;
    }

    /**
     * describe al grupo de un estudiante.
     */
    @Override
    public final String toString() {
        final StringBuffer ret = new StringBuffer("");
        ret.append("\n***************** GrupoEstudiante ********************");
        ret.append("\n*           ge_e_id = " + this.getGe_e_id());
        ret.append("\n*         ge_g_id = " + this.getGe_g_id());
        ret.append("\n**********************************************");
        return ret.toString();
    }
}
