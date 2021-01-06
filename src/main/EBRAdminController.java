package main;

import javax.swing.*;

import com.ebr.bean.Station;

import abstractdata.controller.IDataManageController;

import api.crud.station.EBRAddStationApi;
import api.crud.station.EBRGetStationApi;
import api.inteface.IEBRApiAdd;
import station.controller.AdminStationPageController;

public class EBRAdminController {
	private IEBRApiAdd<Station> apiAdd;
	public JPanel getStationPage() {
		AdminStationPageController controller = new AdminStationPageController(EBRGetStationApi.getInstance());

		return controller.getDataPagePane();
	}

//	public void onAdd() {
//		IDataManageController<Station> stationController = new IDataManageController<Station>() {
//
//			@Override
//			public void onAct(Station station) {
//				apiAdd = EBRAddStationApi.getInstance();
////				api.addNewStation(station);
//				apiAdd.add(station);
//				System.out.println("created Station!");
//			}
//
//		};
//		new StationAddDialog(new Station(), stationController);
//	}
}
