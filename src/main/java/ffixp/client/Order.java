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

import quickfix.SessionID;

public class Order implements Cloneable {
    private SessionID sessionID = null;
    private String symbol = null;
    private int quantity = 0;
    private int open = 0;
    private int executed = 0;
    private OrderSide side = OrderSide.BUY;
    private OrderType type = OrderType.MARKET;
    private OrderTIF tif = OrderTIF.DAY;
    private Double limit = null;
    private Double stop = null;
    private double avgPx = 0.0;
    private boolean rejected = false;
    private boolean canceled = false;
    private boolean isNew = true;
    private String message = null;
    private String ID = null;
    private String originalID = null;
    private static int nextID = 1;
    
    private String wtRq;
    private String securesCode;
    private String securesName;
    private Double wtPrice;
    private int wtNum;
    private Double djJe;
    private int cjNum;
    private Double cjJe;
    private int cdNum;
    private String target;
    private String wtZt;

    public Order() {
        ID = generateID();
    }

    public Order(String ID) {
        this.ID = ID;
    }

    public Object clone() {
        try {
            Order order = (Order) super.clone();
            order.setOriginalID(getID());
            order.setID(order.generateID());
            return order;
        } catch (CloneNotSupportedException e) {}
        return null;
    }

    public String generateID() {
        return Long.toString(System.currentTimeMillis() + (nextID++));
    }

    public SessionID getSessionID() {
        return sessionID;
    }

    public void setSessionID(SessionID sessionID) {
        this.sessionID = sessionID;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOpen() {
        return open;
    }

    public void setOpen(int open) {
        this.open = open;
    }

    public int getExecuted() {
        return executed;
    }

    public void setExecuted(int executed) {
        this.executed = executed;
    }

    public OrderSide getSide() {
        return side;
    }

    public void setSide(OrderSide side) {
        this.side = side;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public OrderTIF getTIF() {
        return tif;
    }

    public void setTIF(OrderTIF tif) {
        this.tif = tif;
    }

    public Double getLimit() {
        return limit;
    }

    public void setLimit(Double limit) {
        this.limit = limit;
    }

    public void setLimit(String limit) {
        if (limit == null || limit.equals("")) {
            this.limit = null;
        } else {
            this.limit = Double.parseDouble(limit);
        }
    }

    public Double getStop() {
        return stop;
    }

    public void setStop(Double stop) {
        this.stop = stop;
    }

    public void setStop(String stop) {
        if (stop == null || stop.equals("")) {
            this.stop = null;
        } else {
            this.stop = Double.parseDouble(stop);
        }
    }

    public void setAvgPx(double avgPx) {
        this.avgPx = avgPx;
    }

    public double getAvgPx() {
        return avgPx;
    }

    public void setRejected(boolean rejected) {
        this.rejected = rejected;
    }

    public boolean getRejected() {
        return rejected;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public boolean getCanceled() {
        return canceled;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public void setOriginalID(String originalID) {
        this.originalID = originalID;
    }

    public String getOriginalID() {
        return originalID;
    }

	public OrderTIF getTif() {
		return tif;
	}

	public void setTif(OrderTIF tif) {
		this.tif = tif;
	}

	public String getWtRq() {
		return wtRq;
	}

	public void setWtRq(String wtRq) {
		this.wtRq = wtRq;
	}

	public String getSecuresCode() {
		return securesCode;
	}

	public void setSecuresCode(String securesCode) {
		this.securesCode = securesCode;
	}

	public String getSecuresName() {
		return securesName;
	}

	public void setSecuresName(String securesName) {
		this.securesName = securesName;
	}

	public Double getWtPrice() {
		return wtPrice;
	}

	public void setWtPrice(Double wtPrice) {
		this.wtPrice = wtPrice;
	}

	public int getWtNum() {
		return wtNum;
	}

	public void setWtNum(int wtNum) {
		this.wtNum = wtNum;
	}

	public Double getDjJe() {
		return djJe;
	}

	public void setDjJe(Double djJe) {
		this.djJe = djJe;
	}

	public int getCjNum() {
		return cjNum;
	}

	public void setCjNum(int cjNum) {
		this.cjNum = cjNum;
	}

	public Double getCjJe() {
		return cjJe;
	}

	public void setCjJe(Double cjJe) {
		this.cjJe = cjJe;
	}

	public int getCdNum() {
		return cdNum;
	}

	public void setCdNum(int cdNum) {
		this.cdNum = cdNum;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getWtZt() {
		return wtZt;
	}

	public void setWtZt(String wtZt) {
		this.wtZt = wtZt;
	}
}
