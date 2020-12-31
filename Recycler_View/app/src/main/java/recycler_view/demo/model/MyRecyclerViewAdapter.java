package recycler_view.demo.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import recycler_view.demo.R;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<String> list;

    public MyRecyclerViewAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_view_holder_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.getTextView().setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
