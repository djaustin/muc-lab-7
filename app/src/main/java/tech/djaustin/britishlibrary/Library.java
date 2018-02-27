package tech.djaustin.britishlibrary;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by danaustin on 27/02/2018.
 */

@Database(entities = {Book.class}, version = 1)
public abstract class Library extends RoomDatabase {
    public abstract BookDao bookDao();
}
