package materialtest.example.ritzipsy.quickmovie.base;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import butterknife.ButterKnife;
import materialtest.example.ritzipsy.quickmovie.R;
import materialtest.example.ritzipsy.quickmovie.webservice.WebserviceConstants;


public class BaseFragment extends Fragment implements WebserviceConstants {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    public boolean isInternetConnected(Context context){
        boolean networkState = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected()) {
                if (networkInfo.isRoaming()) {
                    // Roaming
                }
                int netType = networkInfo.getType();
                if (netType == ConnectivityManager.TYPE_WIFI) {
                    networkState = networkInfo.isConnected();
                } else if (netType == ConnectivityManager.TYPE_MOBILE) {
                    networkState = networkInfo.isConnected();
                } else {
                    networkState = false;
                }
            } else {
                networkState = false;
            }
        } catch (Exception e) {
            networkState = true;
        }
        return networkState;
    }

    public void showAlert(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Title is not a mandatory parameter to show an alert.
        if (title!=null && title.length()>0)
            builder.setTitle(title);

        builder.setMessage(message);
        builder.setPositiveButton(getString(R.string.okay), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.create().show();
    }

    public String getJsonObjectValueForString(JSONObject jsObj, String param){
        String value = "";
        if (jsObj.has(param)) {
            try {
                value = jsObj.getString(param);
                if (value.equals("null") || TextUtils.isEmpty(value)) {
                    value = "";
                }
            } catch (JSONException e) {
            }
        }

        return value;
    }

    public boolean validateFieldsEmpty(EditText txtFields, TextInputLayout inputLayoutFields,
                                       String alert, Window window) {
        if (txtFields.getText().toString().trim().isEmpty()) {
            inputLayoutFields.setError(alert);
            requestFocus(txtFields, window);
            return false;
        } else {
            inputLayoutFields.setErrorEnabled(false);
        }

        return true;
    }

    public void requestFocus(View view, Window window) {
        if (view.requestFocus()) {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
}
