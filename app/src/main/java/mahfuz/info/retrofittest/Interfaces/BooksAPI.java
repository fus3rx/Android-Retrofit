package mahfuz.info.retrofittest.Interfaces;

import java.util.List;

import mahfuz.info.retrofittest.Model.Book;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mahfuz on 3/27/17.
 */

public interface BooksAPI {
    /*Retrofit get annotation with our URL
       And our method that will return us the list ob Book
    */
    @GET("/books.json")
    public Call<List<Book>> getBooks();
}
