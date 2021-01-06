package api.payment;

import java.io.IOException;

import api.inteface.IEBRApiPayment;
import okhttp3.*;

public class EBRPayment implements IEBRApiPayment {
	private static EBRPayment instance;

	private EBRPayment() {
		super();
	}

	public static synchronized EBRPayment getInstance() {
		if (instance == null)
			instance = new EBRPayment();
		return instance;
	}

	@Override
	public void payment(RequestBody body) {
		OkHttpClient client = new OkHttpClient().newBuilder().build();
			Request request = new Request.Builder()
				.url("https://ecopark-system-api.herokuapp.com/api/card/processTransaction").method("PATCH", body)
				.addHeader("Content-Type", "application/json").build();
		try {
			Response response = client.newCall(request).execute();
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
