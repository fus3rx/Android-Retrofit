package mahfuz.info.retrofittest.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by mahfuz on 3/27/17.
 */

public class Book {

    //Variables that are in our json
    @SerializedName("bookId")
    @Expose
    private int bookId;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("inStock")
    @Expose
    private int inStock;

    //Getters and setters
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }
}
