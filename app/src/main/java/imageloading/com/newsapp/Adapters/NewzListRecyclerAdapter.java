package imageloading.com.newsapp.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import imageloading.com.newsapp.R;
import imageloading.com.newsapp.entities.NewzEntity;

/**
 * Created by viral.thakkar on 15-05-2015.
 */
public class NewzListRecyclerAdapter extends RecyclerView.Adapter<NewzListRecyclerAdapter.ListItemViewHolder> {

    private List<NewzEntity> newzList;
    private Activity activity;
    private int colorGreen;
    private int colorRed;
    private int colorDefault;

    public NewzListRecyclerAdapter(Activity activity,List<NewzEntity> newzList) {
        this.newzList=newzList;
        this.activity=activity;
        colorRed=activity.getResources().getColor(R.color.red);
        colorGreen=activity.getResources().getColor(R.color.green);
        colorDefault=activity.getResources().getColor(R.color.default_icon);
    }

    @Override
    public ListItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.newz_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final ListItemViewHolder holder, int position) {
         /* //  NewzEntity newz=newzList.get(position);*/

        holder.layoutReal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imgReal.setColorFilter(colorGreen);
                holder.txtReal.setTextColor(colorGreen);
            }
        });

        holder.layoutFake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.imgFake.setColorFilter(colorRed);
                holder.txtFake.setTextColor(colorRed);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public final static class ListItemViewHolder extends RecyclerView.ViewHolder {
        TextView txtTitle;
        TextView txtNoReal;
        TextView txtNoFake;
        TextView txtNoComments;
        RelativeLayout layoutReal;
        RelativeLayout layoutComment;
        RelativeLayout layoutFake;
        HorizontalScrollView scrollView;
        LinearLayout itemLayout;
        ImageView imgReal;
        ImageView imgComment;
        ImageView imgFake;
        TextView txtReal;
        TextView txtComment;
        TextView txtFake;


        public ListItemViewHolder(View itemView) {
            super(itemView);
            txtTitle = (TextView) itemView.findViewById(R.id.newzitem_txtTitle);
            txtNoFake = (TextView) itemView.findViewById(R.id.newzitem_txtNoFake);
            txtNoReal = (TextView) itemView.findViewById(R.id.newzitem_txtNoReal);
            txtNoComments = (TextView) itemView.findViewById(R.id.newzitem_txtNoComment);
            layoutFake = (RelativeLayout) itemView.findViewById(R.id.newzitem_layoutFake);
            layoutReal = (RelativeLayout) itemView.findViewById(R.id.newzitem_layoutReal);
            layoutComment = (RelativeLayout) itemView.findViewById(R.id.newzitem_layoutComment);
            scrollView = (HorizontalScrollView) itemView.findViewById(R.id.newzitem_horizontalLayout);
            itemLayout = (LinearLayout) itemView.findViewById(R.id.newzitem_horizontalLinearLayout);
             imgReal=(ImageView)itemView.findViewById(R.id.newzitem_imgtruth);
             imgComment=(ImageView)itemView.findViewById(R.id.newzitem_imgComment);
             imgFake=(ImageView)itemView.findViewById(R.id.newzitem_imgfake);
             txtReal=(TextView)itemView.findViewById(R.id.newzitem_txttruth);
             txtComment=(TextView)itemView.findViewById(R.id.newzitem_txtcomment);
             txtFake=(TextView)itemView.findViewById(R.id.newzitem_txtfake);

        }
    }
}



