package ru.opencart.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.opencart.model.RegData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class RegDataGenerator {

    @Parameter(names = "-c", description = "RegData count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    public static void main(String[] args) throws IOException {
        RegDataGenerator generator = new RegDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void run() throws IOException {
        List<RegData> regs = generateRegs(count);
        if (format.equals("csv")) {
            saveAsCsv(regs, new File(file));
        } else if (format.equals("json")) {
            saveAsJson(regs, new File(file));
        } else {
            System.out.println("Unrecognized format " + format);
        }
    }

    private void saveAsJson(List<RegData> regs, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(regs);
        try (Writer writer = new FileWriter(file);) {
            writer.write(json);
        }
    }


    private void saveAsCsv(List<RegData> regs, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        try (Writer writer = new FileWriter(file);) {
            for (RegData reg : regs) {
                writer.write(String.format("%s;%s;%s;%s;%s;%s\n",
                        reg.getUserFirstname(),
                        reg.getUserLastname(),
                        reg.getEmail(),
                        reg.getTelephone(),
                        reg.getPassword(),
                        reg.getConfirmPassword()));
            }
        }
    }

    private List<RegData> generateRegs(int count) {
        Faker data = new Faker();
        String password = data.internet().password();
        List<RegData> regs = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            regs.add(new RegData()
                    .withUserFirstname(data.name().firstName())
                    .withUserLastname(data.name().lastName())
                    .withEmail(data.internet().emailAddress())
                    .withTelephone(data.phoneNumber().cellPhone())
                    .withPassword(password)
                    .withConfirmPassword(password));
        }
        return regs;
    }
}
