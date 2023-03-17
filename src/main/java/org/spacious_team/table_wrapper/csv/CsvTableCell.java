// Generated by delombok at Thu Mar 16 20:14:49 EDT 2023
/*
 * Table Wrapper CSV Impl
 * Copyright (C) 2022  Spacious Team <spacious-team@ya.ru>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.spacious_team.table_wrapper.csv;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.spacious_team.table_wrapper.api.AbstractTableCell;
import org.spacious_team.table_wrapper.api.EmptyTableCell;
import org.spacious_team.table_wrapper.api.TableCell;

public class CsvTableCell extends AbstractTableCell<String> {
    private final int columnIndex;
    private final String value;

    public static TableCell of(String[] row, int columnIndex) {
        return of(row, columnIndex, CsvCellDataAccessObject.INSTANCE);
    }

    public static TableCell of(String[] row, int columnIndex, CsvCellDataAccessObject dao) {
        String cellValue = getCellValue(row, columnIndex);
        return cellValue == null ? EmptyTableCell.of(columnIndex) : new CsvTableCell(cellValue, columnIndex, dao);
    }

    private static String getCellValue(String[] row, int columnIndex) {
        return (columnIndex >= 0) && (columnIndex < row.length) ? row[columnIndex] : null;
    }

    private CsvTableCell(String cellValue, int columnIndex, CsvCellDataAccessObject dao) {
        super(cellValue, dao);
        this.value = cellValue;
        this.columnIndex = columnIndex;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
        return "CsvTableCell(columnIndex=" + this.getColumnIndex() + ", value=" + this.value + ")";
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public boolean equals(final java.lang.Object o) {
        if (o == this) return true;
        if (!(o instanceof CsvTableCell)) return false;
        final CsvTableCell other = (CsvTableCell) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        if (this.getColumnIndex() != other.getColumnIndex()) return false;
        final java.lang.Object this$value = this.value;
        final java.lang.Object other$value = other.value;
        if (this$value == null ? other$value != null : !this$value.equals(other$value)) return false;
        return true;
    }

    @java.lang.SuppressWarnings("all")
    protected boolean canEqual(final java.lang.Object other) {
        return other instanceof CsvTableCell;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getColumnIndex();
        final java.lang.Object $value = this.value;
        result = result * PRIME + ($value == null ? 43 : $value.hashCode());
        return result;
    }

    @java.lang.SuppressWarnings("all")
    public int getColumnIndex() {
        return this.columnIndex;
    }
}
