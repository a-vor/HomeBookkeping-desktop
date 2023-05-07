package com.company.middleware;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DimeensionSQLQuery {
    public static int getRowCount(ResultSet resultSet) throws SQLException {
        int rowCount;
        int currentRow = resultSet.getRow(); // сохраняем текущую позицию курсора
        if (!resultSet.last()) { // перемещаем курсор на последнюю строку
            rowCount = 0;
        } else {
            rowCount = resultSet.getRow(); // получаем номер последней строки
        }
        if (currentRow == 0) { // если курсор был до этого на позиции 0, то перемещаем его на первую строку
            resultSet.beforeFirst();
        } else { // иначе перемещаем курсор на ту строку, на которой он был до этого
            resultSet.absolute(currentRow);
        }
        return rowCount;
    }
}
