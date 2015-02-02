package ws.mahesh.cwc2015.teams;

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


/**
 * Created by Mahesh on 1/26/2015.
 */
public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder> {
    List<TeamsObject> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public TeamsAdapter(Context context, List<TeamsObject> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public TeamsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.teams_list_item, parent, false);
        TeamsViewHolder holder = new TeamsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(TeamsViewHolder holder, int position) {
        TeamsObject current = data.get(position);
        holder.TName.setText(current.team.toUpperCase());
        holder.TCaptain.setText("CAPTAIN : " + current.captain);
        holder.TCoach.setText("COACH : " + current.coach);
        holder.TLogo.setImageResource(current.logoId);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class TeamsViewHolder extends RecyclerView.ViewHolder {
        TextView TName, TCaptain, TCoach;
        ImageView TLogo;

        public TeamsViewHolder(View itemView) {
            super(itemView);
            TCoach = (TextView) itemView.findViewById(R.id.textViewCoach);
            TCaptain = (TextView) itemView.findViewById(R.id.textViewCaptain);
            TName = (TextView) itemView.findViewById(R.id.textViewName);
            TLogo = (ImageView) itemView.findViewById(R.id.imageViewLogo);
        }


    }

}
