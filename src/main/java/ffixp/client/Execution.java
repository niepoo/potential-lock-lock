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

public class Execution {
    private String symbol = null;
    private int quantity = 0;
    private OrderSide side = OrderSide.BUY;
    private double price;
    private String ID = null;
    private String exchangeID = null;
    private static int nextID = 1;
    
    private String securesCode;
    private String securesName ;
    private double zf;
    private double xj;
    private double jk;
    private double zg;
    private double zd;
    private double zs;
    private double zje;

    public Execution() {
        ID = Integer.toString(nextID++);
    }

    public Execution(String ID) {
        this.ID = ID;
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

    public OrderSide getSide() {
        return side;
    }

    public void setSide(OrderSide side) {
        this.side = side;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getID() {
        return ID;
    }

    public void setExchangeID(String exchangeID) {
        this.exchangeID = exchangeID;
    }

    public String getExchangeID() {
        return exchangeID;
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

	public double getZf() {
		return zf;
	}

	public void setZf(double zf) {
		this.zf = zf;
	}

	public double getXj() {
		return xj;
	}

	public void setXj(double xj) {
		this.xj = xj;
	}

	public double getJk() {
		return jk;
	}

	public void setJk(double jk) {
		this.jk = jk;
	}

	public double getZg() {
		return zg;
	}

	public void setZg(double zg) {
		this.zg = zg;
	}

	public double getZd() {
		return zd;
	}

	public void setZd(double zd) {
		this.zd = zd;
	}

	public double getZs() {
		return zs;
	}

	public void setZs(double zs) {
		this.zs = zs;
	}

	public double getZje() {
		return zje;
	}

	public void setZje(double zje) {
		this.zje = zje;
	}
}
