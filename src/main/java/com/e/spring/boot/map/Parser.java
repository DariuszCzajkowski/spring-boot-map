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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class Parser {

    public static final String COVID_CONFIRMED_URL = "https://github.com/CSSEGISandData/COVID-19/raw/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    private DataRepository dataRepository;
    private RestTemplate restTemplate = new RestTemplate();

    public Parser(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void getConfirmed() throws IOException {

        String confirmedCases = restTemplate.getForObject(COVID_CONFIRMED_URL, String.class);
        StringReader stringReader = new StringReader(confirmedCases);
        CSVParser parser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(stringReader);
        LocalDate today = LocalDate.now();
        for (CSVRecord strings : parser) {
            double lat = Double.parseDouble(strings.get("Lat"));
            double lon = Double.parseDouble(strings.get("Long"));
            String confirmed = strings.get(today.minusDays(1).format(DateTimeFormatter.ofPattern("M/dd/yy")));
            dataRepository.addConfirmedPoint(new Point(lat, lon, confirmed));
        }
    }
}
