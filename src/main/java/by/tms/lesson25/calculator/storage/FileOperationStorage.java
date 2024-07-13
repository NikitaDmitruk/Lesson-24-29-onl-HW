package by.tms.lesson25.calculator.storage;

import by.tms.lesson25.calculator.model.Operation;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

public class FileOperationStorage implements OperationStorage {
    private final File HISTORY_TXT_FILE = new File("history.txt");

    public void save(Operation operation) {
        try {
            FileWriter fileWriter = new FileWriter(HISTORY_TXT_FILE, true);
            fileWriter.write(String.format("%s/%s/%s/%s\n",
                    operation.getNum1(),
                    operation.getNum2(),
                    operation.getResult(),
                    operation.getType()));
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        String result = String.format("Hello %s!", myName, age);
    }

    public List<Operation> findAll() {
        try {
            FileReader fileReader = new FileReader(HISTORY_TXT_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Stream<String> lines = bufferedReader.lines();
            List<Operation> list = lines
                    .map(s -> s.split("/"))
                    .map(a -> new Operation(Double.parseDouble(a[0]),
                            Double.parseDouble(a[1]),
                            a[3],
                            Double.parseDouble(a[2]))).toList();
            return list;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
