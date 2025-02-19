package com.ipl_project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.opencsv.*;
import com.opencsv.exceptions.CsvException;

import java.io.*;
import java.util.*;

public class IPLCensor {

    // Censorship function for team names
    private static String censorTeamName(String team) {
        String[] words = team.split(" ");
        if (words.length > 1) {
            words[words.length - 1] = "***";
        }
        return String.join(" ", words);
    }

    // Process JSON file
    private static void processJson(String inputFile, String outputFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> matches = mapper.readValue(new File(inputFile), new TypeReference<>() {});

        for (Map<String, Object> match : matches) {
            match.put("team1", censorTeamName((String) match.get("team1")));
            match.put("team2", censorTeamName((String) match.get("team2")));
            match.put("winner", censorTeamName((String) match.get("winner")));
            match.put("player_of_match", "REDACTED");
        }

        mapper.writeValue(new File(outputFile), matches);
        System.out.println("Censored JSON file saved: " + outputFile);
    }

    // Process CSV file
    private static void processCsv(String inputFile, String outputFile) throws IOException, CsvException {
        try (CSVReader reader = new CSVReader(new FileReader(inputFile));
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            List<String[]> rows = reader.readAll();
            List<String[]> newRows = new ArrayList<>();

            newRows.add(rows.get(0)); // Add header

            for (int i = 1; i < rows.size(); i++) {
                String[] row = rows.get(i);
                row[1] = censorTeamName(row[1]);
                row[2] = censorTeamName(row[2]);
                row[5] = censorTeamName(row[5]);
                row[6] = "REDACTED";
                newRows.add(row);
            }

            writer.writeAll(newRows);
            System.out.println("Censored CSV file saved: " + outputFile);
        }
    }

    public static void main(String[] args) {
        String jsonFilePathOriginal = "D:\\Week_05\\Day_02\\src\\main\\java\\com\\ipl_project\\Original JSON File.json";
        String jsonFilePathCensored = "D:\\Week_05\\Day_02\\src\\main\\java\\com\\ipl_project\\Censored JSON File.json";
        String csvFilePathOriginal = "D:\\Week_05\\Day_02\\src\\main\\java\\com\\ipl_project\\Original CSV File.csv";
        String csvFilePathCensored = "D:\\Week_05\\Day_02\\src\\main\\java\\com\\ipl_project\\Censored CSV File.csv";
        try {
            processJson(jsonFilePathOriginal, jsonFilePathCensored);
            processCsv(csvFilePathOriginal, csvFilePathCensored);
        } catch (IOException e) {
            System.err.println("Error processing files: " + e.getMessage());
        } catch (CsvException e) {
            System.out.println(e.getMessage());
        }
    }
}
