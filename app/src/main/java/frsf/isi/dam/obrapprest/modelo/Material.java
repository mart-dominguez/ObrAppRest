package frsf.isi.dam.obrapprest.modelo;
import java.util.Objects;

public class Material {

    private Integer id;
    private String descripcion;
    private Long codigo;
    private Double precio;

    public Material() {
    }

    public Material(Integer id, Long codigo, Double precio) {
        this.id = id;
        this.codigo = codigo;
        this.precio = precio;
    }

    public Material(Long codigo, Double precio) {
        this.codigo = codigo;
        this.precio = precio;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", codigo=" + codigo +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Material material = (Material) o;
        return Objects.equals(id, material.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

