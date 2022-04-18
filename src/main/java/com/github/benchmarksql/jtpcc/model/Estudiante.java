package com.github.benchmarksql.jtpcc.model;

import java.io.Serializable;

/**
 * @author Iván Camilo Rincón Saavedra
 * @author Leonardo Galeano
 * @project benchmarksql
 */
public class Estudiante implements Serializable {
    /**
     * Generated Id.
     */
    private static final long serialVersionUID = -8122701038727177452L;
    private int e_id;
    private String e_nombre;
    private String e_apellido;
    private String e_correo;
    private int e_semestre;

    public Estudiante() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getE_id() {
        return e_id;
    }

    public void setE_id(int e_id) {
        this.e_id = e_id;
    }

    public String getE_nombre() {
        return e_nombre;
    }

    public void setE_nombre(String e_nombre) {
        this.e_nombre = e_nombre;
    }

    public String getE_apellido() {
        return e_apellido;
    }

    public void setE_apellido(String e_apellido) {
        this.e_apellido = e_apellido;
    }

    public String getE_correo() {
        return e_correo;
    }

    public void setE_correo(String e_correo) {
        this.e_correo = e_correo;
    }

    public int getE_semestre() {
        return e_semestre;
    }

    public void setE_semestre(int e_semestre) {
        this.e_semestre = e_semestre;
    }

    /**
     * describe al estudiante.
     */
    @Override
    public final String toString() {
        final StringBuffer ret = new StringBuffer("");
        ret.append("\n***************** Estudiante ********************");
        ret.append("\n*           e_id = " + this.getE_id());
        ret.append("\n*         e_nombre = " + this.getE_nombre());
        ret.append("\n*         e_apellido = " + this.getE_apellido());
        ret.append("\n*     e_correo = " + this.getE_correo());
        ret.append("\n*       e_semestre = " + this.getE_correo());
        ret.append("\n**********************************************");
        return ret.toString();
    }
}
