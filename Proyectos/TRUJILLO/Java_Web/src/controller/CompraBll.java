
package controller;

import dao.CompraDao;
import entity.Compra;

public class CompraBll {
 CompraDao dao ;

    public CompraBll() {
        dao= new CompraDao();
    }
    
    public void grabacompra(Compra c) throws Exception{
        dao.registracompra(c);
    }
 
}
