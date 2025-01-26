package commands.builtin;

import prompt.PromptDto;

import java.io.IOException;

class FileWriter {

    void write(PromptDto input) {
        write(input, String.join(" ", input.args()) + "\n");
    }

    void write(PromptDto input, String content) {
        try (java.io.FileWriter writer = new java.io.FileWriter(input.redirectFilename())) {
            writer.write(content + "\n");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
