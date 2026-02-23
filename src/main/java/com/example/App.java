package com.example;

/**
 * Hello world!
 *
 */
// Import FileUtils class from Apache Commons IO library
// This is used to perform file operations like copying files
import org.apache.commons.io.FileUtils;

// Import File class to represent file and directory pathnames
import java.io.File;

// Import IOException to handle input-output errors
import java.io.IOException;

// Import ImmutableList from Google Guava library
// ImmutableList creates a list that cannot be modified after creation
import com.google.common.collect.ImmutableList;

// Define the main class
public class App 
{
    // Main method - program execution starts from here
    public static void main( String[] args )
    {
        // Create an immutable list of strings (fruits)
        // This list cannot be changed (no add/remove allowed)
        ImmutableList<String> fruits = ImmutableList.of("Apple", "Banana", "Cherry");
        
        // Print the list of fruits to the console
        System.out.println(fruits);
        
        // Create a File object representing the source file
        File sourceFile = new File("source.txt");
        
        // Create a File object representing the destination file
        File destFile = new File("destination.txt");

        try {
            // Copy the contents of source.txt to destination.txt
            // Using Apache Commons IO FileUtils class
            FileUtils.copyFile(sourceFile, destFile);
            
            // Print success message if file is copied
            System.out.println("File copied successfully!");
        } 
        catch (IOException e) {
            // If any error occurs during file copying,
            // this block will handle the exception
            
            // Print error message
            System.err.println("Error occurred while copying file: " + e.getMessage());
        }
    }
}
