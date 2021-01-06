package station.controller;

import java.util.List;
import java.util.Map;

import com.ebr.bean.Station;

import abstractdata.controller.ADataPageController;
import abstractdata.gui.ADataListPane;
import abstractdata.gui.ADataSinglePane;
import api.crud.station.EBRGetStationApi;
import api.inteface.IEBRApiGet;
import station.gui.UserStationListPane;
import station.gui.StationSearchPane;
import station.gui.StationSinglePane;

public class AdminStationPageController extends ADataPageController<Station> {
	private IEBRApiGet api;

//	public AdminStationPageController() {
//		super();
//	}

	public AdminStationPageController(IEBRApiGet api) {
		super();
		this.api = (EBRGetStationApi) api;
	}

	@Override
	public List<Station> search(Map<String, String> searchParams) {
		api = EBRGetStationApi.getInstance();
		return api.getStations(searchParams);
	}

	public ADataListPane<Station> createListPane() {
		return new UserStationListPane(this);
	}

	@Override
	public StationSearchPane createSearchPane() {
		return new StationSearchPane();
	}

	@Override
	public ADataSinglePane createSinglePane() {
		return new StationSinglePane();
	}

}
