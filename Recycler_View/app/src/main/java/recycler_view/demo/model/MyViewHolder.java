package recycler_view.demo.model;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import recycler_view.demo.R;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private TextView textView;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        this.textView = itemView.findViewById(R.id.textView);
    }

    public TextView getTextView() {
        return textView;
    }
}
