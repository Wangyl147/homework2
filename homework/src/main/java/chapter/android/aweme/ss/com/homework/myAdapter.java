package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;


import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder> {
    private static final String TAG = "myAdapter";

    private int mNumberItems;

    private final ListItemClickListener mOnClickListener;

    private static int viewHolderCount;

    List<Message> dataMessage;

    public myAdapter(int numListItems,List<Message> messages,ListItemClickListener listener) {
        mNumberItems = numListItems;
        mOnClickListener = listener;
        viewHolderCount = 0;
        dataMessage = messages;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdforListItem = R.layout.im_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;


        View view = inflater.inflate(layoutIdforListItem,viewGroup,shouldAttachToParentImmediately);
        myViewHolder viewHolder = new myViewHolder(view);
        //viewHolder.itemView.setBackgroundColor(Color.BLACK);
        //测试不单独说明时背景颜色是否正确

        Log.d(TAG, "onCreateViewHolder: number of ViewHolders created: " + viewHolderCount);
        viewHolderCount++;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder viewHolder, int position) {
        Log.d(TAG, "onBindViewHolder: #" + position);
        viewHolder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //private final FrameLayout picture;
        private final CircleImageView icon;
        private final ImageView tag;
        private final TextView title;
        private final TextView desc;
        private final TextView time;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            //picture = (FrameLayout) itemView.findViewById(R.id.header);
            icon = (CircleImageView) itemView.findViewById(R.id.iv_avatar);
            tag = (ImageView) itemView.findViewById(R.id.robot_notice);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            desc = (TextView) itemView.findViewById(R.id.tv_description);
            time = (TextView) itemView.findViewById(R.id.tv_time);
            itemView.setOnClickListener(this);
        }

        public void bind(int position){
            Message m = dataMessage.get(position);
            int iconResId;
            switch (m.getIcon()) {
                case "TYPE_ROBOT":
                    iconResId=R.drawable.session_robot;break;
                case "TYPE_GAME":
                    iconResId=R.drawable.icon_micro_game_comment;break;
                case "TYPE_SYSTEM":
                    iconResId=R.drawable.session_system_notice;break;
                case "TYPE_STRANGER":
                    iconResId=R.drawable.session_stranger;break;
                default:
                    iconResId=R.drawable.icon_girl;break;
            }
            icon.setImageResource(iconResId);
            Log.d(TAG,"是不是官方");
            if(m.isOfficial()){
                Log.d(TAG,"是官方");
                //tag.setImageResource(R.drawable.im_icon_notice_official);
                tag.setVisibility(View.VISIBLE);
            }
            else
            {
                Log.d(TAG,"不是官方");
                //tag.setImageResource(R.drawable.im_icon_notice_official);
                tag.setVisibility(View.INVISIBLE);
            }
            title.setText(m.getTitle());
            desc.setText(m.getDescription());
            time.setText(m.getTime());
        }

        @Override
        public void onClick(View view) {
            int clickedPosition = getAdapterPosition();
            if (mOnClickListener != null) {
                mOnClickListener.onListItemClick(clickedPosition);
            }
        }
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }
}
