package ru.rudolf;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {

    private final Map<String, String> table;
    //столбец, строка
    private final int column, row;
    //Стартовый ключ с которого начинается таблица
    private final char startColumn;

    public Table(int column, int row, char startColumn) {
        this.column = column;
        this.row = row;
        this.startColumn = startColumn;
        table = new HashMap<>();

        /* Цикл создает "карту" ключей 10x10;
         *  Ключем является буква от A до J и номер от 1 до 10;
         * */
        for (int tRow = 1; tRow <= row; tRow++) {
            for (char tColumn = startColumn; tColumn < startColumn + column; tColumn++) {
                addKey(String.format("%s%d", tColumn, tRow));
            }
        }

    }

    public boolean addKey(String key){
        if (table.containsKey(key)) {
            System.out.println("Ячейка " + key + " существует");
            return false;
        }
        table.put(key, "");
        return true;
    }

    public boolean put(String key, String value){
        if (!table.containsKey(key)) {
            System.out.println("Ячейка " + key + " не существует");
            return false;
        }
        table.put(key, value);
        return true;
    }

    public void save(String systemResPath, Character separator) throws Exception {
        Path path = Paths.get( ClassLoader.getSystemResource(systemResPath).toURI());
        //В русском excel нужна ";" в английском ","
        CSVWriter writer = new CSVWriter(new FileWriter(path.toString()), separator);

        List<String> values;
        String[] sValue;

        for (int tRow = 1; tRow <= row; tRow++) {
            values = new ArrayList<>();
            for (char tColumn = startColumn; tColumn < startColumn + column; tColumn++) {
                values.add(table.get(String.format("%s%d", tColumn, tRow)));
            }
            sValue = new String[values.size()];
            values.toArray(sValue);
            writer.writeNext(sValue);
        }
        writer.close();
        System.out.println("Файл успешно сохранен");
    }

    public char getStartColumn() {
        return startColumn;
    }

    public String get(String key){
        return table.get(key);
    }

    public Map<String, String> getTable() {
        return table;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
