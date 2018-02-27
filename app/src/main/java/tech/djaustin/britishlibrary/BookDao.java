package tech.djaustin.britishlibrary;

import android.arch.persistence.room.*;

/**
 * Created by danaustin on 27/02/2018.
 */

@Dao
public interface BookDao {
    @Insert
    void insertBook(Book book);
    @Query("SELECT * FROM book WHERE ISBN=:isbn LIMIT 1")
    Book retrieveBookByISBN(String isbn);
}