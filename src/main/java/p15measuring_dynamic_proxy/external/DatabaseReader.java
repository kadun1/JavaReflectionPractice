package p15measuring_dynamic_proxy.external;

import java.io.IOException;

public interface DatabaseReader {

    int countRowInTable(String tableName) throws InterruptedException, IOException;

    String[] readRow(String sqlQuery) throws InterruptedException;
}
