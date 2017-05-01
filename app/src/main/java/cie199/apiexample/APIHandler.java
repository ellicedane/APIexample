package cie199.apiexample;

import android.content.Context;
import android.util.Log;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

/**
 * Created by dane on 5/1/2017.
 */

public class APIHandler {

    private static final String BASE_URL = "https://api.imgflip.com/";

    private static RequestQueue requestQueue;

    private static APIHandler sharedClient = null;

    private APIHandler() {}

    public static APIHandler getSharedClient(Context context) {
        if (sharedClient == null) {
            sharedClient = new APIHandler();
            requestQueue = Volley.newRequestQueue(context);
        }

        return sharedClient;
    }

    public void getRequestNoAuth(String requestUrl, Response.Listener<JSONObject> onSuccess, Response.ErrorListener onFailure) {
        String fullRequestUrl = BASE_URL + requestUrl;
        Log.d("GET REQUEST", fullRequestUrl);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, fullRequestUrl, null, onSuccess, onFailure);

        requestQueue.add(request);
    }
}
