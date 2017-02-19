package materialtest.example.ritzipsy.quickmovie.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public abstract class BasePresenter  {

    public static final String TAG = "BasePresenter";

    private final BaseView view;
    //   public String SUCCESS = "1";
    // public String FAILURE = "0";

    public BasePresenter(BaseView view) {
        this.view = view;
    }

    public String extractYTId(String ytUrl) {
        String pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*";

        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(ytUrl);

        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }

    public String fromStream(InputStream in) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                out.append(line);
                out.append("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public String getTodayDate(String format){
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.format(c.getTime());
    }


}