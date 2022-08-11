package p15measuring_dynamic_proxy.external.impl;

import p15measuring_dynamic_proxy.external.DatabaseReader;

import java.io.IOException;

public class DatabaseReaderImpl implements DatabaseReader {
    @Override
    public int countRowInTable(String tableName) throws InterruptedException, IOException {
        System.out.println(String.format("DatabaseReaderImpl - counting rows in table %s", tableName));

        throw new IOException("Error counting rows in table " + tableName);
//        Thread.sleep(1000);
//        return 50;
    }

    @Override
    public String[] readRow(String sqlQuery) throws InterruptedException {
        System.out.println(String.format("DatabaseReaderImpl - Executing SQL query : %s", sqlQuery));

        Thread.sleep(1500);

        return new String[]{"column1", "column2", "column3"};
    }
}
