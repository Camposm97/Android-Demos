package recycler_view.demo.model;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import recycler_view.demo.R;

/**
 * Like how RecyclerView needs its own Adapter, an Adapter needs a ViewHolder which will display
 * the contents that the Adapter contains.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    private CardView cardView; // only need this for adding a onClickListener
    private TextView textView; // for setting the text in MyRecyclerViewAdapter

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        this.cardView = itemView.findViewById(R.id.root);
        this.textView = itemView.findViewById(R.id.textView);
        cardView.setOnClickListener(v -> Toast.makeText(itemView.getContext(), textView.getText(), Toast.LENGTH_SHORT).show());
    }

    public TextView getTextView() {
        return textView;
    }
}
