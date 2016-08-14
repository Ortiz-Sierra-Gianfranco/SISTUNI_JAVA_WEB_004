package controller;

import java.util.List;
import dao.LineaDao;
import entity.Linea;

public class LineaBll {

    //variables
    LineaDao dao;

    //constructor
    public LineaBll() {
        dao = new LineaDao();
    }

    public List<Linea> lineaListar() throws Exception {
        return dao.readAll();
    }
}
