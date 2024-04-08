SEPARATOR = ", "
QUOTE     = "'"
LEFT_PARENTHESIS = "("
RIGHT_PARENTHESIS = ")"
STRING_PREFIX = DIALECT.getDbms().isMicrosoft() ? "N" : ""
KEYWORDS_LOWERCASE = com.intellij.database.util.DbSqlUtil.areKeywordsLowerCase(PROJECT)
KW_NULL = KEYWORDS_LOWERCASE ? "null" : "NULL"

rowFirst = true;
ROWS.each { row ->
    OUT.append(rowFirst ? LEFT_PARENTHESIS : SEPARATOR + LEFT_PARENTHESIS)
    COLUMNS.eachWithIndex { column, i ->
        def value = row.value(column)
        def stringValue = value == null ? KW_NULL : FORMATTER.formatValue(value, column)
        def isStringLiteral = value != null && FORMATTER.isStringLiteral(value, column)
        if (isStringLiteral && DIALECT.getDbms().isMysql()) stringValue = stringValue.replace("\\", "\\\\")
        OUT.append(i == 0 ? "" : SEPARATOR)
        OUT.append(isStringLiteral ? (STRING_PREFIX + QUOTE) : "")
           .append(stringValue ? stringValue.replace(QUOTE, QUOTE + QUOTE) : stringValue)
           .append(isStringLiteral ? QUOTE : "")
    }
    OUT.append(RIGHT_PARENTHESIS)
    rowFirst = false
}