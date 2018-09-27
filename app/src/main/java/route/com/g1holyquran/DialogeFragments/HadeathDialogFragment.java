package route.com.g1holyquran.DialogeFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import route.com.g1holyquran.R;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 9/20/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */
public class HadeathDialogFragment extends DialogFragment{

    public void HadeathDialogFragment(){

    }

    String HadeathTitle;
    String HadeathContent;

    public String getHadeathTitle() {
        return HadeathTitle;
    }

    public String getHadeathContent() {
        return HadeathContent;
    }

    public void setHadeathTitle(String hadeathTitle) {
        HadeathTitle = hadeathTitle;
    }

    public void setHadeathContent(String hadeathContent) {
        HadeathContent = hadeathContent;
    }

    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.hadeath_dialog_fragment,container,false);
        TextView title= view.findViewById(R.id.title);
        TextView content = view.findViewById(R.id.content);

        title.setText(HadeathTitle);
        content.setText(HadeathContent);
         return view;
    }
}
