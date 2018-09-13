package route.com.g1holyquran.Base;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 9/13/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public class MyBaseFragment extends Fragment {

    protected MyBaseActivity activity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity = (MyBaseActivity) context;


    }
}
