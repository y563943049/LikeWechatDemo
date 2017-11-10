package com.example.recyclertest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * @version $Rev$
 * @anthor Administrator
 * @dsc ${TOOD}
 * @updateAuthor $Author
 * @updateDsc ${TOOD}
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    //获取Context上下文
    private Context mContext;
    //获取列表
    private List<Msg> mMsgs;


    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.msg_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        Msg msg = mMsgs.get(position);
        if (msg.getType() == Msg.TYPE_RECEIVED){
            holder.LeftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        }else if(msg.getType() == Msg.TYPE_SEND){
            holder.LeftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout rightLayout;

        LinearLayout LeftLayout;

        TextView leftMsg;

        TextView rightMsg;

        public ViewHolder(View itemView) {
            super(itemView);
            rightLayout = (LinearLayout) itemView.findViewById(R.id.right_layout);
            LeftLayout = (LinearLayout) itemView.findViewById(R.id.left_layout);
            leftMsg = (TextView) itemView.findViewById(R.id.people_text_view);
            rightMsg = (TextView) itemView.findViewById(R.id.user_text_view);
        }

    }

    public MyAdapter(Context context, List<Msg> msgs){
        this.mContext = context;
        this.mMsgs = msgs;
    }
}
