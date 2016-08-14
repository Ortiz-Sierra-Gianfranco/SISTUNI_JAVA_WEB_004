
package entity;

import java.util.List;

public class Compra {
 private int idcompra;
 private String idproveedor;
 private String idempleado;
 private String tipodoc;
 private String nrodoc;
 private double subtotal;
 private double igv;
 private double total;
 private List<Detalle> detalle;

    public Compra() {
    }

    public Compra(int idcompra, String idproveedor, String idempleado, String tipodoc, String nrodoc, double subtotal, double igv, double total, List<Detalle> detalle) {
        this.idcompra = idcompra;
        this.idproveedor = idproveedor;
        this.idempleado = idempleado;
        this.tipodoc = tipodoc;
        this.nrodoc = nrodoc;
        this.subtotal = subtotal;
        this.igv = igv;
        this.total = total;
        this.detalle = detalle;
    }

    public int getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(int idcompra) {
        this.idcompra = idcompra;
    }

    public String getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getTipodoc() {
        return tipodoc;
    }

    public void setTipodoc(String tipodoc) {
        this.tipodoc = tipodoc;
    }

    public String getNrodoc() {
        return nrodoc;
    }

    public void setNrodoc(String nrodoc) {
        this.nrodoc = nrodoc;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIgv() {
        return igv;
    }

    public void setIgv(double igv) {
        this.igv = igv;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Detalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<Detalle> detalle) {
        this.detalle = detalle;
    }
 
 
}
