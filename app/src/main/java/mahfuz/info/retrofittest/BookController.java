package mahfuz.info.retrofittest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import mahfuz.info.retrofittest.Interfaces.BooksAPI;
import mahfuz.info.retrofittest.Model.Book;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mahfuz on 3/27/17.
 */

public class BookController implements Callback<List<Book>> {
    static final String BASE_URL = "http://10.0.2.2:8000/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        BooksAPI api = retrofit.create(BooksAPI.class);
        Call<List<Book>> call = api.getBooks();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
        if(response.isSuccessful()) {
            List<Book> changesList = response.body();
            for (Book book :
                    changesList) {
                System.out.println(book.getName());
            }

        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Book>> call, Throwable t) {
        t.printStackTrace();
    }
}
