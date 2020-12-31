package recycler_view.demo.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import recycler_view.demo.R;

/**
 * RecyclerView is the new ListView, but RecyclerView wants requires more code in order for it to
 * function.  That's where RecyclerView.Adapter comes in. This adapter is what will fill the
 * Recycler.  An adapter should have a list where the list in the contents to be displayed
 * You have to make your own class that extends RecyclerView.Adapter (it's an abstract class)
 * Then using generics it will tell java what ViewHolder we'll be using as the layout for displaying each item in the list
 * to be displayed in the RecyclerView.  Look at MyViewHolder.java for more documentation.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private List<String> list; // holds the data that will be displayed on the RecyclerView

    public MyRecyclerViewAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Crates the view holder layouts to be displayed on the RecyclerView
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_view_holder_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // We can use this method to display the contents from the lists to MyViewHolder
        holder.getTextView().setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
