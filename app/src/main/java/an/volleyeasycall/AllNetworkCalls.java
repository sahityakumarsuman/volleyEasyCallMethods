package an.volleyeasycall;

import android.app.Activity;

import com.android.volley.Request;

import java.util.HashMap;

import an.easyvolleycalls.networking.FailureCallback;
import an.easyvolleycalls.networking.NetworkRequest;
import an.easyvolleycalls.networking.StatusCodeCallback;
import an.easyvolleycalls.networking.SuccessCallback;

/**
 * Created by sahitya on 28/8/17.
 */

public class AllNetworkCalls {

    Activity mActivity;

    public AllNetworkCalls(MainActivity mainActivity) {

        this.mActivity = mainActivity;
    }


    public void networkCallForUserProfile(SuccessCallback successCallback, FailureCallback failureCallback, StatusCodeCallback statusCodeCallback) {


        // This is the header details given to the api to authenticate user and its existence for any api access
        HashMap<String, String> headerDetails = new HashMap<>();
        headerDetails.put(Constants.API_KEY_PARAMETER, Constants.API_KEY);
        headerDetails.put(Constants.API_TOKEN_PARAMETER, Constants.API_USER_TOKEN);

        // The Params for the api which is mostly as input for the api to get Response
        HashMap<String, String> paramForApi = new HashMap<>();
        paramForApi.put(Constants.USER_ID, Constants.USER_ID_REG);

        // Single class method to make network calls
        NetworkRequest networkRequest = new NetworkRequest(mActivity);
        networkRequest.setSuccessCallback(successCallback);
        networkRequest.setFailureCallback(failureCallback);
        networkRequest.setStatusCodeCallback(statusCodeCallback);
        networkRequest.setUrl(Constants.BASE_URL + Constants.AUTHENTICATION);
        networkRequest.setMethod(Request.Method.GET);
        networkRequest.setHeader(headerDetails);
        networkRequest.setParams(paramForApi);
        networkRequest.execute();

    }

}
