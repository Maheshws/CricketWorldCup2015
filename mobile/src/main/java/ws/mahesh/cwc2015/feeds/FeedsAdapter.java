package ws.mahesh.cwc2015.feeds;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import ws.mahesh.cwc2015.R;
import ws.mahesh.cwc2015.webservices.models.NewsFeed;

/**
 * Created by Mahesh on 2/6/2015.
 */
public class FeedsAdapter extends RecyclerView.Adapter<FeedsAdapter.FeedsViewHolder> {
    List<NewsFeed> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;

    public FeedsAdapter(Context context, List<NewsFeed> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public FeedsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.feeds_list_item, parent, false);
        FeedsViewHolder holder = new FeedsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(FeedsViewHolder holder, int position) {
        NewsFeed current = data.get(position);
        holder.FTitle.setText(current.getTitle());
        holder.FDes.setText(current.getDescription());
        holder.FTStamp.setText(current.getTimestamp());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class FeedsViewHolder extends RecyclerView.ViewHolder {
        TextView FTitle, FDes, FTStamp;

        public FeedsViewHolder(View itemView) {
            super(itemView);
            FTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            FDes = (TextView) itemView.findViewById(R.id.textViewDescription);
            FTStamp = (TextView) itemView.findViewById(R.id.textViewTimeStamp);
        }
    }
}
