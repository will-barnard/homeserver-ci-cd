package com.example.uploadingfiles.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ScriptRunnerService {
    public static String runScript(String scriptPath) throws Exception {
        System.out.println("Executing script: " + scriptPath);
        ProcessBuilder pb = new ProcessBuilder(scriptPath);
        pb.redirectErrorStream(true);
        Process process = pb.start();

        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("Script failed:\n" + output);
        }

        return output.toString();
    }
}