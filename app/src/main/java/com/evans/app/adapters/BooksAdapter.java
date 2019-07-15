package com.evans.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.evans.app.BookActivity;
import com.evans.app.R;
import com.evans.app.models.Books;

import java.util.ArrayList;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> {

    private ArrayList<Books> mBooks;
    private Context mContext;

    public BooksAdapter(ArrayList<Books> books, Context context) {
        mBooks = books;
        mContext = context;
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.book_list, parent, false);
        return new BooksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksViewHolder holder, int position) {
        Books book = mBooks.get(position);

        holder.tvTitle.setText(book.getTitle());
        holder.mImageView.setImageResource(book.getThumbnail());
    }

    @Override
    public int getItemCount() {
        return mBooks.size();
    }

    class BooksViewHolder extends RecyclerView.ViewHolder{

        ImageView mImageView;
        TextView tvTitle;
        CardView mCardView;

        BooksViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.book_img);
            tvTitle = itemView.findViewById(R.id.book_title);
            mCardView = itemView.findViewById(R.id.card_view);

            mCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    Books book = mBooks.get(position);
                    Intent intent = new Intent(mContext, BookActivity.class);
                    intent.putExtra("Title", book.getTitle());
                    intent.putExtra("Category", book.getCategory());
                    intent.putExtra("Description", book.getDescription());
                    intent.putExtra("Image", book.getThumbnail());
                    mContext.startActivity(intent);
                    Toast.makeText(mContext, book.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
