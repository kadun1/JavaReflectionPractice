package p14graph_example;

import p14graph_example.p14annotations.P14Annotations.*;

import java.util.List;

public class P14SqlQueryBuilder {

    @Input("ids")
    private List<String> ids;

    @Input("limit")
    private Integer limit;

    @Input("table")
    private String tableName;

    @Input("columns")
    private List<String> columnNames;

    public P14SqlQueryBuilder(List<String> ids, Integer limit, String tableName, List<String> columnNames) {
        this.ids = ids;
        this.limit = limit;
        this.tableName = tableName;
        this.columnNames = columnNames;
    }

    @Operation("SelectBuilder")
    public String selectStatementBuilder(@Input("table") String tableName, @Input("columns") List<String> columnNames) {
        String columnsString = columnNames.isEmpty() ? "*" : String.join(",", columnNames);

        return String.format("SELECT %s FROM %s", columnsString, tableName);
    }

    @Operation("WhereClause")
    public String addWhereClause(@DependsOn("SelectBuilder") String query, @Input("ids") List<String> ids) {
        if (ids.isEmpty()) {
            return query;
        }

        return String.format("%s WHERE id IN (%s)", query, String.join(",", ids));
    }

    @FinalResult
    public String addLimit(@DependsOn("WhereClause") String query, @Input("limit") Integer limit) {
        if (limit == null || limit == 0) {
            return query;
        }

        if (limit < 0) {
            throw new RuntimeException("limit cannot be negative");
        }

        return String.format("%s LIMIT %d", query, limit.intValue());
    }
}
