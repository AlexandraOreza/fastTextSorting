/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Alexandra
 */
public class SumaVect {

    public String SumaVect(String inputFile) {
        // Initialize the result vector as an ArrayList
        ArrayList<Double> sum = new ArrayList<>();
        File input = new File(inputFile);
        System.out.println(input.getAbsolutePath());

        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            System.out.println(input.getAbsolutePath());
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into string vector values
                String[] vectorValues = line.split(" ");

                // Sum the vector element-wise
                for (int i = 1; i < vectorValues.length; i++) {
                    // Parse the string value to double before summing
                    double num = Double.parseDouble(vectorValues[i]);

                    // If the result vector is not long enough, add elements to it
                    if (i >= sum.size()) {
                        sum.add(num);
                    } else {
                        // Otherwise, add the element to the existing value
                        sum.set(i, sum.get(i) + num);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read file: " + e.getMessage());
            return null;
        }

        // Convert the result vector to a string
        StringBuilder sb = new StringBuilder();
        for (double value : sum) {
            sb.append(value).append(" ");
        }
        return sb.toString().trim();
    }
}
