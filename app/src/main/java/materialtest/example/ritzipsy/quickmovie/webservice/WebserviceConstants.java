package materialtest.example.ritzipsy.quickmovie.webservice;

public interface WebserviceConstants {
    interface UploadUserDetails{
        String image_file_upload="file";
        String image_filename_upload="filename";
        String imagePrePath = "http://imdstar.com/church/wp-content/Cimy_User_Extra_Fields/";

        String mod="mod";
        String mod_type="users";
        String method="method";
        String method_type="editProfile";
        String format="format";
        String format_type="json";
        String name="name";
        String address="address";
        String city="city";
        String bloodgroup="bloodgroup";
        String imageupload="image";
        String user_email="user_email";
        String uid="uid";
        String pincode="pincode";

    }
    interface Login {

        String mod="login";
        String methodLogin="userlogin";
        String methodRegistration="registration";
        String methodVerifyotp="verifyOtp";
        String format="json";
        String TAG_RECEIVE_SMS = "com.felda.SMS_CODE_RECIEVE";



    }

}
