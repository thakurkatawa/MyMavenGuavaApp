package com.example;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import com.google.common.collect.ImmutableList;

public class App {

    public static void main(String[] args) {

        // Immutable list example
        ImmutableList<String> fruits = ImmutableList.of("Apple", "Banana", "Cherry");
        System.out.println("Fruits: " + fruits);

        // Create file objects
        File sourceFile = new File("source.txt");
        File destFile = new File("destination.txt");

        // Check if source file exists before copying
        if (!sourceFile.exists()) {
            System.err.println("source.txt not found in workspace. Skipping file copy.");
            return;
        }

        try {
            FileUtils.copyFile(sourceFile, destFile);
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }
}
