package an.volleyeasycall;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.NetworkResponse;

import an.easyvolleycalls.networking.FailureCallback;
import an.easyvolleycalls.networking.StatusCodeCallback;
import an.easyvolleycalls.networking.SuccessCallback;

public class MainActivity extends AppCompatActivity {


    private NetworkResponse networkResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // This class can be used to make all network calls, and don't have to mummble all code at different parts of the project
        AllNetworkCalls networkCallsForApi = new AllNetworkCalls(MainActivity.this);

        networkCallsForApi.networkCallForUserProfile(new SuccessCallback() {
            @Override
            public void onResponse(String response) {

                // getting the Network Response and its status callbacks
                NetworkResponse networkResponse = getNetworkResponse();

                // if the network reponse happens correctly and everything goes well if will executed
                if (networkResponse != null && networkResponse.statusCode == 200) {

                    // Method which can bes used to parse the network response
                    parseDataResponse(response);

                }

            }
        }, new FailureCallback() {
            @Override
            public void onResponse(String error) {


                // Parse the error String which is a JSON response for the particular use

            }
        }, new StatusCodeCallback() {
            @Override
            public void onResponse(NetworkResponse response) {

                // Set the status of the Network response that you made for the network call
                setNetworkResponse(response);
            }
        });

    }

    private void parseDataResponse(String response) {

        // You get the JSON response here you can parse the JSON response as according to yourself here

    }

    // getter method for networkResponse
    public NetworkResponse getNetworkResponse() {
        return networkResponse;
    }

    // setter method for networkResponse
    public void setNetworkResponse(NetworkResponse networkResponse) {
        this.networkResponse = networkResponse;
    }
}
