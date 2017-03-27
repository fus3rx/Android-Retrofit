package mahfuz.info.retrofittest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import mahfuz.info.retrofittest.Interfaces.BooksAPI;
import mahfuz.info.retrofittest.Model.Book;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static mahfuz.info.retrofittest.BookController.BASE_URL;


public class MainActivity extends AppCompatActivity {

    public static final String ROOT_URL = "http://simplifiedcoding.16mb.com/";

    //Strings to bind with intent will be used to send data to other activity
    public static final String KEY_BOOK_ID = "key_book_id";
    public static final String KEY_BOOK_NAME = "key_book_name";
    public static final String KEY_BOOK_PRICE = "key_book_price";
    public static final String KEY_BOOK_STOCK = "key_book_stock";

    //List view to show data
    private ListView listView;

    //List of type books this list will store type Book which is our data model
    private List<Book> books;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BookController controller = new BookController();
        controller.start();


        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        BooksAPI api = retrofit.create(BooksAPI.class);
        Call<List<Book>> call = api.getBooks();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {

            }
            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });



    }

}
