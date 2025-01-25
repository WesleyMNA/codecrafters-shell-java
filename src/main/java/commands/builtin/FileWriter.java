package commands.builtin;

import prompt.PromptDto;

import java.io.IOException;

class FileWriter {

    void write(PromptDto input) {
        try (java.io.FileWriter writer = new java.io.FileWriter(input.redirectFilename())) {
            writer.write(String.join(" ", input.args()) + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
