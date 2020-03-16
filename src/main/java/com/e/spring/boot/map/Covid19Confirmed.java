package com.e.spring.boot.map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.StringReader;

@Service
public class Covid19Confirmed {

    public static final String COVID_CONFIRMED_URL =
            "https://github.com/CSSEGISandData/COVID-19/raw/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";

    private DataRepository dataRepository;

    public Covid19Confirmed(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get() throws IOException, InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject(COVID_CONFIRMED_URL, String.class);

        StringReader stringReader = new StringReader(forObject);
        CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);


        for (CSVRecord strings : parser) {
            double lat = Double.parseDouble(strings.get("Lat"));
            double lon = Double.parseDouble(strings.get("Long"));
            String text = strings.get("3/15/20");
            dataRepository.addPoint(new point(lat, lon, text));
        }
    }

}
