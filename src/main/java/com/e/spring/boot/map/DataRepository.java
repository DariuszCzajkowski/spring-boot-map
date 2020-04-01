package com.e.spring.boot.map;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DataRepository {

    private List<Point> confirmedList;
    private List<Point> deathList;
    private List<Point> recoveredList;

    public DataRepository() {
        this.confirmedList = new ArrayList<>();
        this.deathList = new ArrayList<>();
        this.recoveredList = new ArrayList<>();
    }

    public List<Point> getConfirmedList() {
        return confirmedList;
    }

    public List<Point> getDeathList() {
        return deathList;
    }

    public List<Point> getRecoveredList() {
        return recoveredList;
    }

    public void addConfirmedPoint(Point newPoint) {
        this.confirmedList.add(newPoint);

    }

    public void addDeathPoint(Point newPoint) {
        this.deathList.add(newPoint);

    }

    public void addRecoveredPoint(Point newPoint) {
        this.recoveredList.add(newPoint);

    }

}
