package gov.bfar.util.excel_helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

public class Application {

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            System.out.println("Has arguments");
        } else
            printDoc();
        // throw new IllegalArgumentException("Argument : " + args[0] + " not
        // recognized. \nUse excel_helper --help to show command list");
    }

    private static void printDoc() throws IOException {
        ClassLoader classLoader = Application.class.getClassLoader();
        File file = new File(classLoader.getResource("docs/cheatsheet.txt").getFile());
        LineIterator it = FileUtils.lineIterator(file, "UTF-8");

        try {
            while (it.hasNext()) {
                String line = it.nextLine();
                System.out.println(line);
            }
        } finally {
            LineIterator.closeQuietly(it);
        }

    }
}
