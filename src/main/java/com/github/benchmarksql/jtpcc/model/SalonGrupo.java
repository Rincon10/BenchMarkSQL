package com.github.benchmarksql.jtpcc.model;

import java.io.Serializable;

/**
 * @author Iván Camilo Rincón Saavedra
 * @author Leonardo Galeano
 * @project benchmarksql
 */
public class SalonGrupo implements Serializable {

    /**
     * Generated Id.
     */
    private static final long serialVersionUID = -7555840082316032135L;
    private int sg_s_id;
    private int sg_g_id;

    public SalonGrupo() {
    }

    public int getSg_s_id() {
        return sg_s_id;
    }

    public void setSg_s_id(int sg_s_id) {
        this.sg_s_id = sg_s_id;
    }

    public int getSg_g_id() {
        return sg_g_id;
    }

    public void setSg_g_id(int sg_g_id) {
        this.sg_g_id = sg_g_id;
    }

    /**
     * describe al grupo de un estudiante.
     */
    @Override
    public final String toString() {
        final StringBuffer ret = new StringBuffer("");
        ret.append("\n***************** SalonGrupo ********************");
        ret.append("\n*           sg_s_id = " + this.getSg_s_id());
        ret.append("\n*         sg_g_id = " + this.getSg_g_id());
        ret.append("\n**********************************************");
        return ret.toString();
    }
}
