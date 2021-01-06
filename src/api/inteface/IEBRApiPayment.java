package api.inteface;

import okhttp3.RequestBody;

public interface IEBRApiPayment {
	public void payment(RequestBody body);
}
