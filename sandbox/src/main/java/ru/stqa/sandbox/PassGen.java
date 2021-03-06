package ru.stqa.sandbox;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class PassGen {

    @Parameter(names = "-c", description = "Events count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;

    private static final String SYMBOLS = "ABCDFGHQIJKLMNOPRSTUVWXYZabcdfghqijklmnoprstuvwxyz1234567890";

    private static char getSymbol() {
        int index = (int) (Math.random() * SYMBOLS.length());
        return SYMBOLS.charAt(index);
    }

    public static String generatePassword(int length) {
        StringBuilder sb = new StringBuilder();
        while (length != 0) {
            sb.append((char) getSymbol());
            length--;
        }
        return sb.toString();
    }

    private void run() throws IOException {
        List<String> events = generateEvents(count);
        if (format.equals("csv")){
            saveAsCsv(events, new File(file));
        } else {
            System.out.println("Неподдерживаемый формат " + format);
        }
    }

    public static void main(String[] arg) throws IOException {
        PassGen generator = new PassGen();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(arg);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();
    }

    private void saveAsCsv(List<String> events, File file) throws IOException {
        System.out.println(new File(".").getAbsolutePath());
        try(Writer writer = new FileWriter(file)) {
            for(String event:events)
            {
                writer.write(String.format("%s\n", event));
            }
        }
    }

        private List<String> generateEvents(int count) {
            ArrayList<String> list = new ArrayList<>();
            String y = "\"";
            int a = 20;
            for (int i = 0; i < count; i++) {
                //System.out.println(generatePassword(a));
                        list.add("{" + y + "index" + ": {" + y + "_type" + y + ": " + y + "doc" + y + "," + y + "_id" + y + ": " + y + generatePassword(a) + y + "}}" +
                        "{" + y + "id" + y + ":null," + y + "@version" + y + ":" + y + "1" + y + "," + y + "organizationRootId" + y + ":52," + "userPrivileges" + y + ":[" + y + "P_PPA_01" + y + "," + y + "P_PPA_10" + y + "," + y + "P_PPA_02" + y + "," + y + "P_DBS_02" + y + "," +
                        y + "P_PPA_11" + y + "," + y + "P_DBS_04" + y + "," + y + "P_COMMON_01" + y + "," + y + "P_DBS_01" + y + "," + y + "P_PPA_09" + y + "," + y + "P_PPA_12" + y + "," + y + "P_COMMON_02" + y + "]," + y + "externalSystemId" + y + ":null," + y + "bankOnly" + y + ":false," +
                        y + "entityId" + y + ":346," + y + "participantsRootIds" + y + ":[52]," + y + "requestId" + y + ":" + y + "81d9d712-5514-498d-beca-c38db8e13b8f" + y + "," + y + "actionType" + y + ":" + y + "AGREEMENT_BS_CREATE" + y + "," +
                        y + "module" + y + ":" + y + "BANK_AGREEMENTS_SERVICE" + y + "," + y + "@timestamp" + y + ":" + y + "2020-02-05T13:10:52.666Z" + y + "," + y + "employeeRootId" + y + ":72," + y + "browser" + y + ":null," + y + "entityRootId" + y + ":346," +
                        y + "systemDate" + y + ":" + y + "2020-02-05T13:10:52.614+0000" + y + "," + y + "action" + y + ":" + y + "Операция добавления договора банковского сопровождения выполнена успешно: Версия № 1 от 05.02.2020.<br />" +
                        "Системный номер: [04-006-20-1417111000240-711001001](/bs-agreements/346). " + y + "," + y + "ipAddress" + y + ":null," + y + "entityType" + y + ":" + y + "BANK_SUPPORT_AGREEMENT" + y + "," + y + "eventCode" + y + ":" + y + "CO_DBS_12" + y + "}");
            }
            return list;
    }
}