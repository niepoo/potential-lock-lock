/*******************************************************************************
 * Copyright (c) quickfixengine.org  All rights reserved.
 *
 * This file is part of the QuickFIX FIX Engine
 *
 * This file may be distributed under the terms of the quickfixengine.org
 * license as defined by quickfixengine.org and appearing in the file
 * LICENSE included in the packaging of this file.
 *
 * This file is provided AS IS with NO WARRANTY OF ANY KIND, INCLUDING
 * THE WARRANTY OF DESIGN, MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE.
 *
 * See http://www.quickfixengine.org/LICENSE for licensing information.
 *
 * Contact ask@quickfixengine.org if any conditions of this licensing
 * are not clear to you.
 ******************************************************************************/

package ffixp.client;

import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

public class ExecutionTableModel extends AbstractTableModel {

    private final static int securesCode = 0;
    private final static int SYMBOL = 1;
    private final static int QUANTITY = 2;
    private final static int SIDE = 3;
    private final static int PRICE = 4;

    private final HashMap<Integer, Execution> rowToExecution;
    private final HashMap<String, Integer> idToRow;
    private final HashMap<String, Execution> idToExecution;
    private final HashMap<String, Execution> exchangeIdToExecution;

    private final String[] headers;

    public ExecutionTableModel() {
        rowToExecution = new HashMap<Integer, Execution>();
        idToRow = new HashMap<String, Integer>();
        idToExecution = new HashMap<String, Execution>();
        exchangeIdToExecution = new HashMap<String, Execution>();

        headers = new String[] {"证券代码","证券名称", "数量", "买/卖", "价钱"};
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void addExecution(Execution execution) {
        int row = rowToExecution.size();

        if (exchangeIdToExecution.get(execution.getExchangeID()) != null)
            return;

        rowToExecution.put(row, execution);
        idToRow.put(execution.getID(), row);
        idToExecution.put(execution.getID(), execution);
        exchangeIdToExecution.put(execution.getExchangeID(), execution);

        fireTableRowsInserted(row, row);
    }

    public Execution getExchangeExecution(String exchangeID) {
        return exchangeIdToExecution.get(exchangeID);
    }

    public Execution getExecution(int row) {
        return rowToExecution.get(row);
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) { }

    public Class<String> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getRowCount() {
        return rowToExecution.size();
    }

    public int getColumnCount() {
        return headers.length;
    }

    public String getColumnName(int columnIndex) {
        return headers[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Execution execution = rowToExecution.get(rowIndex);

        switch (columnIndex) {
        case securesCode:
        	return execution.getSecuresCode();
        case SYMBOL:
            return execution.getSymbol();
        case QUANTITY:
            return execution.getQuantity();
        case SIDE:
            return execution.getSide();
        case PRICE:
            return execution.getPrice();
        }
        return "";
    }
}
