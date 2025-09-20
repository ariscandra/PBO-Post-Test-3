package model;

public class Kucing extends Pet {
    public Kucing(String id, String nama, String umur, String pemilik) {
        super(id, nama, umur, pemilik);
    }

    @Override
    public String getJenis() {
        return "Kucing";
    }
}