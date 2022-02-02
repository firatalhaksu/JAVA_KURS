package com.bilgeadam.input_output;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileManipulator {

    public void readFile() throws IOException {

        File file = new File("src/main/resources" + File.separator + "Demo.txt");
        FileReader reader = null;
        if (file.isFile()) {
            try {
                reader = new FileReader(file);
                System.out.printf("Can I write the file? %b\n", file.canWrite());
                int c;
                while ((c = reader.read()) != -1) {
                    System.out.println((char) c);                       //char'lar halinde tek tek okuyup yazdırıyoruz.
                }
            } catch (FileNotFoundException e){
                System.out.println("Given file is not exist!");
            } finally {
                assert reader != null;
                reader.close();
            }
        }
    }

    public void readFilePerLine() throws IOException {

        File file = new File("resouces" + File.separator + "Demo.txt");
        FileReader reader = null;
        if (file.isFile()) {
            try {
                reader = new FileReader(file);
                BufferedReader stream = new BufferedReader(reader);
                stream.lines().forEach(System.out::println);            //satır satır okuyup yazdırıyoruz.

            } catch (FileNotFoundException e){
                System.out.println("Given file is not exist!");
            } finally {
                assert reader != null;
                reader.close();
            }
        }
    }

    public List<Integer> readNumbers() throws IOException {

        File file = new File("resouces" + File.separator + "Numbers.txt");
        FileReader reader = null;
        List<Integer> numbers = new ArrayList<>();
        if (file.isFile()) {
            try {
                reader = new FileReader(file);
                BufferedReader stream = new BufferedReader(reader);
                String line;
                while ((line = stream.readLine()) != null){
                    numbers.addAll(Arrays.stream(line.split("\\s*,\\s*")).map(Integer::parseInt).collect(Collectors.toList()));
                }

            } catch (FileNotFoundException e){
                System.out.println("Given file is not exist!");
            } finally {
                assert reader != null;
                reader.close();
            }
        }
        return numbers;
    }

    public void printToFile(String input, String filename) throws IOException {

        //verilen filename ile dosya oluşturup verilen inputu içine yazdırıyoruz.

        File file = new File("resources" + File.separator + filename);
        FileWriter writer = null;
        try {
            writer = new FileWriter(file);

            writer.write(input);
        }finally {
            assert writer != null;
            writer.close();
        }
    }

    public void printBufferedToFile(String input, String filename) throws IOException{

        //verilen filename ile dosya oluşturup verilen inputu içine SATIR SATIR (UTF_8 formatında byte) yazdırıyoruz.
        //"append" true verirsek, dosyaya ekleme yapmaya izin veririz. false verirsek ekleme yaptırmaz.

        try (FileOutputStream stream = new FileOutputStream("resouces" + File.separator + filename,true)) {

            stream.write("\n".getBytes(StandardCharsets.UTF_8));        //yeni satır ekleme
            stream.write(input.getBytes(StandardCharsets.UTF_8));
            stream.flush();                                             //flush iki input arasındaki farkları yazdırır.
            stream.write(new byte[] {123,112,14});
        }
    }

    public static void main(String[] args) throws IOException {
        FileManipulator qqq = new FileManipulator();
        qqq.printToFile("This is a java test", "Test.txt");
    }
}
