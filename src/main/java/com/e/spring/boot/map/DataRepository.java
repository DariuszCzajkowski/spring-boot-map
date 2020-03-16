package com.e.spring.boot.map;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DataRepository {

    private List<point> pointList;

    public DataRepository() {
        this.pointList = new ArrayList<>();
    }

    public List<point> getPointList() {
        return pointList;
    }

    public void addPoint(point newPoint) {
        this.pointList.add(newPoint);

    }
}
