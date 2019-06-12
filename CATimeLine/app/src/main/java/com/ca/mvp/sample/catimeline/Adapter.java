package com.ca.mvp.sample.catimeline;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.vipulasri.timelineview.TimelineView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    ArrayList<Model> list;

    public Adapter(Context context, ArrayList<Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false),i);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Model model=list.get(i);
        if (model.isComplete())
            viewHolder.timeline.setMarker(context.getResources().getDrawable(R.drawable.round));
        else
            viewHolder.timeline.setMarker(context.getResources().getDrawable(R.drawable.fill_round));
        viewHolder.tvTitle.setText(model.getTitle());
        viewHolder.tvDesc.setText(model.getDescription());
    }

    @Override
    public int getItemViewType(int position) {
        return TimelineView.getTimeLineViewType(position,getItemCount());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.timeline)
        TimelineView timeline;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        public ViewHolder(@NonNull View itemView, int i) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            timeline.initLine(i);
        }
    }
}
