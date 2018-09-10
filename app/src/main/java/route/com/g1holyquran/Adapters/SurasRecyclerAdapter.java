package route.com.g1holyquran.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import route.com.g1holyquran.Model.Sura;
import route.com.g1holyquran.R;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/7/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class SurasRecyclerAdapter extends RecyclerView.Adapter <SurasRecyclerAdapter.ViewHolder> {

    ArrayList<Sura> data;

    OnItemClickListener onItemClickListener;


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public SurasRecyclerAdapter(ArrayList data){
        this.data=data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_sura, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Sura item=data.get(position);
        holder.name.setText(item.getName());


        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (onItemClickListener!=null)
                    onItemClickListener.OnItemClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public interface OnItemClickListener{

        void OnItemClick(int position);

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        View cv;
        TextView name;

        public ViewHolder(View cv){
            super(cv);
            this.cv=cv;
            name=cv.findViewById(R.id.name);

        }
    }
}
