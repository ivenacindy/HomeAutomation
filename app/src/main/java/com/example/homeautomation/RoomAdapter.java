package com.example.homeautomation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {
    private ArrayList<Room> roomData;
    private Context context;

    public RoomAdapter(ArrayList<Room> inputRoom, Context context){
        this.roomData = inputRoom;
        this.context = context;
    }

    public class RoomViewHolder extends RecyclerView.ViewHolder {
        public ImageView ivRoom;
        public TextView tvRoom;
        public RoomViewHolder(View v){
            super(v);
            ivRoom = (ImageView) v.findViewById(R.id.iv_Room);
            tvRoom = (TextView) v.findViewById(R.id.tv_RoomName);
        }
    }

    @Override
    public RoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.rv_room, null);
        RoomViewHolder rvh = new RoomViewHolder(v);
        return rvh;
    }

    @Override
    public void onBindViewHolder(RoomViewHolder roomViewHolder, int position){
        Room room = roomData.get(position);
        roomViewHolder.tvRoom.setText(room.getName());
        roomViewHolder.ivRoom.setImageDrawable(context.getDrawable(room.getImage()));
    }

    @Override
    public int getItemCount() {
        return roomData.size();
    }
}
