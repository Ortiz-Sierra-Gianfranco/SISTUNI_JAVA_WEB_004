/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.VentaDao;
import entity.Venta;

/**
 *
 * @author Carlos YunZeg
 */
public class VentaBll {
    // variable
    VentaDao dao;

    //constructor
    public VentaBll() {
        dao = new VentaDao();
    }

    //metodo
    public void grabarVenta(Venta v) throws Exception {
        dao.registraVentas(v);
    }

}
