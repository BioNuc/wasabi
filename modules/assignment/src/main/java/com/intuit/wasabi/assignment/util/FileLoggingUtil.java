package com.intuit.wasabi.assignment.util;

import com.intuit.wasabi.assignmentobjects.Assignment;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLoggingUtil {
    private static String defaultWasabiExpLogFile = "/media/wasabiExpLog.txt";

    public static void logNewAssignedUser(Assignment assignment) {
        String logStatment = getLogStatement(assignment);
        if (System.getenv("WASABI_ASSIGNMENT_FILE_NAME") == null && System.getenv("WASABI_ASSIGNMENT_FILE_PATH)") != null) {
            String filePath = System.getenv("WASABI_ASSIGNMENT_FILE_PATH)") + '/' + System.getenv("WASABI_ASSIGNMENT_FILE_NAME");
            writeIntoFile(filePath, logStatment);
        } else {
            writeIntoFile(defaultWasabiExpLogFile, logStatment);
        }

    }

    private static String getLogStatement(Assignment assignment) {
        String userId = assignment.getUserID().toString();
        String experimentName = assignment.getExperimentLabel().toString();

        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String formattedCurrentTime = dateFormat.format(currentDate);

        String logStatement = "User with id " + userId + " is assigned to Experiment `"
                + experimentName + "` on " + formattedCurrentTime;

        return logStatement;
    }

    private static void writeIntoFile(String filePath, String statement) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(statement);
            fileWriter.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
