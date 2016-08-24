package first.com.bluchat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * Created by Test on 8/20/2016.v
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    public int type1=1;
    public int type2=2;
    DBHandler db;


    List<String> message;
    List<String> status;
    List<List<String>>data1;

    Context context;

    public RecyclerAdapter(Context context, List<List<String>> data) {

        this.context=context;
        db = new DBHandler(context);
        this.data1=data;
        Log.d("aceess12", String.valueOf(data1));

        for(int i=0;i<(data.size());i++){
            Log.d("sizeofdata", String.valueOf(data.size()));
            message.add(data1.get(i).get(0));
            Log.d("messagedata", String.valueOf(message));

            status.add(data1.get(i).get(2));
            Log.d("statusdata", String.valueOf(status));
            }
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType==type1){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.data_transfer_left,parent,false);
            RecyclerViewHolder recyclerviewholder=new RecyclerViewHolder(view,viewType);
            return recyclerviewholder;
        }

        else{
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.data_transfer_right,parent,false);
            RecyclerViewHolder recyclerviewholder=new RecyclerViewHolder(view,viewType);
            return recyclerviewholder;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        Log.d("holderid", String.valueOf(holder.holderid));
        if (holder.holderid == 1) {

            holder.text1.setText(message.get(position));

            Log.d("flag", status.get(position));
            Log.d("recievecount", String.valueOf(position));

        }
        else if (holder.holderid == 2) {

            holder.text2.setText(message.get(position));
            Log.d("sendcount", String.valueOf(position));
            Log.d("position1", status.get(position));

        }
    }

    @Override
    public int getItemCount() {
        int total=db.getRowCount();
        Log.d("totalsize1", String.valueOf(total));
        return total;
    }

    @Override
    public int getItemViewType(int position){
        Log.d("status",status.get(position));
        if(status.get(position) == "send"){
            return type1;
        }
        else {
            return type2;
        }

    }


    public class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        TextView text1;
        TextView text2;
        int holderid;

        public RecyclerViewHolder(View itemView,int viewtype) {
            super(itemView);
            if(viewtype==type1) {
                text1 = (TextView) itemView.findViewById(R.id.textl);
                holderid=1;
            }
            else{
                text2= (TextView) itemView.findViewById(R.id.textr);
                holderid=2;
            }
        }
    }
}
