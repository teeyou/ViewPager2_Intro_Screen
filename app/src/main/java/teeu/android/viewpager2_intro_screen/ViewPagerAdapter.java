package teeu.android.viewpager2_intro_screen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder> {
    List<Item> mItemList;

    public ViewPagerAdapter(List<Item> list) {
        mItemList = list;
    }

    @NonNull
    @Override
    public ViewPagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_intro, parent, false);
        return new ViewPagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerViewHolder holder, int position) {
        Item item = mItemList.get(position);
        holder.mTextView.setText(item.getText());
        holder.mImageView.setImageResource(item.getImg());
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    static class ViewPagerViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ImageView mImageView;

        public ViewPagerViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.textView);
            mImageView = itemView.findViewById(R.id.imageView);
        }
    }
}
