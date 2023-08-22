package com.kodilla.fileintegrationtask;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileTransformer {

    public String transformFile(String fileName) throws IOException {
        File folder = new File(fileName);
        return folder != null ? folder.getName() : "";
    }
}
