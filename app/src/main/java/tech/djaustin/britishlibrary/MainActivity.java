package tech.djaustin.britishlibrary;

import android.arch.persistence.room.Room;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private Library library;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = this.getPreferences(MODE_PRIVATE);
        ((EditText)findViewById(R.id.etBorrowerId)).setText(sharedPreferences.getString("borrower_id", "No ID Set"));
        library = Room.databaseBuilder(getApplicationContext(), Library.class, "british-library").allowMainThreadQueries().build();
    }

    public void setBorrowerIdWasPressed(View view){
        EditText etBorrowerId = findViewById(R.id.etBorrowerId);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("borrower_id", etBorrowerId.getText().toString());
        editor.commit();
    }

    public void addBookWasPressed(View view){
        String isbn = ((EditText)
                findViewById(R.id.etBookISBN)).getText().toString();
        String title = ((EditText)
                findViewById(R.id.etBookTitle)).getText().toString();
        int copies = Integer.parseInt(((EditText)
                findViewById(R.id.etBookCopies)).getText().toString());
        Book newBook = new Book();
        newBook.setISBN(isbn);
        newBook.setTitle(title);
        newBook.setCopiesInStock(copies);
        library.bookDao().insertBook(newBook);
    }

    public void checkTitleWasPressed(View view){
        String isbn = ((EditText)findViewById(R.id.etCheckTitleISBN)).getText().toString();
        String bookTitle;
        Book book = library.bookDao().retrieveBookByISBN(isbn);
        if(book == null){
            bookTitle = "No match.";
        } else {
            bookTitle = book.getTitle();
        }
        ((TextView)findViewById(R.id.tvBookTitle)).setText(bookTitle);
    }
}
