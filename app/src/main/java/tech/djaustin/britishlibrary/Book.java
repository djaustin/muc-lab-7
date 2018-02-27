package tech.djaustin.britishlibrary;

import android.arch.persistence.room.*;
import android.support.annotation.NonNull;

/**
 * Created by danaustin on 27/02/2018.
 */

@Entity
public class Book {
    @PrimaryKey
    @NonNull
    private String ISBN;

    @NonNull
    public String getISBN() {
        return ISBN;
    }

    public void setISBN(@NonNull String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCopiesInStock() {
        return copiesInStock;
    }

    public void setCopiesInStock(int copiesInStock) {
        this.copiesInStock = copiesInStock;
    }

    @ColumnInfo(name = "book_title")
    private String title;
    @ColumnInfo(name = "copies_in_stock")
    private int copiesInStock;
}