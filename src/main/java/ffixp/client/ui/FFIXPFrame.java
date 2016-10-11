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

package ffixp.client.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ffixp.client.FFIXPClient;
import ffixp.client.FFIXPApplication;
import ffixp.client.ExecutionTableModel;
import ffixp.client.OrderTableModel;
import ffixp.client.RealQuotesTableModel;

/**
 * Main application window
 */
public class FFIXPFrame extends JFrame {

    public FFIXPFrame(RealQuotesTableModel realQuotesTableModel,OrderTableModel orderTableModel, ExecutionTableModel executionTableModel,
            final FFIXPApplication application) {
        super();
        setTitle("金融行情和交易服务模拟简易客户端");
        setSize(1200, 800);

        if (System.getProperties().containsKey("openfix")) {
            createMenuBar(application);
        }
        getContentPane().add(new FFIXPPanel(realQuotesTableModel,orderTableModel, executionTableModel, application),
                BorderLayout.CENTER);
        setVisible(true);
    }

    private void createMenuBar(final FFIXPApplication application) {
        JMenuBar menubar = new JMenuBar();

        JMenu sessionMenu = new JMenu("Session");
        menubar.add(sessionMenu);

        JMenuItem logonItem = new JMenuItem("Logon");
        logonItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FFIXPClient.get().logon();
            }
        });
        sessionMenu.add(logonItem);

        JMenuItem logoffItem = new JMenuItem("Logoff");
        logoffItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FFIXPClient.get().logout();
            }
        });
        sessionMenu.add(logoffItem);

        JMenu appMenu = new JMenu("Application");
        menubar.add(appMenu);

        JMenuItem appAvailableItem = new JCheckBoxMenuItem("Available");
        appAvailableItem.setSelected(application.isAvailable());
        appAvailableItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                application.setAvailable(((JCheckBoxMenuItem) e.getSource()).isSelected());
            }
        });
        appMenu.add(appAvailableItem);

        JMenuItem sendMissingFieldRejectItem = new JCheckBoxMenuItem("Send Missing Field Reject");
        sendMissingFieldRejectItem.setSelected(application.isMissingField());
        sendMissingFieldRejectItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                application.setMissingField(((JCheckBoxMenuItem) e.getSource()).isSelected());
            }
        });
        appMenu.add(sendMissingFieldRejectItem);

        setJMenuBar(menubar);
    }
}
