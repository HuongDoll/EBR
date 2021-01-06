package station.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.ebr.bean.Station;

import abstractdata.controller.ADataPageController;
import abstractdata.gui.ADataListPane;
import abstractdata.gui.ADataSinglePane;
import station.controller.AdminStationPageController;

@SuppressWarnings("serial")
public class UserStationListPane extends ADataListPane<Station> {
	public UserStationListPane(ADataPageController<Station> controller) {
		this.controller = controller;
	}

	@Override
	public void decorateSinglePane(ADataSinglePane<Station> singlePane) {
		JButton viewButton = new JButton("View");
		viewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("xem chi tiet");
			}
		});

		singlePane.addDataHandlingComponent(viewButton);
		viewButton.setPreferredSize(new Dimension(100, 20));
	}
}
