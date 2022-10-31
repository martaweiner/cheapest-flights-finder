package marta.weiner.app.flightfinder.example.init.mapper;

import marta.weiner.app.flightfinder.example.init.entity.AirportEntity;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Component
public class CSVMapper {
    public List<AirportEntity> csvToEntities(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withDelimiter(';').withIgnoreHeaderCase().withTrim())) {

            List<AirportEntity> tutorials = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                AirportEntity entity = new AirportEntity();
                entity.setName(csvRecord.get("name"));
                entity.setShortname(csvRecord.get("shortname"));
                tutorials.add(entity);
            }

            return tutorials;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
