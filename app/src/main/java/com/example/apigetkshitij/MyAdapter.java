package com.example.apigetkshitij;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    static Context context;
    static List<Model> list;

    public MyAdapter(Context context, List<Model> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.design, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.time_point.setText(String.valueOf(list.get(position).getTimepoint()));
        holder.cloud_cover.setText(String.valueOf(list.get(position).getCloudcover()));
        holder.seeing.setText(String.valueOf(list.get(position).seeing));
        holder.transparency.setText(String.valueOf(list.get(position).getTransparency()));
        holder.direction.setText(String.valueOf(list.get(position).getTemp2m()));
        holder.temp2m.setText(String.valueOf(list.get(position).getTemp2m()));
        holder.prec_type.setText(String.valueOf(list.get(position).getPrec_type()));
        holder.speed.setText(list.get(position).getPrec_type());
        holder.direction1.setText(list.get(position).getWind10m().getDirection());
        holder.speed1.setText(String.valueOf(list.get(position).getWind10m().getSpeed()));


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView time_point, cloud_cover, seeing, transparency, direction, speed, direction1, speed1, temp2m, prec_type;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            time_point = itemView.findViewById(R.id.time_point);
            cloud_cover = itemView.findViewById(R.id.cloud_cover);
            seeing = itemView.findViewById(R.id.seeing);
            transparency = itemView.findViewById(R.id.transparency);
            direction = itemView.findViewById(R.id.direction);
            speed = itemView.findViewById(R.id.speed);
            direction1 = itemView.findViewById(R.id.direction1);
            speed1 = itemView.findViewById(R.id.speed1);
            temp2m = itemView.findViewById(R.id.temp2m);
            prec_type = itemView.findViewById(R.id.prec_type);
            itemView.setOnClickListener((View.OnClickListener) this);

        }

        @Override
        public void onClick(View view) {

            int position = getAdapterPosition();
            Intent intent = new Intent(context, MainActivity2.class);

            intent.putExtra("timepoint", list.get(position).getTimepoint());
            String title = time_point.getText().toString();
            intent.putExtra("timepoint", title);

            intent.putExtra("cloudcover", list.get(position).getTimepoint());
            String title1 = cloud_cover.getText().toString();
            intent.putExtra("cloudcover", title1);

            intent.putExtra("seeing", list.get(position).getTimepoint());
            String title2 = seeing.getText().toString();
            intent.putExtra("seeing", title2);

            intent.putExtra("transparency", list.get(position).getTimepoint());
            String title3 = transparency.getText().toString();
            intent.putExtra("transparency", title3);

            intent.putExtra("direction", list.get(position).getTimepoint());
            String title4 = direction.getText().toString();
            intent.putExtra("direction", title4);

            intent.putExtra("speed", list.get(position).getTimepoint());
            String title5 = speed.getText().toString();
            intent.putExtra("speed", title5);

            intent.putExtra("direction1", list.get(position).getTimepoint());
            String title6 = direction1.getText().toString();
            intent.putExtra("direction1", title6);

            intent.putExtra("speed1", list.get(position).getTimepoint());
            String title7 = speed1.getText().toString();
            intent.putExtra("speed1", title7);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        }
    }
}
