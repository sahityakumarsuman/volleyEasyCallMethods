package an.easyvolleycalls.networking;

import com.android.volley.NetworkResponse;

/**
 * Created by sahitya on 11/5/17.
 */

public interface StatusCodeCallback {
    void onResponse(NetworkResponse response);
}
