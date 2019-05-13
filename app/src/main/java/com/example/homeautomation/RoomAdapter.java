package com.example.homeautomation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.RoomViewHolder> {
    private List<Room> roomData;
    private Context context;

    public RoomAdapter(List<Room> inputRoom, Context context){
        this.roomData = inputRoom;
        this.context = context;
    }

    public class RoomViewHolder extends RecyclerView.ViewHolder {
        public Switch switchStatus;
        public TextView tvRoom;

        public RoomViewHolder(View v){
            super(v);
            tvRoom = (TextView) v.findViewById(R.id.tv_RoomName);
            switchStatus = (Switch) v.findViewById(R.id.switch_onoff);
        }
    }

    @Override
    public RoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_room, parent, false);
        RoomViewHolder rvh = new RoomViewHolder(v);
        return rvh;
    }

    @Override
    public void onBindViewHolder(RoomViewHolder roomViewHolder, int position){
        Room room = roomData.get(position);
        int s = room.getStatus();
        boolean bool = (s == 1);

        roomViewHolder.tvRoom.setText(room.getName());
        roomViewHolder.switchStatus.setChecked(bool);
    }

    @Override
    public int getItemCount() {
        return roomData.size();
    }
}
