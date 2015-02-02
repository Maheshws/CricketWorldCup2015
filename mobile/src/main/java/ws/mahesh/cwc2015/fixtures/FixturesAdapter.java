package ws.mahesh.cwc2015.fixtures;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import ws.mahesh.cwc2015.R;
import ws.mahesh.cwc2015.utils.TimeZoneHelper;

/**
 * Created by Mahesh on 1/28/2015.
 */
public class FixturesAdapter extends RecyclerView.Adapter<FixturesAdapter.FixturesViewHolder> {
    List<FixtureObject> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
    private int color;

    public FixturesAdapter(Context context, List<FixtureObject> data, int color) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.color = color;
    }

    @Override
    public FixturesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.sch_list_item, parent, false);
        FixturesViewHolder holder = new FixturesViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FixturesViewHolder holder, int position) {
        FixtureObject current = data.get(position);
        holder.res.setVisibility(View.VISIBLE);

        holder.matchInfo.setBackgroundColor(color);
        if (current.group.equals("NA"))
            if (current.match_id == 0)
                holder.matchInfo.setText(current.match_type);
            else
                holder.matchInfo.setText(current.match_type + " " + current.match_id);
        else
            holder.matchInfo.setText(current.match_type + " " + current.match_id + ", " + "Group " + current.group);

        if (current.result.equals("TBD"))
            holder.res.setVisibility(View.INVISIBLE);
        else
            holder.res.setText(current.result);

        holder.team1.setText(current.team1_short);
        holder.team2.setText(current.team2_short);

        holder.matchDateTime.setText(TimeZoneHelper.getTime(current.date + " " + current.time).toUpperCase());


        holder.stadInfo.setText(current.stadium + ", " + current.city);

        holder.TLogo1.setImageResource(current.team1_img);
        holder.TLogo2.setImageResource(current.team2_img);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class FixturesViewHolder extends RecyclerView.ViewHolder {
        TextView matchInfo, matchDateTime, team1, team2, res, stadInfo;
        ImageView TLogo1, TLogo2;

        public FixturesViewHolder(View itemView) {
            super(itemView);
            matchInfo = (TextView) itemView.findViewById(R.id.textViewMatchType);
            matchDateTime = (TextView) itemView.findViewById(R.id.textViewDateTime);
            team1 = (TextView) itemView.findViewById(R.id.textViewTeam1Info);
            team2 = (TextView) itemView.findViewById(R.id.textViewTeam2Info);
            res = (TextView) itemView.findViewById(R.id.textViewRes);
            stadInfo = (TextView) itemView.findViewById(R.id.textViewStadInfo);
            TLogo1 = (ImageView) itemView.findViewById(R.id.imageViewTeam1Img);
            TLogo2 = (ImageView) itemView.findViewById(R.id.imageViewTeam2Img);
        }
    }
}
