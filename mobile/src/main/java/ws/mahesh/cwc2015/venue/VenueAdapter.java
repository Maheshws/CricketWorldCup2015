package ws.mahesh.cwc2015.venue;

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
public class VenueAdapter extends RecyclerView.Adapter<VenueAdapter.VenueViewHolder> {
    List<VenueObject> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public VenueAdapter(Context context, List<VenueObject> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public VenueViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.venue_list_item, parent, false);
        VenueViewHolder holder = new VenueViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(VenueViewHolder holder, int position) {
        VenueObject current = data.get(position);
        holder.VStadium.setText(current.stadium);
        holder.VInfo.setText(current.std_info.replace("\\n", "\n"));
        holder.VLogo.setImageResource(current.res);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class VenueViewHolder extends RecyclerView.ViewHolder {
        TextView VStadium, VInfo;
        ImageView VLogo;

        public VenueViewHolder(View itemView) {
            super(itemView);
            VStadium = (TextView) itemView.findViewById(R.id.textViewStdName);
            VInfo = (TextView) itemView.findViewById(R.id.textViewStdInfo);
            VLogo = (ImageView) itemView.findViewById(R.id.imageViewStdIcon);
        }
    }
}
