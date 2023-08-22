package com.kodilla.fileintegrationtask;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping("/integration")
public class FileIntegrationRestController {

    @PostMapping
    public void createFile(@RequestParam String name, @RequestParam String text) throws IOException {
        FileWriter myWriter = new FileWriter("C:\\Users\\Lenovo\\kodilla\\bean-lifecycle\\data\\input_task\\" + name + ".txt");
        myWriter.write(text);
        myWriter.close();
    }

    @GetMapping
    public ResponseEntity<String> readFile() throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader("C:\\Users\\Lenovo\\kodilla\\bean-lifecycle\\data\\output_task\\files.txt"));
        String line = reader.readLine();
        String finalText = "";
        while (line != null) {
            finalText = finalText + line + "\n";
            line = reader.readLine();
        }
        reader.close();
        return ResponseEntity.ok(finalText);
    }
}
