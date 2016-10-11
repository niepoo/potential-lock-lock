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

public class OrderTableModel extends AbstractTableModel {

    private final static int wtRq = 0;
    private final static int side = 1;
    private final static int securesCode = 2;
    private final static int securesName = 3;
    private final static int wtPrice = 4;
    private final static int wtNum = 5;
    private final static int djJe = 6;
    private final static int cjNum = 7;
    private final static int cjJe = 8;
    private final static int cdNum = 9;
    private final static int target = 10;
    private final static int wtZt = 11;

    private final HashMap<Integer, Order> rowToOrder;
    private final HashMap<String, Integer> idToRow;
    private final HashMap<String, Order> idToOrder;

    private final String[] headers;

    public OrderTableModel() {
        rowToOrder = new HashMap<Integer, Order>();
        idToRow = new HashMap<String, Integer>();
        idToOrder = new HashMap<String, Order>();

        headers = new String[]
                  {"委托日期","买/卖","证券代码", "证券名称", "委托价钱","委托数量", "冻结金额","成交数量", 
                   "成交金额", "撤单数量", "服务器","委托状态"};
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void addOrder(Order order) {
        int row = rowToOrder.size();

        rowToOrder.put(row, order);
        idToRow.put(order.getID(), row);
        idToOrder.put(order.getID(), order);

        fireTableRowsInserted(row, row);
    }

    public void updateOrder(Order order, String id) {

        if (!id.equals(order.getID())) {
            String originalID = order.getID();
            order.setID(id);
            replaceOrder(order, originalID);
            return;
        }

        Integer row = idToRow.get(order.getID());
        if (row == null)
            return;
        fireTableRowsUpdated(row, row);
    }

    public void replaceOrder(Order order, String originalID) {

        Integer row = idToRow.get(originalID);
        if (row == null)
            return;

        rowToOrder.put(row, order);
        idToRow.put(order.getID(), row);
        idToOrder.put(order.getID(), order);

        fireTableRowsUpdated(row, row);
    }

    public void addID(Order order, String newID) {
        idToOrder.put(newID, order);
    }

    public Order getOrder(String id) {
        return idToOrder.get(id);
    }

    public Order getOrder(int row) {
        return rowToOrder.get(row);
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) { }

    public Class<String> getColumnClass(int columnIndex) {
        return String.class;
    }

    public int getRowCount() {
        return rowToOrder.size();
    }

    public int getColumnCount() {
        return headers.length;
    }

    public String getColumnName(int columnIndex) {
        return headers[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Order order = rowToOrder.get(rowIndex);
        switch (columnIndex) {
        case wtRq:
            return order.getSymbol();
        case side:
            return order.getQuantity();
        case securesCode:
            return order.getOpen();
        case securesName:
            return order.getExecuted();
        case wtPrice:
            return order.getSide();
        case wtNum:
            return order.getType();
        case djJe:
            return order.getLimit();
        case cjJe:
            return order.getStop();
        case cdNum:
            return order.getAvgPx();
        case target:
            return order.getSessionID().getTargetCompID();
        case wtZt:
            return order.getSessionID().getTargetCompID();
        }
        return "";
    }
}
