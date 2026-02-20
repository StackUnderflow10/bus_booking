package main;

import dao.BusDAO;

public class Booking {
    public static void main(String[] args) {
        BusDAO busDAO = new BusDAO();
        busDAO.searchBus("Kolkata","Siliguri","2026-03-01");
    }
}
