package route.com.g1holyquran;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import route.com.g1holyquran.Base.MyBaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class AhadeathFragment extends MyBaseFragment {


    public AhadeathFragment() {
        // Required empty public constructor
    }


    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_quran, container, false);

        return view;
    }

}
