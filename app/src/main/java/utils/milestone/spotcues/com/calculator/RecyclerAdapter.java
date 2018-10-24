package utils.milestone.spotcues.com.calculator;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerItemViewHolder> {
    private String mDataset;
    private ArrayList<RecyclerData> myList;

    int mLastPosition = 0;
    private AddClickListener mListener;

    public RecyclerAdapter(ArrayList<RecyclerData> myList,AddClickListener listener){
        this.myList=myList;
        mListener = listener;
    }
    public RecyclerItemViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        RecyclerItemViewHolder holder = new RecyclerItemViewHolder(view);
        return holder;
    }



    @Override
    public void onBindViewHolder(RecyclerItemViewHolder holder, final int position) {

        Log.d("onBindViewHolder ", myList.size() + "");
        holder.txtnum1TextView.setText(myList.get(position).getNumber1());
        holder.txtnum2TextView.setText(myList.get(position).getNumber2());
        holder.optionTextView.setText(myList.get(position).getOperator());
        holder.txtansTextView.setText(myList.get(position).getResult());
        mLastPosition=position;

    }

    @Override
    public int getItemCount() {
        return (null!=myList?myList.size():0);
    }

    public void notifyData(ArrayList<RecyclerData> myList) {
        Log.d("notifyData ", myList.size() + "");
        this.myList = myList;
        notifyDataSetChanged();
    }


    public static class RecyclerItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView txtnum1TextView;
        private final TextView txtnum2TextView;
        private final TextView optionTextView;
        private final TextView txtansTextView;
        private LinearLayout mainLayout;


        // each data item is just a string in this case
        public TextView mTextView;
        public RecyclerItemViewHolder(final View parent) {
            super(parent);
            txtnum1TextView=(TextView)parent.findViewById(R.id.txtnum1);
            txtnum2TextView=(TextView)parent.findViewById(R.id.txtnum2);
            optionTextView=(TextView)parent.findViewById(R.id.option);
            txtansTextView=(TextView)parent.findViewById(R.id.ans);
            mainLayout = (LinearLayout) parent.findViewById(R.id.mainLayout);
}}
}