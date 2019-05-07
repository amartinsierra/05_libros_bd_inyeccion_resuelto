package beans;

import java.util.Date;

/**
 * Created by antonio on 21/09/2017.
 */

public class Libro {
    private String titulo;
    private String autor;
    private float precio;
    private Date fecha;

    public Libro(String titulo, String autor, float precio, Date fecha) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
